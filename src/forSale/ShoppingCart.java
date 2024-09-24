package forSale;

import java.util.ArrayList;
import java.util.List;

/**
 * Shopping Cart Class
 */
public class ShoppingCart {
	private List<SalableProduct> cartItems;
	
	/**
	 * Constructor for empty Shopping Cart
	 */
	public ShoppingCart() {
		this.cartItems = new ArrayList<>();
	}
	/**
	 * Adds items to cart
	 * @param product	product being added to cart
	 * @param quantity	quantity of product being added to cart
	 */
	public void addToCart(SalableProduct product, int quantity) {
		// Check to make sure product has enough stock
		if (product.getQuantity() >= quantity) {
			// Add quantity of product to cart
			cartItems.add(new SalableProduct(product.getName(), product.getDescription(), product.getPrice(), quantity));
		} else {
			System.out.println("Stock is insufficent... " + product.getName() + " does not have enough stock.");
		}
	
	}
	/**
	 * Removes product from Shopping Cart
	 * @param product Product for removal
	 */
	public void removeFromCart(SalableProduct product) {
		cartItems.remove(product); // Remove product from cart
	}
	/**
	 * Clears items in cart
	 */
	public void clearCart() {
		cartItems.clear(); // Clear items in the cart
	}
}
