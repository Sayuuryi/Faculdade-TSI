
import java.text.DecimalFormat;

public class Exercicio2 {
    public static void main(String[] args) {
        int raio = 2;
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(raio, 3);

        //Formatação de Casas decimais
        DecimalFormat formatando = new DecimalFormat("#0.00");

        String formatado = formatando.format(volume);

        System.out.println(formatado); // Volume da Esfera = 33.51
        
    }
}