public class Estagiario extends Funcionario {
    public Estagiario(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void trabalhar() {
        System.out.println("Estagiário " + nome + " está aprendendo e auxiliando nas tarefas.");
    }


}
