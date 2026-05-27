import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Assinatura assinatura = new AssinaturaBase();
        boolean[] escolhidos = new boolean[6];
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\nEscolha os pacotes da assinatura:");
            System.out.println("1 - Varios dispositivos - R$19,99");
            System.out.println("2 - Frete gratis - R$9,99");
            System.out.println("3 - Caixa surpresa - R$29,99");
            System.out.println("4 - Cartao Platinum - R$49,99");
            System.out.println("5 - Cash Back - R$19,99");
            System.out.println("0 - Finalizar");
            System.out.print("Opcao: ");
            opcao = entrada.nextInt();

            if (opcao == 0) {
                break;
            }

            if (opcao < 1 || opcao > 5) {
                System.out.println("Opcao invalida.");
            } else if (escolhidos[opcao]) {
                System.out.println("Esse pacote ja foi escolhido.");
            } else {
                escolhidos[opcao] = true;

                switch (opcao) {
                    case 1:
                        assinatura = new PacoteVariosDispositivos(assinatura);
                        break;
                    case 2:
                        assinatura = new PacoteFreteGratis(assinatura);
                        break;
                    case 3:
                        assinatura = new PacoteCaixaSurpresa(assinatura);
                        break;
                    case 4:
                        assinatura = new PacoteCartaoPlatinum(assinatura);
                        break;
                    case 5:
                        assinatura = new PacoteCashBack(assinatura);
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.println("\nAssinatura escolhida:");
        System.out.println(assinatura.getDescricao());
        System.out.println("Total: " + formatarPreco(assinatura.getPreco()));

        entrada.close();
    }

    public static String formatarPreco(double preco) {
        return String.format(Locale.US, "R$%.2f", preco).replace(".", ",");
    }
}
