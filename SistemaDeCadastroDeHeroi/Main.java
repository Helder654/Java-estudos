import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Voce quer criar um Guerreiro ou um Arqueiro?");
        
        String classe = sc.nextLine();

        if(classe.equalsIgnoreCase("Guerreiro")){

        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Nivel:");
        int nivel = sc.nextInt();

        System.out.println("Vida:");
        int vida = sc.nextInt();
        sc.nextLine();

        System.out.println("Arma:");
        String arma = sc.nextLine();
        

        Guerreiro Guerreiro1 = new Guerreiro(nome, nivel, vida, arma);

        System.out.println("Voce criou um guerreiro");
        Guerreiro1.informacoesHeroi();
        Guerreiro1.atacar();
        }else if(classe.equalsIgnoreCase("Arqueiro")){
        
        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Nivel:");
        int nivel = sc.nextInt();

        System.out.println("Vida:");
        int vida = sc.nextInt();
        sc.nextLine();

        System.out.println("Tipo de flecha:");
        String tipoFlecha = sc.nextLine();
        

        Arqueiro Arqueiro1 = new Arqueiro(nome, nivel, vida, tipoFlecha);

        System.out.println("Voce criou um Arqueiro ");
        Arqueiro1.informacoesHeroi();
        Arqueiro1.atacar();
    }else{
        System.out.println("Voce digitou um valor invalido");
    }
}
}
