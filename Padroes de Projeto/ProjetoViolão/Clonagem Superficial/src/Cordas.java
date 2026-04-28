public class Cordas {
    
    String material;
    int quantidade;
    
    public Cordas(String materia, int quantidade) {
        this.material = material;
        this.quantidade = quantidade;
    }

    public String toString() {
        return quantidade + " cordas de " + material;
    }

}
