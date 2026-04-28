public class ViolaoFlat implements Violao {
    
    String nome;
    String descricao;
    Cordas cordas;

    public ViolaoFlat(String nome, String descricao, Cordas cordas) {
        this.nome = nome;
        this.descricao = descricao;
        this.cordas = cordas;
    }

    @Override
    public Violao clone() {
        return new ViolaoFlat(nome, descricao, cordas);
    }

    @Override
    public void mostrar() {
        System.out.println("Tipo: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Cordas: " + cordas);
        System.out.println();
    }

}
