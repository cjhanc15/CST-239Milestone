package milestone1;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<SalableProduct> productList;
    /**
     * Constructs a new ShoppingCart object.
     */
    public ShoppingCart() {
        productList = new ArrayList<SalableProduct>();
    }

    /**
     * Adds the specified product to the shopping cart.
     * @param product the product to be added to the shopping cart
     */
    public void addProduct(SalableProduct product) {
        productList.add(product);
    }

    /**
     * Removes the specified product from the shopping cart.
     * @param product the product to be removed from the shopping cart
     */
    public void removeProduct(SalableProduct product) {
        productList.remove(product);
    }

    /**
     * Returns the total cost of all products in the shopping cart.
     * @return the total cost of all products in the shopping cart
     */
    public double getTotal() {
        double total = 0;

        for (SalableProduct product : productList) {
            total += product.getPrice();
        }
        total = (double)Math.round(total * 100) / 100;
        return total;
    }
    
    /**
    The checkout method is used to purchase all the products in the shopping cart from a given store.
    It loops through each product in the cart and calls its purchase() method with a quantity of 1.
    After purchasing all the products, it clears the shopping cart.
    @param store the store from which to purchase the products
    */
    public void checkout(StoreFront store) {
	    for (SalableProduct product : productList) {
	    store.purchaseProduct(product, 1);
	    }
	    
	    productList.clear();
    }
    /**

    The cancelOrder method is used to cancel the purchase of all the products in the shopping cart from a given store.
    It loops through each product in the cart and calls its cancelPurchase() method with a quantity of 1.
    After canceling the purchase of all the products, it clears the shopping cart.
    @param store the store from which to cancel the purchase of the products
    */
    public void cancelOrder(StoreFront store) {
	    for (SalableProduct product : productList) {
	    store.cancelPurchase(product, 1);
	    }
	    
	    productList.clear();
    }
}

