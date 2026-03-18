import java.util.Scanner;

public class ExemploFactoryMethod {
    public static void main(String[] args) {

        Aplicacao app = new Aplicacao();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("Escolha o tipo:");
            System.out.println("1 - Windows");
            System.out.println("2 - HTML");
            System.out.println("3 - Jogo");
            System.out.println("4 - Mobile");
            System.out.println("5 - Texto");

            opcao = scanner.nextInt();
            String tipo = "";

            switch (opcao) {
            case 1: tipo = "windows"; break;
            case 2: tipo = "web"; break;
            case 3: tipo = "jogo"; break;
            case 4: tipo = "mobile"; break;
            case 5: tipo = "texto"; break;
            case 6: tipo = "sair"; break;
            default:
                System.out.println("Opção inválida!");
                return;
            }
            app.initialize(tipo);
            app.run();
            
        } while (opcao != 6);

        scanner.close();

        
    }
}