package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindBy(css = "[name='user_password']")
	private WebElement PasswordTextField;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement LoginButton;

//	Getter methods
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	public void LoginToApp(String UserName, String Password) {
		UserTextField.sendKeys(UserName);
		PasswordTextField.sendKeys(Password);
		LoginButton.click();
	}
	
}
