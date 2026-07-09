public class Desenvolvedor extends Funcionario implements Bonificavel {
    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor " + nome + " está desenvolvendo código.");
    }
    public double calcularBonus(double valor) {
        return salario * 0.15;
    }
}
