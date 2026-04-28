import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
    
        FabricaInstrumentos fabrica = new FabricaInstrumentos();

        fabrica.adicionar("classico", new ViolaoClassico("Violao Classico",
                "Acustico, 6 cordas de nylon, bom para iniciantes",
                new Cordas("Nylon", 6)));

        fabrica.adicionar("folk", new ViolaoFolk("Violao Folk",
                "Corpo maior, cordas de aco, usado em pop e rock",
                new Cordas("Aco", 6)));

        fabrica.adicionar("flat", new ViolaoFlat("Violao Flat",
                "Caixa fina, timbre suave, quase sempre eletrico",
                new Cordas("Nylon", 6)));

        fabrica.adicionar("jumbo", new ViolaoJumbo("Violao Jumbo",
                "Corpo largo, base arredondada, som grave",
                new Cordas("Aco", 6)));

        fabrica.adicionar("7cordas", new Violao7Cordas("Violao 7 Cordas",
                "Violao brasileiro, usado em choro e samba",
                new Cordas("Nylon", 7)));

        fabrica.adicionar("12cordas", new Violao12Cordas("Violao 12 Cordas",
                "Cordas em pares, muita ressonancia, exige tecnica",
                new Cordas("Aco", 12)));

        fabrica.adicionar("parlor-zero", new VioloesParlor("Parlor", "Zero",
                "Menor dos parlor, confortavel para longas sessoes",
                new Cordas("Nylon", 6)));

        fabrica.adicionar("parlor-duplo", new VioloesParlor("Parlor", "Duplo Zero",
                "Um pouco maior, bom para fingerstyle",
                new Cordas("Nylon", 6)));

        fabrica.adicionar("parlor-triplo", new VioloesParlor("Parlor", "Triplo Zero",
                "Tamanho intermediario, timbre caracteristico",
                new Cordas("Nylon", 6)));

        Scanner scanner = new Scanner(System.in);
        String opcao = "";

        while(!opcao.equals("sair")) {
            System.out.println("\n=== Fabrica de Violoes (Tipo de Clonagem Superficial) ===");
            fabrica.listar();
            System.out.println("Escolha um violao (ou 'sair'): ");
            opcao = scanner.nextLine().trim();

            if (opcao.equals("sair"))
                break;

            Violao v = fabrica.pedir(opcao);
            if (v != null) {
                System.out.println("\nViolao clonado: ");
                v.mostrar();

                if (v instanceof ViolaoClassico) {
                    ViolaoClassico original = (ViolaoClassico) fabrica.pedir("classico");
                    ViolaoClassico copia = (ViolaoClassico) original.clone();

                    System.out.println("Teste de Clonagem Superficial");
                    System.out.println("Original: " + System.identityHashCode(original.cordas));
                    System.out.println("Clone: " + System.identityHashCode(copia.cordas));
                    System.out.println("ao iguais: " + (original.cordas == copia.cordas));
                }
            }
        }

        scanner.close();
    }
}
