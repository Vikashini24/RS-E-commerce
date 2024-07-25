package runtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class OrderTest extends LoginTest{

	//private WebDriver driver;
	private ProductPage productpage;
	private CartPage cartpage;
	
	public OrderTest() throws IOException {
		super.setup();
		productpage = new ProductPage(driver);
		cartpage = new CartPage(driver);
	}
	
	
	@Test
	public void order() {
		productpage.productsList();
		productpage.addProductToCart();
		productpage.clickCart();
		//productpage.clickCheckout();
		cartpage.checkCart();
	}
	
	
}
