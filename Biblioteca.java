package projetoPOO;

import java.util.ArrayList;

public class Biblioteca{
    private ArrayList<Livro> listaLivros;

    public Biblioteca(){
        this.listaLivros = new ArrayList<>();
    }

    public Livro criarLivro(String titulo, String autor, int id, int anoPublicacao){
        Livro livro = new Livro(titulo, autor, id, anoPublicacao);
        this.listaLivros.add(livro);
        return livro;
    }

    public boolean adicionarLivro(Livro livro){
        if(livro == null) return false;

        this.getListaLivros().add(livro);
        return true;
    }

    public boolean removerLivro(Livro livro){
        if(livro == null) return false;

        this.getListaLivros().remove(livro);
        return true;
    }

    public Livro buscarPorId(int id){
        for(Livro livroBuscado : listaLivros){
            if(livroBuscado.getId() == id){
                return livroBuscado;
            }
        }
        return null;
    }

    public void listarLivros(){
        System.out.println("\n----LISTA DE TODOS OS LIVROS DA BIBLIOTECA----");
        for(Livro l : getListaLivros()){
            System.out.println(l.toString());
        }
    }

    public void listarIdLivros(){
        System.out.println("\n----LISTA DE ID's OS LIVROS DA BIBLIOTECA----");
        for(Livro l : getListaLivros()){
            System.out.println(l.getTitulo() + " --> " + l.getId());
        }
    }

    public ArrayList<Livro> getListaLivros(){
        return this.listaLivros;
    }
}