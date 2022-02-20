package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		WebElement scrollElement = driver.findElement(By.xpath("//h2[text()='Table Rows']"));
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("arguments[0].scrollIntoView();", scrollElement);
		
		//to scroll down to the end of page
		//obj.executeAsyncScript("window.scrollTo(0, document.body.scrollHeight);");
		
		//scroll up
		//obj.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		

	}

}
