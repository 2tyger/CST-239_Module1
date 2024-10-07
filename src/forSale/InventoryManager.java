package forSale;

import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Manager Class
 */
public class InventoryManager {
	private List<SalableProduct> inventory;
	
	/**
	 * Inventory Manager
	 */
	public InventoryManager() {
		this.inventory = new ArrayList<>();
	}
	
	/**
	 * Initialize inventory
	 * @param products Inventory products
	 */
	public void initializeInventory(List<SalableProduct> products) {
		this.inventory = products;
	}
	
	/**
	 * Add Product
	 * @param product Product
	 * @param quantity Quantity being added
	 */
	public void addProduct(SalableProduct product, int quantity) {
		for (SalableProduct p : inventory) {
			if (p.getSKU().equals(product.getSKU())) {
				p.setQuantity(p.getQuantity() + quantity);
				return;
			}
		}
		System.out.println("Product doesn't exist in inventory :" + product.getName());
	}
	
	/**
	 * Remove Product
	 * @param product Product
	 * @param quantity Quantity being removed
	 * @return in stock: true or false
	 */
	public boolean removeProduct(SalableProduct product, int quantity) {
		for (SalableProduct p : inventory) {
			if (p.getSKU().equals(product.getSKU())) {
				if (p.getQuantity() >= quantity) {
					p.setQuantity(p.getQuantity() - quantity);
					return true;
				} else {
					System.out.println("Product is out of stock: " + product.getName());
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	 * Get inventory
	 * @return return inventory
	 */
	public List<SalableProduct> getInventory() {
		return inventory;
	}
}
