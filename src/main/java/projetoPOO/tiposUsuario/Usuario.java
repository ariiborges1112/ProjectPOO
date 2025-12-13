package projetoPOO.tiposUsuario;
//importação da classe Livro e de ArrayList
import projetoPOO.Livro;
import java.util.ArrayList;
//criação da classe abstrata e da implementação da interface
public abstract class Usuario implements Regras{
    private String nome;
    private String email;
    private final int id;
    private static int proximoId = 1;
    private int limiteEmprestimos;
    private int diasDevolucao;
    private final ArrayList<Livro> livrosEmprestados;


    //construtor que inicializa apenas nome, email, incrememnta 1 ao ID e cria a ArrayList
    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.id = proximoId++;
        this.livrosEmprestados = new ArrayList<>();
    }

    //metodo concreto que indica que o usuario chegou no limite de emprestimos
    public boolean alcancouLimite(){
        return this.getLivrosEmprestados().size() >= this.getLimiteEmprestimos();
    }

    //metodo concreto que lista todos os livros emprestados por usuário (aluno, professor e visitante)
    public void listarLivrosEmprestadosPorUsuario(){
        System.out.println("\nlista de livros emprestados para " + this.getNome() + " abaixo:");
        for(Livro livros : this.getLivrosEmprestados())
            System.out.println(livros);
    }

    //encapsulamentoo
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        if(nome != null){
            this.nome = nome;
        }
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        if(email != null){
            this.email = email;
        }
    }

    public int getId(){
        return this.id;
    }

    public static int getProximoId(){
        return proximoId;
    }

    public int getLimiteEmprestimos(){
        return this.limiteEmprestimos;
    }

    public void setLimiteEmprestimos(int limiteEmprestimos){
        if(limiteEmprestimos > 0){
            this.limiteEmprestimos = limiteEmprestimos;
        }
    }

    public int getDiasDevolucao(){
        return this.diasDevolucao;
    }

    public void setDiasDevolucao(int diasDevolucao){
        if(diasDevolucao >= 0){
            this.diasDevolucao = diasDevolucao;
        }
    }

    public ArrayList<Livro> getLivrosEmprestados(){
        return this.livrosEmprestados;
    }
}