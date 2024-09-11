package product;

import org.testng.annotations.Test;

import ObjectRepository.CreatePro;
import ObjectRepository.DeletePrdName;
import ObjectRepository.HomePage;
import ObjectRepository.ProductPage;
import genericUtilities.BaseClass;
import genericUtilities.Excel_Utility;
import genericUtilities.Java_Utilities;

public class CreateAndDeleteTest extends BaseClass {
	@Test(groups = "regressionTest")
	public void createAndDeleteTest() throws Throwable {
		
		Excel_Utility elib = new Excel_Utility();
		
		Java_Utilities jlib = new Java_Utilities();
		int ranNum = jlib.getRanNum();
		
		String proName = elib.ExcelData("Sheet1", 3, 0)+ranNum;
		
		HomePage home = new HomePage(driver);
		ProductPage product = new ProductPage(driver);
		CreatePro create = new CreatePro(driver);
		
		home.getProducts().click();
		product.getCreateProduct().click();
		
		create.proFillandSave(proName, "12354");
		
		home.getProducts().click();
		
		DeletePrdName deleteprd = new DeletePrdName(driver);
		deleteprd.selectPrdData(driver, proName);
		
		deleteprd.clickOnDeleteBotton();
		driver.switchTo().alert().accept();
		
		deleteprd.validateProductDeleted(driver, proName);
	}
}
