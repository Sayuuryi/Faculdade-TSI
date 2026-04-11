package personagem;

public class Androide implements Personagem {
    
    @Override
    public void atacar() {
        System.out.println("Androide ataca disparando seu Laser!");
    }

    @Override
    public void defender() {
        System.out.println("O Android ativou seu escudo!");
    }

    @Override 
    public void exibirInfo() {
        System.out.println("Personagem: Androide | Tema: Futurista");
    }
    
}