package projetoPOO;

import projetoPOO.tiposUsuario.Usuario;
import java.util.ArrayList;

public class GerenciarEmprestimos{
    protected ArrayList<Emprestimo> listaEmprestimos;
    protected int contadorId;

    public GerenciarEmprestimos(){
        this.listaEmprestimos = new ArrayList<>();
        this.contadorId = 1;
    }

    public Emprestimo criarEmprestimo(Usuario usuario, Livro livro){
        Emprestimo e = new Emprestimo(contadorId++, usuario, livro);
        listaEmprestimos.add(e);
        e.emprestar();

        livro.setDisponivel(false);
        usuario.getLivrosEmprestados().add(livro);
        return e;
    }

    public boolean devolverPeloId(int idEmprestimo){
        for(Emprestimo e : listaEmprestimos){
            if(e.id == idEmprestimo && !e.devolvido){
                e.devolver();

                Livro livro = e.livro;
                Usuario usuario = e.usuario;

                livro.setDisponivel(true);
                usuario.getLivrosEmprestados().remove(livro);
                return true;
            }
        }
        return false;
    }

    public void listarLivros(){
        System.out.println("\n----LISTA DE LIVROS EMPRESTADOS----");
        for(Emprestimo e : listaEmprestimos){
            System.out.println(e.toString());
        }
    }
}