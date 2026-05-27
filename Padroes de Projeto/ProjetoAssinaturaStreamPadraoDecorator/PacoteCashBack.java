public class PacoteCashBack extends Pacote {
    public PacoteCashBack(Assinatura assinatura) {
        super(assinatura);
    }

    public String getDescricao() {
        return assinatura.getDescricao() + "\nPacote 5: compra com Cash Back";
    }

    public double getPreco() {
        return assinatura.getPreco() + 19.99;
    }
}
