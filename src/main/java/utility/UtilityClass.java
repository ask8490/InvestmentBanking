package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import base.BaseClass;

public class UtilityClass extends BaseClass {

	public static String readCredentialFile(String key) throws IOException {
		Properties propObj = new Properties(); 
		FileInputStream credentialFIle = new FileInputStream(System.getProperty("user.dir")+"\\credentials.properties");
		propObj.load(credentialFIle);
		String value = propObj.getProperty(key);
		return value;
	}
	
	public static String readExcelFile(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestDataFiles\\TestData.xlsx");
		String StockSymbol = WorkbookFactory.create(file).getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return StockSymbol;
	}
}
