public class Main {

    public static void main(String[] args) {

        DescontoHotel desconto = new DescontoHotel();

        double vip = desconto.calcularDesconto("DESCONTO-VIP");
        double normal = desconto.calcularDesconto("DESCONTO-NORMAL");
        double nenhum = desconto.calcularDesconto("OUTRO");

        System.out.println("Desconto VIP: " + vip);
        System.out.println("Desconto NORMAL: " + normal);
        System.out.println("Sem desconto: " + nenhum);
    }
}