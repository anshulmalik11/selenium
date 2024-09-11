package organization;

	import org.openqa.selenium.By;
	import org.testng.annotations.Test;

	import ObjectRepository.CreateOrganisationPage;
import ObjectRepository.CreatePro;
import ObjectRepository.HomePage;
	import ObjectRepository.OrganisationPage;
import ObjectRepository.ProductPage;
import genericUtilities.BaseClass;
	import genericUtilities.Excel_Utility;
	import genericUtilities.Java_Utilities;

	public class RegressionTest extends BaseClass {
		@Test(groups = "smokeTest")
		public void createOrganisationTest() throws Throwable {

//			To avoid duplicates
			Java_Utilities jlib = new Java_Utilities();
			int ranNum = jlib.getRanNum();
			
//			read data from excel
			Excel_Utility elib = new Excel_Utility();
			String orgName = elib.ExcelData("Sheet1", 0, 0)+ranNum;
			String phnNum = elib.ExcelData("Sheet1", 1, 0)+ranNum;
			String email = elib.ExcelData("Sheet1", 2, 0);

			HomePage home = new HomePage(driver);
			home.getOrgLink().click();
//			click on organization link
			
//			click on lookup img
			OrganisationPage orgpage = new OrganisationPage(driver);
			orgpage.getCreateLink().click();
			
			CreateOrganisationPage create = new CreateOrganisationPage(driver);
//			create organization data
			create.enterOrgData(orgName);
			driver.findElement(By.id("phone")).sendKeys(phnNum);
			driver.findElement(By.id("email1")).sendKeys(email);
			
//			click on save button
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
//			logout from application
			Thread.sleep(3000);
			
			System.out.println("create organisation executed");
		}

		@Test(groups = "regressionTest")
		public void createProductTest() throws Throwable {
			
			Java_Utilities jlib = new Java_Utilities();
			int ranNum = jlib.getRanNum();
			
//			reading data from excel sheet
			Excel_Utility elib = new Excel_Utility();
			String name = elib.ExcelData("Sheet1", 0, 1)+ranNum;
			String num = elib.ExcelData("Sheet1", 1, 0);
					
//			login into Vtiger Application
			HomePage home = new HomePage(driver);
			ProductPage product = new ProductPage(driver);
			CreatePro create = new CreatePro(driver);
			
//			click on product
			home.getProducts().click();
			
			product.getCreateProduct().click();
			
			create.proFillandSave(name, num);
			System.out.println("create product executed");		
		}
	}
