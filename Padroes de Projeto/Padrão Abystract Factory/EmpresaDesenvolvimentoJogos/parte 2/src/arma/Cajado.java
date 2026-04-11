package arma;

public class Cajado implements Arma {
    
    @Override
    public void usar() {
        System.out.println("Você começa a castar uma magia de ataque com seu cajado.");
    }

    @Override
    public void guardar() {
        System.out.println("Você casta uma magia de defesa.");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Arma: Cajado | Tipo: Ranged");
    }

}
