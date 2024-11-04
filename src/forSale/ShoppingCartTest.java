package forSale;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
	
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
	public void testAddToCart() {
		InventoryManager sharedInventoryManager = new InventoryManager();
		Storefront storefront = new Storefront(sharedInventoryManager);
		ShoppingCart shoppingCart = new ShoppingCart(sharedInventoryManager);
		List<SalableProduct> products;
		
		storefront.initalizeStore();
		
		products = sharedInventoryManager.getInventory();
		
		shoppingCart.addToCart(products.get(0), 1);
		
		assertTrue(outContent.toString().contains("has been added to cart!"));
	}

	@Test
	public void testCartList() {
		InventoryManager sharedInventoryManager = new InventoryManager();
		Storefront storefront = new Storefront(sharedInventoryManager);
		ShoppingCart shoppingCart = new ShoppingCart(sharedInventoryManager);
		List<SalableProduct> products;
		
		storefront.initalizeStore();
		
		products = sharedInventoryManager.getInventory();
		
		shoppingCart.addToCart(products.get(0), 1);
		shoppingCart.cartList();
		
		assertTrue(outContent.toString().contains(products.get(0).getSKU()));	
	}

}
