package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigData {
	
	Properties property;
	
	public ConfigData() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\Eclipse_WorkSpace\\RahulShetty\\POM\\src\\main\\java\\resources\\data.properties");
		property = new Properties();
		property.load(fis);
	}
	
	public String getProperty(String key) {
		String browserName = property.getProperty(key);
		return browserName;
	}
	
}
