public class VioloesParlor implements Instrumento {

    private String nome;
    private String tipo;
    private String descricao;
    private Cordas cordas;

    public VioloesParlor(String nome, String tipo, String descricao, Cordas cordas) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.cordas = cordas;
    }

    @Override
    public Instrumento clonar() {
        return new VioloesParlor(nome, tipo, descricao, cordas.copiar());
    }

    @Override
    public void exibir() {
        System.out.println("Nome: " + nome + " - " + tipo);
        System.out.println("Descricao: " + descricao);
        System.out.println("Cordas: " + cordas);
        System.out.println();
    }
    
}