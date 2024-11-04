package forSale;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArmorTest {

	@Test
	public void testGetItem() {
		List<SalableProduct> products = new ArrayList<>();
		
		products.add(new Armor("W-002", "Big Gun", "BANG! BANG!", 199.99, 5, "material"));

		for (SalableProduct product : products) {
			assertTrue(product.getItem().toString().contains("material"));
		}		
	}

}