package SistemaFuncionarios;

public class main {
    public static void main(String[] args) {
        Desenvolvedor dev1 = new Desenvolvedor("João", 5000.0);
            dev1.trabalhar();
            double bonusDev1 = dev1.calcularBonus(dev1.salario);
            System.out.println("Bônus do desenvolvedor " + dev1.nome + ": " + bonusDev1);
            dev1.mostrarDados();
        

        Gerente gerente1 = new Gerente("Maria", 8000.0);
            gerente1.trabalhar();
            double bonusGerente1 = gerente1.calcularBonus(gerente1.salario);
            System.out.println("Bônus do gerente " + gerente1.nome + ": " + bonusGerente1);
            gerente1.mostrarDados();
        
        Estagiario estagiario1 = new Estagiario("Pedro", 1500.0);
            estagiario1.trabalhar();
            estagiario1.mostrarDados();
    }
}
