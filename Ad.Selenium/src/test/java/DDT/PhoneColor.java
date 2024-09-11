package DDT;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoneColor {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.name("field-keywords")).sendKeys("iphone",Keys.ENTER);
		List<WebElement> colors = driver.findElements(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Starlight']/../../../..//div[@class='a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']//a"));
		
		for(WebElement cl:colors) {
			System.out.println(cl.getAttribute("aria-label"));
		}
		driver.close();
	}
}
