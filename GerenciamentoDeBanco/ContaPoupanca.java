package GerenciamentoDeBanco;

public class ContaPoupanca extends ContaBancaria{

    double saldo;
    TipoConta POUPANCA;

    public ContaPoupanca(double saldo) {
        this.saldo = saldo;
    }

    public ContaPoupanca(double saldo, TipoConta POUPANCA) {
        this(saldo);
        this.POUPANCA = POUPANCA;
    }
    @Override
    public void depositar(double valor){
        saldo = (saldo + valor) * 0.99;
    }
    @Override
    public void consultarSaldo(){
        System.out.println(saldo);
    }
}
