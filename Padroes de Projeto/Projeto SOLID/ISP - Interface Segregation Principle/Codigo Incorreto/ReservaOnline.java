public class ReservaOnline implements IServicoHotel {

    @Override
    public void reservaQuarto() {
        System.out.println("Reserva online realizada com sucesso.");
    }

    @Override
    public void servirCafeDaManha() {
        throw new UnsupportedOperationException("Reserva online nao serve cafe.");
    }
}