package GerenciamentoDeBanco;

public class ContaCorrente extends ContaBancaria{

    double saldo;
    TipoConta CORRENTE;

    public ContaCorrente(double saldo) {
        this.saldo = saldo;
    }
    //TODO: sobrecarga do construtor chamando novos atributos
        
    public ContaCorrente(double saldo, TipoConta CORRENTE) {
        this(saldo);
        this.CORRENTE = CORRENTE;
    }

    @Override
    public void depositar(double valor){
        saldo = saldo + valor;
    }

    @Override
    public void consultarSaldo(){
        System.out.println(saldo);
    }


}
