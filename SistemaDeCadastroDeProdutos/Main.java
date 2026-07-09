import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Produto> produtos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        int codigoProduto;

        while(opcao != 8){
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Exibir produto");
            System.out.println("3 - Adicionar estoque");
            System.out.println("4 - Remover estoque");
            System.out.println("5 - Valor total em estoque");
            System.out.println("6 - Alterar preço");
            System.out.println("7 - Alterar quantidade");
            System.out.println("8 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    Produto produto = new Produto();
                    System.out.println("Nome do produto: ");
                    String nome = sc.nextLine();

                    System.out.println("Codigo do produto: ");
                    codigoProduto = sc.nextInt();

                    System.out.println("Quantidade do produto: ");
                    int quantidade = sc.nextInt();

                    System.out.println("Preco do produto: ");
                    double preco = sc.nextDouble();

                    produto.setNome(nome);
                    produto.setCodigo(codigoProduto);
                    produto.setQuantidadeEstoque(quantidade);
                    produto.setPreco(preco);

                    produtos.add(produto);

                    System.out.println("Produto adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o codigo do produto: ");
                    codigoProduto = sc.nextInt();

                    for (Produto p : produtos) {
                        if (p.getCodigo() == codigoProduto) {
                            p.exibirInformacoes();
                        } else {
                            System.out.println("Codigo invalido!");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o codigo do produto: ");
                    codigoProduto = sc.nextInt();

                    for (Produto p : produtos) {
                        if (p.getCodigo() == codigoProduto) {
                            System.out.println("Quantidade para adicionar no estoque: ");
                            p.adicionarEstoque(sc.nextInt());
                        } else {
                            System.out.println("Codigo invalido!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Digite o codigo do produto: ");
                    codigoProduto = sc.nextInt();

                    for (Produto p : produtos) {
                        if (p.getCodigo() == codigoProduto) {
                            System.out.println("Quantidade para remover no estoque: ");
                                p.removerEstoque(sc.nextInt());
                        } else {
                            System.out.println("Codigo invalido!");
                        }
                    }
                    break;

                case 5:
                     System.out.println("Digite o codigo do produto: ");
                    codigoProduto = sc.nextInt();

                     for (Produto p : produtos) {
                         if (p.getCodigo() == codigoProduto) {
                                p.calcularTotalEstoque();
                         }
                     }
                    break;

                case 6:
                    System.out.println("Digite o codigo do produto: ");
                    codigoProduto = sc.nextInt();

                    for (Produto p : produtos) {
                        if (p.getCodigo() == codigoProduto) {
                            System.out.println("Digite o novo valor do produto: ");
                            p.alterarPreco(sc.nextDouble());
                        }
                    }
                    break;

                case 7:
                    System.out.println("Digite o codigo do produto: ");
                    codigoProduto = sc.nextInt();

                    for (Produto p : produtos) {
                        if (p.getCodigo() == codigoProduto) {
                            System.out.println("Digite a quantidade do produto: ");
                            p.alterarQuantidade(sc.nextInt());

                        }
                    }
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
