package forSale;

import java.io.IOException;

/**
 * Admin Thread class extends Thread
 */
public class AdminThread extends Thread {
    private InventoryManager inventoryManager;

    /**
     * Admin Thread
     * @param inventoryManager ... inv manager
     */
    public AdminThread(InventoryManager inventoryManager) {
    	this.inventoryManager = inventoryManager;
    }
    
    /**
     * Run Method
     */
	public void run() {
		AdminService adminService = new AdminService(inventoryManager);
		try {
			adminService.start(7777);
			adminService.cleanup();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
