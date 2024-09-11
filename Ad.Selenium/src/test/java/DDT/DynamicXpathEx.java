package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpathEx {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://olympics.com/en/paris-2024");
		String gold = driver.findElement(By.xpath("//span[text()='USA']/../..//span[@data-cy='number-of-golds']")).getText();
		
		System.out.println("number of golds: "+gold);
		
		String silver = driver.findElement(By.xpath("//span[text()='JPN']/../..//span[@class=\"sc-bdnyFh bjnoKy MedalsTallyElement-styles__MedalCounter-sc-d9279d18-0 hlLVoN text--number-xs\"]")).getText();
		
		System.out.println("number of silver: "+silver);
	
		driver.close();
	}
}
