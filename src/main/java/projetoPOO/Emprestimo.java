package projetoPOO;
//importação da classe Usuario
import projetoPOO.tiposUsuario.Usuario;
//classe que dá dados ao Emprestimo
public class Emprestimo{
    final int idEmprestimo;
    static int proximoId = 1;
    private Usuario usuario;
    private Livro livro;
    private String dataEmprestimo;
    private boolean ativo;

    //construtor que inicializa usuario, livro e incrementa 1 ao ID
    public Emprestimo(Usuario usuario, Livro livro){
        this.idEmprestimo = proximoId++;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = "";
        this.ativo = true;
    }

    //metodo toString() que retorna as informações do respectivo Emprestimo
    @Override
    public String toString(){
        return "\n----INFORMAÇÕES DO EMPRÉSTIMO----" +
                "\nID do empréstimo: " + idEmprestimo + "\nusuário=" + usuario +
                "\nlivro: " + livro + "\ndevolvido: " + ativo;
    }

    //encapsulamento
    public Usuario getUsuario(){
        return this.usuario;
    }

    public void setUsuario(Usuario usuario){
        if(usuario != null){
            this.usuario = usuario;
        }
    }

    public Livro getLivro(){
        return this.livro;
    }

    public void setLivro(Livro livro){
        if(livro != null){
            this.livro = livro;
        }
    }

    public String getDataEmprestimo(){
        return this.dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo){
        if(dataEmprestimo != null){
            this.dataEmprestimo = dataEmprestimo;
        }
    }

    public boolean isAtivo(){
        return this.ativo;
    }

    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
}