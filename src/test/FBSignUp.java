package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		WebElement Signup = driver.findElement(By.cssSelector("a[data-testid*='open-registration']"));
		Signup.click();
		
		WebElement FirstName = driver.findElement(By.cssSelector("input[aria-label='First name']"));
		WebElement Surname = driver.findElement(By.cssSelector("input[aria-label='Surname']"));
		WebElement Email = driver.findElement(By.cssSelector("input[aria-label*='number or email']"));
		WebElement Password = driver.findElement(By.cssSelector("input#password_step_input"));
		WebElement ReEnterEmail = driver.findElement(By.cssSelector("input[aria-label^='Re-enter']"));
		
			
		FirstName.sendKeys("Divya");
		Surname.sendKeys("K");
		Email.sendKeys("abc@world.com");
		ReEnterEmail.sendKeys("abc@world.com");
		Password.sendKeys("123@$ABcdefg");
		
		//dynamic Xpath
		String strGender = "Female";
				
		//input[@value='1']
				
		//label[text()='Custom']/following-sibling::input
		//label[text()='Male']/following-sibling::input
		//label[text()='Female']/following-sibling::input
				
		String genXpath = "//label[text()= '" + strGender + "' ]/following-sibling::input";
		WebElement Gender = driver.findElement(By.xpath(genXpath));
		Gender.click();
		
		//get the values from the drop-down list and print on the console
		//driver.findElement's' method for List
		List<WebElement> Months = driver.findElements(By.xpath("//select[@title='Month']/option"));
		//select#month>option - cssSelector
		
		for(WebElement element : Months) {
			System.out.println(element.getText());
		}
		
		WebElement Days = driver.findElement(By.xpath("//select[@title='Day']/option")); 
		
		WebElement currMonth = driver.findElement(By.xpath("//select[@title='Month']/option[@selected='1']"));
		//select#month>option[selected='1']  - cssSelector
						System.out.println("Current Month:" + currMonth.getText());
		
		WebElement BDay = driver.findElement(By.xpath("//select[@id='day']"));
		Select BirthDay = new Select(BDay); //creating a constructor of SELECT class
		//Select is a class provided by Webelement
		BirthDay.selectByVisibleText("25");
		
		WebElement BMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select BirthMonth = new Select(BMonth); //creating a constructor of SELECT class
		//Select is a class provided by Webelement
		BirthMonth.selectByVisibleText("Jun");
		
		WebElement BYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select BirthYear = new Select(BYear); //creating a constructor of SELECT class
		//Select is a class provided by Webelement
		BirthYear.selectByVisibleText("1987");
		
	
						
		//driver.quit();

	}

}
