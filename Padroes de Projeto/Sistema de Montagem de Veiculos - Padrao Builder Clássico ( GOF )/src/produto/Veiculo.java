package produto;

public class Veiculo {

    private String motor;
    private String transmissao;
    private String cor;
    private String rodas;

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setRodas(String rodas) {
        this.rodas = rodas;
    }

    public void exibirInfo() {
        System.out.println("Motor: " + motor);
        System.out.println("Transmissão: " + transmissao);
        System.out.println("Cor: " + cor);
        System.out.println("Rodas: " + rodas);
    }

}