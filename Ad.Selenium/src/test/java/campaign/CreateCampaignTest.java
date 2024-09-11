package campaign;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ObjectRepository.CampaignPage;
import ObjectRepository.CreateCamp;
import ObjectRepository.HomePage;
import genericUtilities.BaseClass;
import genericUtilities.Excel_Utility;
import genericUtilities.Java_Utilities;
import genericUtilities.WebDriver_Utility;

public class CreateCampaignTest extends BaseClass {
	
	@Test(groups = "regressionTest")
	public void createCampaignTest() throws Throwable {
		
//		WebDriver driver = null;
		
		Excel_Utility elib = new Excel_Utility();
		Java_Utilities jlib = new Java_Utilities();
		int ranNum = jlib.getRanNum();
		
		String name = elib.ExcelData("Sheet1",0,0)+ranNum;
		WebDriver_Utility wlib = new WebDriver_Utility();		
		
		HomePage home = new HomePage(driver);
		CreateCamp create = new CreateCamp(driver);
		CampaignPage page = new CampaignPage(driver);

		
		WebElement ele = home.getMore();

		wlib.moveToElementAction(driver, ele);
		
		home.getCampaign().click();
		
		page.getCreateButton().click();
		
		create.fillAndSave(name, "nothing much just chill", "no one with us");
				
//		logout from application
		
		System.out.println("create campaign executed");
		
	}
}
