package milestone1;

public class Health extends SalableProduct {
	/**
	 * The amount of health that is boosted.
	 */
	private int boost;

	/**
	 * Constructs a Health object with the given parameters.
	 *
	 * @param name        the name of the Health object
	 * @param description the description of the Health object
	 * @param price       the price of the Health object
	 * @param quantity    the quantity of the Health object
	 * @param boost       the amount of health that is boosted
	 */
	public Health(String name, String description, double price, int quantity, int boost) {
	    super(name, description, price, quantity);
	    this.boost = boost;
	}

	/**
	 * Returns the amount of health that is boosted.
	 *
	 * @return the amount of health that is boosted
	 */
	public int getBoost() {
	    return boost;
	}

	/**
	 * Sets the amount of health that is boosted.
	 *
	 * @param boost the new amount of health that is boosted
	 */
	public void setBoost(int boost) {
	    this.boost = boost;
	}
}

