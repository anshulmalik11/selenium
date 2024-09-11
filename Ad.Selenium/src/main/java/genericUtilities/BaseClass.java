package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass{
	
	public static WebDriver sdriver;
	public WebDriver driver;
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void BS() {
		System.out.println("DataBase Connection Open");
	}
	
	@BeforeTest(groups={"smokeTest","regressionTest"})
	public void BT() {
		System.out.println("Parallel execution");
	}
	
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void BC() throws Throwable {
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getPropertiesData("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		System.out.println("Browser Launched");
		sdriver = driver;
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void BM() throws Throwable {
		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitPageLoad(driver);
		
		String URL = flib.getPropertiesData("url");
		String USERNAME = flib.getPropertiesData("username");
		String PASSWORD = flib.getPropertiesData("password");
		
		driver.get(URL);
		
		LoginPage login = new LoginPage(driver);
		login.LoginToApp(USERNAME, PASSWORD);
		System.out.println("login into application");
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void AM() {
		HomePage home = new HomePage(driver);
		home.getSignOut();
		System.out.println("logout from the application");
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void AC() {
		driver.quit();
		System.out.println("closing the browser");
	}
	
	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void AT() {
		System.out.println("parallel execution is done");
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void AS() {
		System.out.println("DataBase Connection close");
	}
}