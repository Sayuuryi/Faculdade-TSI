public class Aplicacao { // cliente

    private CaixaDeDialogo caixaDeDialogo;

    public void initialize(String tipo) {

        if ("windows".equalsIgnoreCase(tipo)) {
            caixaDeDialogo = new JanelaWinDialogo();

        } else if ("web".equalsIgnoreCase(tipo)) {
            caixaDeDialogo = new JanelaWebDialogo();

        } else if ("jogo".equalsIgnoreCase(tipo)) {
            caixaDeDialogo = new JanelaJogoDialogo();

        } else if ("mobile".equalsIgnoreCase(tipo)) {
            caixaDeDialogo = new JanelaMobileDialogo();

        } else if ("texto".equalsIgnoreCase(tipo)) {
            caixaDeDialogo = new JanelaTextoDialogo();

        } else {
            System.out.println("Tipo inválido!");
        }
    }

    public void run() {
        caixaDeDialogo.renderJanela();
    }
}