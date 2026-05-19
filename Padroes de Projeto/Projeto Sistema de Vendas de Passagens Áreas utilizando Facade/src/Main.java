import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("=== Sistema de Venda de Pacote de Viagens ===");

            System.out.print("Quantidade de compradores: ");
            int quantidadeCompradores = Integer.parseInt(entrada.nextLine());

            List<Comprador> compradores = new ArrayList<>();
            for (int i = 1; i <= quantidadeCompradores; i++) {
                System.out.println();
                System.out.println("Comprador " + i);

                System.out.print("Nome: ");
                String nome = entrada.nextLine();

                System.out.print("CPF: ");
                String cpf = entrada.nextLine();

                compradores.add(new Comprador(nome, cpf));
            }

            System.out.println();
            System.out.print("Escolha a poltrona do aviao. Exemplo 1A, 8C ou 32F: ");
            String poltrona = entrada.nextLine();

            System.out.println();
            System.out.println("Tipo de quarto:");
            System.out.println("1 - Simples");
            System.out.println("2 - Executivo");
            System.out.println("3 - Suite presidencial");
            System.out.print("Opcao: ");
            int opcaoQuarto = Integer.parseInt(entrada.nextLine());

            System.out.print("Quantidade de diarias no hotel: ");
            int diariasHotel = Integer.parseInt(entrada.nextLine());

            System.out.println();
            System.out.println("Tipo de carro:");
            System.out.println("1 - Economico");
            System.out.println("2 - Executivo");
            System.out.println("3 - Luxo");
            System.out.print("Opcao: ");
            int opcaoCarro = Integer.parseInt(entrada.nextLine());

            System.out.print("Quantidade de diarias do carro: ");
            int diariasCarro = Integer.parseInt(entrada.nextLine());

            System.out.println();
            System.out.println("Forma de pagamento:");
            System.out.println("1 - Pix: 10% de desconto");
            System.out.println("2 - Boleto: 5% de desconto");
            System.out.println("3 - Debito: valor normal");
            System.out.println("4 - Credito: ate 6 vezes com juros de 3,99% a partir da 2a parcela");
            System.out.print("Opcao: ");
            int opcaoPagamento = Integer.parseInt(entrada.nextLine());

            int parcelas = 1;
            if (opcaoPagamento == 4) {
                System.out.print("Quantidade de parcelas: ");
                parcelas = Integer.parseInt(entrada.nextLine());
            }

            PacoteViagemFacade facade = new PacoteViagemFacade();
            PacoteViagem pacote = facade.comprarPacote(compradores, poltrona, opcaoQuarto, diariasHotel,
                    opcaoCarro, diariasCarro, opcaoPagamento, parcelas);

            pacote.imprimirResumo();
        } catch (Exception erro) {
            System.out.println();
            System.out.println("Erro: " + erro.getMessage());
        } finally {
            entrada.close();
        }
    }
}
