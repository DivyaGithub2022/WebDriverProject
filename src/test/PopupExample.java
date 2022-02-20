package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		// ======Alert Accept
		
		WebElement element = driver.findElement(By.xpath("//button[@id='alertButton']"));
		element.click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		alert.accept();
		
		// ======Alert Cancel
		
		WebElement elem2 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("arguments[0].scrollIntoView();", elem2);
		elem2.click();
		
		Alert alertCancel = driver.switchTo().alert();
		
		System.out.println(alertCancel.getText());
		alertCancel.dismiss();
				
		// ======ALert poup - enter text before Accepting
		
		WebElement elem3 = driver.findElement(By.xpath("//button[@id='promtButton']"));
		elem3.click();
				
		Alert alertPrompt = driver.switchTo().alert();
		System.out.println(alertPrompt.getText());
		alertPrompt.sendKeys("Divya");
		alertPrompt.accept();
		
		//Thread.sleep(4000);

	}

}
