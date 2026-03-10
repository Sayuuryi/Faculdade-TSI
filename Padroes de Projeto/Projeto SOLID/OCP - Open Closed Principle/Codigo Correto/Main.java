public class Main {

    public static void main(String[] args) {

        IDesconto descontoNormal = new DescontoNormal();
        IDesconto descontoVIP = new DescontoVIP();
        IDesconto semDesconto = new SemDesconto();

        System.out.println("Desconto Normal: " + descontoNormal.calcular());
        System.out.println("Desconto VIP: " + descontoVIP.calcular());
        System.out.println("Sesconto Normal: " + semDesconto.calcular());
    }
}