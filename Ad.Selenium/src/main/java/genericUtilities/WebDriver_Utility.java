package genericUtilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();		
	}
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	public void fullWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	public void waitPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchWindow(WebDriver driver, String title) {
		Set<String> allwin = driver.getWindowHandles();
		
		Iterator<String> it = allwin.iterator();
		while(it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String currentTitle = driver.getTitle();
			if(currentTitle.contains(title)) {
				break;
			}
		}
	}
	public void moveToElementAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();;
	}
	
	public void switchToSecondWindow(WebDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();

        // Optionally, switch to a specific window
        String mainWindowHandle = driver.getWindowHandle(); // Store the main window handle
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle); // Switch to the new window    
            }
        }
	}
}
