public class PacoteVariosDispositivos extends Pacote {
    public PacoteVariosDispositivos(Assinatura assinatura) {
        super(assinatura);
    }

    public String getDescricao() {
        return assinatura.getDescricao() + "\nPacote 1: assistir videos em varios dispositivos";
    }

    public double getPreco() {
        return assinatura.getPreco() + 19.99;
    }
}
