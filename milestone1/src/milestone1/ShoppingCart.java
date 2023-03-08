package milestone1;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<SalableProduct> productList;

    public ShoppingCart() {
        productList = new ArrayList<SalableProduct>();
    }

    public void addProduct(SalableProduct product) {
        productList.add(product);
    }

    public void removeProduct(SalableProduct product) {
        productList.remove(product);
    }

    public double getTotal() {
        double total = 0;

        for (SalableProduct product : productList) {
            total += product.getPrice();
        }

        return total;
    }
}

