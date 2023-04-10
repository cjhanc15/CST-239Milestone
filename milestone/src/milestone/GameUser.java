package milestone;

import java.util.ArrayList;
import java.util.Scanner;

import milestone.Armor;
import milestone.Health;
import milestone.InventoryManager;
import milestone.ShoppingCart;
import milestone.StoreFront;
import milestone.Weapon;

/**
The GameUser class tests the functionality of the StoreFront, InventoryManager, SalableProduct, Health, Armor, and Weapon classes.
*/
public class GameUser {
	/**
	Adds a selected product to the shopping cart.
	@param inventory The inventory of products.
	@param cart The shopping cart.
	@param list The list of available products.
	@param place The index of the selected product in the list.
	*/
	public static void addProductToCart(InventoryManager inventory, ShoppingCart cart, ArrayList<SalableProduct> list, int place) {
    	int count = 1;
        for (SalableProduct product : list) {
        	if(count == place) {
        		cart.addProduct(product); 
        		System.out.println("\nAdded " + product.getName() + " to cart");
        		return;
        	}
        	else count ++;
        }
        System.out.println("No products found");
	}
	/**
	The main method creates products, an inventory manager, and a store, and allows the user to add items to a shopping cart and checkout.
	@param args Command-line arguments.
	*/
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// create some products
		//2 health
		Health smallHealthPotion = new Health("Small Health Potion", "+15 hp", 12.99, 500, 15);
		Health largeHealthPotion = new Health("Large Health Potion", "+50 hp", 29.99, 250, 50);
		
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
		
		System.out.println("Hello, what would you like to buy? Press '0' when finished shopping.\n");
		
		inventory.getAllProducts();
		
		int product = scan.nextInt();
		while(product != 0) {
			addProductToCart(inventory, cart, inventory.getAllProducts(), product);
			product = scan.nextInt();
		}
		
		System.out.println("Press '1' to checkout or '2' to cancel your order.");
		int choice = scan.nextInt();
		while(choice != 1 && choice != 2) {
			System.out.println("Press '1' to checkout or '2' to cancel your order.");
			choice = scan.nextInt();
		}
		
		if(choice == 1) {
			cart.checkout(store);
			System.out.println("Thank you for your purchase, goodbye");
			scan.close();
		}
		else {
			cart.cancelOrder(store);
			System.out.println("Your order has been cancelled. Come back soon");
			scan.close();
		}
		
		scan.close();
		
	}
}