package FOITest;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.SwitchTenant;

public class HandleSurgeries extends base
{
	@Test
	public void addNewSuregery() throws Exception
	{
	driver=initialize();
	driver.get(p.getProperty("url2"));
	driver.manage().window().maximize();
	//Thread.sleep(5000);
	SwitchTenant t=new SwitchTenant(driver);
	t.ChangeTenant("Default");
	ValidLogin vc = new ValidLogin();
	vc.testLogin(driver,4);
	}

}
