package SistemaFuncionarios;

public class Gerente extends Funcionario implements Bonificavel {
    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente " + nome + " está gerenciando a equipe.");
    }

    public double calcularBonus(double valor) {
        return salario * 0.25;
    }
}
