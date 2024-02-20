package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {
	WebDriver driver;
	
	public StartPage ( WebDriver driver) {
		this.driver = driver;
	}
	
	private By usernameInput = By.xpath("//input[@id=\"user-name\"]");
	private By passwordInput = By.xpath("//input[@id=\"password\"]");
	private By loginButton = By.xpath("//input[@id=\"login-button\"]");
	private By robotIcon = By.xpath("//div[@id=\"root\"]/div/div[2]/div[1]/div[2]");
	private By loginErrorLabel = By.xpath("//div[@id=\"login_button_container\"]/div/form/div[3]/h3");

	public void enterUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}
		public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	public void authenthicate(String username, String password) {
		enterUsername(username);
		enterPassword(password);
        clickLogin();
    }
	public boolean isOpen() {
		return driver.findElement(robotIcon).isDisplayed();
	}
	
	public String getLoginError() {
		return driver.findElement(loginErrorLabel).getText();
	}
	
	
	 
}
