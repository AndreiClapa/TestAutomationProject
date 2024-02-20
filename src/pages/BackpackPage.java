package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testData.Backpack;

public class BackpackPage {
	

	WebDriver driver;
	
	public BackpackPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public static Backpack backpackTD = new Backpack("backpack");
	
	private By productLabel = By.xpath("//div[@class=\"inventory_details_name large_size\"]");
    private By productDetails = By.xpath("//div[@class=\"inventory_details_desc large_size\"]");
	private By productPrice = By.xpath("//div[@class=\"inventory_details_price\"]");
    private By addToCartButton = By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]");
    private By backToProductsButton = By.xpath("//button[@id=\"back-to-products\"]");
    private By removeFromCartButton = By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]");
    private By shoppingCartBadge = By.xpath("//span[@class=\"shopping_cart_badge\"]");
	
    
    public String getProductLabel() {
		return driver.findElement(productLabel).getText();
	}
	public String getProductDetails() {
		return driver.findElement(productDetails).getText();
	}
	public String getProductPrice() {
		return driver.findElement(productPrice).getText();
	}
	public double getPrice() {
		String str = backpackTD.getPrice().substring(1);
	    double price = Double.parseDouble(str) ;
	    return price;
	}
	public void clickAddToCart() {
		driver.findElement(addToCartButton).click();
	}
	public String getAddToCartButtonText() {
		return driver.findElement(addToCartButton).getText();
	}
	public void clickBackToProducts() {
		driver.findElement(backToProductsButton).click();
	}
	public String getRemoveFromCartButtonText() {
		return driver.findElement(removeFromCartButton).getText();
	}
	public void clickRemoveFromCart() {
		        driver.findElement(removeFromCartButton).click();
	}

	public boolean isDisplayedShoppingCartBadge() {
		return driver.findElement(shoppingCartBadge).isDisplayed();
	}
}
