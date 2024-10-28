package forSale;

/**
 * Weapon extends SalableProduct
 */
public class Weapon extends SalableProduct {
	
	private String caliber;
	
	/**
	 * Weapon item method
	 * @param sku			item number
	 * @param name			item name
	 * @param description	item description
	 * @param price			item price
	 * @param quantity		item quantity
	 * @param caliber		item caliber
	 */
	public Weapon(String sku, String name, String description, double price, int quantity, String caliber) {
		super(sku, name, description, price, quantity);
		
		this.caliber = caliber;
	}
	
	/**
	 * Getter that returns caliber
	 * @return	returns caliber
	 */
	public String getCaliber() {
		return caliber;
	}
	
	//public void setCaliber(String caliber) {
	//	this.caliber = caliber;
	//}
	
	@Override
	public String getDescription() {
		String description;
		
		description = super.getDescription();
		description += " Caliber: " + caliber;
		
		return description;
	}
	
	@Override
	public String getItem() {
		String item;
		
		item = super.getItem();
		item += ", " + caliber;
		
		return item;
	}
	
	@Override
	public String getItemJSON() {
		String item;
		
		item = super.getItem();
		item += ", \"caliber\": \"" + caliber + "\"";
		
		return item;
	}
}
