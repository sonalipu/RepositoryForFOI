package FOITest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import CommonFunctions.ReadExcel;
import jxl.Cell;
import jxl.read.biff.BiffException;
import pageObject.ClickRole;
import pageObject.LoginPage;
import FOITest.base;
import java.io.File;

public class ValidateLogin extends ReadExcel{
	@Test
	public void testLogin() throws BiffException, IOException, InterruptedException
	{
		ReadExcel obj_to_read = new ReadExcel();
		obj_to_read.ReadExcelFile("C:\\Users\\SonaliPujari\\CommonFiles\\LoginDetails.xls",0);
		String user1 = "";
		String value = null;
		System.out.println("in read excel" + obj_to_read.excel_row);
		for(int i=1;i<obj_to_read.excel_row;i++)  //row
		{
			user1 = "";
			for(int j=0;j<obj_to_read.excel_col;j++) //col
			{
				
				Cell c= obj_to_read.excel_Sheet.getCell(j,i);	
				value=c.getContents();
				user1=user1+" "+value;
				
			}
		
			System.out.println(user1.trim());
			String[] NameArray = user1.split(" ");
			String uname=NameArray[1];
			String password=NameArray[2];
			System.out.println(NameArray[1]);
			System.out.println(NameArray[2]);
			base obj = new base();
			WebDriver driver = obj.initialize();
			//driver=initialize();
			System.out.println("in read excel");
			obj.driver.get(obj.p.getProperty("url"));
			obj.driver.manage().window().maximize();
			
			LoginPage lp=new LoginPage(driver); 
			Thread.sleep(3000);
			lp.getemail().sendKeys(uname);
			Thread.sleep(3000);
			lp.getpassword().sendKeys(password);
			Thread.sleep(3000);
			lp.Login().click();
			
			Thread.sleep(3000);
			try
			{
				//If credentials are invalid then find the invalid credential message and click ok
				driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div/div/div[6]/button[1]")).click();
				driver.close();
			}
			catch(Exception e)
			  {
				//If credentials are valid then follow the valid credential flow
				System.out.println("ok.........");
			/*	ClickRole rl = new ClickRole();
				rl.ClickAdministration(obj.driver);
				rl.ClickRoles(obj.driver);
				rl.AddNewRoles(obj.driver,"netestrole");
				Thread.sleep(3000);
				//rl.EditRole(driver, "rolefortest");
				rl.DeleteRoles(obj.driver, "netestrole");*/
			  }
	
		}
	}
}
