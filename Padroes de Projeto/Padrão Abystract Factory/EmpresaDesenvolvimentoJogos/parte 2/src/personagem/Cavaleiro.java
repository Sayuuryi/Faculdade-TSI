package personagem;

public class Cavaleiro implements Personagem {

    @Override
    public void atacar() {
        System.out.println("Cavaleiro ataca brandindo sua Espada!");
    }

    @Override
    public void defender() {
        System.out.println("O Cavaleiro se defendeu!");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Personagem: Cavaleiro | Tema: Medieval");
    }

}