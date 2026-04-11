public class Main {

    public static void main(String[] args) {
    
        System.out.println("=== Notebook Gamer ===");
        Notebook gamer = new Notebook.Builder()
            .processador("Intel core I9")
            .memoriaRam("32GB DDR5")
            .armazenamento("2TB SSD NVMe")
            .placaDeVideo("NVIDIA RTX 5090")
            .sistemaOperacional("Windows 11")
            .build();
        gamer.exibirInfo();

        System.out.println();

        System.out.println("=== Notebook Escritório ===");
        Notebook escritorio = new Notebook.Builder()
            .processador("Intel core I5")
            .memoriaRam("16GB DDR4")
            .armazenamento("1TB SSD NVMe")
            .placaDeVideo("NVIDIA RTX 4070 SUPER")
            .sistemaOperacional("Windows 11")
            .build();
        escritorio.exibirInfo();

    }   

}