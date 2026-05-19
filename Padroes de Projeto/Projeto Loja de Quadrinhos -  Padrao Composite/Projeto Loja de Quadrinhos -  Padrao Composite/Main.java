import java.util.ArrayList;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        ArrayList<ItemLeaf> itensDisponiveis = new ArrayList<>();

        itensDisponiveis.add(new ItemLeaf(15.0, "Quadrinho"));
        itensDisponiveis.add(new ItemLeaf(5.0, "Chaveiro"));
        itensDisponiveis.add(new ItemLeaf(10.0, "Busto"));
        itensDisponiveis.add(new ItemLeaf(1.0, "Adesivo"));
        itensDisponiveis.add(new ItemLeaf(25.0, "Poster"));
        itensDisponiveis.add(new ItemLeaf(25.0, "Camiseta"));
        itensDisponiveis.add(new ItemLeaf(3.0, "Caneta"));
        itensDisponiveis.add(new ItemLeaf(20.0, "Miniatura"));

        StoreComposite caixaCliente = new StoreComposite("Bronze", 3);
        Random random = new Random();

        for (int i = 0; i < caixaCliente.limite; i++) {

            int indice = random.nextInt(itensDisponiveis.size());
            ItemLeaf itemSorteado = itensDisponiveis.get(indice);
            caixaCliente.addItem(itemSorteado);
    
        }

        caixaCliente.showItens();
        System.out.println("Valor total: R$ " + caixaCliente.showPrice());

    }

}

