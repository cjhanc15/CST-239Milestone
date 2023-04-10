package milestone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**

The InventoryManager class manages a list of SalableProduct objects and provides methods to add, remove, update, and sort them.
@param <T> the type of SalableProduct managed by the InventoryManager
*/
public class InventoryManager<T extends SalableProduct> {
    private ArrayList<T> productList;

    /**
     * Constructs a new InventoryManager with an empty product list.
     */
    public InventoryManager() {
        productList = new ArrayList<T>();
    }

    /**
     * Adds the specified SalableProduct to the product list.
     * @param product the SalableProduct to add
     */
    public void addProduct(T product) {
        productList.add(product);
    }

    /**
     * Removes the specified SalableProduct from the product list.
     * @param product the SalableProduct to remove
     */
    public void removeProduct(T product) {
        productList.remove(product);
    }

    /**
     * Updates the quantity of the specified SalableProduct in the product list.
     * @param product the SalableProduct to update
     * @param quantity the new quantity value
     */
    public void updateProduct(T product, int quantity) {
        product.setQuantity(quantity);
    }

    /**
     * Returns an ArrayList containing all the SalableProducts in the product list.
     * @return an ArrayList of SalableProduct objects
     */
    public ArrayList<T> getAllProducts() {
    	int count = 1;
        for (T product : productList) {
            System.out.println(count + ": " + product.getName() + " - " + product.getDescription() + " - $" + product.getPrice() + " - " + product.getQuantity() + " units");
            count ++;
        }
        return productList;
    }
    
    /**
     * Returns all products sorted in ascending or descending order by name.
     * @param order the order in which to sort the products ("asc" for ascending, "desc" for descending)
     * @return an ArrayList of SalableProduct objects sorted by name
     */
    public ArrayList<T> sortProductsByName(String order) {
        ArrayList<T> sortedList = new ArrayList<T>(productList);
        if(order.equals("asc") ) {
            Collections.sort(sortedList, new Comparator<T>() {
                public int compare(T p1, T p2) {
                    return p1.getName().compareTo(p2.getName());
                }
            });
        } else {
            Collections.sort(sortedList, new Comparator<T>() {
                public int compare(T p1, T p2) {
                    return p2.getName().compareTo(p1.getName());
                }
            });
        }
        return sortedList;
    }
    
    /**
     * Returns all products sorted starting with lowest or highest price.
     * @param order the order in which to sort the products ("low" for lowest to highest, "high" for highest to lowest)
     * @return an ArrayList of SalableProduct objects sorted by price
     */
    public ArrayList<T> sortProductsByPrice(String order) {
        ArrayList<T> sortedList = new ArrayList<T>(productList);
        if(order.equals("low") ) {
            Collections.sort(sortedList, new Comparator<T>() {
                public int compare(T p1, T p2) {
                    return Double.compare(p1.getPrice(), p2.getPrice());
                }
            });
        } else {
            Collections.sort(sortedList, new Comparator<T>() {
                public int compare(T p1, T p2) {
                    return Double.compare(p2.getPrice(), p1.getPrice());
                }
            });
        }
        return sortedList;
    }
}

