package forSale;

/**
 * Health extends SalableProduct
 */
public class Health extends SalableProduct {

	private String hitpoints;
	
	/**
	 * Health item method
	 * @param sku			item number
	 * @param name			item name
	 * @param description	item description
	 * @param price			item price
	 * @param quantity		item quantity
	 * @param hitpoints		item hitpoints
	 */
	public Health(String sku, String name, String description, double price, int quantity, String hitpoints) {
		super(sku, name, description, price, quantity);
		
		this.hitpoints = hitpoints;
	}
	
	/**
	 * Getter that returns hitpoints
	 * @return returns hitpoints
	 */
	public String getHitpoints() {
		return hitpoints;
	}
	
	//public void setHitpoints(String hitpoints) {
	//	this.hitpoints = hitpoints;
	//}
	
	@Override
	public String getDescription() {
		String description;
		
		description = super.getDescription();
		description += " Hitpoints: " + hitpoints;
		
		return description;
	}
	
	@Override
	public String getItem() {
		String item;
		
		item = super.getItem();
		item += ", " + hitpoints;
		
		return item;
	}
	
	@Override
	public String getItemJSON() {
		String item;
		
		item = super.getItem();
		item += ", \"hitpoints\": \"" + hitpoints + "\"";
		
		return item;
	}
}
