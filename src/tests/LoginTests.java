package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import messages.Product;
import messages.Start;

public class LoginTests extends BaseTest{
	
	@Before @Override
	public void before() {
		super.before();
		assertTrue(startPage.isOpen());
	}
	
	@Test
	public void loginWithValidCredentials() {	
		startPage.authenthicate( userTD.getUsername() , userTD.getPassword());
		assertEquals(Product.HEADER, productPage.getHeaderText());
	}
	
	@Test
	public void loginWithInvalidPassword() {
		startPage.authenthicate( userTD.getUsername() , "invalid");
		assertEquals(Start.LOGIN_ERROR, startPage.getLoginError());

	}

}
