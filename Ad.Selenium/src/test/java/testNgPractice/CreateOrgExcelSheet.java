package testNgPractice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.Excel_Utility;

public class CreateOrgExcelSheet {
	@Test(dataProvider = "readData")
	public void orgModuleTest(String orgName, String phnNum, String mailId) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+ranNum);
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(mailId);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	@DataProvider
	public Object readData() throws Throwable{
		Excel_Utility elib = new Excel_Utility();
		return elib.ExcelDataOfOrg();
	
	}

}
