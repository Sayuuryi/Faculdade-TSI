import arma.Arma;
import fabrica.FabricaFantasia;
import fabrica.FabricaFuturistica;
import fabrica.FabricaMedieval;
import fabrica.FabricaTema;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import personagem.Personagem;
import transporte.Transporte;

public class Main {

    public static void main(String[] args) {
        
        Map<String, FabricaTema> fabricas = new HashMap<>();
        fabricas.put("medieval", new FabricaMedieval());
        fabricas.put("futurista", new FabricaFuturistica());
        fabricas.put("fantasia", new FabricaFantasia());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um tema: medieval, futurista, fantasia");
        String escolha = scanner.nextLine().trim().toLowerCase();

        FabricaTema fabrica = fabricas.get(escolha);

        if (fabrica == null) {
            System.out.println("Tema inválido! Escolha: " + fabricas.keySet());
            return;
        }

        executarTema(fabrica, escolha);
        scanner.close();

    }

    public static void executarTema(FabricaTema fabrica, String nomeTema) {
        System.out.println("\n=== Tema " + nomeTema + " ===");
        
        Personagem personagem = fabrica.criarPersonagem();
        Arma arma = fabrica.criarArma();
        Transporte transporte = fabrica.criarTransporte();

        personagem.exibirInfo();
        arma.exibirInfo();
        transporte.exibirInfo();

        personagem.atacar();
        arma.usar();
        transporte.mover();
        arma.guardar();
        transporte.parar();
    }

}