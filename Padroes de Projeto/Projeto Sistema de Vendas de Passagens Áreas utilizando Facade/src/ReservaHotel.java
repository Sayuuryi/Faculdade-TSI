public class ReservaHotel {
    private String tipoQuarto;
    private int quantidadePessoas;
    private int quantidadeDiarias;
    private double valor;

    public ReservaHotel(String tipoQuarto, int quantidadePessoas, int quantidadeDiarias, double valor) {
        this.tipoQuarto = tipoQuarto;
        this.quantidadePessoas = quantidadePessoas;
        this.quantidadeDiarias = quantidadeDiarias;
        this.valor = valor;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public int getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    public double getValor() {
        return valor;
    }
}
