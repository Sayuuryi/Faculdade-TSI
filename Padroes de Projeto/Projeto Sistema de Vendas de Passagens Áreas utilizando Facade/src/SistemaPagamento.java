public class SistemaPagamento {
    public ResumoPagamento realizarPagamento(double valorPacote, int opcaoPagamento, int parcelas) {
        String formaPagamento = descobrirFormaPagamento(opcaoPagamento);

        if (!formaPagamento.equals("Credito")) {
            parcelas = 1;
        }

        if (formaPagamento.equals("Credito") && (parcelas < 1 || parcelas > 6)) {
            throw new IllegalArgumentException("O credito pode ser parcelado de 1 ate 6 vezes.");
        }

        double desconto = calcularDesconto(valorPacote, formaPagamento);
        double acrescimo = calcularAcrescimo(valorPacote, formaPagamento, parcelas);
        double valorFinal = valorPacote - desconto + acrescimo;

        return new ResumoPagamento(formaPagamento, parcelas, desconto, acrescimo, valorFinal);
    }

    private String descobrirFormaPagamento(int opcaoPagamento) {
        if (opcaoPagamento == 1) {
            return "Pix";
        }

        if (opcaoPagamento == 2) {
            return "Boleto";
        }

        if (opcaoPagamento == 3) {
            return "Debito";
        }

        if (opcaoPagamento == 4) {
            return "Credito";
        }

        throw new IllegalArgumentException("Forma de pagamento invalida.");
    }

    private double calcularDesconto(double valorPacote, String formaPagamento) {
        if (formaPagamento.equals("Pix")) {
            return valorPacote * 0.10;
        }

        if (formaPagamento.equals("Boleto")) {
            return valorPacote * 0.05;
        }

        return 0.00;
    }

    private double calcularAcrescimo(double valorPacote, String formaPagamento, int parcelas) {
        if (!formaPagamento.equals("Credito")) {
            return 0.00;
        }

        return valorPacote * 0.0399 * (parcelas - 1);
    }
}
