public class ReservaCarro {
    private String tipoCarro;
    private int quantidadeDiarias;
    private double valor;

    public ReservaCarro(String tipoCarro, int quantidadeDiarias, double valor) {
        this.tipoCarro = tipoCarro;
        this.quantidadeDiarias = quantidadeDiarias;
        this.valor = valor;
    }

    public String getTipoCarro() {
        return tipoCarro;
    }

    public int getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    public double getValor() {
        return valor;
    }
}
