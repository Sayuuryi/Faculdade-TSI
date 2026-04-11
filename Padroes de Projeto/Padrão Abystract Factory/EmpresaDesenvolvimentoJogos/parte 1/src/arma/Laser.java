package arma;

public class Laser implements Arma {
    
    @Override
    public void usar() {
        System.out.println("Laser destrói o inimigo com energia pura!");
    }

    @Override
    public void guardar() {
        System.out.println("Android guarda Laser.");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Arma: Laser | Tipo: Longa Distância");
    }

}