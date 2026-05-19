public class ResumoPagamento {
    private String formaPagamento;
    private int parcelas;
    private double desconto;
    private double acrescimo;
    private double valorFinal;

    public ResumoPagamento(String formaPagamento, int parcelas, double desconto, double acrescimo, double valorFinal) {
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
        this.desconto = desconto;
        this.acrescimo = acrescimo;
        this.valorFinal = valorFinal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public int getParcelas() {
        return parcelas;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public double getValorParcela() {
        return valorFinal / parcelas;
    }
}
