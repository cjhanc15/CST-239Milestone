package milestone1;

import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<SalableProduct> productList;

    public InventoryManager() {
        productList = new ArrayList<SalableProduct>();
    }

    public void addProduct(SalableProduct product) {
        productList.add(product);
    }

    public void removeProduct(SalableProduct product) {
        productList.remove(product);
    }

    public void updateProduct(SalableProduct product, int quantity) {
        product.setQuantity(quantity);
    }

    public ArrayList<SalableProduct> getAllProducts() {
        return productList;
    }
}
