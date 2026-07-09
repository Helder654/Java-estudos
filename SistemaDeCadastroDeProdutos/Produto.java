public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            System.out.println("O nome nao pode ser nulo.");
        } else {
            this.nome = nome;
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            System.out.println("preço deve ser maior que zero");
        } else {
            this.preco = preco;
        }
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0) {
            System.out.println("A quantidade nao pode ser menor que zero");
        } else {
            this.quantidadeEstoque = quantidadeEstoque;
        }
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("A quantidade nao pode ser menor que zero");
        } else {
            this.quantidadeEstoque += quantidade;
        }
    }

    public void removerEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("A quantidade nao pode ser menor que zero");
        } else {
            this.quantidadeEstoque -= quantidade;
        }

    }

    public void calcularTotalEstoque() {
        double totalEstoque = quantidadeEstoque * preco;
        System.out.println("O valor total em estoque é: " + totalEstoque);
    }

    public void exibirInformacoes() {
        System.out.println("Nome do produto: " + nome);
        System.out.println("Codigo do produto: " + codigo);
        System.out.println("Preço do produto: " + preco);
        System.out.println("Quantidade do produto: " + quantidadeEstoque);
    }

    public void alterarPreco(double valor) {
        setPreco(valor);
        System.out.println("Valor de " + nome + " atualizado com sucesso!");
    }

    public void alterarQuantidade(int quantidade) {
        setQuantidadeEstoque(quantidade);
        System.out.println("quantidade de " + nome + " atualizado com sucesso!");
    }
}
