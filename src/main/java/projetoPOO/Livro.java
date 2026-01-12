package projetoPOO;

public class Livro{
    private String titulo;
    private String autor;
    private final int idLivro;
    private static int proximoIdLivro = 1;
    private int anoPublicacao;
    private boolean disponivel;

    //construtor que inicializa titulo, autor, anoPublicacao e incrementa 1 ao ID
    public Livro(String titulo, String autor, int anoPublicacao){
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.idLivro = proximoIdLivro++;
        this.setAnoPublicacao(anoPublicacao);
        this.disponivel = true;
    }

    //metodo que verfiica se o livro está disponivel retornando true ou false
    public boolean podeSerEmprestado(){
        return this.disponivel;
    }

    //encapsulamento
    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        if(titulo == null || titulo.isEmpty()){
            throw new IllegalArgumentException("Erro: Título inválido");
        }
        this.titulo = titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setAutor(String autor){
        if(autor == null || autor.isEmpty()){
            throw new IllegalArgumentException("Erro: Nome de autor inválido");
        }
        this.autor = autor;
    }

    public int getIdLivro(){
        return this.idLivro;
    }

    public static int getProximoIdLivro(){
        return proximoIdLivro;
    }

    public int getAnoPublicacao(){
        return this.anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao){
        if(anoPublicacao <= 0){
            throw new IllegalArgumentException("Erro: O ano de publicação deve ser maior que 0");
        }
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDisponivel(){
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    //metodo toString() que retorna as informações do respectivo livro
    @Override
    public String toString() {
        return "\n----INFORMAÇÕES SOBRE O LIVRO----" +
                "\ntitulo: " + this.getTitulo() + "\nautor: " + this.getAutor() + "\nID: " + this.getIdLivro() +
                "\nano de publicação: " + this.getAnoPublicacao() + "\ndisponibilidade: " + this.isDisponivel();
    }
}