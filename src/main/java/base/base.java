package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\Study\\EclipseWorkspace\\E2EProject\\src\\main\\java\\config\\data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D://drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "D://drivers//msedgedriver.exe");
			driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
public String getScreenshotPath(String testcaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\Screenshots\\"+testcaseName+".png";
	FileUtils.copyFile(source, new File(destinationFile));
	return destinationFile;
}
}
