package projetoPOO.tiposUsuario;
//subclasse Visitante que herda tudo de Usuario
public class Visitante extends Usuario{
    public Visitante(String nome, int id, String email){
        super(nome, id, email);
        this.definirLimite();
        this.definirDiasMaximoDevolucao();
    }

    @Override
    public double calcularMulta(int diasDeAtraso){
        return diasDeAtraso * 1.5;
    }

    @Override
    public void definirLimite(){
        this.setLimiteEmprestimos(2);
    }

    @Override
    public void definirDiasMaximoDevolucao(){
        this.setDiasDevolucao(25);
    }

    @Override
    public String toString(){
        return "\n----INFORMÇÕES DE VISITANTE----" +
                "\nnome: " + this.getNome() + "\nID: " + this.getId() + "\nemail:" + this.getEmail() +
                "\nlimite de emprestimos: " + this.getLimiteEmprestimos() +
                "\ndias para devolver: " + this.getDiasDevolucao();
    }
}