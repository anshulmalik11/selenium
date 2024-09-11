package DDT;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingSingleDataFrom_Excel {
	public static void main(String[] args) throws Throwable {
		
//		Step1: Path Representation
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		
//		Step2: keeping the excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
//		Step3: get the control of Sheet1
		Sheet sheet = book.getSheet("Sheet1");
		
//		Step4: get the control of the Row
		Row row = sheet.getRow(0);
		
//		Step5: get the control of cell
		Cell cell = row.getCell(0);
		
//		Step6: Reading the cell value
		String data = cell.getStringCellValue();
		
//		Step7: Printing statement
		System.out.println(data);
	}
}
