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

public class CreateAndDeleteTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createAndDeleteTest() throws Throwable {
		
		Excel_Utility elib = new Excel_Utility();
		Java_Utilities jlib = new Java_Utilities();
		WebDriver_Utility wlib = new WebDriver_Utility();
		HomePage home = new HomePage(driver);
		
		int num = jlib.getRanNum();
		String campName = elib.ExcelData("Sheet1",0,0)+num;

		WebElement ele = home.getMore();
		
		wlib.moveToElementAction(driver, ele);
		
		home.getCampaign().click();
		
		CampaignPage campaign = new CampaignPage(driver);
		campaign.getCreateButton().click();
		
		CreateCamp create = new CreateCamp(driver);
		create.fillAndSave(campName, "just a description", "no One");
		
		wlib.moveToElementAction(driver, ele);
		home.getCampaign().click();
		
		create.deleteCamp(driver, campName);
		
		System.out.println("campaign created and deleted");
	}
}
