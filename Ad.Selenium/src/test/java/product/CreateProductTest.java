package product;

import org.testng.annotations.Test;

import ObjectRepository.CreatePro;
import ObjectRepository.HomePage;
import ObjectRepository.ProductPage;
import genericUtilities.BaseClass;
import genericUtilities.Excel_Utility;
import genericUtilities.Java_Utilities;

public class CreateProductTest extends BaseClass {
	@Test(groups = "regressionTest")
	public void createProductTest() throws Throwable {
		
		Java_Utilities jlib = new Java_Utilities();
		int ranNum = jlib.getRanNum();
		
//		reading data from excel sheet
		Excel_Utility elib = new Excel_Utility();
		String name = elib.ExcelData("Sheet1", 0, 1)+ranNum;
		String num = elib.ExcelData("Sheet1", 1, 0);
				
//		login into Vtiger Application
		HomePage home = new HomePage(driver);
		ProductPage product = new ProductPage(driver);
		CreatePro create = new CreatePro(driver);
		
//		click on product
		home.getProducts().click();
		
		product.getCreateProduct().click();
		
		create.proFillandSave(name, num);
		System.out.println("create product executed");		
	}
}
