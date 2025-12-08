package projetoPOO;
//importação da classe Usuario
import projetoPOO.tiposUsuario.Usuario;
//classe que dita o que é um empréstimo
public class Emprestimo{
    private final int idEmprestimo;
    private static int proximoId = 1;
    private Usuario usuario;
    private Livro livro;
    private String dataEmprestimo;
    private boolean ativo;

    public Emprestimo(Usuario usuario, Livro livro){
        this.idEmprestimo = proximoId++;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = "";
        this.ativo = true;
    }

    public void finalizarEmprestimo(){
        this.ativo = false;
        this.livro.setDisponivel(true);
        this.usuario.getLivrosEmprestados().remove(this.livro);

        System.out.println("empréstimo de " + this.livro.getTitulo() + " foi concluido");
    }

    //metodo toString() que retorna as informações do respectivo Emprestimo
    @Override
    public String toString(){
        return "\n----INFORMAÇÕES DO EMPRÉSTIMO----" +
                "\nID do empréstimo: " + idEmprestimo + "\nusuário=" + usuario +
                "\nlivro: " + livro + "\ndevolvido: " + ativo;
    }

    //encapsulamento
    public int getIdEmprestimo(){
        return this.idEmprestimo;
    }

    public static int getProximoId(){
        return proximoId;
    }

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