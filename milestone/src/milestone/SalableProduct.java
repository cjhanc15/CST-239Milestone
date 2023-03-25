package milestone;

public class SalableProduct {
	private String name;
	private String description;
	private double price;
	private int quantity;

	/**
	 * Constructs a new SalableProduct object with the specified name, description, price and quantity.
	 * @param name the name of the product
	 * @param description the description of the product
	 * @param price the price of the product
	 * @param quantity the quantity of the product
	 */
	public SalableProduct(String name, String description, double price, int quantity) {
	    this.name = name;
	    this.setDescription(description);
	    this.setPrice(price);
	    this.setQuantity(quantity);
	}

	/**
	 * Returns the name of the product.
	 * @return the name of the product
	 */
	public String getName() {
	   return name;
	}

	/**
	 * Sets the name of the product.
	 * @param name the name of the product
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the description of the product.
	 * @return the description of the product
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the product.
	 * @param description the description of the product
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the price of the product.
	 * @return the price of the product
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the product.
	 * @param price the price of the product
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Returns the quantity of the product.
	 * @return the quantity of the product
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity of the product.
	 * @param quantity the quantity of the product
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
