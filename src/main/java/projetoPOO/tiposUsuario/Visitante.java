package projetoPOO.tiposUsuario;
//subclasse Visitante que herda tudo de Usuario
public class Visitante extends Usuario{
    public Visitante(String nome, String email){
        super(nome, email);
        this.definirLimite();
        this.definirDiasMaximoDevolucao();
    }

    //implementação da interface Regras
    @Override
    public double calcularMulta(int diasDeAtraso){
        return diasDeAtraso * 1.5;
    }

    //metodos que atribuem valor aos atributos limiteEmprestimos e diasDevolucao
    @Override
    public void definirLimite(){
        this.setLimiteEmprestimos(2);
    }

    @Override
    public void definirDiasMaximoDevolucao(){
        this.setDiasDevolucao(25);
    }

    //metodo toString() que retorna as informações do respectivo Visitante
    @Override
    public String toString(){
        return "\n----INFORMÇÕES DE VISITANTE----" +
                "\nnome: " + this.getNome() + "\nID: " + this.getId() + "\nemail:" + this.getEmail() +
                "\nlimite de emprestimos: " + this.getLimiteEmprestimos() +
                "\ndias para devolver: " + this.getDiasDevolucao();
    }
}