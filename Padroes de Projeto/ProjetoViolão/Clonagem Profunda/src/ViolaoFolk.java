public class ViolaoFolk implements Instrumento {
    
    private String nome;
    private String descricao;
    private Cordas cordas;

    public ViolaoFolk(String nome, String descricao, Cordas cordas) {
        this.nome = nome;
        this.descricao = descricao;
        this.cordas = cordas;
    }

    @Override
    public Instrumento clonar() {
        return new ViolaoFolk(nome, descricao, cordas.copiar());
    }

    @Override
    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Cordas: " + cordas);
        System.out.println();
    }

}
