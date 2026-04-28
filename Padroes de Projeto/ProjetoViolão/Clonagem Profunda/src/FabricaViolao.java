
import java.util.HashMap;

public class FabricaViolao {
    
    private HashMap<String, Instrumento> estoque = new HashMap<>();

    public void registrar(String chave, Instrumento i) {
        estoque.put(chave, i);
    }

    public Instrumento fabricar(String chave) {
        if (!estoque.containsKey(chave)) {
            System.out.println("Tipo invalido: " + chave);
            return null;
        }

        return estoque.get(chave).clonar();

    }

    public void mostrarCatalogo() {
        System.out.println("Catalogo:");
        for (String k : estoque.keySet())
            System.out.println("  " + k);
    }

}
