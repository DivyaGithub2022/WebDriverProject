package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		// getWindowHandles - get the address of active browser
		String ParentWindow = driver.getWindowHandle();
		System.out.println("Before clicking New Window button: " + ParentWindow);
		
		//click on 'NEW WINDOW' button in the window
		
		WebElement element = driver.findElement(By.xpath("//button[@id='windowButton']"));
		element.click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		
		while(itr.hasNext()) {
			
			String currentVal = itr.next();
			System.out.println(currentVal);
			
			if(!currentVal.equals(ParentWindow)) {
				
				driver.switchTo().window(currentVal);
			}
		}
		
		WebElement WinText = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
		System.out.println(WinText.getText());
		
		driver.close(); //for closing the current window
		//driver.quit(); //for closing all the windows opened in the session
		
		driver.switchTo().window(ParentWindow);
		System.out.println("Back to Parent Window Handle");
		//driver.close();
		
		//click on 'NEW TAB' button in the window
		
		WebElement element2 = driver.findElement(By.xpath("//button[@id='tabButton']"));
		System.out.println(element2.getText());
		element2.click();
		
		Set<String> handles2 = driver.getWindowHandles();
		Iterator<String> itr2 = handles2.iterator();
		
		while(itr2.hasNext()) {
			
			String currentVal2 = itr2.next();
			System.out.println(currentVal2);
			
			if(!currentVal2.equals(ParentWindow)) {
				
				driver.switchTo().window(currentVal2);
				System.out.println(currentVal2);
			}
		}
		
		WebElement WinText2 = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
		System.out.println(WinText2.getText());
		
		driver.close(); //for closing the current window
		//driver.quit(); //for closing all the windows opened in the session
		
		driver.switchTo().window(ParentWindow);
		System.out.println("Back to Parent Window Handle");
		//driver.close();
				
	}

}
