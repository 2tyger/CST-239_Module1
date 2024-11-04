package forSale;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryManagerTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
	
	@Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));  // Redirect System.out
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);  // Restore System.out after test
    }
	
	@Test
	public void testAddProduct() {
		InventoryManager sharedInventoryManager = new InventoryManager();
		Storefront storefront = new Storefront(sharedInventoryManager);

		storefront.initalizeStore();
		
		List<SalableProduct> products = new ArrayList<>();
		products.add(new Health("W-002", "Big Gun", "BANG! BANG!", 199.99, 5, "hitpoints"));
		
		for (SalableProduct product : products) {
			sharedInventoryManager.addProduct(product, 1);
		}
		
		assertTrue(!outContent.toString().contains("Product doesn't exist in inventory :"));
	}
}
