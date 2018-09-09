package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long Page_Load_Wait=20;
	public static long Implicitly_Wait=30;
public 	XSSFWorkbook workbook ;
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public Object[][] getTestData(String sheetName){
	FileInputStream file=null;
		try {
			file=new FileInputStream("/home/bhavya/workspace/FreeCRMTest/src/main/java/com/crm/qa/testdata/ContactTestdata.ods");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++){
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		
		return data;
	}

}
