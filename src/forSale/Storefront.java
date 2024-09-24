package forSale;

import java.util.ArrayList;
import java.util.List;
/**
 * Storefront class
 */
public class Storefront {
	// ShoppingCart
	private ShoppingCart shoppingCart;
	private List<SalableProduct> products;
	/**
	 * Constructor to initialize cart
	 */
	public Storefront() {
		this.shoppingCart = new ShoppingCart();
	}
	/**
	 * Initialize store and list of products
	 */
	public void initalizeStore() {
		this.products = new ArrayList<>();
		products.add(new SalableProduct("Earbuds", "The Best Earbuds", 24.99, 5));
	}
	/**
	 * Purchase product by adding to cart
	 * @param product 	product being purchase
	 * @param quantity 	qantity being purchased
	 */
	public void purchaseProduct(SalableProduct product, int quantity) {
		shoppingCart.addToCart(product, quantity);
	}
	/**
	 * Cancel purchase by clearing cart
	 */
	public void cancelPurchase() {
		shoppingCart.clearCart();
	
	}
}
