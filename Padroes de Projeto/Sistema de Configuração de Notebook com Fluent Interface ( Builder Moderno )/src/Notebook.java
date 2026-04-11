public class Notebook {

    private final String processador;
    private final String memoriaRam;
    private final String armazenamento;
    private final String placaDeVideo;
    private final String sistemaOperacional;

    private Notebook(Builder builder) {
        this.processador = builder.processador;
        this.memoriaRam = builder.memoriaRam;
        this.armazenamento = builder.armazenamento;
        this.placaDeVideo = builder.placaDeVideo;
        this.sistemaOperacional = builder.sistemaOperacional;
    }

    public void exibirInfo() {
        System.out.println("Processador: " + processador);
        System.out.println("Memória Ram: " + memoriaRam);
        System.out.println("Armazenamento: " + armazenamento);
        System.out.println("Placa de Video: " + placaDeVideo);
        System.out.println("Sistema Operacional: " + sistemaOperacional);
    }

    public static class Builder {
        
        private String processador;
        private String memoriaRam;
        private String armazenamento;
        private String placaDeVideo;
        private String sistemaOperacional;

        public Builder processador(String processador) {
            this.processador = processador;
            return this;
        }

        public Builder memoriaRam(String memoriaRam) {
            this.memoriaRam = memoriaRam;
            return this;
        }

        public Builder armazenamento(String armazenamento) {
            this.armazenamento = armazenamento;
            return this;
        }

        public Builder placaDeVideo(String placaDeVideo) {
            this.placaDeVideo = placaDeVideo;
            return this;
        }

        public Builder sistemaOperacional(String sistemaOperacional) {
            this.sistemaOperacional = sistemaOperacional;
            return this;
        }

        public Notebook build() {
            return new Notebook(this);
        }

    }

}