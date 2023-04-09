package milestone;

import java.util.ArrayList;
import java.util.Scanner;

/**

The Administrator class provides functionality for updating and printing inventory data of a Store Front Application.
It contains methods for startup, updating inventory, and printing salable products.
The main method initializes an Inventory Manager and a Store Front, and starts the application.
*/
public class Administrator {
	
	/**
	 * Prompts the user for input to update the Inventory Manager or print all Salable Products.
	 * If 'U' is entered, calls the update method.
	 * If 'R' is entered, calls the print method.
	 * If 'Q' is entered, closes the Scanner object and exits the program.
	 * @param store the Store Front to update
	 * @param inventory the Inventory Manager to update
	 */
	public static void startup(StoreFront store, InventoryManager inventory) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What would you like to do today?");
		System.out.println("Press 'U' to update the Inventory Manager.");
		System.out.println("Press 'R' to view all Salable Products");
		System.out.println("Press 'Q' to quit.");
		
		String ok = scan.nextLine();

		while(! (ok.equals("U") || ok.equals("R") || ok.equals("Q"))) {
			System.out.println("What would you like to do today?\n\n");
			System.out.println("Press 'U' to update the Inventory Manager.");
			System.out.println("Press R to view all Salable Products");			
			ok = scan.nextLine();
		}
		
		if(ok.equals("U")) update(store, inventory);
		if(ok.equals("R")) print(store, inventory);
		if(ok.equals("Q")) scan.close();
	}

	/**
	 * Reads data from a file, updates the Store Front with new Salable Products, and writes the updated data to a file.
	 * Calls the startup method to prompt for additional actions.
	 * @param store the Store Front to update
	 * @param inventory the Inventory Manager to update
	 */
	public static void update(StoreFront store, InventoryManager inventory) {
		System.out.println("Reading file...");
		
		store.readFile();
		System.out.println("SUCCESS. Please view 'shoppingList.out'");
		
		startup(store, inventory);
	}
	
	/**
	 * Prints all Salable Products from the Inventory Manager.
	 * Calls the startup method to prompt for additional actions.
	 * @param store the Store Front to print from
	 * @param inventory the Inventory Manager to print from
	 */
	public static void print(StoreFront store, InventoryManager inventory) {
		System.out.println("\n\nSalable Products:");
		inventory.getAllProducts();
		
		startup(store, inventory);
	}

	/**
	 * Initializes an Inventory Manager and a Store Front, and starts the application by calling the startup method.
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		InventoryManager inventory = new InventoryManager();
		StoreFront store = new StoreFront("store", "remote", inventory);
		
		startup(store, inventory);
	}
}
