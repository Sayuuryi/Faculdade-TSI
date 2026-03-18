public class BotaoHTML implements Botao {
    
    @Override
    public void render() {
        System.out.println("Renderizando botão estilo HTML.");
    }

    @Override
    public void onClick() {
        System.out.println("Clique no botão HTML!\n");
    }
}