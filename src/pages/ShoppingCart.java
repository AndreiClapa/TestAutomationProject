package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart {
	
	WebDriver driver;
	
	public ShoppingCart ( WebDriver driver) {
		this.driver = driver;
	}

	private By shoppingCartLabel = By.xpath("//div[@id=\"header_container\"]/div[2]/span");
	private By inventoryFirstItemName = By.xpath("//a[@id=\"item_4_title_link\"]/div");
	private By inventorySecondItemName = By.xpath("//a[@id=\"item_2_title_link\"]/div");
	private By checkoutButton = By.xpath("//button[@id=\"checkout\"]");
	private By removeButton = By.xpath("//button[@class=\"btn btn_secondary btn_small cart_button\"]");
	private By removedInventoryItem = By.xpath("//div[@class=\"removed_cart_item\"]");
	
	
	public String getshoppingCartLabel() {
		return driver.findElement(shoppingCartLabel).getText();
	}
	public String getInventoryFirstItemName() {
		return driver.findElement(inventoryFirstItemName).getText();
	}
	public String getInventorySecondItemName() {
		return driver.findElement(inventorySecondItemName).getText();
	}
	public boolean checkRemovedInventoryItemIsPresent() {
		return driver.findElement(removedInventoryItem).isDisplayed();
	}
	
	public void clickCheckoutButton() {
		driver.findElement(checkoutButton).click();
	}
	public void clickRemoveFromCart() {
		driver.findElement(removeButton).click();
	}
	
	
}
