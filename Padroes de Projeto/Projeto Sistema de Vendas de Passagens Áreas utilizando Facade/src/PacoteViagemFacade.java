import java.util.List;

public class PacoteViagemFacade {
    private SistemaReservaPassagem sistemaReservaPassagem;
    private SistemaClasseVoo sistemaClasseVoo;
    private SistemaAssentos sistemaAssentos;
    private SistemaHotel sistemaHotel;
    private SistemaAluguelCarro sistemaAluguelCarro;
    private SistemaPagamento sistemaPagamento;

    public PacoteViagemFacade() {
        sistemaReservaPassagem = new SistemaReservaPassagem();
        sistemaClasseVoo = new SistemaClasseVoo();
        sistemaAssentos = new SistemaAssentos();
        sistemaHotel = new SistemaHotel();
        sistemaAluguelCarro = new SistemaAluguelCarro();
        sistemaPagamento = new SistemaPagamento();
    }

    public PacoteViagem comprarPacote(List<Comprador> compradores, String poltrona, int opcaoQuarto,
            int diariasHotel, int opcaoCarro, int diariasCarro, int opcaoPagamento, int parcelas) {

        String poltronaNormalizada = sistemaAssentos.normalizarPoltrona(poltrona);
        int fileira = sistemaAssentos.pegarFileira(poltronaNormalizada);
        char letra = sistemaAssentos.pegarLetra(poltronaNormalizada);
        sistemaAssentos.validarAssento(fileira, letra);

        String classeVoo = sistemaClasseVoo.descobrirClasse(fileira);
        double valorPassagem = sistemaClasseVoo.calcularValor(classeVoo);
        String ladoAviao = sistemaAssentos.descobrirLado(letra);
        String posicaoPoltrona = sistemaAssentos.descobrirPosicao(letra);

        ReservaPassagem passagem = sistemaReservaPassagem.reservarPassagem(poltronaNormalizada, classeVoo,
                ladoAviao, posicaoPoltrona, valorPassagem);
        ReservaHotel hotel = sistemaHotel.reservarHotel(opcaoQuarto, compradores.size(), diariasHotel);
        ReservaCarro carro = sistemaAluguelCarro.reservarCarro(opcaoCarro, diariasCarro);

        double valorPacote = passagem.getValor() + hotel.getValor() + carro.getValor();
        ResumoPagamento pagamento = sistemaPagamento.realizarPagamento(valorPacote, opcaoPagamento, parcelas);

        return new PacoteViagem(compradores, passagem, hotel, carro, pagamento, valorPacote);
    }
}
