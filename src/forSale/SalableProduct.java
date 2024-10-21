package forSale;
/**
 * Salable product class
 */
public class SalableProduct implements Comparable<SalableProduct> {
	// Instance variables with associated product details
	private String sku;
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	/**
	 * Constructor that initializes new product
	 * @param sku			Product sku
	 * @param name			Product name
	 * @param description	Product description
	 * @param price			Product price
	 * @param quantity		Product quantity
	 */
	public SalableProduct(String sku, String name, String description, double price, int quantity) {
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * Getter that returns product price
	 * @return Returns product price
	 */
	public String getSKU() {
		return sku;
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
	
	/**
	 * Setter that sets quantity
	 * @param quantity quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Getter that returns entire salable item as a string
	 * @return returns salable item as string
	 */
	public String getItem() {
		return sku + " - " + name + ", " + description + " - " + price + ", " + quantity;
	}
	
	@Override
	public int compareTo(SalableProduct other) {
		// compare by name
		int nameComparison = this.name.compareTo(other.name);
		if (nameComparison != 0) {
			return nameComparison;
		}
		
		// if name is equal, compare by price
		return Double.compare(this.price, other.price);
	}
}