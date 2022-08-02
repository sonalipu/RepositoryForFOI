package FOITest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import jxl.read.biff.BiffException;
import pageObject.ClickRole;

public class ValidateRoles extends ClickRole{
	//public WebDriver driver;
	public void validateRole(WebDriver driver) throws InterruptedException, BiffException, IOException
	{
		this.driver=driver;
		ClickRole rl = new ClickRole();
		rl.ClickAdministration(driver);
		rl.ClickRoles(driver);
		rl.AddNewRoles(driver,"roleabcd");
		Thread.sleep(3000);
		//rl.EditRole(driver, "rolefortest");
		rl.DeleteRoles(driver, "roleabcd");	
	}
}
