package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertMultipleDataTo_ExcelFile {
	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\AmazonLinks.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet1");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		List <WebElement>links = driver.findElements(By.xpath("//a"));
		
		for (int i = 0; i < links.size(); i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(links.get(i).getAttribute("href"));
		}
		FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\AmazonLinks.xlsx");
		book.write(fos);
		book.close();
		driver.close();
		
	}
}
