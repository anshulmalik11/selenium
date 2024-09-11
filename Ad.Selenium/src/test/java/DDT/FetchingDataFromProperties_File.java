package DDT;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDataFromProperties_File {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.saucedemo.com/v1/");
//		driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys("standard_user");
//		driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		driver.close();
//		System.out.println("Everything is executed");
		
		//Step1: get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\data2.properties");
		
		//Step2: create an object to property class to load all the keys
		Properties pro = new Properties();
		pro.load(fis);
		
		//Step3: read the value using getProperty()
		
		String url = pro.getProperty("URL");
		String username = pro.getProperty("USERNAME");
		String password = pro.getProperty("PASSWORD");
		
		driver.get(url);
		driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();
		
		System.out.println("Executed");
		
		
	}
}
