package milestone;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

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

    Reads the contents of the "shoppingList.out" file, parses the JSON strings in each line,
    and creates a SalableProduct object for each line, adding them to the productList.
    If the JSON string is not properly formatted, an error message is printed to the console.
    @throws NumberFormatException If the quantity field in the JSON string cannot be parsed as an integer.
    @throws IOException If there is an error reading the file.
    */
    public void orderByShoppingList() {
        try {
            File file = new File("shoppingList.out");
            Scanner scan = new Scanner(file);

            while (scan.hasNext()) {
                String json = scan.nextLine();
                System.out.println("JSON string: " + json); // Debug statement
                String[] parts = json.split(",");
                if (parts.length >= 4) {
                    String name = parts[0].substring(parts[0].indexOf(":") + 2, parts[0].length() - 1);
                    String description = parts[1].substring(parts[1].indexOf(":") + 2, parts[1].length() - 1);
                    double price = Double.parseDouble(parts[2].substring(parts[2].indexOf(":") + 1));
                    int quantity = Integer.parseInt(parts[3].substring(parts[3].indexOf(":") + 1, parts[3].length() - 1));
                    System.out.println("Name: " + name + ", Description: " + description + ", Price: " + price + ", Quantity: " + quantity); // Debug statement
                    SalableProduct product = new SalableProduct(name, description, price, quantity);
                    productList.add(product);
                } else {
                    System.out.println("Invalid JSON string: " + json);
                }
            }

            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

