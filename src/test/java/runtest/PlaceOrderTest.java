package runtest;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.CheckoutPage;
import utils.ConfigData;

public class PlaceOrderTest extends OrderTest{
	
	private CheckoutPage checkoutpage;
	private ConfigData config;
	
	public PlaceOrderTest() throws IOException {
		checkoutpage = new CheckoutPage(driver);
		config = new ConfigData();
	}
	
	@Test
	public void checkout() {
		checkoutpage.getPaymentMethod();
		checkoutpage.getCVV(config.getProperty("cvvCode"));
		checkoutpage.getCardName(config.getProperty("name"));
		checkoutpage.getCountry(config.getProperty("India"));
		checkoutpage.getPlaceOrder();
	}
	
}
