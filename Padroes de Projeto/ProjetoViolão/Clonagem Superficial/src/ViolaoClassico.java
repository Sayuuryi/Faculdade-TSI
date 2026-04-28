public class ViolaoClassico implements Violao {
    
    String nome;
    String descricao;
    Cordas cordas;

    public ViolaoClassico(String nome, String descricao, Cordas cordas) {
        this.nome = nome;
        this.descricao = descricao;
        this.cordas = cordas;
    }

    @Override
    public Violao clone() {
        return new ViolaoClassico(nome, descricao, cordas);
    }

    @Override
    public void mostrar() {
        System.out.println("Tipo: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Cordas: " + cordas);
        System.out.println();
    }
    
}
