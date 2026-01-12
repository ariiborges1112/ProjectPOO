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
    public Emprestimo criarEmprestimo(Biblioteca biblioteca, Usuario usuario, Livro livro) throws Exception{
        if(biblioteca == null || usuario == null || livro == null) {
            throw new IllegalArgumentException("Erro: Biblioteca, Usuário ou Livro não podem ser nulos");
        }

        if(usuario.alcancouLimite()) {
            throw new Exception("Erro: O usuário " + usuario.getNome() + " já está com " + usuario.getLivrosEmprestados().size() + " livros");
        }

        if(!biblioteca.livrosDaBiblioteca.contains(livro)){
            throw new Exception("Erro: O livro " + livro.getTitulo() + " não pertence a esta biblioteca");
        }

        if(!livro.isDisponivel()){
            throw new Exception("Indisponível: O livro " + livro.getTitulo() + " já está emprestado no momento");
        }

        Emprestimo e = new Emprestimo(usuario, livro);

        emprestimosAtivos.add(e);
        usuario.getLivrosEmprestados().add(livro);
        livro.setDisponivel(false);

        System.out.println("sucesso! Empréstimo criado para " + usuario.getNome());
        System.out.println(livro.getTitulo() + " acaba de ser emprestado");
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
                //remove do sistema
                it.remove();
                //remove da lista do usuário especifico
                atual.getUsuario().getLivrosEmprestados().remove(atual.getLivro());
                //seta o empréstimo para falso e set o livro como disponivel
                atual.setAtivo(false);
                atual.getLivro().setDisponivel(true);
                return true;
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
                //remove do sistema
                it.remove();
                //remove da lista do usuário especifico
                atual.getUsuario().getLivrosEmprestados().remove(atual.getLivro());
                //seta o empréstimo para falso e set o livro como disponivel
                atual.setAtivo(false);
                atual.getLivro().setDisponivel(true);
                return true;
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