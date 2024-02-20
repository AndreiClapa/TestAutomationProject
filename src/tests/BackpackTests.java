package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import messages.Product;

public class BackpackTests extends BaseTest{
	
	@Before @Override
	public void before() {
		super.before();
		assertTrue(startPage.isOpen());
		startPage.authenthicate( userTD.getUsername() , userTD.getPassword());
		assertEquals(Product.HEADER, productPage.getHeaderText());
	}
	
	@Test
	public void checkBackpackProductDetails() {	
		productPage.clickBackpackProduct();
		assertEquals(backpackPage.getProductLabel(), backpackTD.getLabel());
		assertEquals(backpackPage.getProductDetails(), backpackTD.getDetails());
		assertEquals(backpackPage.getProductPrice(), backpackTD.getPrice());
	}
	
	@Test
	public void checkAddBackpackToCart() {
		productPage.clickBackpackProduct();
		backpackPage.clickAddToCart();
		assertEquals(backpackPage.getRemoveFromCartButtonText(), Product.REMOVE_BUTTON);
	}
	
	@Test
	public void checkRemoveFromCart() {
		productPage.clickBackpackProduct();
		backpackPage.clickAddToCart();
        assertTrue(backpackPage.isDisplayedShoppingCartBadge());
        headerMenu.goToShoppingCart();
        shoppingCart.clickRemoveFromCart();
		assertFalse(shoppingCart.checkRemovedInventoryItemIsPresent());
	}
}
