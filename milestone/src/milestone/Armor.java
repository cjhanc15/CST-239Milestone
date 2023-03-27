package milestone;
/**
The Armor class represents a type of SalableProduct that has an additional
attribute for defense power.
*/
public class Armor extends SalableProduct {
	/** The defense power of the weapon. */
	private int defense;
	/**
	Constructs a new Armor with the specified attributes.
	@param name the name of the weapon
	@param description the description of the weapon
	@param price the price of the weapon
	@param quantity the quantity of the weapon
	@param defense the defense power of the weapon
	*/
	public Armor(String name, String description, double price, int quantity, int defense) {
		super(name, description, price, quantity);
		this.setDefense(defense);
	}
	/**
	Returns the defense power of the weapon.
	@return the defense power of the weapon
	*/
	public int getDefense() {
		return defense;
	}
	/**
	Sets the defense power of the weapon.
	@param attack the defense power of the weapon
	*/
	public void setDefense(int defense) {
		this.defense = defense;
	}
}