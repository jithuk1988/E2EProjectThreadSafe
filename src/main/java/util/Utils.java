package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.base;

public class Utils extends base {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static long EXPLICIT_WAIT = 20;
	public static long POLLING_TIME = 250;
	public static String TEST_DATA_PATH = "D:\\Study\\EclipseWorkspace\\E2EProject\\src\\test\\java\\testData\\TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static WebDriver driver;
	  /**
	   * This method will wait for certain time for the visibility of the element and then enter the text.
	   * @param element The WebElement 
	   * @param text The text to enter
	   */
	public static void sendKeys(WebElement element, String text)
	{
		WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	}
	/**
	   * This method will wait for certain time for the element to be clickable and then try to click.
	   * @param element The WebElement 
	   */
	public static void click(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	/**
	   * This method will read the excel file based on the sheet, row number and column number.
	   * Row and column numbers starts from 0 
	   * @param sheetName The name of the Sheet in excel file.
	   * @param rowNumber To specify the row number.
	   * @param columnNumber To specify the column number. 
	   */
	public static String readExcelCells(String sheetName, int rowNumber, int columnNumber) throws IOException
	{
		FileInputStream file = new FileInputStream(new File(TEST_DATA_PATH));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        Cell column = row.getCell(columnNumber);
        return column.getStringCellValue();
	}
	
	/**
	   * This method will read the excel file and return the sheet data in a multidimensional object array.
	   * @param sheetName To specify the sheet name in the Excel file
	   */
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TEST_DATA_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		} catch(EncryptedDocumentException e)  {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

}
