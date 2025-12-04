package projetoPOO.tiposUsuario;
//importe da classe Livro e da ArrayList
import projetoPOO.Livro;
import java.util.ArrayList;
//criação da classe abstrata e da implementação da interface
public abstract class Usuario implements Regras{
    private String nome;
    private int id;
    private String email;
    private int limiteEmprestimos;
    private int diasDevolucao;
    private final ArrayList<Livro> livrosEmprestados;

    //construtor que inicializa apenas nome, id, email e cria o ArrayList
    public Usuario(String nome, int id, String email){
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.livrosEmprestados = new ArrayList<>();
    }

    //metodo concreto
    public boolean alcancouLimite(){
        if(this.getLivrosEmprestados().size() >= this.getLimiteEmprestimos()){
            System.out.println("limite alcançado!");
            return true;
        }
        System.out.println("o limite não foi alcançado");
        System.out.println("ainda há espaço");
        return false;
    }

    //encapsulamento
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        if(this.nome != null){
            this.nome = nome;
        }
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        if(this.id > 0){
            this.id = id;
        }
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        if(this.email != null){
            this.email = email;
        }
    }

    public int getLimiteEmprestimos(){
        return this.limiteEmprestimos;
    }

    public void setLimiteEmprestimos(int limiteEmprestimos){
        if(this.limiteEmprestimos > 0){
            this.limiteEmprestimos = limiteEmprestimos;
        }
    }

    public int getDiasDevolucao(){
        return this.diasDevolucao;
    }

    public void setDiasDevolucao(int diasDevolucao){
        this.diasDevolucao = diasDevolucao;
    }

    public ArrayList<Livro> getLivrosEmprestados(){
        return this.livrosEmprestados;
    }
}