package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import components.HeaderMenu;
import pages.BackpackPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.OnesiePage;
import pages.ProductsPage;
import pages.ShoppingCart;
import pages.StartPage;
import testData.Backpack;
import testData.Checkout;
import testData.Onesie;
import testData.URL;
import testData.User;



public class BaseTest {
	
	static WebDriver driver;
	public static StartPage startPage;
	public static ProductsPage productPage;
	public static HeaderMenu headerMenu;
	public static User userTD = new User("user");
	public static Backpack backpackTD = new Backpack("backpack");
	public static Checkout checkoutTD = new Checkout("checkout");
	public static Onesie onesieTD = new Onesie("onesie");
	public static BackpackPage backpackPage;
	public static ShoppingCart shoppingCart;
	public static CheckoutPage checkoutPage;
	public static OnesiePage onesiePage;
	public static CheckoutOverviewPage checkoutOverviewPage;
	public static CheckoutCompletePage checkoutCompletePage;
	
	@BeforeClass
	public static void beforeAll() {
	}
	@AfterClass
	public static void afterAll() {
	}
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
	    System.setProperty("webdriver.chrome.whitelistedIps", "");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		startPage = new StartPage(driver);
		productPage = new ProductsPage(driver);
		headerMenu = new HeaderMenu(driver);
		backpackPage = new BackpackPage(driver);
		shoppingCart = new ShoppingCart(driver);
		checkoutPage = new CheckoutPage(driver);
		onesiePage = new OnesiePage(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
		
		driver.navigate().to(URL.BASE_URL);
		
	}
	@After
	public void after() {
		driver.close();
		driver.quit();
	}
	
	
	

}
