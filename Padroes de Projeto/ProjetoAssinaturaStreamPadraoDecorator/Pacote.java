public abstract class Pacote implements Assinatura {
    protected Assinatura assinatura;

    public Pacote(Assinatura assinatura) {
        this.assinatura = assinatura;
    }
}
