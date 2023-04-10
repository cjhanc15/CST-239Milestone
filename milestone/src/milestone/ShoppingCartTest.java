package milestone;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
The ShoppingCartTest class tests the ShoppingCart class.
*/
public class ShoppingCartTest {

	private ShoppingCart<SalableProduct> cart;
	private InventoryManager inventory;
	private StoreFront store;

	/**
	 * Sets up the initial conditions for testing the ShoppingCart class.
	 */
	@Before
	public void setUp() {
	    cart = new ShoppingCart<SalableProduct>();
	    inventory = new InventoryManager();
	    store = new StoreFront("store", "location", inventory);
	}

	/**
	 * Tests the addProduct method of the ShoppingCart class.
	 */
	@Test
	public void testAddProduct() {
	    SalableProduct product = new SalableProduct("Product 1", "Description 1", 10.0, 1);
	    cart.addProduct(product);
	    assertEquals(10.0, cart.getTotal(), 0.001);
	}

	/**
	 * Tests the removeProduct method of the ShoppingCart class.
	 */
	@Test
	public void testRemoveProduct() {
	    SalableProduct product1 = new SalableProduct("Product 1", "Description 1", 10.0, 1);
	    SalableProduct product2 = new SalableProduct("Product 2", "Description 2", 20.0, 1);
	    cart.addProduct(product1);
	    cart.addProduct(product2);
	    cart.removeProduct(product1);
	    assertEquals(20.0, cart.getTotal(), 0.001);
	}

	/**
	 * Tests the getTotal method of the ShoppingCart class.
	 */
	@Test
	public void testGetTotal() {
	    SalableProduct product1 = new SalableProduct("Product 1", "Description 1", 10.0, 1);
	    SalableProduct product2 = new SalableProduct("Product 2", "Description 2", 20.0, 2);
	    cart.addProduct(product1);
	    cart.addProduct(product2);
	    assertEquals(30.0, cart.getTotal(), 0.001);
	}

	/**
	 * Tests the checkout method of the ShoppingCart class.
	 */
	@Test
	public void testCheckout() {
	    SalableProduct product1 = new SalableProduct("Product 1", "Description 1", 10.0, 1);
	    SalableProduct product2 = new SalableProduct("Product 2", "Description 2", 20.0, 2);
	    inventory.addProduct(product1);
	    inventory.addProduct(product2);
	    cart.addProduct(product1);
	    cart.addProduct(product2);
	    cart.checkout(store);
	    assertEquals(2, inventory.getAllProducts().size());
	}

	/**
	 * Tests the cancelOrder method of the ShoppingCart class.
	 */
	@Test
	public void testCancelOrder() {
	    SalableProduct product1 = new SalableProduct("Product 1", "Description 1", 10.0, 1);
	    SalableProduct product2 = new SalableProduct("Product 2", "Description 2", 20.0, 2);
	    inventory.addProduct(product1);
	    inventory.addProduct(product2);
	    cart.addProduct(product1);
	    cart.addProduct(product2);
	    cart.cancelOrder(store);
	    assertEquals(2, inventory.getAllProducts().size());
	}


}

