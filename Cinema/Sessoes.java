package Cinema;

import java.util.ArrayList;
import java.time.LocalTime;

public class Sessoes {

    private int id;
    private Filmes filme;
    private LocalTime horario;
    private int sala;
    
    private ArrayList<Assento> assentos;
    private ArrayList<Assento> assentosReservados;

    public Sessoes(int id, Filmes filme, LocalTime horario, int sala) {
        this.id = id;
        this.filme = filme;
        this.horario = horario;
        this.sala = sala;
        this.assentos = new ArrayList<>();
        this.assentosReservados = new ArrayList<>();

        criarAssentos();
        
    }

    private void criarAssentos() {
    char[] fileiras = {'A', 'B', 'C'};

    for (char fileira : fileiras) {
        for (int numero = 1; numero <= 5; numero++) {
            assentos.add(new Assento(fileira, numero));
        }
    }
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filmes getFilme() {
        return filme;
    }

    public void setFilme(Filmes filme) {
        this.filme = filme;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public ArrayList<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(ArrayList<Assento> assentos) {
        this.assentos = assentos;
    }

    public ArrayList<Assento> getAssentosReservados() {
        return assentosReservados;
    }

    public void mostrarTodosAssentos() {
    for (Assento assento : assentos) {

        if (assentosReservados.contains(assento)) {
            System.out.println(
                    assento.fileira() + "" + assento.numero() + " - RESERVADO"
            );
        } else {
            System.out.println(
                    assento.fileira() + "" + assento.numero() + " - LIVRE"
            );
        }
    }
}
    public boolean reservarAssento(Assento assento) {

        if (!assentos.contains(assento)) {
            return false;
        }

        if (assentosReservados.contains(assento)) {
            return false;
        }

        assentosReservados.add(assento);
        return true;
    }
    @Override
    public String toString() {
        return "ID: " + id +
            " | Filme: " + filme.getNome() +
            " | Horário: " + horario +
            " | Sala: " + sala;
    }
    public void mostrarAssentosReservados(){
        if(assentosReservados.isEmpty()){
            System.out.println("Nenhum assento reservado nessa sessão");
        return;
        }
        for(Assento assento : assentosReservados){
        System.out.println(assento.fileira() + " " + assento.numero()
            );
        }
    }
    public boolean cancelarReserva(Assento assento) {

        if (!assentosReservados.contains(assento)) {
            return false;
        }
        assentosReservados.remove(assento);
        return true;
    }
    public void mostrarAssentosDisponiveis() {
    if (assentos.isEmpty()) {
        System.out.println("Não há nenhum assento cadastrado.");
        return;
    }

    boolean encontrouDisponivel = false;

    for (Assento assento : assentos) {
        if (!assentosReservados.contains(assento)) {
            System.out.println(
                    assento.fileira() + "" + assento.numero()
            );

            encontrouDisponivel = true;
        }
    }

    if (!encontrouDisponivel) {
        System.out.println("Não há assentos disponíveis.");
        }
    }
}
