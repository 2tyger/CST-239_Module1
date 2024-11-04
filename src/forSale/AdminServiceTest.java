package forSale;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdminServiceTest {
	
	@Test
	public void testProductListJSON() {
		InventoryManager sharedInventoryManager = new InventoryManager();
		Storefront storefront = new Storefront(sharedInventoryManager);
		AdminService adminService = new AdminService(sharedInventoryManager);
				
		storefront.initalizeStore();
			
		assertTrue(adminService.productListJSON().contains("W-001"));
		
	}

}
