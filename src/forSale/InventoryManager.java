package forSale;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	
	/**
	 * Sort Inventory by Product Name and Price
	 */
	public void sortInventoryByNameAndPrice(boolean descending) {
		// custom comparator... this should allow me to sort by name then by price
		Comparator<SalableProduct> comparator = new Comparator<SalableProduct>() {
			@Override
			public int compare(SalableProduct p1, SalableProduct p2) {
				int nameComparison = p1.getName().compareTo(p2.getName());
				if (nameComparison == 0) {
					// sort by price if names are the same
					return Double.compare(p1.getPrice(),  p2.getPrice());
				}
				return nameComparison;
			}
		};
		
		// sort the inventory by comparator
		Collections.sort(inventory, comparator);
		
		// reverse for descending order
		if (descending) {
			Collections.reverse(inventory);
		}
	}
	
	/**
	 * Sort Inventory by Price ONLY
	 */
	public void sortInventoryByPrice(boolean descending) {
		Collections.sort(inventory, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())); 
		// arrow operator used with lambda expressions
		// lambda expressions allow you to write functions without a name concisely
		// the syntax for lambda expressions is (parameters) -> body as seen above ^
		if (descending) {
			Collections.reverse(inventory);
		}
	}
}
