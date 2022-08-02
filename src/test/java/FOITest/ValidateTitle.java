package FOITest;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LoginPage;

public class ValidateTitle extends base
{
	@Test
	public void validatetitle() throws Exception
	{
		driver=initialize();
		
		driver.get(p.getProperty("url"));

		LoginPage p=new LoginPage(driver);
		String title=p.getTitle();
		System.out.println();
		Assert.assertEquals(title, "Incisions");
	}

}
