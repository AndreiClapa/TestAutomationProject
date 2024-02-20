package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import messages.Product;

public class LogoutTest extends BaseTest {
	
	@Before @Override
	public void before() {
		super.before();
		assertTrue(startPage.isOpen());
	}
	
	@Test
	public void logout() {	
		startPage.authenthicate( userTD.getUsername() , userTD.getPassword());
		assertEquals(Product.HEADER, productPage.getHeaderText());
		headerMenu.clickBurgerMenu();
		headerMenu.clickLogoutButton();
		assertTrue(startPage.isOpen());
	}

}
