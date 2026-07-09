import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Livro> livros = new ArrayList<>();
        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Emprestar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Ano de publicacao: ");
                    int anoPublicacao = sc.nextInt();
                    sc.nextLine();

                    Livro livro = new Livro(titulo, autor, anoPublicacao, true);
                    livros.add(livro);

                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:

                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        for (Livro l : livros) {
                            l.exibirInformacoes();
                        }
                    }

                    break;

                case 3:

                    System.out.print("Digite o titulo do livro: ");
                    String tituloEmprestar = sc.nextLine();

                    boolean encontrado = false;

                    for (Livro l : livros) {
                        if (l.getTitulo().equalsIgnoreCase(tituloEmprestar)) {
                            l.emprestar();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Livro nao encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("Digite o titulo do livro: ");
                    String tituloDevolver = sc.nextLine();

                    encontrado = false;

                    for (Livro l : livros) {
                        if (l.getTitulo().equalsIgnoreCase(tituloDevolver)) {
                            l.devolver();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Livro nao encontrado.");
                    }

                    break;

                case 5:

                    System.out.println("Programa encerrado.");
                    break;

                default:

                    System.out.println("Opcao invalida.");
            }
        }

        sc.close();
    }
}