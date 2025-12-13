package projetoPOO.tiposUsuario;
//subclasse Professor que herda tudo de Usuario
public class Professor extends Usuario{
    public Professor(String nome, String email){
        super(nome, email);
        this.definirLimite();
        this.definirDiasMaximoDevolucao();
    }

    //implementação da interface Regras
    @Override
    public double calcularMulta(int diasDeAtraso){
        return diasDeAtraso * 0.5;
    }

    //metodos que atribuem valor aos atributos limiteEmprestimos e diasDevolucao
    @Override
    public void definirLimite(){
        this.setLimiteEmprestimos(10);
    }

    @Override
    public void definirDiasMaximoDevolucao(){
        this.setDiasDevolucao(100);
    }

    //metodo toString() que retorna as informações do respectivo Professor
    @Override
    public String toString(){
        return "\n----INFORMÇÕES DE PROFESSOR----" +
                "\nnome: " + this.getNome() + "\nID: " + this.getId() + "\nemail:" + this.getEmail() +
                "\nlimite de emprestimos: " + this.getLimiteEmprestimos() +
                "\ndias para devolver: " + this.getDiasDevolucao();
    }
}