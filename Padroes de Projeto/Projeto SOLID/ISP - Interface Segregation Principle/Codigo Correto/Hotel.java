public class Hotel implements Reserva, CafeDaManha {

    @Override
    public void reservarQuarto() {
        System.out.println("Reserva realizada no hotel.");
    }

    @Override
    public void servirCafeDaManha() {
        System.out.println("Cafe da manha servido.");
    }
}