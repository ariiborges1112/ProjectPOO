package projetoPOO;

import projetoPOO.tiposUsuario.Aluno;
import projetoPOO.tiposUsuario.Professor;
import projetoPOO.tiposUsuario.Usuario;
import projetoPOO.tiposUsuario.Visitante;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();
        GerenciarEmprestimos gestor = new GerenciarEmprestimos();
        Scanner scanner = new Scanner(System.in);
        Usuario usuarioLogado = null; //usuário começa vazio

        //CARREGAMENTO DE ARQUIVOS
        String caminhoDaPasta = "./src/AcervoBiblioteca";

        try{
            System.out.println("Lendo acervo do disco rígido...");
            biblioteca.carregarAcervoDePasta(caminhoDaPasta);
        }catch(Exception e){
            System.out.println("Erro crítico ao ler arquivos: " + e.getMessage());
        }

        //lista os livros criados
        //caso o arquivo estuver vazio ou o caminho errado, haverá um aviso
        biblioteca.listarLivros();

        //AREA DO LOGIN
        while(usuarioLogado == null){
            System.out.println("\nLOGIN: [1]Aluno [2]Professor [3]Visitante [0]Sair");
            System.out.print("Opção: ");

            try{
                //transforma String no tipo int por exemplo "1" --> 1
                int tipo = Integer.parseInt(scanner.nextLine());

                if(tipo == 0){
                    System.out.println("saindo");
                    return;
                }

                if (tipo >= 1 && tipo <= 3){
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    // Instancia dependendo do tipo
                    if(tipo == 1) usuarioLogado = new Aluno(nome, email);
                    else if (tipo == 2) usuarioLogado = new Professor(nome, email);
                    else usuarioLogado = new Visitante(nome, email);
                }else{
                    System.out.println("Erro, opção inválida");
                }
            }catch(NumberFormatException e) {
                System.out.println("Digite um número entre 0 e 3");
            }
        }

        //MENU PRINCIPAL
        int opc = -1; //só para garantir que irá entrar no loop

        // O loop roda ENQUANTO a opção for diferente de 0
        while(opc != 0){
            //Mostrar as opções
            System.out.println("\n--- BIBLIOTECA (" + usuarioLogado.getNome() + ") ---");
            System.out.println("1 - Listar Acervo");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Alugar");
            System.out.println("4 - Devolver");
            System.out.println("5 - Meus Empréstimos");
            System.out.println("0 - Sair");
            System.out.println("ESCOLHA UMA OPÇÃO: ");

            //aqui faz a leitura Segura da opção (opc)
            try{
                String entradaDoUsuario = scanner.nextLine(); // Lê TUDO o que o usuário digitou como texto
                opc = Integer.parseInt(entradaDoUsuario); // Tenta converter esse texto para número
            }catch(NumberFormatException e){
                opc = -1; // Se der erro (ex: digitou "abc"), define -1
            }

            switch(opc){
                case 1: //lista livros do acervo
                    biblioteca.listarLivros();
                    break;
                case 2: //cadastra um livro
                    System.out.println("\nCadastro de Livro");
                    System.out.print("Título: ");
                    String t = scanner.nextLine();
                    System.out.print("Autor: ");
                    String a = scanner.nextLine();

                    try{ //caso algo estiver errado, será lançado na tela
                        System.out.print("Ano de publicação: ");
                        int ano = Integer.parseInt(scanner.nextLine());
                        biblioteca.criarLivro(t, a, ano);

                        System.out.println("Cadastrado!");
                    } catch(NumberFormatException e){
                        System.out.println("Erro: o ano deve ser um número inteiro");
                    } catch(Exception e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 3: //aluga livro
                    System.out.println("\nAlugar Livro");
                    biblioteca.listarLivros();

                    System.out.print("ID do livro desejado: ");
                    try{
                        int id = Integer.parseInt(scanner.nextLine());
                        Livro livro = biblioteca.buscar(id);

                        if(livro != null) gestor.criarEmprestimo(biblioteca, usuarioLogado, livro);
                        else System.out.println("Livro não encontrado");

                    } catch(NumberFormatException e){
                        System.out.println("Erro: O ID deve ser um número");
                    } catch(Exception e){
                        System.out.println("Erro no empréstimo: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("\nDevolução de Livro");
                    System.out.print("Título exato do Livro: ");
                    String tituloExato = scanner.nextLine();

                    if(gestor.finalizarViaTitulo(tituloExato)) System.out.println("Livro devolvido");
                    else System.out.println("Erro, título incorreto ou livro não consta na biblioteca");
                    break;
                case 5:
                    System.out.println("\nMeus Empréstimos");
                    usuarioLogado.listarLivrosEmprestadosPorUsuario();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválido, tente novamente.");
            }
        }
    }
}