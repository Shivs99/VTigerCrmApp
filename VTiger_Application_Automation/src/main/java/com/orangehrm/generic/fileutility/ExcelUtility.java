package com.orangehrm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExecl(String sheetName, int rownum, int cellnum) throws Exception, IOException {
		FileInputStream fis = new FileInputStream("./TestScriptData/organizationdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter formate=new DataFormatter();
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		book.close();
		return formate.formatCellValue(cell);
	}

	public int getrowCount(String sheetName) throws Exception, Throwable {
		FileInputStream fis = new FileInputStream("./TestScriptData/EmployeeData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		book.close();
		return sheet.getLastRowNum();

	}

	public void setDataIntoExcel(String sheetname, int rownum, int cellnum, String data) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./TestScriptData/EmployeeData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(data);

		FileOutputStream fos = new FileOutputStream("./TestScriptData/EmployeeData.xlsx");
		book.write(fos);
		book.close();

	}
}
