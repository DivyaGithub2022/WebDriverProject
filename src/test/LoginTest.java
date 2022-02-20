package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//First, we need to tell the Class where to find the Driver file
		
		//webdriver is an interface
		WebDriver driver = new ChromeDriver();
		//we are creating an object of Chromedriver which is implementing the WebDriver
		
		driver.get("https://www.simplilearn.com/");
		//get operation launches the url
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		//webelement is a class
		WebElement Loginlink = driver.findElement(By.linkText("Log in"));
		//WebElement Loginlink = driver.findElement(By.className("login"));
		Loginlink.click();
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement Loginbutton = driver.findElement(By.name("btn_login"));
		
		WebElement checkBox = driver.findElement(By.className("rememberMe"));
		//WebElement RememberMe= driver.findElement(By.className("rememberMe"));
        //RememberMe.click();
		
		/*
		WebElement logo = driver.findElement(By.xpath("//div[@class='logo-image']/img"));
		logo.click();
		String logoText = logo.getText();
		System.out.println(logoText);
		*/	
		UserName.sendKeys("xyz@abcd.com");
		Password.sendKeys("Hello@123");
		checkBox.click();
		Loginbutton.click();
		
		
		//Validate the message displayed in the UI page
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		if(ActualMsg.equals(ExpMsg)) {
			System.out.println("TC Pass");
		}else {
			System.out.println("TC Fail");
			System.out.println("Atual msg: " + ActualMsg);
		}
		

		//how to find all the hyperlinks in the UI page?
		//findelement - will return only the first <a> in the page
		//we are creating a list of links so can be saved into a List only
		List<WebElement> links = driver.findElements(By.tagName("a")); //use List or ArrayList
		System.out.println("Total links are " + links.size());
		
		for(WebElement elm : links) {
			System.out.println(elm.getAttribute("href"));
		}
		
		//getattribute - to get the value of that attribute by giving the name, and that attribute wil be printed on the console
		
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		Thread.sleep(5000);
		//only when the element is not completely ready it'll wait, not always
		driver.close();
		driver.quit();
		
		//javascript:void(0); - for those links in the page does not have value

	}

}
