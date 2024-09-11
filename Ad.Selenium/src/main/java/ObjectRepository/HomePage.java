package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getMore() {
		return more;
	}

	public WebElement getCampaign() {
		return campaign;
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}
	
	
	@FindBy(linkText = "More")
	private WebElement more;
	
	@FindBy(name = "Campaigns")
	private WebElement campaign;
	
	@FindBy(linkText = "Products")
	private WebElement products; 
	
	// logout
	
	public WebElement getProducts() {
		return products;
	}

	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement Move;
	
	public WebElement getMove() {
		return Move;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement Contacts;
	
	
	public WebElement getContacts() {
		return Contacts;
	}

	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	public void logout() {
		Move.click();
		signOut.click();
	}

	
}
