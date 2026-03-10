public class Main {

    public static void main(String[] args) {

        Reserva reservaHotel = new Hotel();
        reservaHotel.reservarQuarto();

        Reserva reservaOnline = new ReservaOnlineCorreto();
        reservaOnline.reservarQuarto();

        CafeDaManha cafe = new Hotel();
        cafe.servirCafeDaManha();
    }
}