package testNgPractice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateOrganization{
	
	@Test(dataProvider = "readData")
	public void organisationModuleTest(String orgName, String phnNum, String mailId) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(mailId);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}
	@DataProvider
	public Object [][] readData(){
		Object[][]objArr = new Object[2][3];
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		objArr[0][0] = "AAA"+ranNum;
		objArr[0][1] = "837213";
		objArr[0][2] = "and@akd.com";
		
		objArr[1][0] = "BBB"+ranNum;
		objArr[1][1] = "89374213";
		objArr[1][2] = "ash@akd.com";
		return objArr;
	}
}
