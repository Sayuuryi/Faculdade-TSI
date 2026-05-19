public class SistemaAluguelCarro {
    private static final double DIARIA_ECONOMICA = 150.00;

    public ReservaCarro reservarCarro(int opcaoCarro, int quantidadeDiarias) {
        if (quantidadeDiarias <= 0) {
            throw new IllegalArgumentException("A quantidade de diarias deve ser maior que zero.");
        }

        String tipoCarro = descobrirTipoCarro(opcaoCarro);
        double diaria = calcularDiaria(opcaoCarro);
        double valor = diaria * quantidadeDiarias;

        return new ReservaCarro(tipoCarro, quantidadeDiarias, valor);
    }

    private String descobrirTipoCarro(int opcaoCarro) {
        if (opcaoCarro == 1) {
            return "Economico";
        }

        if (opcaoCarro == 2) {
            return "Executivo";
        }

        if (opcaoCarro == 3) {
            return "Luxo";
        }

        throw new IllegalArgumentException("Tipo de carro invalido.");
    }

    private double calcularDiaria(int opcaoCarro) {
        if (opcaoCarro == 1) {
            return DIARIA_ECONOMICA;
        }

        double diariaExecutiva = DIARIA_ECONOMICA;

        if (opcaoCarro == 2) {
            return diariaExecutiva;
        }

        if (opcaoCarro == 3) {
            return diariaExecutiva;
        }

        throw new IllegalArgumentException("Tipo de carro invalido.");
    }
}
