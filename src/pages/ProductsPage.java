package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By headerLabel = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
	private By productBackpack = By.xpath("//*[@id=\"item_4_title_link\"]/div");
	private By productOnesie = By.xpath("//a[@id=\"item_2_title_link\"]");
	private By shoppingCartLink = By.xpath("//div[@id=\"shopping_cart_container\"]/a");
	private By filterDropdown = By.xpath("//select[@class=\"product_sort_container\"]");
	private By productName = By.xpath("//div[@class=\"inventory_item\"][1]/div/div/a/div");
	private By sortAZ = By.xpath("//option[@value=\"az\"]");
	private By sortZa = By.xpath("//option[@value=\"za\"]");
	private By sortLoHi = By.xpath("//option[@value=\"lohi\"]");
	private By sortHiLo = By.xpath("//option[@value=\"hilo\"]");
	private By productPrice = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
	
	public String getHeaderText() {
		return driver.findElement(headerLabel).getText();
	}
	
	public void clickBackpackProduct() {
		driver.findElement(productBackpack).click();
	}
	public void clickOnesieProduct() {
		driver.findElement(productOnesie).click();
	}
	
    public void clickShoppingCart() {
	    driver.findElement(shoppingCartLink).click();
}
    public void clickFilterDropdown() {
    	driver.findElement(filterDropdown).click();
    }
    public void sortAZ() {
    	driver.findElement(sortAZ).click();
    }
    public void sortZa() {
    	driver.findElement(sortZa).click();
    }
    
    public void sortLowHigh() {
    	driver.findElement(sortLoHi).click();
    }
    
    public void sortHighLow() {
    	driver.findElement(sortHiLo).click();
    }
    
    public void checkOrderedAz() {
    ArrayList<String> obtainedList = new ArrayList<String>(); 
    List<WebElement> elementList = driver.findElements(productName);
    for( WebElement we:elementList){
       obtainedList.add(we.getText());
    }
    ArrayList<String> sortedList = new ArrayList<>();   
    for(String s:obtainedList){
    sortedList.add(s);
    }
    Collections.sort(sortedList);
    assertTrue(sortedList.equals(obtainedList));
    }
    
    public void checkOrderedZa() {
        ArrayList<String> obtainedList = new ArrayList<String>(); 
        List<WebElement> elementList = driver.findElements(productName);
        for( WebElement we:elementList){
           obtainedList.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();   
        for(String s:obtainedList){
        sortedList.add(s);
        }
        Collections.sort(sortedList);
        assertTrue(sortedList.equals(obtainedList));
        }
    
    public void sortPriceLowHigh() {
    	List<WebElement> price = driver.findElements(productPrice);
    	List<String> prices = new ArrayList<String>();
    	for (WebElement e : price) {    	
    	    prices.add(e.getText());
    	}

    	List<String> sortedPrices = new ArrayList<String>(prices);
    	Collections.sort(sortedPrices);
    	assertEquals(sortedPrices, prices);
}
    
    public void sortPriceHighLow() {
    	List<WebElement> price = driver.findElements(productPrice);
    	List<String> prices = new ArrayList<String>();
    	for (WebElement e : price) {    	
    	    prices.add(e.getText());
    	}

    	List<String> sortedPrices = new ArrayList<String>(prices);
    	Collections.sort(sortedPrices);
    	assertEquals(sortedPrices, prices);
}
}

    
