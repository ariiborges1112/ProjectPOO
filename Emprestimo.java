package projetoPOO;

import projetoPOO.tiposUsuario.Usuario;

public class Emprestimo{
    public int id;
    public Usuario usuario;
    public Livro livro;
    public String dataEmprestimo;
    public boolean devolvido;

    public Emprestimo(int id, Usuario usuario, Livro livro){
        this.id = id;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = "";
        this.devolvido = false;
    }

    public void emprestar(){
        this.devolvido = false;
    }

    public void devolver(){
        this.devolvido = true;
    }

    @Override
    public String toString(){
        return "\n----INFORMAÇÕES DO EMPRÉSTIMO----" +
                "\nID do empréstimo: " + id + "\nusuário=" + usuario +
                "\nlivro: " + livro + "\ndevolvido: " + devolvido;
    }
}