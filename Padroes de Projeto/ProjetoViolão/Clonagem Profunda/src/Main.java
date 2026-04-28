import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        FabricaViolao fabrica = new FabricaViolao();

        fabrica.registrar("classico", new ViolaoClassico("Violao Classico",
                "Acustico com 6 cordas de nylon, indicado para iniciantes",
                new Cordas("Nylon", 6)));

        fabrica.registrar("folk", new ViolaoFolk("Violao Folk",
                "Corpo grande, cordas de aco, popular no pop e rock",
                new Cordas("Aco", 6)));

        fabrica.registrar("flat", new ViolaoFlat("Violao Flat",
                "Caixa acustica bem fina, precisa de amplificacao",
                new Cordas("Nylon", 6)));

        fabrica.registrar("jumbo", new ViolaoJumbo("Violao Jumbo",
                "Corpo bem largo, ficou famoso com Elvis Presley",
                new Cordas("Aco", 6)));

        fabrica.registrar("7cordas", new Violao7Cordas("Violao 7 Cordas",
                "Tipico do choro e samba, setima corda mais grave",
                new Cordas("Nylon", 7)));

        fabrica.registrar("12cordas", new Violao12Cordas("Violao 12 Cordas",
                "Doze cordas em pares, som com muita ressonancia",
                new Cordas("Aco", 12)));

        fabrica.registrar("parlor-zero", new VioloesParlor("Parlor",
                "Zero", "Menor dos tres, estrutura bem compacta",
                new Cordas("Nylon", 6)));

        fabrica.registrar("parlor-duplo", new VioloesParlor("Parlor",
                "Duplo Zero", "Medio, bom para fingerstyle",
                new Cordas("Nylon", 6)));

        fabrica.registrar("parlor-triplo", new VioloesParlor("Parlor",
                "Triplo Zero", "Tamanho entre o duplo e um classico",
                new Cordas("Nylon", 6)));
        
        Scanner scanner = new Scanner(System.in);
        String opcao = "";

        while (!opcao.equals("sair")) {
            System.out.println("\n=== Fabrica de Violoes (Tipo de Clonagem Profunda) ===");
            fabrica.mostrarCatalogo();
            System.out.println("Escolha um violao (ou 'sair'): ");
            opcao = scanner.nextLine().trim();

            if (opcao.equals("sair"))
                break;

            Instrumento inst = fabrica.fabricar(opcao);
            if (inst != null) {
                System.out.println("\nViolao fabricado:");
                inst.exibir();

                if (inst instanceof ViolaoClassico) {
                    ViolaoClassico a = (ViolaoClassico) fabrica.fabricar("classico");
                    ViolaoClassico b = (ViolaoClassico) a.clonar();

                    b.getCordas().setMaterial("Aco");

                    // Alterar o clone nao afeta o original
                    System.out.println("Teste de Clonagem Profunda");
                    System.out.println("Original: " + a.getCordas());
                    System.out.println("Clone:    " + b.getCordas());
                    System.out.println("Mesma referencia? " + (a.getCordas() == b.getCordas()));
                }
            }
        }
    
        scanner.close();

    }

}
