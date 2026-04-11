import arma.Arma;
import fabrica.FabricaFuturistica;
import fabrica.FabricaMedieval;
import fabrica.FabricaTema;
import personagem.Personagem;

public class Main {

    public static void main(String[] args) {
        
        executarTema(new FabricaMedieval(), "Medieval");
        System.out.println();
        executarTema(new FabricaFuturistica(), "Futurista");
        
    }

    public static void executarTema(FabricaTema fabrica, String nomeTema) {

        System.out.println("=== Tema " + nomeTema + " ===");
    
        Personagem personagem = fabrica.criarPersonagem();
        Arma arma = fabrica.criarArma();

        personagem.exibirInfo();
        arma.exibirInfo();

        personagem.atacar();
        arma.usar();
        arma.guardar();
    }

}