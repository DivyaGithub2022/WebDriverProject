package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.GeckoDriverInfo;

public class FBLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); //to install gecko exe files
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver1 = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		
		

	}

}
