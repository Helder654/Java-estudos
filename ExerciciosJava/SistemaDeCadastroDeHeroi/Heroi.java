public abstract class Heroi {
    protected String nome;
    protected int nivel;
    protected int vida;

   
    public Heroi(String nome, int nivel, int vida) {
        this.nome = nome;
        this.nivel = nivel;
        this.vida = vida;
    }

    public void informacoesHeroi() {
        System.out.println("Nome: " + nome);
        System.out.println("Nível: " + nivel);
        System.out.println("Vida: " + vida);
    }

    public abstract void atacar();


}
