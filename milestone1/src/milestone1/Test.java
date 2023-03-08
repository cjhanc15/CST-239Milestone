package milestone1;

public class Test {
	public static void main(String[] args) {
		
		// create some products
		SalableProduct product1 = new SalableProduct("Product 1", "Description of Product 1", 10.99, 100);
		SalableProduct product2 = new SalableProduct("Product 2", "Description of Product 2", 5.99, 50);
		
		// create an inventory manager and add the products
		InventoryManager inventory = new InventoryManager();
		inventory.addProduct(product1);
		inventory.addProduct(product2);
		
		// create a store and initialize it with some products
		StoreFront store = new StoreFront("My Store", "123 Main St", inventory);
		
		// test the purchaseProduct method
		store.purchaseProduct(product1, 5);
		if (product1.getQuantity() == 95) {
			System.out.println("SUCCESS: Product quantity updated correctly");
		} else {
			System.out.println("ERROR: Product quantity not updated correctly");
		}
		
		// test the cancelPurchase method
		store.cancelPurchase(product1, 2);
		if (product1.getQuantity() == 97) {
			System.out.println("SUCCESS: Product quantity updated correctly");
		} else {
			System.out.println("ERROR: Product quantity not updated correctly");
		}
		//initialize new shopping cart
		ShoppingCart cart = new ShoppingCart();

		//shopping cart addProduct()
		cart.addProduct(product1);
		cart.addProduct(product2);
		if(cart.getTotal() == 16.98) System.out.println("SUCCESS: Products added to cart correctly");
		else System.out.println("ERROR: Products not added to cart successfully");
		
		//shopping cart removeProduct()
		cart.removeProduct(product2);
		if(cart.getTotal() == 10.99) {
			System.out.println("SUCCESS: Product removed from cart correctly");
			System.out.println("SUCCESS: Total retrieved correctly");
		} else System.out.println("ERROR: Product not removed from cart successfully");	
	}
}

