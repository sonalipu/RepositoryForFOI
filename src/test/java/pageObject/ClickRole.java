package pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CommonFunctions.ReadExcel;
import jxl.Cell;
import jxl.read.biff.BiffException;

public class ClickRole {

	
	public WebDriver driver;
	
	public void ClickAdministration (WebDriver driver)
	{
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]//descendant::span[text()='Administration']")).click();
	}
	
	public void ClickRoles (WebDriver driver)
	{
		this.driver=driver;
		driver.findElement(By.xpath("//*[@id=\"menu_Roles\"]/span[text()='Roles']")).click();
		//driver.findElement(By.xpath("//*[@id=\\\"#kt_aside_menu\\\"]//descendant::span[text()='Roles']")).click();
	}
	
	public void AddNewRoles (WebDriver driver,String srcval) throws BiffException, IOException, InterruptedException
	{
		this.driver=driver;
		System.out.println("click on new role");
		
		Thread.sleep(300);
		ReadExcel rf = new ReadExcel();//Create an instance of readexcel to read the input file. Pass the name and sheet no.
		rf.ReadExcelFile(srcval, 7);
		String value = null;
		int i = 1;
		for (i=1;i<rf.excel_row;i++)  //row
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::ng-component//descendant::div//descendant::div[contains(@class,'d-flex justify-content-')]//descendant::button[contains(@class,'btn btn-primary float-end')]")).click();
			Thread.sleep(5000);
			for(int j=0;j<rf.excel_col;j++) //col
			{
				
				Cell c= rf.excel_Sheet.getCell(j,i);	
				value=c.getContents();
				System.out.println("Value = " + value);
			}
			
			System.out.println("Set the value for new role");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"RoleDisplayName\"]")).sendKeys(value);
		System.out.println("click on add button");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/p-sidebar/div/div[2]/form/div/div[3]/button[2][@type='submit']")).click();
		Thread.sleep(1000);
		System.out.println("check if role is already added then close the pop up message");
		try
		{
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[6]/button[1]")).click();
		System.out.println("before close new role");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/p-sidebar/div/div[2]/form/div/div[3]/button[1]")).click();
		System.out.println("after close new role");
		}
		catch (Exception e)
		{
			System.out.println("diffrent role hence add it");

		}
		driver.navigate().refresh();
		}
		 
		/*Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::ng-component//descendant::div//descendant::div[contains(@class,'d-flex justify-content-')]//descendant::button[contains(@class,'btn btn-primary float-end')]")).click();
		//*[@id="kt_wrapper"]//descendant::ng-component//descendant::div//descendant::div[contains(@class,'d-flex justify-content-')]//descendant::button[contains(@class,'btn btn-primary float-end')]
			//	driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/div[1]/div/div[2]/div[2]/button[3]")).click();
		//Enter the new role data in role textbox
		System.out.println("Set the value for new role");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"RoleDisplayName\"]")).sendKeys(userrole);
		System.out.println("click on add button");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/p-sidebar/div/div[2]/form/div/div[3]/button[2][@type='submit']")).click();
		Thread.sleep(10000);
		System.out.println("check if role is already added then close the pop up message");
		try
		{
		driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[6]/button[1]")).click();
		System.out.println("before close new role");
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/p-sidebar/div/div[2]/form/div/div[3]/button[1]")).click();
		System.out.println("after close new role");
		}
		catch (Exception e)
		{
			System.out.println("diffrent role hence add it");

		}
		driver.navigate().refresh();*/
	} 
	
	public void SelectRole(WebDriver driver,String userrole) throws InterruptedException
	{
		
	}
	
	public void EditRole (WebDriver driver,String userrole) throws InterruptedException
	{
		
		/* Create the list of rows and traverse through it till the desired role is reached. 
		 Then click the desired role.
		 */
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[starts-with(@id,'pr_id_')]//descendant::p-tablecheckbox"));
		List<WebElement> roleRows = driver.findElements(By.xpath("//*[starts-with(@id,'pr_id_')]/tbody/tr"));
		Thread.sleep(5000);
	    System.out.println("Number of Check boxes : "+ roleRows.size());
		System.out.println("IN edit role");

		int i = 0;

		   for(i=0;i<roleRows.size(); i++)
	    {
			   System.out.println("IN add check box "+ roleRows.get(i).getText());
	
			   if (roleRows.get(i).getText().contains(userrole))
			   {

				   System.out.println("condition satisfied" + checkBoxes.get(i).getAttribute("class"));
				   Thread.sleep(10000);
				   checkBoxes.get(i).click();
				   break;
			   }

	    }
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,0)", "");
		   driver.findElement(By.xpath("//*[@id='deleteRecord' and @type='button']")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//*[@id=\"kt_body\"]//descendant::div[contains(@class,'swal2-actions')]/button[text()='Yes']")).click();
		   Thread.sleep(200);
		   
		   //*[@id="kt_body"]//descendant::div[contains(@class,'swal2-actions')]/button[text()='Yes']
		  /*
		   //Click on edit button to edit the selected role
		   driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/div[1]/div/div[2]/div[2]/button[2]")).click();
		  boolean ret = driver.findElement(By.xpath("//*[@id=\"EditRole_IsDefault\"]")).isSelected();
		  System.out.println("bollean val" + ret);

		  if (ret == false)
		  {
			  Assert.assertEquals(ret, false);
			  driver.findElement(By.xpath("//*[@id=\"EditRole_IsDefault\"]")).click();
			  Thread.sleep(10000);
			  //click on add button to save the changess
			  driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/p-sidebar/div/div[2]/form/div/div[3]/button[2][@type='submit']")).click();
		  }
		  else 
		  { 
			  System.out.println("provider type already clicked then uncheck it and save the changes");
			  Assert.assertEquals(ret, true);
			  driver.findElement(By.xpath("//*[@id=\"EditRole_IsDefault\"]")).click();
			  Thread.sleep(10000);
			  //click on add button to save the changess
			  driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/p-sidebar/div/div[2]/form/div/div[3]/button[2][@type='submit']")).click();
	
		  }*/

	}
	
	    public void DeleteRoles (WebDriver driver,String userrole) throws InterruptedException
		{
			this.driver=driver;
			WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(30));
			
			System.out.println("IN delete");
			/* Create the list of rows and traverse through it till the desired role is reached. 
			 Then click the desired role.
			 */
			List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[starts-with(@id,'pr_id_')]/tbody/tr/td/p-tablecheckbox"));
			//List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[@id=\"pr_id_11-table\"]/tbody/tr/td/p-tablecheckbox"));
			//table[starts-with(@id,'pr_id_')]/tbody/tr
			List<WebElement> roleRows = driver.findElements(By.xpath("//table[starts-with(@id,'pr_id_')]/tbody/tr"));
			//List<WebElement> roleRows = driver.findElements(By.xpath("//*[@id=\"pr_id_11-table\"]/tbody/tr"));
			Thread.sleep(10000);
		    System.out.println("Number of Check boxes : "+ roleRows.size());
			System.out.println("IN delete role");

			int i = 0;

			   for(i=0;i<roleRows.size(); i++)
		    {
				   System.out.println("IN add check box "+ roleRows.get(i).getText());
		
				   if (roleRows.get(i).getText().contains(userrole))
				   {

					   System.out.println("condition satisfied" + checkBoxes.get(i).getAttribute("class"));
					   Thread.sleep(10000);
					   checkBoxes.get(i).click();
					   break;
				   }

		    }
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("window.scrollBy(0,-1000)");
			 //Delete the role in role 
			   Thread.sleep(1000); 
			  //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"kt_wrapper\\\"]/div[2]/ng-component/div/div/div[1]/div/div[2]/div[2]/button[1]")))
			   WebElement deltebtn = driver.findElement(By.xpath("//*[@id='deleteRecord' and @type='button']"));
			   //WebElement deltebtn = driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/div[1]/div/div[2]/div[2]/button[1]"));
			new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(deltebtn));
			Thread.sleep(1000);  
			deltebtn.click();
			
			System.out.println("IN delte 1");
			//Thread.sleep(10000);
			//*[@id="kt_body"]/div/div/div[6]/button[1] Click on yes button on popup box for to confirm delete
			
			WebElement yesBtn = driver.findElement(By.xpath("//*[@id=\"kt_body\"]//descendant::div[contains(@class,'swal2-actions')]/button[text()='Yes']"));
			//WebElement yesBtn = driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div/div/div[6]/button[1]"));// -- yes button xpath
			new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(deltebtn));
			Thread.sleep(1000);
			yesBtn.click();
			Thread.sleep(1000);
			driver.navigate().refresh();
	    } 
}
