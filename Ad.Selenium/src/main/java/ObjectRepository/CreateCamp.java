package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCamp {
	public CreateCamp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "campaignname")
	private WebElement nametext;
	
	@FindBy(xpath = "//textarea[@class=\"detailedViewTextBox\"]")
	private WebElement description;
	
	@FindBy(id = "targetaudience")
	private WebElement targetaudience;
	
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@value=\"Delete\"]")
	private WebElement deleteButton;
	
	public void selectCamp(WebDriver driver, String campName) {
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+campName+"']"
				+ "/../preceding-sibling::td/input[@type='checkbox']")).click();
	}
	
	
	public WebElement getDeleteButton() {
		return deleteButton;
	}


	public WebElement getNametext() {
		return nametext;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getTargetaudience() {
		return targetaudience;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void fillAndSave(String name, String des, String text) {
		nametext.sendKeys(name);
		description.sendKeys(des);
		targetaudience.sendKeys(text);
		saveButton.click();
	}
	
	public void deleteCamp(WebDriver driver, String campName) {
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+campName+"']"
				+ "/../preceding-sibling::td/input[@type='checkbox']")).click();
		deleteButton.click();
		driver.switchTo().alert().accept();
	}			
}
