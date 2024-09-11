package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePro {
	public CreatePro(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "productname")
	private WebElement proName;
	
	@FindBy(id = "productcode")
	private WebElement productNum;
	
	@FindBy(css = "[title='Save [Alt+S]']")
	private WebElement saveButton;


public void proFillandSave(String name, String num) {
	proName.sendKeys(name);
	productNum.sendKeys(num);
	saveButton.click();
}
}
