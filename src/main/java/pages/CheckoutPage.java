package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Waits;

public class CheckoutPage extends BasePage{
	
	private Waits wait;

	@FindBy(xpath="//div/div/i[@class='icon icon-credit-card']")
	WebElement paymentMethod;
	
	@FindBy(xpath="(//input[@class='input txt'])[1]")
	WebElement cvv;
	
	@FindBy(xpath="(//input[@class='input txt'])[2]")
	WebElement cardName;
	
	@FindBy(xpath="//div[@class='form-group']/input")
	WebElement country;
	
	@FindBy(css=".ta-item.list-group-item.ng-star-inserted")
	List<WebElement> countryList;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.wait = new Waits(driver);
	}
	
	public void getPaymentMethod() {
		String payment = paymentMethod.getText();
		System.out.println(payment);
	}
	
	public void getCVV(String cvvCode) {
		cvv.sendKeys(cvvCode);
	}
	
	public void getCardName(String name) {
		cardName.sendKeys(name);
	}
	
	public void getCountry(String countryName) {
		wait.implicitWait();
		country.sendKeys("ind");
		for (WebElement countries : countryList) {
			if(countries.getText().equalsIgnoreCase(countryName)) {
				countries.click();
				break;
			}
		}
	}
	
	public void getPlaceOrder() {
		placeOrder.click();
	}
	
}
