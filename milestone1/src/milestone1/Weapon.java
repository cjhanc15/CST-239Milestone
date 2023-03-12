package milestone1;
/**
The Weapon class represents a type of SalableProduct that has an additional
attribute for attack power.
*/
public class Weapon extends SalableProduct {
	/** The attack power of the weapon. */
	private int attack;
	/**
	Constructs a new Weapon with the specified attributes.
	@param name the name of the weapon
	@param description the description of the weapon
	@param price the price of the weapon
	@param quantity the quantity of the weapon
	@param attack the attack power of the weapon
	*/
	public Weapon(String name, String description, double price, int quantity, int attack) {
	super(name, description, price, quantity);
	this.setAttack(attack);
	}
	/**
	Returns the attack power of the weapon.
	@return the attack power of the weapon
	*/
	public int getAttack() {
	return attack;
	}
	/**
	Sets the attack power of the weapon.
	@param attack the attack power of the weapon
	*/
	public void setAttack(int attack) {
	this.attack = attack;
	}
}
