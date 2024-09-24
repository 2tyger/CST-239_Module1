package forSale;
/**
 * Salable product class
 */
public class SalableProduct {
	// Instance variables with associated product details
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	/**
	 * Constructor that initializes new product
	 * @param name			Product name
	 * @param description	Product description
	 * @param price			Product price
	 * @param quantity		Product quantity
	 */
	public SalableProduct(String name, String description, double price, int quantity) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * Getter that returns product name
	 * @return Returns product name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter that returns product description
	 * @return Returns product description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Getter that returns product price
	 * @return Returns product price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Getter that returns product quantity
	 * @return returns product quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
}