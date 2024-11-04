package forSale;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StorefrontTest {
	
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
	public void testProductList() {
		InventoryManager sharedInventoryManager = new InventoryManager();
		Storefront storefront = new Storefront(sharedInventoryManager);

		storefront.initalizeStore();
		
		storefront.productList();
		
		// contains our first product
		assertTrue(outContent.toString().contains("W-001"));
	}

	@Test
	public void testProductAdd() {
		InventoryManager sharedInventoryManager = new InventoryManager();
		Storefront storefront = new Storefront(sharedInventoryManager);

		storefront.initalizeStore();
		
		// test product add
		Assert.assertTrue(storefront.productAdd("W-001"));		
	}

}
