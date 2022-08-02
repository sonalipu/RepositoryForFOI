package FOITest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
public class base
{
	public WebDriver driver;
	public Properties p;
	public WebDriver initialize() throws IOException
	{
		p=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\SonaliPujari\\Workspace_Selenium\\FOITest\\data.properties");
		p.load(fis);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit)
		
		String BrowserName=p.getProperty("browser");
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\SonaliPujari\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.equals("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		else if (BrowserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
	}
	
	

}
