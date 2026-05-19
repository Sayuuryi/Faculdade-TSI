
import java.util.ArrayList;

public class StoreComposite implements StoreComponent {
    
    String nivel;
    int limite;

    ArrayList<StoreComponent> components = new ArrayList<>();

    public StoreComposite(String nivel, int limite) {
        this.nivel = nivel;
        this.limite = limite;
    }

    @Override
    public double showPrice() {
        double total = 0;

        for (int i = 0; i < components.size(); i++) {
            total += components.get(i).showPrice();
        }

        return total;
    }

    @Override
    public void showItens() {
        System.out.println("Caixa " + nivel + " - Itens");
        
        for (int i = 0; i < components.size(); i++) {
            components.get(i).showItens();
        }

    }

    public void addItem(StoreComponent addItem) {
        components.add(addItem);

    }


}
