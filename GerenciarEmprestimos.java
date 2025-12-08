package projetoPOO;

import projetoPOO.tiposUsuario.Usuario;
import java.util.ArrayList;
import java.util.Iterator;

public class GerenciarEmprestimos{
    protected ArrayList<Emprestimo> emprestimosAtivos;

    public GerenciarEmprestimos(){
        this.EmprestimosAtivos = new ArrayList<>();
    }

    public Emprestimo criarEmprestimo(Biblioteca biblioteca, Usuario usuario, Livro livro){
        if(biblioteca == null || usuario == null || livro == null) return null;
        if(usuario.alcancouLimite()) return null;
        if(!biblioteca.livrosDaBiblioteca.contains(livro)) return null;
        if(!livro.isDisponivel()) return null;

        Emprestimo e = new Emprestimo(usuario, livro);

        usuario.getLivrosEmprestados().add(livro);
        livro.setDisponivel(false);
        EmprestimosAtivos.add(e);

        System.out.println("empréstimo de " + livro.getTitulo() + " para " + usuario.getNome() + " criado");
        return e;
    }

    public boolean finalizarViaId(int id){
        if(id <= 0) return false;
        Iterator it =

        for(Emprestimo e : EmprestimosAtivos){
            if(e.getIdEmprestimo() == id && e.isAtivo()){

                Livro livro = e.getLivro();
                Usuario usuario = e.getUsuario();

                e.finalizarEmprestimo();

                return true;
            }
        }
        return false;
    }

    public boolean finalizarViaTitulo(String titulo){

    }

    public void listarLivros(){
        System.out.println("\n----LISTA DE EMPRESTIMOS----");
        for(Emprestimo e : EmprestimosAtivos)
            System.out.println(e.toString());
    }
}