public class ReservaPassagem {
    private String poltrona;
    private String classeVoo;
    private String ladoAviao;
    private String posicaoPoltrona;
    private double valor;

    public ReservaPassagem(String poltrona, String classeVoo, String ladoAviao, String posicaoPoltrona, double valor) {
        this.poltrona = poltrona;
        this.classeVoo = classeVoo;
        this.ladoAviao = ladoAviao;
        this.posicaoPoltrona = posicaoPoltrona;
        this.valor = valor;
    }

    public String getPoltrona() {
        return poltrona;
    }

    public String getClasseVoo() {
        return classeVoo;
    }

    public String getLadoAviao() {
        return ladoAviao;
    }

    public String getPosicaoPoltrona() {
        return posicaoPoltrona;
    }

    public double getValor() {
        return valor;
    }
}
