package GerenciamentoDeBanco;

public interface Conta {
    
    void consultarSaldo();

    abstract void depositar(double valor);
}
