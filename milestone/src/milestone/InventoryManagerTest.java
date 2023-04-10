package milestone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
/**

The InventoryManagerTest class is a JUnit test case for the InventoryManager class.
It provides test methods for adding, removing, updating, and sorting salable products.
*/
public class InventoryManagerTest {

    private InventoryManager<SalableProduct> manager;
    private SalableProduct product1;
    private SalableProduct product2;
    /**
    Sets up the test fixtures.
    */
    @Before
    public void setUp() {
        manager = new InventoryManager<>();
        product1 = new SalableProduct("Product 1", "Description 1", 10.0, 5);
        product2 = new SalableProduct("Product 2", "Description 2", 20.0, 3);
    }
    /**
    Tests the addProduct method of InventoryManager.
    It verifies that a product is added successfully to the inventory list.
    */
    @Test
    public void testAddProduct() {
        manager.addProduct(product1);
        ArrayList<SalableProduct> allProducts = manager.getAllProducts();
        assertEquals(1, allProducts.size());
        assertTrue(allProducts.contains(product1));
    }
    /**
    Tests the removeProduct method of InventoryManager.
    It verifies that a product is removed successfully from the inventory list.
    */
    @Test
    public void testRemoveProduct() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.removeProduct(product1);
        ArrayList<SalableProduct> allProducts = manager.getAllProducts();
        assertEquals(1, allProducts.size());
        assertFalse(allProducts.contains(product1));
        assertTrue(allProducts.contains(product2));
    }
    /**
    Tests the updateProduct method of InventoryManager.
    It verifies that a product is updated successfully with a new quantity.
    */
    @Test
    public void testUpdateProduct() {
        manager.addProduct(product1);
        manager.updateProduct(product1, 10);
        ArrayList<SalableProduct> allProducts = manager.getAllProducts();
        assertEquals(10, allProducts.get(0).getQuantity());
    }
    /**
    Tests the sortProductsByName method of InventoryManager.
    It verifies that the list of products is sorted by name in ascending and descending order.
    */
    @Test
    public void testSortProductsByName() {
        manager.addProduct(product2);
        manager.addProduct(product1);
        ArrayList<SalableProduct> sortedListAsc = manager.sortProductsByName("asc");
        ArrayList<SalableProduct> sortedListDesc = manager.sortProductsByName("desc");
        assertEquals(2, sortedListAsc.size());
        assertEquals(2, sortedListDesc.size());
        assertEquals(product1, sortedListAsc.get(0));
        assertEquals(product2, sortedListAsc.get(1));
        assertEquals(product2, sortedListDesc.get(0));
        assertEquals(product1, sortedListDesc.get(1));
    }
    /**
    Tests the sortProductsByPrice method of InventoryManager.
    It verifies that the list of products is sorted by price in low and high order.
    */
    @Test
    public void testSortProductsByPrice() {
        manager.addProduct(product2);
        manager.addProduct(product1);
        ArrayList<SalableProduct> sortedListLow = manager.sortProductsByPrice("low");
        ArrayList<SalableProduct> sortedListHigh = manager.sortProductsByPrice("high");
        assertEquals(2, sortedListLow.size());
        assertEquals(2, sortedListHigh.size());
        assertEquals(product1, sortedListLow.get(0));
        assertEquals(product2, sortedListLow.get(1));
        assertEquals(product2, sortedListHigh.get(0));
        assertEquals(product1, sortedListHigh.get(1));
    }
}

