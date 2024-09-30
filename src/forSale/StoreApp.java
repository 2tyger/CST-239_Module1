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
		storefront.startScreen();
	}
}
