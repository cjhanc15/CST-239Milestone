package milestone;

import java.util.ArrayList;

public class InventoryManager {
	private ArrayList<SalableProduct> productList;

	/**
	 * Constructs a new InventoryManager with an empty product list.
	 */
	public InventoryManager() {
	    productList = new ArrayList<SalableProduct>();
	}

	/**
	 * Adds the specified SalableProduct to the product list.
	 * @param product the SalableProduct to add
	 */
	public void addProduct(SalableProduct product) {
	    productList.add(product);
	}

	/**
	 * Removes the specified SalableProduct from the product list.
	 * @param product the SalableProduct to remove
	 */
	public void removeProduct(SalableProduct product) {
	    productList.remove(product);
	}

	/**
	 * Updates the quantity of the specified SalableProduct in the product list.
	 * @param product the SalableProduct to update
	 * @param quantity the new quantity value
	 */
	public void updateProduct(SalableProduct product, int quantity) {
	    product.setQuantity(quantity);
	}

	/**
	 * Returns an ArrayList containing all the SalableProducts in the product list.
	 * @return an ArrayList of SalableProduct objects
	 */
	public ArrayList<SalableProduct> getAllProducts() {
	    return productList;
	}
}
