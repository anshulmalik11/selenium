package genericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
//	this method is used to read data from excel file
//	@param SheetName
//	@param rowNum
//	@param cellNum
//	@return
//	@throws Throwable
//	@author Anshul
	
	
	public String ExcelData(String SheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fes = new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		
		String value = cell.getStringCellValue();
		return value;
	}
	public String getExcelDataUsingFormatter(String SheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
	}
	

	public Object ExcelDataOfOrg() throws Throwable {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\OrgData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		int rowNum = sheet.getLastRowNum()+1;
		int cellNum = sheet.getRow(0).getLastCellNum();
		
		Object [][] objArr = new Object [rowNum][cellNum];
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < cellNum; j++) {
				objArr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return objArr;
	}
	 
}
