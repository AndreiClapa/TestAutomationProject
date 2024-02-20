package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import messages.Checkout;
import messages.CheckoutComplete;
import messages.CheckoutOverview;

public class CheckoutTests extends BaseTest{
	
	@Before @Override
	public void before() {
		super.before();
		assertTrue(startPage.isOpen());
		startPage.authenthicate( userTD.getUsername() , userTD.getPassword());
		productPage.clickBackpackProduct();
		backpackPage.clickAddToCart();
		headerMenu.goToShoppingCart();
		shoppingCart.clickCheckoutButton();
		assertEquals(checkoutPage.getCheckoutPageLabel(), Checkout.HEADER);

	}
	
	@Test
	public void checkCheckoutWithValidData() throws InterruptedException {	
		checkoutPage.enterCheckoutData(checkoutTD.getFirstName(), checkoutTD.getLastName(), checkoutTD.getPostalCode());
		 assertEquals(checkoutOverviewPage.getcheckoutOverviewPageLabel(), CheckoutOverview.HEADER);		 
		 checkoutOverviewPage.clickFinishButton();
		 assertEquals(checkoutCompletePage.getcheckoutCompleteHeader(), CheckoutComplete.HEADER);
		  
	}
	
	@Test
	public void checkInvalidDataCheckout() {
		checkoutPage.enterCheckoutData("", "", "");
		assertEquals(checkoutPage.getErrorMessage(),Checkout.FIRST_NAME_ERROR);
		checkoutPage.enterCheckoutData("a", "", "");
		assertEquals(checkoutPage.getErrorMessage(),Checkout.LAST_NAME_ERROR);
		checkoutPage.enterCheckoutData("a", "B", "");
		assertEquals(checkoutPage.getErrorMessage(),Checkout.POSTAL_CODE_ERROR);

	}

}
