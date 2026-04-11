package personagem;

public class Mago implements Personagem {

    @Override
    public void atacar() {
        System.out.println("Você casta uma bola de fogo com seu cajado.");
    }

    @Override
    public void defender() {
        System.out.println("Você termina de castar seu escudo e se defende.");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Personagem: Mago | Tema: Fantasia");
    }

}