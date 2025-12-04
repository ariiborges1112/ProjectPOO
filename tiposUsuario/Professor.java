package projetoPOO.tiposUsuario;
//subclasse Professor que herda tudo de Usuario
public class Professor extends Usuario{
    public Professor(String nome, int id, String email){
        super(nome, id, email);
        this.definirLimite();
        this.definirDiasMaximoDevolucao();
    }

    @Override
    public double calcularMulta(int diasDeAtraso){
        return diasDeAtraso * 0.5;
    }

    @Override
    public void definirLimite(){
        this.setLimiteEmprestimos(10);
    }

    @Override
    public void definirDiasMaximoDevolucao(){
        this.setDiasDevolucao(100);
    }

    @Override
    public String toString(){
        return "\n----INFORMÇÕES DE PROFESSOR----" +
                "\nnome: " + this.getNome() + "\nID: " + this.getId() + "\nemail:" + this.getEmail() +
                "\nlimite de emprestimos: " + this.getLimiteEmprestimos() +
                "\ndias para devolver: " + this.getDiasDevolucao();
    }
}