package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicUsingFlipkart {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.findElement(By.name("q")).sendKeys("iphone",Keys.ENTER);
		
		String phnName = "Apple iPhone 14 Plus (Blue, 128 GB)";
		
		String price = driver.findElement(By.xpath("//div[text()='"+phnName+"']/ancestor::div[@class='yKfJKb row']/descendant::div[@class='Nx9bqj _4b5DiR']")).getText();
		
		System.out.println("The price of "+phnName+" is "+price);
		
		driver.close();

	}

}
