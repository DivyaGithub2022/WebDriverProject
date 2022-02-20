package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		TakesScreenshot obj = (TakesScreenshot) driver;
		//(TakesScreenshot) - type casting
		File file = obj.getScreenshotAs(OutputType.FILE);
		//getScreenshot method will return a file as result, so need to save it to a file object
		
		try{
			FileUtils.copyFile(file, new File("image.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//FileUtils.copyFile(file, new File());
		//FileUtils is from the Jar file downloaded (commons-io-jar file)
		//Its used for copying the file from RAM (file object) to our harddisk (save it in our Comp's file system/folder).
		
		//If you want to take multiple screenshots then create the try catch block with the File object creation as well to getscreenshot inside a function and then call hat wherever required.

	}

}
