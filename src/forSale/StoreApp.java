package forSale;

/**
 * Store application / interface test class
 */
public class StoreApp {
	/**
	 * Main method
	 * @param args Main method
	 */
	public static void main(String[] args) {
		InventoryManager sharedInventoryManager = new InventoryManager();

        // Pass shared InventoryManager instance to both Storefront and AdminThread
        Storefront storefront = new Storefront(sharedInventoryManager);
        AdminThread adminThread = new AdminThread(sharedInventoryManager);
    
        // start admin service thread
		adminThread.start();
        
		storefront.initalizeStore();
		storefront.startScreen();
		
	}
}
