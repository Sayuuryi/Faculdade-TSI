public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Concessionaria();

        hotel.vender(); // Vai gerar erro em tempo de execução
        // Exception in thread "main" java.lang.UnsupportedOperationException Mostra Claramente a violação do Principio de Substituição de Liskov.
    }
}