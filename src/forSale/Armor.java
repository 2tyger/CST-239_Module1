package forSale;

/**
 * Armor extends SalableProduct
 */
public class Armor extends SalableProduct {

	private String material;
	
	/**
	 * Armor item method
	 * @param sku			item number
	 * @param name			item name
	 * @param description	item description
	 * @param price			item price
	 * @param quantity		item quantity
	 * @param material		item material
	 */
	public Armor(String sku, String name, String description, double price, int quantity, String material) {
		super(sku, name, description, price, quantity);
		
		this.material = material;
	}
	
	/**
	 * Getter that returns material
	 * @return	returns material
	 */
	public String getMaterial() {
		return material;
	}
	
	//public void setMaterial(String material) {
	//	this.material = material;
	//}
	
	@Override
	public String getDescription() {
		String description;
		
		description = super.getDescription();
		description += " Material: " + material;
		
		return description;
	}
	
	@Override
	public String getItem() {
		String item;
		
		item = super.getItem();
		item += ", " + material;
		
		return item;
	}
}
