package projetoPOO;
//importação da ArrayList
import java.util.ArrayList;

public class Livro{
    private String titulo;
    private String autor;
    private int id;
    private int anoPublicacao;
    private boolean disponivel;
    private final ArrayList<Integer> filaDeEspera;

    //metodo construtor
    public Livro(String titulo, String autor, int id, int anoPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
        this.filaDeEspera = new ArrayList<>();
    }

    //metodo que verfiica se o livro está disponivel e se há reservas vazias retornando true ou false
    public boolean podeSerEmprestado(){
        return this.disponivel && this.getFilaDeEspera().isEmpty();
    }

    //encapsulamento
    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        if(this.titulo != null){
            this.titulo = titulo;
        }
    }

    public String getAutor(){
        return this.autor;
    }

    public void setAutor(String autor){
        if(this.autor != null){
            this.autor = autor;
        }
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getAnoPublicacao(){
        return this.anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDisponivel(){
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public ArrayList<Integer> getFilaDeEspera(){
        return this.filaDeEspera;
    }

    //metodo especial que retorna as informações do respectivo livro
    @Override
    public String toString() {
        return "\n----INFORMAÇÕES SOBRE O LIVRO----" +
                "\ntitulo: " + this.getTitulo() + "\nautor: " + this.getAutor() + "\nID: " + this.getId() +
                "\nano de publicação: " + this.getAnoPublicacao() + "\ndisponibilidade: " + this.isDisponivel();
    }
}