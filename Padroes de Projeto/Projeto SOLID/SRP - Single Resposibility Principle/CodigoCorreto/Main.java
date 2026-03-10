public class Main {
    public static void main(String[] args) {

        Atendimento atendimento = new Atendimento();
        ControleAcesso acesso = new ControleAcesso();
        Financeiro financeiro = new Financeiro();

        atendimento.atenderCliente();
        acesso.abrirPortao();
        financeiro.gerarRelatorio();
        financeiro.processarPagamento();
    }
}