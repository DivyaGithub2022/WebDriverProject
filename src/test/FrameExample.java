package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		driver.switchTo().frame("frame1");
		//frame(1)=frame index . If no ID available better to get ID from the Developer or use Frame Index.
		WebElement Heading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(Heading.getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		System.out.println("frame2");
		WebElement Heading2 = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(Heading2.getText());
		
		driver.close();
		
	}

}
