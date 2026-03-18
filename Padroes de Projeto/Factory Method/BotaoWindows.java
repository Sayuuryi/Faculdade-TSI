public class BotaoWindows implements Botao {

    @Override
    public void render() {
        System.out.println("Renderizando botão estilo Windows.");
    }

    @Override
    public void onClick() {
        System.out.println("Clique no botão Windows!\n");
    }
}