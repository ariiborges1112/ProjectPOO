package projetoPOO.tiposUsuario;
//subclasse Aluno que herda tudo de Usuario
public class Aluno extends Usuario{
    public Aluno(String nome, String email){
        super(nome, email);
        this.definirLimite();
        this.definirDiasMaximoDevolucao();
    }

    //implementação da interface Regras
    @Override
    public double calcularMulta(int diasDeAtraso){
        return diasDeAtraso * 1.0;
    }

    //metodos que atribuem valor aos atributos limiteEmprestimos e diasDevolucao
    @Override
    public void definirLimite(){
        this.setLimiteEmprestimos(3);
    }

    @Override
    public void definirDiasMaximoDevolucao(){
        this.setDiasDevolucao(30);
    }

    //metodo toString() que retorna as informações do respectivo Aluno
    @Override
    public String toString(){
        return "\n----INFORMÇÕES DE ALUNO----" +
                "\nnome: " + this.getNome() + "\nID: " + this.getId() + "\nemail:" + this.getEmail() +
                "\nlimite de emprestimos: " + this.getLimiteEmprestimos() +
                "\ndias para devolver: " + this.getDiasDevolucao();
    }
}