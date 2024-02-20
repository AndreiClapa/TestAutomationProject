package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
WebDriver driver;
	
	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By checkoutCompleteHeader = By.xpath("//div[@id=\"checkout_complete_container\"]/h2");
	private By backHomeButton = By.id("back-to-products");
	
	
	public String getcheckoutCompleteHeader() {
		return driver.findElement(checkoutCompleteHeader).getText();
	}

	public void clickgoBackHome() {
		driver.findElement(backHomeButton).click();
	}
}
