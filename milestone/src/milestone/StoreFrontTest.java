/**

The package milestone contains the class StoreFrontTest, which tests the functionality of the StoreFront class.
*/
package milestone;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

/**

StoreFrontTest is a class that tests the functionality of the StoreFront class.
*/
public class StoreFrontTest {
	private StoreFront store;
	InventoryManager<SalableProduct> inventory;
	/**
	Sets up the StoreFrontTest by creating a new inventory manager and store.
	*/
	@Before
	public void setUp() {
		inventory = new InventoryManager<>();
		store = new StoreFront("Test Store", "Test Location", inventory);
}
	/**
	Tests the setName method of the StoreFront class.
	*/
	@Test
	public void testSetName() {
		store.setName("New Name");
		assertEquals("New Name", store.getName());
	}
	/**
	Tests the setLocation method of the StoreFront class.
	*/
	@Test
	public void testSetLocation() {
		store.setLocation("New Location");
		assertEquals("New Location", store.getLocation());
	}
	/**
	Tests the readFile method of the StoreFront class.
	@throws IOException if there is an I/O error.
	*/
	@Test
	public void testReadFile() throws IOException {
		// create a test input file
		File inputFile = new File("ShoppingList.in");
		PrintWriter inputWriter = new PrintWriter(new FileWriter(inputFile));
		inputWriter.println("Product 1,Description 1,1.99");
		inputWriter.close();
		// call the method under test
		store.readFile();
		// check that the output file was created and contains the expected JSON strings
		File outputFile =  new File("ShoppingList.out");
		assertTrue(outputFile.exists());
		Scanner outputScanner = new Scanner(outputFile);
		assertEquals("{\"name\":\"Product 1\",\"description\":\"Description 1\",\"price\":1.99,\"quantity\":1}", outputScanner.nextLine());
		assertFalse(outputScanner.hasNextLine());
		outputScanner.close();
	}
	/**
	Tests the purchaseProduct method of the StoreFront class.
	*/
	@Test
	public void testPurchaseProduct() {
		// create a test product and add it to the inventory
		SalableProduct product = new SalableProduct("Test Product", "Test Description", 9.99, 10);
		inventory.addProduct(product);
		// call the method under test
		store.purchaseProduct(product, 5);
		// check that the inventory was updated correctly
		assertEquals(5, product.getQuantity());
	}
	/**
	Tests the cancelPurchase method of the StoreFront class.
	*/
	@Test
	public void testCancelPurchase() {
		// create a test product and add it to the inventory
		SalableProduct product = new SalableProduct("Test Product", "Test Description", 9.99, 10);
		inventory.addProduct(product);
		// call the method under test
		store.cancelPurchase(product, 5);
		// check that the inventory was updated correctly
		assertEquals(15, product.getQuantity());
	}
}
	
