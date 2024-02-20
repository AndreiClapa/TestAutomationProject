package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	WebDriver driver;
	
	public CheckoutPage ( WebDriver driver) {
		this.driver = driver;
	}
	
	
	private By checkoutPageLabel = By.xpath("//div[@id=\"header_container\"]/div[2]/span");
	private By firstNameInput = By.xpath("//input[@id=\"first-name\"]");
	private By lastNameInput = By.xpath("//input[@id=\"last-name\"]");
	private By postalCodeInput = By.xpath("//input[@id=\"postal-code\"]");
	private By continueButton = By.xpath("//input[@id=\"continue\"]");
	private By errorMessage = By.xpath("//h3[@data-test=\"error\"]");
	
	
	public String getCheckoutPageLabel() {
		return driver.findElement(checkoutPageLabel).getText();
	}
	
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameInput).sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		driver.findElement(lastNameInput).sendKeys(lastName);
	}
	public void enterPostalCode(String postalCode) {
		driver.findElement(postalCodeInput).sendKeys(postalCode);
	}
	public void clickContinue() {
		driver.findElement(continueButton).click();
	}
	public void enterCheckoutData(String firstName, String lastName, String postalCode) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPostalCode(postalCode);
		clickContinue();
	}
	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}
	
	

}
