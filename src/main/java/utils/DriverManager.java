package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	protected static WebDriver driver; 
	
	public static WebDriver getDriver() throws IOException {
		if(driver == null) {
			ConfigData config = new ConfigData();
			String browserName = config.getProperty("browser");
			
			if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} 
			else if(browserName.equalsIgnoreCase("firefox")) {
				//WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void quitdriver() {
		if(driver != null) {
			driver.quit();
			//driver = null;
		}
	}

	
	
}
