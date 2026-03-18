public class BotaoJogo implements Botao {

    @Override
    public void render() {
        System.out.println("Renderizando botão de Jogo.");
    }

    @Override
    public void onClick() {
        System.out.println("Clique no botão de Jogo!\n");
    }
}