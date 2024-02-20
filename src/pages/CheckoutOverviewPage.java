package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
	
	WebDriver driver;
	
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By checkoutOverviewPageLabel = By.xpath("//span[@class=\"title\"]");
	private By finishButton = By.id("finish");
	private By itemTotal = By.xpath("//div[@class=\"summary_subtotal_label\"]");
	private By taxCost = By.xpath("//div[@class=\"summary_tax_label\"]");
	private By totalCost = By.xpath("//div[@class=\"summary_total_label\"]");

	public String getcheckoutOverviewPageLabel() {
		return driver.findElement(checkoutOverviewPageLabel).getText();
	}
	public void clickFinishButton() {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(finishButton).click();
	}
	
	public double getItemTotal() {
		String priceText = driver.findElement(itemTotal).getText();
	    String str = priceText.substring(13);
		double price = Double.parseDouble(str);
		return price;
	}
	
	public double getTax() {
		String priceText = driver.findElement(taxCost).getText();
		String str = priceText.substring(6);
		double price = Double.parseDouble(str) ;
		return price;
	}
	public double getTotalCost() {
		String priceText = driver.findElement(totalCost).getText();
		String str = priceText.substring(8);
		double price = Double.parseDouble(str) ;
		return price;
	    }
	
}
