package projetoPOO;
//importação das classes Usuario, e de ArrayList e Iterator
import projetoPOO.tiposUsuario.Usuario;
import java.util.HashSet;
import java.util.Iterator;
//classe que faz todas as operações dos empréstimos usando métodos
public class GerenciarEmprestimos{
    protected HashSet<Emprestimo> emprestimosAtivos;

    //construtor que inicializa a ArrayList
    public GerenciarEmprestimos(){
        this.emprestimosAtivos = new HashSet<>();
    }

    /*
    metood que cria um emprestimo recebendo sua Biblioteca,
    o usuario responsavel pelo emprestimo e o livro emprestado
     */
    public Emprestimo criarEmprestimo(Biblioteca biblioteca, Usuario usuario, Livro livro){
        if(biblioteca == null || usuario == null || livro == null) return null;
        if(usuario.alcancouLimite()) return null;
        if(!biblioteca.livrosDaBiblioteca.contains(livro)) return null;
        if(!livro.isDisponivel()) return null;

        Emprestimo e = new Emprestimo(usuario, livro);

        emprestimosAtivos.add(e);
        usuario.getLivrosEmprestados().add(livro);
        livro.setDisponivel(false);

        System.out.println("empréstimo de " + livro.getTitulo() + " para " + usuario.getNome() + " criado");
        return e;
    }

    /*
    metodo que encerra encerra o emprestimo recebendo o ID
    e verificando se existe algum ID corresponde ao de algum livro
     */
    public boolean finalizarViaId(int id){
        if(id <= 0) return false;

        Iterator<Emprestimo> it = emprestimosAtivos.iterator();

        while(it.hasNext()){

            Emprestimo atual = it.next();

            if(atual.idEmprestimo == id){
                it.remove();
                atual.setAtivo(true);
                atual.getLivro().setDisponivel(true);
                break;
            }
        }
        return false;
    }

    /*
    metodo que encerra encerra o emprestimo recebendo um titulo
    e verificando se existe algum titulo corresponde ao de algum livro
     */
    public boolean finalizarViaTitulo(String titulo){
        if(titulo == null) return false;

        Iterator<Emprestimo> it = emprestimosAtivos.iterator();

        while(it.hasNext()){

            Emprestimo atual = it.next();

            if(atual.getLivro().getTitulo().equals(titulo)){
                it.remove();
                atual.setAtivo(true);
                atual.getLivro().setDisponivel(true);
                break;
            }
        }
        return false;
    }

    //metodo que lista todos os livros emprestados
    public void listarLivros(){
        System.out.println("\n----LISTA DE EMPRESTIMOS----");
        for(Emprestimo e : emprestimosAtivos)
            System.out.println(e.toString());
    }
}