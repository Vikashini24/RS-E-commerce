package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

public class ProductPage extends BasePage{
	
	Waits wait = new Waits(driver);
	
	@FindBy(xpath="//div/div[@class='card']")
	List<WebElement> numOfProducts;
	
	@FindBy(xpath="//div[@class='card']//h5/b[text()='ZARA COAT 3']")
	WebElement zaraCoat3;
	
	@FindBy(xpath="//div[@class='card']//h5[b[text()='ZARA COAT 3']]/following-sibling::button[@class='btn w-10 rounded']")
	WebElement addToCart;
	
	@FindBy(id="toast-container")
	WebElement addedNote;
	
	@FindBy(css = ".la-ball-scale-multiple")
	WebElement spinner;
	
	@FindBy(xpath="(//li/button[@class='btn btn-custom'])[3]")
	WebElement cartButton;
	
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public void productsList() {
		int prodSize = numOfProducts.size();
		System.out.println("Total number of products in the page: " + prodSize);
	}
	
	
	public void addProductToCart() {
		String prodName = zaraCoat3.getText();
		System.out.println("Product Name: " + prodName);
		if(prodName.equalsIgnoreCase("zara coat 3")) {
			addToCart.click();
		}
		wait.visibilityOfElement(addedNote);
		System.out.println("Product added notice: " + addedNote);
	}
	
	public void clickCart() {
		wait.elementToDisapper(spinner);
		cartButton.click();
	}
	
	
	
	
}
