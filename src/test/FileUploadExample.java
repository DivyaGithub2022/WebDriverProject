package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		WebElement fileUpload = driver.findElement(By.xpath("//input[@name='uploadfile_0']"));
		fileUpload.sendKeys("C:\\Users\\Pc\\Downloads");
		
		WebElement TnCcheckbox = driver.findElement(By.id("terms"));
		TnCcheckbox.click();
		
		WebElement submit = driver.findElement(By.id("submitbutton"));
		submit.click();
		
		//not working this snippet
		//WebElement message = driver.findElement(By.xpath("//h3[@id='res']"));
		//System.out.println(message.getText());
		
		driver.close();

	}

}
