package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	public WebDriver driver;
	
	
	/*driver.findElement(By.id("userNameEmailAddress")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("123qwe");
	driver.findElement(By.id("loginBtn")).click();*/
	
	
	//By Email=By.xpath("userNameEmailAddress");
	By Email=By.id("userNameEmailAddress");
	
	By Password=By.id("password");

	By loginbtn=By.id("loginBtn");


	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getemail()
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		return driver.findElement(Email);
	}
	
	public WebElement getpassword()
	{
		return driver.findElement(Password);
	}
	
	public WebElement Login()
	{
		return driver.findElement(loginbtn);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
}

