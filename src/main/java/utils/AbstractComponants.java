package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AbstractComponants {
	
	protected WebDriver Driver;
	protected Actions a;
	
	public AbstractComponants(WebDriver driver) {
		this.Driver = driver;
		this.a = new Actions(Driver);
	}
	
	public void action(WebElement ele) {
		a.moveToElement(ele).click().build().perform();
	}
	
	
	
	
	
}
