package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabaddi {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		
		String wonMatch = driver.findElement(By.xpath("//p[text()='Puneri Paltan']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-won']")).getText();
		String lostMatch = driver.findElement(By.xpath("//p[text()='Puneri Paltan']/ancestor::div[@class='row-head']/descendant::div[@class='table-data matches-lost']")).getText();
		System.out.println("Matches won are: "+wonMatch);
		
		System.out.println("Matches lost are: "+lostMatch);
		driver.close();
	}
}