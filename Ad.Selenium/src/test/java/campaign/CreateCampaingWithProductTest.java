package campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ObjectRepository.CampaignPage;
import ObjectRepository.CreateCamp;
import ObjectRepository.CreatePro;
import ObjectRepository.HomePage;
import ObjectRepository.ProductPage;
import genericUtilities.BaseClass;
import genericUtilities.Excel_Utility;
import genericUtilities.Java_Utilities;
import genericUtilities.WebDriver_Utility;

public class CreateCampaingWithProductTest extends BaseClass{
	@Test(groups = "regressionTest")
	public void createCampaingWithProductTest() throws Throwable {
		
		Java_Utilities jlib = new Java_Utilities();
		int ranNum = jlib.getRanNum();
	
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		String campName = elib.ExcelData("Sheet1", 0, 0)+ranNum;
		String proName = elib.ExcelData("Sheet1", 3, 0)+ranNum;
		String proNum = elib.ExcelData("Sheet1", 1, 0)+ranNum;
		
		HomePage home = new HomePage(driver);
		CampaignPage campaign = new CampaignPage(driver);
		CreateCamp createCampaign = new CreateCamp(driver);
		CreatePro createProduct = new CreatePro(driver);
		ProductPage product = new ProductPage(driver);
		
//		click on product
		home.getProducts().click();
		product.getCreateProduct().click();
		createProduct.proFillandSave(proName, proNum);
		
		//-------------------campaign----------------
		
		WebElement ele = home.getMore();
		
		wlib.moveToElementAction(driver, ele);
		
		home.getCampaign().click();
		
		campaign.getCreateButton().click();
		
		CreateCamp create = new CreateCamp(driver);
		
		create.getNametext().sendKeys(campName);
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		wlib.switchWindow(driver, "Products&action");
		
		driver.findElement(By.id("search_txt")).sendKeys(proName);
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.linkText(proName)).click();
		wlib.switchWindow(driver, "Campaigns&action");
		
		createCampaign.getSaveButton().click();

		System.out.println("create campaign with the product added executed");	
	}
}