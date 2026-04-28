public class VioloesParlor implements Violao {
    
    String nome;
    String descricao;
    Cordas cordas;
    String subtipo;

    public VioloesParlor(String nome, String subtipo, String descricao, Cordas cordas) {
        this.nome = nome;
        this.subtipo = subtipo;
        this.descricao = descricao;
        this.cordas = cordas;
    }

    @Override
    public Violao clone() {
        return new VioloesParlor(nome, subtipo, descricao, cordas);
    }

    @Override
    public void mostrar() {
        System.out.println("Tipo: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Cordas: " + cordas);
        System.out.println();
    }

}
