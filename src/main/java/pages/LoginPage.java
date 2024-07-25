package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Waits;

public class LoginPage extends BasePage{
	
	Waits wait = new Waits(driver);
	
	@FindBy(id="userEmail")
	WebElement emailField;
	
	@FindBy(id="userPassword")
	WebElement pwField;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(id="toast-container")
	WebElement loginNote;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterPw(String pw) {
		pwField.sendKeys(pw);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void loginNotice() {
		wait.visibilityOfElement(loginNote);
		String getLoginNotice = loginNote.getText();
		System.out.println("Login Notice: " + getLoginNotice); 
	}
	
	
}
