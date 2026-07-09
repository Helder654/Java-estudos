public class Arqueiro extends Heroi{

    private String tipoFlecha;

     public Arqueiro(String nome, int nivel, int vida, String tipoFlecha) {
        super(nome, nivel, vida);
        this.tipoFlecha = tipoFlecha;
    }
     @Override
    public void atacar() {
        System.out.println(nome + " ataca com a flecha " + tipoFlecha);
    }

}
    