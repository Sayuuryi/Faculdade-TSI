public class Main {

    public static void main(String[] args) {

        Pagamento pagamento = new PagamentoPix(); // Testar com o PIX
        // Pagamento pagamento = new CorretoPagamentoCartao(); // Testar com o Cartão
        
        CorretoHotel hotel = new CorretoHotel(pagamento);

        hotel.realizarPagamento();

    }

}