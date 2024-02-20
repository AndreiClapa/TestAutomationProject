package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import messages.CheckoutComplete;
import messages.Product;
import messages.ShoppingCart;

public class ProductsTests extends BaseTest{
	
	@Before @Override
	public void before() {
		super.before();
		assertTrue(startPage.isOpen());
		startPage.authenthicate( userTD.getUsername() , userTD.getPassword());
		assertEquals(Product.HEADER, productPage.getHeaderText());
	}
	
	@Test
	public void checkOrderOfProductsAz() {
		productPage.clickFilterDropdown();
		productPage.sortAZ();
		productPage.checkOrderedAz();
	}
	@Test
	public void checkOrderOfProductsZa() {
		productPage.clickFilterDropdown();
		productPage.sortZa();
		productPage.checkOrderedZa();
	}
	@Test
	public void checkSortPriceLowHigh() {
		productPage.clickFilterDropdown();
		productPage.sortLowHigh();
		productPage.sortPriceLowHigh();
	}
	@Test
	public void checkSortPriceHighLow() {
		productPage.clickFilterDropdown();
		productPage.sortHighLow();
		productPage.sortPriceHighLow();
	}
	
	@Test
	public void happyFlowToPurchaseTwoProducts() {
		backpackPage.clickAddToCart();
		onesiePage.clickAddToCart();
		assertTrue(headerMenu.shoppingCartBadge().contains("2"));
		headerMenu.goToShoppingCart();
		assertEquals(shoppingCart.getInventoryFirstItemName(), ShoppingCart.FIRST_PRODUCT_NAME);
		assertEquals(shoppingCart.getInventorySecondItemName(), ShoppingCart.SECOND_PRODUCT_NAME);
		shoppingCart.clickCheckoutButton();
		checkoutPage.enterCheckoutData(checkoutTD.getFirstName(), checkoutTD.getLastName(), checkoutTD.getPostalCode());
        checkoutOverviewPage.clickFinishButton();
		 assertEquals(checkoutCompletePage.getcheckoutCompleteHeader(), CheckoutComplete.HEADER);
	}
	
	@Test
	public void checkTotalPriceForTwoProducts() {
		backpackPage.clickAddToCart();
		onesiePage.clickAddToCart();
		headerMenu.goToShoppingCart();
		shoppingCart.clickCheckoutButton();
		checkoutPage.enterCheckoutData(checkoutTD.getFirstName(), checkoutTD.getLastName(), checkoutTD.getPostalCode());
		Assertions.assertEquals(backpackPage.getPrice() + onesiePage.getPrice(), checkoutOverviewPage.getItemTotal());
	}
}
