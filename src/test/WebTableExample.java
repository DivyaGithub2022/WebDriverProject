package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		List<WebElement> tbRows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		//to make Xpath efficient change (//table[@id='customers']/tbody/tr) to (//table[@id='customers']//tr)
		System.out.println("Total rows: "+ tbRows.size());
		
		List<WebElement> tbColumns = driver.findElements(By.xpath("//table[@id='customers']//th"));
		//to make Xpath efficient change from "//table[@id='customers']/tbody/tr/th" to abve xpath
		System.out.println("Total Columns: " + tbColumns.size());
		
		List<WebElement> tbData = driver.findElements(By.xpath("//table[@id='customers']//tr[4]/td"));
		//to print the 3rd row in a web table
		for(WebElement elm : tbData) {
			System.out.println(elm.getText());
		}
		
		/*
		 * To find all the data in the first column -
		 * //table[@id=\"customers\"]//td[1]  or
		 * //table[@id='customers']//tr/td[1]
		 * for a dynamic /run time values - column or row numbers, we can use for loop as well
		 */
		
		int column = 1;
		String Col = "//table[@id='customers']//tr/td[" + column + "]";
		List<WebElement> tbColData = driver.findElements(By.xpath(Col));
		
		System.out.println("Data for First Column: ");
		
		for (WebElement elm1 : tbColData) {
			System.out.println(elm1.getText());
		}
		driver.close();

	}

}
