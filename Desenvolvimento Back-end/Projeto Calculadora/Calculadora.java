import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();

            // Switch com as opções do que o usuário pode escolher.
            switch (opcao) {
                case 0:
                    System.out.println("Encerrando calculadora...");
                    break;

                case 1:
                    System.out.println("Resultado: " + subtracao(scanner));
                    break;

                case 2:
                    System.out.println("Resultado: " + multiplicacao(scanner));
                    break;

                case 3:
                    divisao(scanner);
                    break;

                case 4:
                    System.out.println("Resultado: " + raizQuadrada(scanner));
                    break;

                case 5:
                    System.out.println("Resultado: " + raizCubica(scanner));
                    break;

                case 6:
                    System.out.println("Resultado: " + potencia(scanner));
                    break;

                case 7:
                    System.out.println("Binário: " + decimalParaBinario(scanner));
                    break;

                case 8:
                    System.out.println("Resultado: " + dezElevado(scanner));
                    break;

                case 9:
                    System.out.println("Fatorial: " + fatorial(scanner));
                    break;

                case 10:
                    System.out.println("PI = " + Math.PI);
                    break;

                default:
                    System.out.println("Opção inválida!\n");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // Menu da calculadora mostrado ao usuário.
    private static void mostrarMenu() {
        System.out.println("\n===== CALCULADORA =====");
        System.out.println("0  - Sair");
        System.out.println("1  - Subtração");
        System.out.println("2  - Multiplicação");
        System.out.println("3  - Divisão");
        System.out.println("4  - Raiz Quadrada");
        System.out.println("5  - Raiz Cúbica");
        System.out.println("6  - Potência (a^b)");
        System.out.println("7  - Decimal para Binário");
        System.out.println("8  - 10 elevado a N");
        System.out.println("9  - Fatorial");
        System.out.println("10 - Valor de PI");
        System.out.print("Escolha: ");
    }

    // Métodos para fazer operações matemáticas.
    private static double subtracao(Scanner scanner) {
        System.out.print("Número 1: ");
        double a = scanner.nextDouble();

        System.out.print("Número 2: ");
        double b = scanner.nextDouble();

        return a - b;
    }

    private static double multiplicacao(Scanner scanner) {
        System.out.print("Número 1: ");
        double a = scanner.nextDouble();

        System.out.print("Número 2: ");
        double b = scanner.nextDouble();

        return a * b;
    }

    private static void divisao(Scanner scanner) {
        System.out.print("Número 1: ");
        double a = scanner.nextDouble();

        System.out.print("Número 2: ");
        double b = scanner.nextDouble();

        if (b != 0)
            System.out.println("Resultado: " + (a / b));
        else
            System.out.println("Erro: divisão por zero!");
    }

    private static double raizQuadrada(Scanner scanner) {
        System.out.print("Número: ");
        return Math.sqrt(scanner.nextDouble());
    }

    private static double raizCubica(Scanner scanner) {
        System.out.print("Número: ");
        return Math.cbrt(scanner.nextDouble());
    }

    private static double potencia(Scanner scanner) {
        System.out.print("Base: ");
        double base = scanner.nextDouble();

        System.out.print("Expoente: ");
        double exp = scanner.nextDouble();

        return Math.pow(base, exp);
    }

    private static String decimalParaBinario(Scanner scanner) {
        System.out.print("Número inteiro: ");
        return Integer.toBinaryString(scanner.nextInt());
    }

    private static double dezElevado(Scanner scanner) {
        System.out.print("Expoente: ");
        return Math.pow(10, scanner.nextInt());
    }

    private static long fatorial(Scanner scanner) {
        System.out.print("Número inteiro: ");
        int n = scanner.nextInt();
        long fat = 1;
        for (int i = 1; i <= n; i++) {
            fat *= i;
        }

        return fat;
    
    }
}
