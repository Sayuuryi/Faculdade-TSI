public class PacoteCaixaSurpresa extends Pacote {
    public PacoteCaixaSurpresa(Assinatura assinatura) {
        super(assinatura);
    }

    public String getDescricao() {
        return assinatura.getDescricao() + "\nPacote 3: caixa surpresa com produtos de filmes e series";
    }

    public double getPreco() {
        return assinatura.getPreco() + 29.99;
    }
}
