package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.AbstractComponants;
import utils.Waits;

public class CartPage extends BasePage {
	
	private AbstractComponants abstractcomponant = new AbstractComponants(driver);
	private Waits wait = new Waits(driver);
	
	@FindBy(tagName="//h1")
	WebElement cartTitle;
	
	@FindBy(tagName="//h3")
	WebElement prodInCart;
	
	//@FindBy(xpath="(//ul)[3]/li[3]/button")
	//@FindBy(xpath="//li/button[@class='btn btn-primary']")
	@FindBy(xpath="/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button")
	WebElement checkoutButton;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkCart() {
			wait.visibilityOfElement(checkoutButton);
			//wait.elemenyToBeClickable(checkoutButton);
			System.out.println("Checkout button is visible: " + checkoutButton.isDisplayed());
			System.out.println("Checkout button is enabled: " + checkoutButton.isEnabled());
			abstractcomponant.action(checkoutButton);
			checkoutButton.click();
		}
				
	}
	




//try {
//	//wait.visibilityOfElement(checkoutButton);
//	wait.elemenyToBeClickable(checkoutButton);
//	System.out.println("Checkout button is visible: " + checkoutButton.isDisplayed());
//	System.out.println("Checkout button is enabled: " + checkoutButton.isEnabled());
//	abstractcomponant.action(checkoutButton);
//	checkoutButton.click();
//} catch (NoSuchElementException e) { 
//	//e.printStackTrace();
//	throw e;
//}

