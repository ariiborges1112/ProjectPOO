package projetoPOO;
//importação de ArrayList
import java.util.ArrayList;
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

    //metodo que procura o livro na biblioteca pelo seu ID
    public Livro buscarPorId(int id){
        if(id <= 0) return null;

        for(Livro livroBuscar : livrosDaBiblioteca){
            if(livroBuscar.getIdLivro() == id)
                return livroBuscar;
        }
        return null;
    }

    //metodo que procura o livro na biblioteca pelo seu ID
    public Livro buscarPorTitulo(String titulo){
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
}