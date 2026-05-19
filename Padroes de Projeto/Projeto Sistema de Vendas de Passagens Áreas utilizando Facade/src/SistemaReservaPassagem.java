public class SistemaReservaPassagem {
    public ReservaPassagem reservarPassagem(String poltrona, String classeVoo, String ladoAviao,
            String posicaoPoltrona, double valor) {
        return new ReservaPassagem(poltrona, classeVoo, ladoAviao, posicaoPoltrona, valor);
    }
}
