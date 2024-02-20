package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import messages.Product;

public class OnesieTests extends BaseTest{
	
	@Before @Override
	public void before() {
		super.before();
		assertTrue(startPage.isOpen());
		startPage.authenthicate( userTD.getUsername() , userTD.getPassword());
		assertEquals(Product.HEADER, productPage.getHeaderText());
	}
	
	@Test
	public void checkOnesieProductDetails() {	
		productPage.clickOnesieProduct();
		assertEquals(onesiePage.getProductLabel(), onesieTD.getLabel());
		assertEquals(onesiePage.getProductDetails(), onesieTD.getDetails());
		assertEquals(onesiePage.getProductPrice(), onesieTD.getPrice());
	}
	
	@Test
	public void checkAddOnesieToCart() {
		productPage.clickOnesieProduct();
		onesiePage.clickAddToCart();
		assertEquals(onesiePage.getRemoveFromCartButtonText(), Product.REMOVE_BUTTON);
	}
	
	@Test
	public void checkRemoveFromCart() {
		productPage.clickOnesieProduct();
		onesiePage.clickAddToCart();
        assertTrue(onesiePage.isDisplayedShoppingCartBadge());
        headerMenu.goToShoppingCart();
        shoppingCart.clickRemoveFromCart();
		assertFalse(shoppingCart.checkRemovedInventoryItemIsPresent());
	}
}
