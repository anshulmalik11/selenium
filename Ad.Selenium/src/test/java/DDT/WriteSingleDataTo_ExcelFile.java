package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteSingleDataTo_ExcelFile {
	public static void main(String[] args) throws Throwable {
		
//		Step1: give connection between the physical file and test script
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		
//		Step2: keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
//		Step3: taking control of the excel sheet
		Sheet sheet = book.getSheet("Sheet1");
		
//		Step4: taking control of the row
		Row row = sheet.getRow(5);
		if(row == null) {
			row =  sheet.createRow(5);
		}
		
//		Step5: taking control of the cell
		Cell cell = row.getCell(0);
		if(cell == null) {
			cell = row.createCell(0);
		}
		

//		Step6: inserting data in cell
		cell.setCellValue("Last");
		
//		Step7: keep the cell in write mode
		FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\TestData.xlsx");
		
		book.write(fos);
		book.close();
	}
}
