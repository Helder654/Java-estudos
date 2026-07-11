package Cinema;

public class Filmes{
    String nome;
    private Generos genero;
    private int duracao;
    private Classificacoes classificacao;
    
    public Filmes() {
    }

    public Filmes(String nome, Generos genero, int duracao, Classificacoes classificacao){
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Generos getGenero() {
        return genero;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Classificacoes getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacoes classificacao) {
        this.classificacao = classificacao;
    }



    
}
