
import builder.CaminhaoBuilder;
import builder.CarroBuilder;
import builder.MotoBuilder;
import diretor.Diretor;


public class Main {

    public static void main(String[] args) {
    
        System.out.println("=== Carro ===");
        CarroBuilder carroBuilder = new CarroBuilder();
        new Diretor(carroBuilder).construir();
        carroBuilder.getVeiculo().exibirInfo();
        System.out.println();

        System.out.println("=== Caminhao ===");
        CaminhaoBuilder caminhaoBuilder = new CaminhaoBuilder();
        new Diretor(caminhaoBuilder).construir();
        caminhaoBuilder.getVeiculo().exibirInfo();
        System.out.println();

        System.out.println("=== Moto ===");
        MotoBuilder motoBuilder = new MotoBuilder();
        new Diretor(motoBuilder).construir();
        motoBuilder.getVeiculo().exibirInfo();

    }

}