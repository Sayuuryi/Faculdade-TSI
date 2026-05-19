public class SistemaHotel {
    private static final double DIARIA_SIMPLES = 200.00;

    public ReservaHotel reservarHotel(int opcaoQuarto, int quantidadePessoas, int quantidadeDiarias) {
        if (quantidadePessoas <= 0) {
            throw new IllegalArgumentException("A quantidade de pessoas deve ser maior que zero.");
        }

        if (quantidadeDiarias <= 0) {
            throw new IllegalArgumentException("A quantidade de diarias deve ser maior que zero.");
        }

        String tipoQuarto = descobrirTipoQuarto(opcaoQuarto);
        double diariaPorPessoa = calcularDiariaPorPessoa(opcaoQuarto);
        double valor = diariaPorPessoa * quantidadePessoas * quantidadeDiarias;

        return new ReservaHotel(tipoQuarto, quantidadePessoas, quantidadeDiarias, valor);
    }

    private String descobrirTipoQuarto(int opcaoQuarto) {
        if (opcaoQuarto == 1) {
            return "Simples";
        }

        if (opcaoQuarto == 2) {
            return "Executivo";
        }

        if (opcaoQuarto == 3) {
            return "Suite presidencial";
        }

        throw new IllegalArgumentException("Tipo de quarto invalido.");
    }

    private double calcularDiariaPorPessoa(int opcaoQuarto) {
        if (opcaoQuarto == 1) {
            return DIARIA_SIMPLES;
        }

        double diariaExecutiva = DIARIA_SIMPLES * 1.50;

        if (opcaoQuarto == 2) {
            return diariaExecutiva;
        }

        if (opcaoQuarto == 3) {
            return diariaExecutiva * 3.00;
        }

        throw new IllegalArgumentException("Tipo de quarto invalido.");
    }
}
