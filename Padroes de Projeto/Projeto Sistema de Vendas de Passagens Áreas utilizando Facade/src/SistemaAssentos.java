public class SistemaAssentos {
    public String normalizarPoltrona(String poltrona) {
        return poltrona.toUpperCase().trim();
    }

    public int pegarFileira(String poltrona) {
        try {
            return Integer.parseInt(poltrona.substring(0, poltrona.length() - 1));
        } catch (Exception erro) {
            throw new IllegalArgumentException("Poltrona invalida. Exemplo correto: 1A ou 20F.");
        }
    }

    public char pegarLetra(String poltrona) {
        if (poltrona.length() < 2) {
            throw new IllegalArgumentException("Poltrona invalida. Exemplo correto: 1A ou 20F.");
        }

        return poltrona.charAt(poltrona.length() - 1);
    }

    public void validarAssento(int fileira, char letra) {
        if (fileira < 1 || fileira > 32) {
            throw new IllegalArgumentException("A fileira deve estar entre 1 e 32.");
        }

        if (letra < 'A' || letra > 'F') {
            throw new IllegalArgumentException("A letra da poltrona deve estar entre A e F.");
        }
    }

    public String descobrirLado(char letra) {
        if (letra == 'A' || letra == 'B' || letra == 'C') {
            return "lado esquerdo";
        }

        return "lado direito";
    }

    public String descobrirPosicao(char letra) {
        if (letra == 'A' || letra == 'F') {
            return "janela";
        }

        if (letra == 'B' || letra == 'E') {
            return "meio";
        }

        return "corredor";
    }
}
