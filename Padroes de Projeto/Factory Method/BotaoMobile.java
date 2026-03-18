public class BotaoMobile implements Botao {

    @Override
    public void render() {
        System.out.println("Renderizando botão Mobile.");
    }

    @Override
    public void onClick() {
        System.out.println("Clique no botão Mobile!\n");
    }
}