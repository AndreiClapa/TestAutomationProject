package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderMenu {
	
	WebDriver driver;
	
	public HeaderMenu(WebDriver driver) {
		this.driver = driver;
	}
	
	private By shoppingCartIcon = By.xpath("//div[@id=\"shopping_cart_container\"]/a");
	private By shoppingCartBadge = By.xpath("//span[@class=\"shopping_cart_badge\"]");
	private By burgerMenu = By.xpath("//button[@id=\"react-burger-menu-btn\"]");
	private By logoutButton = By.xpath("//a[@id=\"logout_sidebar_link\"]");

	public void goToShoppingCart() {
		driver.findElement(shoppingCartIcon).click();
	}
	
	public String shoppingCartBadge() {
		return driver.findElement(shoppingCartBadge).getText();
	}
	
	public void clickBurgerMenu() {
		driver.findElement(burgerMenu).click();
	}
	
	public void clickLogoutButton() {
		driver.findElement(logoutButton).click();
	}
}
