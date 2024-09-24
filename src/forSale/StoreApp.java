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
		Storefront storefront = new Storefront();
		storefront.initalizeStore();
		// add to cart
		storefront.purchaseProduct(new SalableProduct("Earbuds", "The Best Earbuds", 24.99, 5), 2);
		// clear cart
		storefront.cancelPurchase();
	}
}
