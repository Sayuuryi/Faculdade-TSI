

public class ViolaoClassico implements Instrumento {

    private String nome;
    private String descricao;
    private Cordas cordas;

    public ViolaoClassico(String nome, String descricao, Cordas cordas) {
        this.nome = nome;
        this.descricao = descricao;
        this.cordas = cordas;
    }

    @Override
    public Instrumento clonar() {
        return new ViolaoClassico(nome, descricao, cordas.copiar());
    }
    
    @Override
    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Cordas: " + cordas);
        System.out.println();
    }

    public Cordas getCordas() {
        return cordas;
    }

}
