public class Cordas {
    private String material;
    private int quantidade;

    public Cordas(String material, int quantidade) {
        this.material = material;
        this.quantidade = quantidade;
    }

    public Cordas copiar() {
        return new Cordas(this.material, this.quantidade);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String toString() {
        return quantidade + " cordas de " + material;
    }

}