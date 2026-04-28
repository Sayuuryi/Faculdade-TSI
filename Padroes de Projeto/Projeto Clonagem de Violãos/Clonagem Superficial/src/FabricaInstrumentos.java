
import java.util.HashMap;

public class FabricaInstrumentos {
    
    private HashMap<String, Violao> catalogo = new HashMap<>();

    public void adicionar(String id, Violao v) {
        catalogo.put(id, v);
    }

    public Violao pedir(String id) {
        Violao v = catalogo.get(id);
        if (v == null) {
            System.out.println("Violao nao encontrado: " + id);
            return null;
        }

        return v.clone();

    }

    public void listar() {
        System.out.println("Violoes disponiveis: ");

        for (String id : catalogo.keySet()) {
            System.out.println("  - " + id);
        }
    }

}
