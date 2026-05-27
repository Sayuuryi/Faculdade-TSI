public class PacoteFreteGratis extends Pacote {
    public PacoteFreteGratis(Assinatura assinatura) {
        super(assinatura);
    }

    public String getDescricao() {
        return assinatura.getDescricao() + "\nPacote 2: frete gratis em produtos";
    }

    public double getPreco() {
        return assinatura.getPreco() + 9.99;
    }
}
