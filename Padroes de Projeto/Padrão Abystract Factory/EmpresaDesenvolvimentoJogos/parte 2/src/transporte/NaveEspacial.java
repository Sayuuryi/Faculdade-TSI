package transporte;

public class NaveEspacial implements Transporte {
    
    @Override
    public void mover() {
        System.out.println("A nave começa a se mover na velocidade da luz");
    }

    @Override
    public void parar() {
        System.out.println("A Nave espacial começa a desacelerar");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Transporte: Nave Espacial | Tipo: Interestelar");
    }
}