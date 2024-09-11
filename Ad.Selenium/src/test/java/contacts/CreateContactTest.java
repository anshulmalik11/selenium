package contacts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ObjectRepository.ContactPage;
import ObjectRepository.CreateCont;
import ObjectRepository.HomePage;
import genericUtilities.BaseClass;
import genericUtilities.Excel_Utility;
import genericUtilities.Java_Utilities;
import genericUtilities.WebDriver_Utility;

public class CreateContactTest extends BaseClass {
	@Test (groups = "smokeTest")
	public void createContactTest() throws Throwable {
		Excel_Utility elib = new Excel_Utility();
		Java_Utilities jlib = new Java_Utilities();
		WebDriver_Utility wlib = new WebDriver_Utility();
		
		int ran = jlib.getRanNum();
		
		String first = elib.ExcelData("Sheet1", 4, 0)+ran;
		String last = elib.ExcelData("Sheet1", 5, 0)+ran;
		String mobile = elib.ExcelData("Sheet1", 1, 0)+ran;
		String email = elib.ExcelData("Sheet1", 2, 0);
		String OrgName = elib.ExcelData("Sheet1", 0, 0)+ran;
		
		HomePage home = new HomePage(driver);
		ContactPage contact = new ContactPage(driver);
		CreateCont create = new CreateCont(driver);
		
		home.getContacts().click();
		contact.getCreateButton().click();
		
		create.fillContact("Prof.", first, last, mobile, email, OrgName);
		
		driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/img")).click();
		wlib.switchWindow(driver, "Accounts&action");
		driver.findElement(By.id("1")).click();
		wlib.switchWindow(driver, "Contacts&action");
		
		driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[10]/td[4]/img")).click();
        
		wlib.switchToSecondWindow(driver);
		
		driver.findElement(By.id("1")).click();
		
		wlib.switchWindow(driver, "Contacts&action");
		
		create.getSaveButton().click();
		System.out.println("new contact created");
	}
}
