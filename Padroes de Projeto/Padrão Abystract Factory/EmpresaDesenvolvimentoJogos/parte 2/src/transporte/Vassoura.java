package transporte;

public class Vassoura implements Transporte {
    
    @Override
    public void mover() {
        System.out.println("A Vassoura magica se move pelos céus!");
    }

    @Override
    public void parar() {
        System.out.println("A Vassoura magica pousa suavemente no chao.");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Transporte: Vassoura Magica | Tipo: Aéreo ");
    }
    
}
