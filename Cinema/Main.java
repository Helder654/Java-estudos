package Cinema;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Filmes> Filme = new ArrayList<>();
        ArrayList<Sessoes> Sessao = new ArrayList<>();
        
        int menu = 0;
        while(menu != 8){

        System.out.println("1. Cadastrar filmes.");
        System.out.println("2. Criar sessões");
        System.out.println("3. Reservar assentos");
        System.out.println("4. Cancelar reservas.");
        System.out.println("5. Listar sessões.");
        System.out.println("6. Mostrar assentos disponíveis.");
        System.out.println("7. Mostrar assentos ocupados.");
        System.out.println("8. Sair");
        
        menu = sc.nextInt();
        sc.nextLine();
       
        switch (menu) {
            case 1:
                //cadastrar filme
                System.out.println("Digite o nome do filme");
                String nome = sc.nextLine();
               
                System.out.println("Digite a duração do filme em minutos");
                int duracao = sc.nextInt();
                sc.nextLine();
            
                System.out.println("Gêneros disponíveis:");
                    for (Generos g : Generos.values()) {
                        System.out.println(g);
                    }
                    Generos genero = null;

                    while(genero == null){
                System.out.println("Escolha o genero do filme");
            
                try {
                    genero = Generos.valueOf(sc.nextLine().trim().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Gênero inválido. Digite uma opção existente.");
                    }
                }    
                

                System.out.println("Classificações Disponiveis: ");
                    for(Classificacoes c : Classificacoes.values()){
                        System.out.println(c);
                    }

                Classificacoes classificacao = null;

                while(classificacao == null){
                System.out.println("Escolha a classificação do filme");
                
                try{
                    classificacao = Classificacoes.valueOf(sc.nextLine().trim().toUpperCase());
                } catch(IllegalArgumentException e) {
                    System.out.println("Classificação invalida, selecione uma classificação disponivel");
                    }
                }

                Filmes filme = new Filmes(nome, genero, duracao, classificacao);
                Filme.add(filme);

                System.out.println("Filme cadastrado com sucesso!");
                
                break;

            case 2:
                //criar seções
                if (Filme.isEmpty()) {
                        System.out.println("Nenhum filme cadastrado. Cadastre um filme primeiro.");
                     break;
                }
                
                System.out.println("Digite o id da seção");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Filmes disponiveis: ");
                for(int i = 0; i < Filme.size(); i++){
                    System.out.println((i + 1) + " - " + Filme.get(i).getNome());
                }
                    int opcaoFilme = 0;
                    
                    while (opcaoFilme < 1 || opcaoFilme > Filme.size()) {
                        
                        System.out.println("Escolha um filme");
                        
                        opcaoFilme = sc.nextInt();
                        sc.nextLine();

                        if(opcaoFilme <= 0 || opcaoFilme > Filme.size()){
                        System.out.println("Voce selecionou uma opção invalida");
                        }
                    }
                        Filmes filmeSelecionado = Filme.get(opcaoFilme - 1);

                    LocalTime horario = null;
                    
                    while (horario == null) {
                    System.out.println("Digite o Horario da seção");

                    try {
                        horario = LocalTime.parse(sc.nextLine().trim());
                    } catch (DateTimeParseException e) {
                        System.out.println("Horario invalido. Exemplo válido: 20:30");
                    }
                }
                System.out.println("Digite a sala da seção");
                int sala = sc.nextInt();
                sc.nextLine();

                Sessoes sessao = new Sessoes(id, filmeSelecionado, horario, sala);
                Sessao.add(sessao);
                
                System.out.println("Sessão criada com sucesso!");

                break;

            case 3:
                // Reservar assento

                if (Sessao.isEmpty()) {
                    System.out.println("Nenhuma sessão cadastrada.");
                    break;
                }

                System.out.println("Sessões disponíveis:");

                for (int i = 0; i < Sessao.size(); i++) {
                    Sessoes sessaoAtual = Sessao.get(i);

                    System.out.println(
                            (i + 1) + " - " + sessaoAtual.getFilme().getNome() + " | Horário: " + sessaoAtual.getHorario() + " | Sala: " + sessaoAtual.getSala());
                }

                int opcaoSessao = 0;

                while (opcaoSessao < 1 || opcaoSessao > Sessao.size()) {
                    System.out.println("Escolha uma sessão:");

                    opcaoSessao = sc.nextInt();
                    sc.nextLine();

                    if (opcaoSessao < 1 || opcaoSessao > Sessao.size()) {
                        System.out.println("Sessão inválida. Escolha uma opção da lista.");
                    }
                }

                Sessoes sessaoSelecionada = Sessao.get(opcaoSessao - 1);

                System.out.println("Assentos da sessão:");
                sessaoSelecionada.mostrarTodosAssentos();

                System.out.println("Digite a fileira do assento:");

                char fileira = sc.nextLine().trim().toUpperCase().charAt(0);

                System.out.println("Digite o número do assento:");

                int numeroAssento = sc.nextInt();
                sc.nextLine();

                Assento assentoEscolhido = new Assento(fileira, numeroAssento);

                boolean reservado =
                        sessaoSelecionada.reservarAssento(assentoEscolhido);

                if (reservado) {
                    System.out.println("Assento " + fileira + numeroAssento + " reservado com sucesso!");
                } else {
                    System.out.println(
                            "Esse assento não existe ou já está reservado."
                    );
                }

            break;

            case 4:
                // Cancelar reserva

                if (Sessao.isEmpty()) {
                    System.out.println("Nenhuma sessão cadastrada.");
                    break;
                }

                System.out.println("Sessões disponíveis:");

                for (int i = 0; i < Sessao.size(); i++) {
                    Sessoes sessaoAtual = Sessao.get(i);

                    System.out.println(
                            (i + 1)
                            + " - " + sessaoAtual.getFilme().getNome()
                            + " | Horário: " + sessaoAtual.getHorario()
                            + " | Sala: " + sessaoAtual.getSala()
                    );
                }

                int opcaoSessaoCancelar = 0;

                while (
                        opcaoSessaoCancelar < 1
                        || opcaoSessaoCancelar > Sessao.size()
                ) {
                    System.out.println("Escolha uma sessão:");

                    opcaoSessaoCancelar = sc.nextInt();
                    sc.nextLine();

                    if (
                            opcaoSessaoCancelar < 1
                            || opcaoSessaoCancelar > Sessao.size()
                    ) {
                        System.out.println("Sessão inválida.");
                    }
                }

                Sessoes sessaoParaCancelar =
                        Sessao.get(opcaoSessaoCancelar - 1);

                if (sessaoParaCancelar.getAssentosReservados().isEmpty()) {
                    System.out.println(
                            "Essa sessão não possui reservas para cancelar."
                    );
                    break;
                }

                System.out.println("Assentos reservados:");
                sessaoParaCancelar.mostrarAssentosReservados();

                System.out.println("Digite a fileira do assento:");

                char fileiraCancelar = sc.nextLine().trim().toUpperCase().charAt(0);

                System.out.println("Digite o número do assento:");

                int numeroCancelar = sc.nextInt();
                sc.nextLine();

                Assento assentoCancelar =
                        new Assento(fileiraCancelar, numeroCancelar);

                boolean cancelado =
                        sessaoParaCancelar.cancelarReserva(assentoCancelar);

                if (cancelado) {
                    System.out.println("Reserva do assento " + fileiraCancelar + numeroCancelar + " cancelada com sucesso!");
                } else {
                    System.out.println("Esse assento não possui reserva nesta sessão.");
                }

                break;

                case 5:
                    //listar sessoes
                    for (Sessoes sessao1 : Sessao) {
                        System.out.println(sessao1);
                        }
                break;

                case 6:
                        //listar assentos disponiveis
                    if (Sessao.isEmpty()) {
                        System.out.println("Nenhuma sessão cadastrada.");
                        break;
                    }

                    System.out.println("Sessões disponíveis:");

                    for (int i = 0; i < Sessao.size(); i++) {
                        Sessoes sessaoAtual = Sessao.get(i);

                        System.out.println(
                                (i + 1)
                                + " - " + sessaoAtual.getFilme().getNome()
                                + " | Horário: " + sessaoAtual.getHorario()
                                + " | Sala: " + sessaoAtual.getSala()
                        );
                    }

                    int opcaoSessaoDisponivel = 0;

                    while (
                            opcaoSessaoDisponivel < 1
                            || opcaoSessaoDisponivel > Sessao.size()
                    ) {
                        System.out.println("Escolha uma sessão:");

                        opcaoSessaoDisponivel = sc.nextInt();
                        sc.nextLine();

                        if (
                                opcaoSessaoDisponivel < 1
                                || opcaoSessaoDisponivel > Sessao.size()
                        ) {
                            System.out.println("Sessão inválida.");
                        }
                    }

                    Sessoes sessaoDisponivel =
                            Sessao.get(opcaoSessaoDisponivel - 1);

                    System.out.println("Assentos disponíveis:");

                    sessaoDisponivel.mostrarAssentosDisponiveis();

                 break;

                 case 7:
                    //listar assentos ocupados
                    if (Sessao.isEmpty()) {
                        System.out.println("Nenhuma sessão cadastrada.");
                        break;
                    }

                    System.out.println("Sessões disponíveis:");

                    for (int i = 0; i < Sessao.size(); i++) {
                        Sessoes sessaoAtual = Sessao.get(i);

                        System.out.println(
                                (i + 1)
                                + " - " + sessaoAtual.getFilme().getNome()
                                + " | Horário: " + sessaoAtual.getHorario()
                                + " | Sala: " + sessaoAtual.getSala()
                        );
                    }

                    int opcaoSessaoOcupada = 0;

                    while (
                            opcaoSessaoOcupada < 1
                            || opcaoSessaoOcupada > Sessao.size()
                    ) {
                        System.out.println("Escolha uma sessão:");

                        opcaoSessaoOcupada = sc.nextInt();
                        sc.nextLine();

                        if (
                                opcaoSessaoOcupada < 1
                                || opcaoSessaoOcupada > Sessao.size()
                        ) {
                            System.out.println("Sessão inválida.");
                        }
                    }

                    Sessoes sessaoOcupada =
                            Sessao.get(opcaoSessaoOcupada - 1);

                    System.out.println("Assentos ocupados:");

                    sessaoOcupada.mostrarAssentosReservados();

                    break;        
                    case 8:
                        //encerrar programa
                        System.out.println("Sistema encerrado.");
                    break;
                    
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
            }
        }
    sc.close();
    }
}
