package runtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigData;
import utils.DriverManager;

public class RunTest {
	
	private WebDriver driver;
	private LoginPage loginpage;
	private ConfigData config;
	private ProductPage productpage;
	private CartPage cartpage;
	private CheckoutPage checkoutpage;
	
	@BeforeTest
	public void setup() throws IOException {
		config = new ConfigData();
		driver = DriverManager.getDriver(); 
		driver.get(config.getProperty("url"));
		loginpage = new LoginPage(driver);
		productpage = new ProductPage(driver);
		cartpage = new CartPage(driver);
		checkoutpage = new CheckoutPage(driver);
	}
	
	@Test (priority=1)
	public void login() {
		loginpage.enterEmail(config.getProperty("email"));
		loginpage.enterPw(config.getProperty("pw"));
		loginpage.clickLogin();
		loginpage.loginNotice();
	}
	
	@Test (priority=2)
	public void order() {
		productpage.productsList();
		productpage.addProductToCart();
		productpage.clickCart();
		cartpage.checkCart();
	}
	
	@Test (priority=3)
	public void checkout() {
		checkoutpage.getPaymentMethod();
		checkoutpage.getCVV(config.getProperty("cvvCode"));
		checkoutpage.getCardName(config.getProperty("name"));
		checkoutpage.getCountry(config.getProperty("India"));
		checkoutpage.getPlaceOrder();
	}
	
	@AfterTest
	public void tearDown() {
		DriverManager.quitdriver();
	} 

	
}
