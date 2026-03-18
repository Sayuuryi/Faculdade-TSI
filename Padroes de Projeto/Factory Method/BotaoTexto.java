public class BotaoTexto implements Botao {

    @Override
    public void render() {
        System.out.println("Renderizando botão de Texto.");
    }

    @Override
    public void onClick() {
        System.out.println("Clique no botão de Texto!\n");
    }
}