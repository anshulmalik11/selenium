package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt='Create Organization...']")
	private WebElement createLink;

	public WebElement getCreateLink() {
		return createLink;
	}
}
