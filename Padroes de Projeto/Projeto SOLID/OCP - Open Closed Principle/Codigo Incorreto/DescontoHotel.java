public class DescontoHotel {

    public double calcularDesconto(String tipo) {

        if (tipo.equals("DESCONTO-VIP")) // Verifica se o tipo é DESCONTO-VIP e se for aplica um Desconto.
            return 0.2;

        if (tipo.equals("DESCONTO-NORMAL")) // Verifica se o tipo é DESCONTO-NORMAL é se for aplcia um Desconto.
            return 0.1;

        return 0; // Caso não se encaixe em nenhum deles não aplique desconto.
    }
}

// Aqui a classe precisa ser modificada sempre que adicionamos um novo desconto. Isso significa que ela não está
// fechada para mudanças, violando o (OSP )princípio aberto fechado