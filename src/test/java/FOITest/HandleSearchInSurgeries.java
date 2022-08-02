package FOITest;

import org.testng.annotations.Test;

import pageObject.SwitchTenant;

public class HandleSearchInSurgeries extends base
{
	@Test
	public void SearchInSurgery() throws Exception
	{
	driver=initialize();
	driver.get(p.getProperty("url2"));
	driver.manage().window().maximize();
	//Thread.sleep(5000);
	SwitchTenant t=new SwitchTenant(driver);
	t.ChangeTenant("Default");
	ValidLogin vc = new ValidLogin();
	vc.testLogin(driver,5);
	}
	
	


}
