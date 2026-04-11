package transporte;

public class Cavalo implements Transporte {

    @Override
    public void mover() {
        System.out.println("O Cavalo está se movendo!");
    }

    @Override
    public void parar() {
        System.out.println("O Cavalo parou de se mover!");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Transporte: Cavalo | Tipo: Terrestre");
    }

}
