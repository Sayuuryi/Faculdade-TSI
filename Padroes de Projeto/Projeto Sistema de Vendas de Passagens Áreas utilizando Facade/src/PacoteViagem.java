import java.util.List;

public class PacoteViagem {
    private List<Comprador> compradores;
    private ReservaPassagem passagem;
    private ReservaHotel hotel;
    private ReservaCarro carro;
    private ResumoPagamento pagamento;
    private double valorPacote;

    public PacoteViagem(List<Comprador> compradores, ReservaPassagem passagem, ReservaHotel hotel,
            ReservaCarro carro, ResumoPagamento pagamento, double valorPacote) {
        this.compradores = compradores;
        this.passagem = passagem;
        this.hotel = hotel;
        this.carro = carro;
        this.pagamento = pagamento;
        this.valorPacote = valorPacote;
    }

    public void imprimirResumo() {
        System.out.println();
        System.out.println("===== RESUMO DA COMPRA =====");

        System.out.println();
        System.out.println("Dados dos compradores:");
        for (int i = 0; i < compradores.size(); i++) {
            Comprador comprador = compradores.get(i);
            System.out.println((i + 1) + " - Nome: " + comprador.getNome() + " | CPF: " + comprador.getCpf());
        }

        System.out.println();
        System.out.println("Dados da passagem:");
        System.out.println("Poltrona escolhida: " + passagem.getPoltrona());
        System.out.println("Classe do voo: " + passagem.getClasseVoo());
        System.out.println("Lado da aeronave: " + passagem.getLadoAviao());
        System.out.println("Posicao da poltrona: " + passagem.getPosicaoPoltrona());
        System.out.printf("Valor da passagem: R$ %.2f%n", passagem.getValor());

        System.out.println();
        System.out.println("Dados do hotel:");
        System.out.println("Quarto: " + hotel.getTipoQuarto());
        System.out.println("Pessoas: " + hotel.getQuantidadePessoas());
        System.out.println("Diarias: " + hotel.getQuantidadeDiarias());
        System.out.printf("Valor do hotel: R$ %.2f%n", hotel.getValor());

        System.out.println();
        System.out.println("Dados do carro:");
        System.out.println("Carro: " + carro.getTipoCarro());
        System.out.println("Diarias: " + carro.getQuantidadeDiarias());
        System.out.printf("Valor do carro: R$ %.2f%n", carro.getValor());

        System.out.println();
        System.out.println("Pagamento:");
        System.out.println("Forma de pagamento: " + pagamento.getFormaPagamento());
        System.out.println("Parcelas: " + pagamento.getParcelas());
        System.out.printf("Valor do pacote: R$ %.2f%n", valorPacote);
        System.out.printf("Desconto: R$ %.2f%n", pagamento.getDesconto());
        System.out.printf("Acrescimo: R$ %.2f%n", pagamento.getAcrescimo());
        System.out.printf("Valor final: R$ %.2f%n", pagamento.getValorFinal());
        System.out.printf("Valor por parcela: R$ %.2f%n", pagamento.getValorParcela());
    }
}
