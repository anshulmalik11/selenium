package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {
	public CreateOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBys({@FindBy(name="accountname"),@FindBy(xpath = "//input[@name='accountname']")})
	private WebElement name;
	
	public void enterOrgData(String OrgName) {
		name.sendKeys(OrgName);
	}

	public WebElement getName() {
		return name;
	}
}
