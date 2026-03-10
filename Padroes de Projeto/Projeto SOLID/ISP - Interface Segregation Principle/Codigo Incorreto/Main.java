public class Main {
    public static void main(String[] args) {

        IServicoHotel servico = new ReservaOnline();

        servico.reservaQuarto();  // funciona sem erros.

        // servico.servirCafeDaManha(); // se chamar a função ele vai dá erro. ( Descomentar quando for demonstrar.)
    }
}