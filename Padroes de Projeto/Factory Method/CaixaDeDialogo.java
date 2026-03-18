public abstract class CaixaDeDialogo {
    // Factory Method
    public abstract Botao CriaBotao(); // método abstrato
    public void renderJanela() {
        Botao BotaoOk = CriaBotao(); // adia para as subclasses
        BotaoOk.render();
        BotaoOk.onClick();
    }
}