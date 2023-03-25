package milestone;

import milestone.Armor;
import milestone.Health;
import milestone.InventoryManager;
import milestone.ShoppingCart;
import milestone.StoreFront;
import milestone.Weapon;

/**
The Test class tests the functionality of the StoreFront, InventoryManager, SalableProduct, Health, Armor, Weapon,
*/
public class Test {
	/**
	The Test class tests the functionality of the StoreFront, InventoryManager, SalableProduct, Health, Armor, Weapon,
	*/
	public static void main(String[] args) {
		
		// create some products
		//2 health
		Health smallHealthPotion = new Health("Small Health Potion", "+15 hp", 12.99, 500, 15);
		Health largeHealthPotion = new Health("large Health Potion", "+50 hp", 29.99, 250, 50);
		
		//2 armor
		Armor woodenArmor = new Armor("Wooden Armor", "+5 defense", 99.99, 10, 5);
		Armor grassArmor = new Armor("Grass Armor", "+15 defense", 129.99, 7, 15);

		//2 weapons
		Weapon woodenSword = new Weapon("Wooden Sword", "+5 attack", 59.99, 50, 5);
		Weapon grassSword = new Weapon("Grass Sword", "+15 attack", 79.99, 20, 15);
		
		// create an inventory manager and add the products
		InventoryManager inventory = new InventoryManager();
		inventory.addProduct(smallHealthPotion);
		inventory.addProduct(largeHealthPotion);
		inventory.addProduct(woodenArmor);
		inventory.addProduct(grassArmor);
		inventory.addProduct(woodenSword);
		inventory.addProduct(grassSword);
		
		// create a store and fill it with some products
		StoreFront store = new StoreFront("My Store", "123 Main St", inventory);
		
		//initialize new shopping cart
		ShoppingCart cart = new ShoppingCart();

		//shopping cart addProduct()
		cart.addProduct(smallHealthPotion);
		cart.addProduct(woodenArmor);
		cart.addProduct(woodenSword);
		cart.addProduct(grassSword);
		if(cart.getTotal() == 252.96) System.out.println("SUCCESS: Products added to cart correctly");
		else System.out.println("ERROR: Expected: $252.96, Recieved: $" + cart.getTotal());
		
		//shopping cart removeProduct()
		cart.removeProduct(grassSword);
		if(cart.getTotal() == 172.97) {
			System.out.println("SUCCESS: Product removed from cart correctly");
			System.out.println("SUCCESS: Total retrieved correctly");
		} else System.out.println("ERROR: Expected: $172.97, Recieved: $" + cart.getTotal());	
		
		// test the checkout method
		cart.checkout(store);
		if (smallHealthPotion.getQuantity() == 499) {
			System.out.println("SUCCESS: Product quantity updated correctly");
		} else {
			System.out.println("ERROR: Expected: 499, Recieved: " + smallHealthPotion.getQuantity());
		}
		
		cart.addProduct(smallHealthPotion);
		
		// test the cancelPurchase method
		cart.cancelOrder(store);
		if (smallHealthPotion.getQuantity() == 500) {
			System.out.println("SUCCESS: Product quantity updated correctly");
		} else {
			System.out.println("ERROR: Expected: 500, Recieved: " + smallHealthPotion.getQuantity());
		}
		
		//test shopping list
		store.readFile();
		cart.orderByShoppingList();
		System.out.println("SUCCESS: order by shopping list successful");
	}
}
