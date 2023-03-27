package milestone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**

The StoreFront class represents a store that sells salable products. It stores the name and location of the store,
and an inventory manager to manage the products available for sale.
*/
public class StoreFront {
    private String name;
    private String location;
    private InventoryManager inventory;
    /**
     * Constructs a new StoreFront object with the specified name, location, and inventory manager.
     * @param name the name of the store
     * @param location the location of the store
     * @param inventory the inventory manager for the store
     */
    public StoreFront(String name, String location, InventoryManager inventory) {
        this.setName(name);
        this.setLocation(location);
        this.inventory = inventory;
    }

    /**
     * Returns the name of the store.
     * @return the name of the store
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the store.
     * @param name the new name of the store
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the location of the store.
     * @return the location of the store
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the store.
     * @param location the new location of the store
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    /**

    Reads the contents of the "shoppingList.in" file, creates a SalableProduct object for each line,
    and writes a corresponding JSON string to the "shoppingList.out" file.
    The format of the JSON string is as follows:
    {"name":"product name","description":"product description","price":product price,"quantity":product quantity}
    Only lines with at least 3 comma-separated fields are processed.
    @throws IOException If there is an error reading or writing the file.
    */
    public void readFile() {
        try (Scanner scanner = new Scanner(new File("shoppingList.in"))) {
            PrintWriter pw = new PrintWriter(new FileWriter("shoppingList.out"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String productName = parts[0];
                    String description = parts[1];
                    double price = Double.parseDouble(parts[2]);

                    SalableProduct product = new SalableProduct(productName, description, price, 1);
                    String json = String.format("{\"name\":\"%s\",\"description\":\"%s\",\"price\":%.2f,\"quantity\":%d}",
                            product.getName(), product.getDescription(), product.getPrice(), product.getQuantity());
                    pw.println(json);
                }
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    /**
     * Purchases the specified quantity of the specified product from the store's inventory.
     * @param product the product to purchase
     * @param quantity the quantity of the product to purchase
     */
    public void purchaseProduct(SalableProduct product, int quantity) {
        int qty = product.getQuantity() - quantity;
        inventory.updateProduct(product, qty);
    }

    /**
     * Cancels a purchase of the specified quantity of the specified product, returning it to the store's inventory.
     * @param product the product to return to inventory
     * @param quantity the quantity of the product to return to inventory
     */
    public void cancelPurchase(SalableProduct product, int quantity) {
        int qty = product.getQuantity() + quantity;
        inventory.updateProduct(product, qty);
    }
    
    
}
