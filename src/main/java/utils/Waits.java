package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public Waits(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void visibilityOfElement(WebElement addedNote) {
		wait.until(ExpectedConditions.visibilityOf(addedNote));
	}
	
	public void elementToDisapper(WebElement ele) {
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void elemenyToBeClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	
	public void thread() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
