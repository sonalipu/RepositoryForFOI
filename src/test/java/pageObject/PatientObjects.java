package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientObjects 
{
	public WebDriver driver;
	
	By Patients= By.xpath("//span[text()='Patients']");
	
	By search=By.xpath("//input[@id='searchName']");
	
	public WebElement clickonPatients(WebDriver driver)
	{
		return driver.findElement(Patients);
	}

	public WebElement clickonSearch(WebDriver driver)
	{
		return driver.findElement(search);
	}

	
}
