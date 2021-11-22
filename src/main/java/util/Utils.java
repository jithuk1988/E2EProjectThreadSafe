package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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
	public WebDriver driver;
	  /**
	   * This method will wait for certain time for the visibility of the element and then enter the text.
	   * @param element The WebElement 
	   * @param text The text to enter
	   */
	public void sendKeys(WebElement element, String text)
	{
		WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	}
	/**
	   * This method will wait for certain time for the element to be clickable and then try to click.
	   * @param element The WebElement 
	   */
	public void click(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public String readExcel(String filePath,String sheetName, int rowNumber, int columnNumber) throws IOException
	{
		FileInputStream file = new FileInputStream(new File(filePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        Cell column = row.getCell(columnNumber);
        return column.getStringCellValue();
	}
}
