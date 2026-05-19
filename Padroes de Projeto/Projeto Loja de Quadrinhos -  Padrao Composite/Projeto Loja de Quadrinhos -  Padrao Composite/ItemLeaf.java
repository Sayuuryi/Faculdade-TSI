public class ItemLeaf implements StoreComponent {

    Double itemPrice;
    String itemName;

    

    public ItemLeaf(Double itemPrice, String itemName) {
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }

    @Override
    public double showPrice() {
        return itemPrice;
    }

    @Override
    public void showItens() {
        System.out.println("O item " + itemName + " está custando R$ " + itemPrice);
    }
    
}
