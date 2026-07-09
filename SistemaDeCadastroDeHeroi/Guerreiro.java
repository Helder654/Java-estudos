public class Guerreiro extends Heroi {
    
    private String arma;

    public Guerreiro(String nome, int nivel, int vida, String arma) {
        super(nome, nivel, vida);
        this.arma = arma;
    }

    @Override
    public void atacar() {
        System.out.println(nome + " ataca com sua " + arma);
    }

}
