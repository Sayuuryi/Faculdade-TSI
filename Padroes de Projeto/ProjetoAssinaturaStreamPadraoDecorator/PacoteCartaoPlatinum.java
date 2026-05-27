public class PacoteCartaoPlatinum extends Pacote {
    public PacoteCartaoPlatinum(Assinatura assinatura) {
        super(assinatura);
    }

    public String getDescricao() {
        return assinatura.getDescricao() + "\nPacote 4: cartao de credito Platinum";
    }

    public double getPreco() {
        return assinatura.getPreco() + 49.99;
    }
}
