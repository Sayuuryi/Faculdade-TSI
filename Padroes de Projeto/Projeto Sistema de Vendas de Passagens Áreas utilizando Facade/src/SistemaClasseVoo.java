public class SistemaClasseVoo {
    private static final double VALOR_ECONOMICA = 500.00;

    public String descobrirClasse(int fileira) {
        if (fileira >= 1 && fileira <= 3) {
            return "1a Classe";
        }

        if (fileira >= 4 && fileira <= 8) {
            return "Classe Executiva";
        }

        return "Classe Economica";
    }

    public double calcularValor(String classeVoo) {
        if (classeVoo.equals("Classe Economica")) {
            return VALOR_ECONOMICA;
        }

        double valorExecutiva = VALOR_ECONOMICA + (VALOR_ECONOMICA * 2.50);

        if (classeVoo.equals("Classe Executiva")) {
            return valorExecutiva;
        }

        return valorExecutiva + (valorExecutiva * 1.50);
    }
}
