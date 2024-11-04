package forSale;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 * Storefront class
 */
public class Storefront {
	// ShoppingCart
	private ShoppingCart shoppingCart;
	private InventoryManager inventoryManager;
	private List<SalableProduct> products;
	
	/**
	 * Constructor to initialize cart
	 */
	public Storefront(InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
		this.shoppingCart = new ShoppingCart(inventoryManager);
	}
	/**
	 * Initialize store and list of products
	 * @throws IOException 
	 */
	public void initalizeStore() {
        ObjectMapper objectMapper = new ObjectMapper();
		this.products = new ArrayList<>();
		
        try {
        	
            // Parse the JSON file into a JsonNode array
            JsonNode root = objectMapper.readTree(new File("src/inventory.json"));

            // Loop through the JSON array
            for (JsonNode node : root) {
                String type = node.get("type").asText(); // Get the product type
                String name = node.get("name").asText();
                double price = node.get("price").asDouble();
                String sku = node.get("sku").asText();
                String description = node.get("description").asText();
                int quantity = node.get("quantity").asInt();

                // Determine the subclass based on the type field
                switch (type) {
                    case "Weapon":
                    	String size = node.get("size").asText();
                    	products.add(new Weapon(sku, name, description, price, quantity, size));
                        break;
                    case "Armor":
                    	String material = node.get("material").asText();
                    	products.add(new Weapon(sku, name, description, price, quantity, material));
                        break;
                    case "Health":
                    	String hitpoints = node.get("hitpoints").asText();
                    	products.add(new Weapon(sku, name, description, price, quantity, hitpoints));
                    	break;
                    default:
                        System.out.println("Unknown product type: " + type);
                }
            }
			//products.add(new Weapon("W-002", "Big Gun", "BANG! BANG!", 199.99, 5, "BIG"));
			//products.add(new Armor("A-001", "Chestplate", "Might hurt your shoulders but it'll protect your heart.", 249.99, 3, "Iron"));
			//products.add(new Armor("A-002", "Leggings", "Break a leg... or don't.", 149.99, 3, "Diamond"));
			//products.add(new Health("H-001", "Bandage", "Let's wrap this up.", 9.99, 40, "SMALL"));
        } catch (IOException e) {
        	System.out.println("I/O Error.");
        	e.printStackTrace();
        }
		
        inventoryManager.initializeInventory(products);
	}
	/**
	 * Purchase product by adding to cart
	 * @param product 	product being purchase
	 * @param quantity 	qantity being purchased
	 */
	public void purchaseProduct(SalableProduct product, int quantity) {
		shoppingCart.addToCart(product, quantity);
		inventoryManager.removeProduct(product, quantity);
	}
	
	/**
	 * Cancel Purchase
	 * @param product Product
	 * @param quantity Quantity being added back to inventory
	 */
	public void cancelPurchase(SalableProduct product, int quantity) {
		inventoryManager.addProduct(product, quantity);
	}
	
	/**
	 * List products available
	 */
	public void productList() {
		for (SalableProduct product : inventoryManager.getInventory()) {
			System.out.println(product.getItem());
		}
	}
	
	/**
	 * Add product to cart
	 */
	public boolean productAdd() {
		return productAdd("");
	}
	public boolean productAdd(String sku) {
		String userInput;
		Scanner scanner = new Scanner(System.in);
		boolean itemAdded = false;
		
		// ask for sku if null, e.g. not passed to method
		if (sku == "") {
			System.out.print("ENTER SKU: ");
			userInput = scanner.nextLine();
	    } else {
	    	userInput = sku;
	    }
		
		try {
			for (Object salableProduct: products) {
				String curSKU = ((SalableProduct) salableProduct).getSKU();
				if (curSKU.equals(userInput)) {
					shoppingCart.addToCart((SalableProduct) salableProduct, 1);
					itemAdded = true;
				}
			}
			if (itemAdded == false) {
				System.out.println("Invalid SKU. Item not found.");
			}
			
		} catch(InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid SKU.");
		}
		
		scanner.close();
		return itemAdded;
	}
	
	/**
	 * User interface menu
	 */
	public void startScreen() {
		int userInput = 0;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("~ Welcome to Ty's Shop ~");
			System.out.println("1 - List Products, 2 - Add Item to Cart, 3 - List Cart, 4 - Clear Cart, 5 - Purchase Cart, 6 - Sort Products, 7 - LEAVE");
			System.out.print("~ Select Option: ");
			userInput = scanner.nextInt();
			
			System.out.println("");
			
			switch (userInput) {
			case 1:
				productList();
				System.out.println("");
				break;
			case 2:
				productAdd();
				System.out.println("");
				break;
			case 3:
				shoppingCart.cartList();
				System.out.println("");
				break;
			case 4:
				shoppingCart.clearCart();
				System.out.println("");
				break;
			case 5:
				shoppingCart.purchaseCart();
				System.out.println("");
				break;
			case 6:
				sortOptions();
				break;
			case 7:
				System.out.println("Thanks for coming, see you soon!");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid input. Please enter a valid number (1-6).");
				System.out.println("");
				break;
				
			}
		} while (true);
	}
	
	/**
	 * Sort Displayed Products
	 */
	private void sortOptions() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("1 - Sort by Name AND Price, 2 - Sort by Price ONLY");
		System.out.print("~ Select Option: ");
		
		int sortInput = scanner.nextInt();
		
		System.out.println("");
		System.out.println("1 - Ascending, 2 - Descending");
		System.out.print("~ Select Option: ");
		
		boolean descending = scanner.nextInt() == 2;
		
		System.out.println("");
		
		if (sortInput == 1) {
			inventoryManager.sortInventoryByNameAndPrice(descending);
		} else {
			inventoryManager.sortInventoryByPrice(descending);
		}
		
		productList(); // list sorted products
		System.out.println("");
	}
}
