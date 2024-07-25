package runtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ConfigData;
import utils.DriverManager;

public class LoginTest {
	
	protected WebDriver driver;
	private ConfigData config;
	private LoginPage loginpage;
	
	@BeforeTest
	public void setup() throws IOException {
		config = new ConfigData();
		driver = DriverManager.getDriver(); 
		driver.get(config.getProperty("url"));
		loginpage = new LoginPage(driver);
	}
	
	@Test
	public void testLogin() {
		loginpage.enterEmail(config.getProperty("email"));
		loginpage.enterPw(config.getProperty("pw"));
		loginpage.clickLogin();
		loginpage.loginNotice();
	}
	
//	@AfterTest
//	public void tearDown() {
//		DriverManager.quitdriver();
//	} 
	
}
