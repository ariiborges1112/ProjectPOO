package projetoPOO;
//importação de ArrayList
import java.util.ArrayList;
import java.io.*;
//classe de controle dos livros
public class Biblioteca{
    protected ArrayList<Livro> livrosDaBiblioteca;

    //construtor que inicializa apenas a arrayList
    public Biblioteca(){
        this.livrosDaBiblioteca = new ArrayList<>();
    }

    //metodo que cria um Livro e automaticamente já o adiciona a array
    public Livro criarLivro(String titulo, String autor, int anoPublicacao){
        if(titulo == null || autor == null || anoPublicacao <= 0) return null;

        Livro livro = new Livro(titulo, autor, anoPublicacao);
        this.livrosDaBiblioteca.add(livro);

        return livro;
    }

    //metodo que adiciona o livro manualmente ao array
    public boolean adicionarLivro(Livro livro){
        if(livro == null) return false;

        this.livrosDaBiblioteca.add(livro);
        return true;
    }

    //metodo que remove o livro manualmente ao array
    public boolean removerLivro(Livro livro){
        if(!livrosDaBiblioteca.contains(livro)) return false;

        this.livrosDaBiblioteca.remove(livro);
        return true;
    }

    //SOBRECARGA DE METODOS
    //metodo que procura o livro na biblioteca pelo seu ID
    public Livro buscar(int id){
        if(id <= 0) return null;

        for(Livro livroBuscar : livrosDaBiblioteca){
            if(livroBuscar.getIdLivro() == id)
                return livroBuscar;
        }
        return null;
    }

    //metodo que procura o livro na biblioteca pelo seu titulo
    public Livro buscar(String titulo){
        if(titulo == null) return null;

        for(Livro livroBuscar : livrosDaBiblioteca){
            if(livroBuscar.getTitulo().equals(titulo))
                return livroBuscar;
        }
        return null;
    }

    //metodos que listam os Livros presentes na Biblioteca
    public void listarLivros(){
        System.out.println("\n----LISTA DE TODOS OS LIVROS DA BIBLIOTECA----");
        for(Livro livros : this.livrosDaBiblioteca)
            System.out.println(livros.toString());
    }

    //lista por ID
    public void listarIdLivros(){
        System.out.println("\n----LISTA DE ID's DOS LIVROS DA BIBLIOTECA----");
        for(Livro livros : this.livrosDaBiblioteca)
            System.out.println(livros.getTitulo() + " --> " + livros.getIdLivro());
    }

    // 1. metodo Público para iniciar o carregamento
    public void carregarAcervoDePasta(String caminhoDaPasta){
        File raiz = new File(caminhoDaPasta);

        if(raiz.exists() && raiz.isDirectory()){
            System.out.println("Iniciando varredura na pasta: " + caminhoDaPasta);
            processarRecursivamente(raiz);
        }
        else System.out.println("Erro: o caminho '" + caminhoDaPasta + "' não existe ou não é uma pasta válida");

    }

    // 2. metodo Recursivo (Varre subpastas)
    private void processarRecursivamente(File arquivoOuPastaAtual){
        if(arquivoOuPastaAtual.isDirectory()){
            File[] conteudo = arquivoOuPastaAtual.listFiles();

            if(conteudo != null){
                for(File item : conteudo){
                    processarRecursivamente(item); // Chama a si mesmo
                }
            }
        } else if (arquivoOuPastaAtual.getName().endsWith(".txt")){
            System.out.println("--> Lendo arquivo: " + arquivoOuPastaAtual.getName());
            lerArquivoDeLivros(arquivoOuPastaAtual);
        }
    }

    // 3. Leitura do arquivo (Linha por linha)
    private void lerArquivoDeLivros(File arquivo){
        try(BufferedReader reader = new BufferedReader(new FileReader(arquivo))){
            String linha;

            while((linha = reader.readLine()) != null){
                // Formato esperado: Titulo;Autor;Ano
                String[] dados = linha.split(";");

                if(dados.length >= 3){
                    try{
                        String titulo = dados[0];
                        String autor = dados[1];
                        int ano = Integer.parseInt(dados[2]);

                        // Cria e adiciona usando o próprio metodo da classe
                        this.criarLivro(titulo, autor, ano);

                    }catch(NumberFormatException e){
                        System.out.println("   AVISO: Ano inválido na linha: " + linha);
                    } catch(IllegalArgumentException e){
                        System.out.println("   AVISO: Dados inválidos: " + e.getMessage());
                    }
                }
            }
        } catch(IOException e){
            System.out.println("Erro ao ler o arquivo " + arquivo.getName() + ": " + e.getMessage());
        }
    }
}