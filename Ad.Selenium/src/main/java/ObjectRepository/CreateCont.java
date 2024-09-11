package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCont {
	public CreateCont(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "salutationtype")
	private WebElement dropDown;
	
	@FindBy(name = "firstname")
	private WebElement firstName;
	
	@FindBy(name = "lastname")
	private WebElement lastName;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "department")
	private WebElement department;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	public WebElement getSaveButton() {
		return saveButton;
	}


	public void fillContact(String salu, String first, String last, String num, String mail, String dept) {
		Select obj = new Select(dropDown);
		obj.selectByValue(salu);
		firstName.sendKeys(first);
		lastName.sendKeys(last);
		phone.sendKeys(num);
		email.sendKeys(mail);
		department.sendKeys(dept);
	}
}
