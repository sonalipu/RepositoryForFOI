package pageObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonFunctions.ReadExcel;
import jxl.Cell;
import jxl.read.biff.BiffException;

public class ValidateUsers {
public WebDriver driver;
	
	public void ClickAdministration (WebDriver driver)
	{
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//*[@id="menu_Orders"]/span[3]
		//*[@id="#kt_aside_menu"]//descendant::span[text()='Administration']
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]//descendant::span[text()='Administration']")).click();
	}

	public void ClickUsers (WebDriver driver) throws InterruptedException
	{
		this.driver=driver;
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]//descendant::span[text()='Users']")).click();
	}
	
	//*[@id="kt_wrapper"]/div[2]/ng-component/div/div/div[1]/div/div[1]/div[1]/input
	public void SearchUsers (WebDriver driver,String srcval) throws InterruptedException, BiffException, IOException
	{
		this.driver=driver;		
		
		ReadExcel rf = new ReadExcel();
		rf.ReadExcelFile(srcval, 4);
		String value="";
		int i = 1;
		WebElement searchbtn;
		for (i=1;i<rf.excel_row;i++)  //row
		{

			for(int j=0;j<rf.excel_col;j++) //col
			{
				
				Cell c= rf.excel_Sheet.getCell(j,i);	
				value=c.getContents();
				System.out.println("Value = " + value);
		
				//Thread.sleep(1000);
				//*[@id="kt_wrapper"]/div[2]/ng-component/div/div/div[1]/div/div[1]/div[1]/input
				//driver.navigate().refresh();
				
				/*searchbtn = driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::input[@name='filterText']"));
				//Thread.sleep(1000);
				//WebElement searchbtn = driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/div[1]/div/div[1]/div[1]/input"));
				//searchbtn.clear();
				Thread.sleep(100);
				searchbtn.sendKeys(value);
				//Thread.sleep(1000);
				searchbtn.sendKeys(Keys.RETURN);
				Thread.sleep(10000);
				searchbtn.clear();*/
				EditSearchandUser(driver,value);
				//driver.navigate().refresh();
				//Thread.sleep(3000);
			}
			
		}	
			
				//*[@id="kt_wrapper"]/div[2]/ng-component/div/div/div[1]/div/div[1]/div[1]/input
	/*	WebElement searchbtn = driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::input[@name='filterText']"));
		//WebElement searchbtn = driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/div[1]/div/div[1]/div[1]/input"));
		searchbtn.sendKeys(value);
		searchbtn.sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		EditUser(driver,"Edit");
		*/
	}
	
	public void AddUser(WebDriver driver,String srcval) throws BiffException, IOException, InterruptedException
	{

		this.driver = driver;
		Thread.sleep(3000);
		ReadExcel rf = new ReadExcel();//Create an instance of readexcel to read the input file. Pass the name and sheet no.
		rf.ReadExcelFile(srcval, 2);
		String value;
		int i = 1;
		for (i=1;i<rf.excel_row;i++)  //row
		{
			//driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/div[1]/div/div[1]/div[2]/button[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::button[starts-with(@class,'btn btn-primary btn') and contains(@class,'ng-star-inserted')]")).click();
			Thread.sleep(1000);
			for(int j=0;j<rf.excel_col;j++) //col
			{
				
				Cell c= rf.excel_Sheet.getCell(j,i);	
				value=c.getContents();
				System.out.println("Value = " + value);
				switch(j)
				{
				case 0: driver.findElement(By.xpath("//*[@id='Name']")).sendKeys(value);
				break;
				
				case 1: driver.findElement(By.xpath("//*[@id='Surname']")).sendKeys(value);
				break;
				
				case 2: driver.findElement(By.xpath("//*[@id='EmailAddress']")).sendKeys(value);
				break;
				
				case 3: driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys(value);
				break;
				
				case 4: driver.findElement(By.xpath("//*[@id='PhoneNumber']")).sendKeys(value);
				break;
				
				case 5: driver.findElement(By.xpath("//*[@id='Ext']")).sendKeys(value);
				break;
				
				case 6: driver.findElement(By.xpath("//*[@id='PhoneAlt']")).sendKeys(value);
                break;
                
				case 7: driver.findElement(By.xpath("//*[@id='MobileNumber']")).sendKeys(value);
				break;
				
				case 8: driver.findElement(By.xpath("//*[@id='BeeperNumber']")).click();
				break;
				
				case 9: driver.findElement(By.xpath("//*[@id='FaxNumber']")).sendKeys(value);
				break;
				
				case 10: driver.findElement(By.xpath("//*[@id='AthenaID']")).sendKeys(value);
				break;

				case 11: //click on role radio button. 
							driver.findElement(By.xpath("//*[@id=\"roleInfoEle\"]")).click();
						    Thread.sleep(2000); //wait till the change of elements
						    //select the dropdown having list of roles
						    driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/createoreditusermodal/p-sidebar/div/div[2]/form/div/div[2]/tabset/div/tab[2]/div/p-multiselect/div/div[2]/div")).click();
						    //create a list of elements of checkboxes for roles
							List<WebElement> dropDwon = driver.findElements(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/createoreditusermodal/p-sidebar/div/div[2]/form/div/div[2]/tabset/div/tab[2]/div/p-multiselect/div/div[4]/div[2]/ul//span[starts-with(@class,'ng-star-inserted')]"));
							Thread.sleep(200);
							
							/*driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/createoreditusermodal/p-sidebar/div/div[2]/form/div/div[2]/tabset/div/tab[2]/div/p-multiselect/div/div[4]/div[1]/div[2]/input")).sendKeys(value);
							driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/createoreditusermodal/p-sidebar/div/div[2]/form/div/div[2]/tabset/div/tab[2]/div/p-multiselect/div/div[4]/div[1]/div[1]/div[2]")).click();
									*/
							//traverse the for loop to locate and select the check box		
							System.out.println("IN dropdwn size "+ dropDwon.size());   
							for(int k=0;k<dropDwon.size(); k++)
							    {
									   System.out.println("IN dropdwn "+ k+ dropDwon.get(k).getText());
							
									   if (dropDwon.get(k).getText().contains(value))
									   {
			
										   System.out.println("condition satisfied  " + dropDwon.get(k).getText());
										   Thread.sleep(1000);
										   
										   dropDwon.get(k).click();
										   break;
									   }
			
							    }
		
						Thread.sleep(1000);
						break;
				case 12:
					driver.findElement(By.xpath("//*[@id=\"providerDetailsInfoEle\"]")).click();
					Thread.sleep(2000);
					//split the values stored in excel column to get indivisual value of provider detail fields
					String valarray[] = value.split("-");
					System.out.println("split array "+ valarray[0]);
					System.out.println("split array "+ valarray[1]);
					System.out.println("split array "+ valarray[2]);
					System.out.println("split array "+ valarray[3]);
					System.out.println("split array "+ valarray[4]);
					System.out.println("split array "+ valarray[5]);
					//*[@id="kt_wrapper"]//descendant::span[starts-with(@class,'p-multiselect-trigger-icon') and contains(@class,'pi-chevron-down')][2]
					driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::span[starts-with(@class,'p-multiselect-trigger-icon') and contains(@class,'pi-chevron-down')][2]")).click();
					//*[@id="kt_wrapper"]/div[2]/ng-component/div/createoreditusermodal/p-sidebar/div/div[2]/form/div/div[2]/tabset/div/tab[3]/div[1]/div[2]/p-dropdown/div/div[2]/span
					List<WebElement> dropDwonservice = driver.findElements(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/createoreditusermodal/p-sidebar/div/div[2]/form/div/div[2]/tabset/div/tab[3]/div[1]/div[1]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem/li"));
					
					Thread.sleep(200);
					
					//traverse the for loop to locate and select the check box		
					System.out.println("IN dropdwn size "+ dropDwonservice.size());   
					for(int m=0;m<dropDwonservice.size(); m++)
					    {
							   System.out.println("IN dropdwn "+ m+ dropDwonservice.get(m).getText());
					
							   if (dropDwonservice.get(m).getText().contains(valarray[0]))
							   {
	
								   System.out.println("condition satisfied  " + dropDwonservice.get(m).getText());
								   Thread.sleep(1000);
								   
								   dropDwonservice.get(m).click();
								   break;
							   }
	
					    }

				Thread.sleep(1000);
					
					 driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::createoreditusermodal//descendant::tabset//descendant::p-dropdown//descendant::span[contains(@class,'p-dropdown-trigger')]")).click();
					 Thread.sleep(500);
						List<WebElement> dropDwonProvType = driver.findElements(By.xpath("//*[starts-with(@id,'pr_id_')]/p-dropdownitem/li"));
						
						Thread.sleep(200);
						
						//traverse the for loop to locate and select the check box		
						System.out.println("IN dropdwn size "+ dropDwonProvType.size());   
						for(int p=0;p<dropDwonProvType.size(); p++)
						    {
								   System.out.println("IN dropdwn "+ p+ dropDwonProvType.get(p).getText());
						
								   if (dropDwonProvType.get(p).getText().contains(valarray[1]))
								   {
		
									   System.out.println("condition satisfied  " + dropDwonProvType.get(p).getText());
									   Thread.sleep(1000);
									   
									   dropDwonProvType.get(p).click();
									   break;
								   }
		
						    }
							driver.findElement(By.xpath("//*[@id=\"ProviderCode\"]")).sendKeys(valarray[2]);
							Thread.sleep(200);
							driver.findElement(By.xpath("//*[@id=\"Credential\"]")).sendKeys(valarray[3]);
							Thread.sleep(200);
							driver.findElement(By.xpath("//*[@id=\"NPINumber\"]")).sendKeys(valarray[4]);
							Thread.sleep(200);
							driver.findElement(By.xpath("//*[@id=\"BCBSFNumber\"]")).sendKeys(valarray[5]);
							Thread.sleep(200);
					 
					 break;
					
				
				}//close switch
				
			}//close inner for
			
			//click on save button
			driver.findElement(By.xpath("//*[@id='kt_wrapper']/div[2]/ng-component/div/createoreditusermodal/p-sidebar/div/div[2]/form/div/div[3]/button[2]")).click();
			Thread.sleep(1000);
			//click on popup message if user entered is already added
			try
			{
			//click on ok button of popup message
			WebElement btnOk = driver.findElement(By.xpath("//*[@id='kt_body']/div[2]/div/div[6]/button[1]"));
			Thread.sleep(2000);
			btnOk.click();
			//click on cancel button of new user.
			driver.findElement(By.xpath("//*[@id='kt_wrapper']/div[2]/ng-component/div/createoreditusermodal/p-sidebar/div/div[2]/form/div/div[3]/button[1]")).click();
			Thread.sleep(200);
			}
					catch (Exception e)
			{
				System.out.println("diffrent user hence add it");

			}
		}//outer for loop
	
			Thread.sleep(1000);
			driver.navigate().refresh();
	}
	
	public void DeleteUsers(WebDriver driver,String srcval) throws InterruptedException, BiffException, IOException
	{
		this.driver = driver;
		Thread.sleep(1000);
		//*[starts-with(@id,'pr_id_')]//descendant::i[contains(@class,'pi pi-ellipsis')]
		List<WebElement> roleRows = driver.findElements(By.xpath("//p-tablecheckbox[contains(@id,'username_')]"));
		Thread.sleep(6000);
	    System.out.println("Number of Check boxes : "+ roleRows.size());
		System.out.println("IN delete user");
		 
		ReadExcel rf = new ReadExcel();//Create an instance of readexcel to read the input file. Pass the name and sheet no.
		rf.ReadExcelFile(srcval, 3);
		String value;
		System.out.println("Number of row n col : " + rf.excel_row + rf.excel_col);
		int i = 1;
		for (i=1;i<rf.excel_row;i++)  //row
		{
			for(int j=0;j<rf.excel_col;j++) //col
			{
				
				Cell c= rf.excel_Sheet.getCell(j,i);	

				value=c.getContents();

				System.out.println("Value = " + value);
				boolean isnext;
				isnext= checkNextButton(driver,roleRows,value);
				here : while (isnext == false)
						{
							System.out.println("IN while 1");
							boolean istof = driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::button[contains(@class,'p-ripple p-element p-paginator-next')]")).isEnabled();
							if (istof = true)
							{
								driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::button[contains(@class,'p-ripple p-element p-paginator-next')]")).click();
								Thread.sleep(3000);
								System.out.println("IN while 2");
								roleRows = driver.findElements(By.xpath("//p-tablecheckbox[contains(@id,'username_')]"));
								Thread.sleep(3000);
								isnext= checkNextButton(driver,roleRows,value);
								if (isnext == false)
								{
									System.out.println("IN while 3");
									break here;
								}
								else
								{
									System.out.println("IN while 4");
									break;
								}
							}
						} 
			}
		}
	
		Thread.sleep(1000);
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,-250)");
		   Thread.sleep(1000);
		//Click on delete button
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::button[contains(@class,'btn btn-outline-primary btn-sm')]")).click();
		//The popup appears asking for confirmation
		//click on ok button of popup message
		WebElement btnOk = driver.findElement(By.xpath("//*[@id=\"kt_body\"]//descendant::button[contains(@class,'swal2-confirm')]"));
		Thread.sleep(2000);
		btnOk.click();
		Thread.sleep(1000);
		driver.navigate().refresh();
	}


	public boolean checkNextButton(WebDriver driver,List<WebElement> roleRows,String value) throws InterruptedException
	{
		this.driver = driver;
		 for(int k=0;k<roleRows.size(); k++)
		   {
			  
			   System.out.println("id val" + roleRows.get(k).getAttribute("id"));
	
			   if (roleRows.get(k).getAttribute("id").contains(value))
			   {
				   System.out.println("condition satisfied value "+ value);

				   System.out.println("condition satisfied" + roleRows.get(k).getAttribute("id"));

					   Thread.sleep(1000);
					   roleRows.get(k).click();
					   return true;
			   }
		   }
		 return false;

	}


	/*public void EditUsers(WebDriver driver,String srcval) throws InterruptedException, BiffException, IOException
	{
		this.driver = driver;
		Thread.sleep(1000);
		List<WebElement> userRows = driver.findElements(By.xpath("//*[@id=\"pr_id_9-table\"]//descendant::i[contains(@class,'pi pi-ellipsis-v')]"));
		Thread.sleep(6000);
	    System.out.println("Number of Check boxes : "+ userRows.size());
		System.out.println("IN delete user");
		 
		ReadExcel rf = new ReadExcel();//Create an instance of readexcel to read the input file. Pass the name and sheet no.
		rf.ReadExcelFile(srcval, 4);
		String value;
		System.out.println("Number of row n col : " + rf.excel_row + rf.excel_col);
		int i;
		for (i=1;i<rf.excel_row;i++)  //row
		{
			for(int j=0;j<rf.excel_col;j++) //col
			{
				
				Cell c= rf.excel_Sheet.getCell(j,i);	

				value=c.getContents();

				System.out.println("Value = " + value);
				SelectAndEdit( driver,value);
			}
		}
	}*/

	/*public void SelectAndEdit(WebDriver driver,String srcval) throws InterruptedException
	{
		
		this.driver = driver;
		Thread.sleep(1000);
		List<WebElement> userRows = driver.findElements(By.xpath("//*[@id=\"pr_id_9-table\"]//descendant::i[contains(@class,'pi pi-ellipsis-v')]"));
		Thread.sleep(6000);
	    System.out.println("Number of users on the page : "+ userRows.size());
		System.out.println("IN select ad edit user");
		boolean isnext;
		isnext= checkNextButton2(driver,userRows,srcval);
		here : while (isnext == false)
				{
					System.out.println("IN while 1");
					boolean istof = driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::button[contains(@class,'p-ripple p-element p-paginator-next')]")).isEnabled();
					if (istof = true)
					{
						driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::button[contains(@class,'p-ripple p-element p-paginator-next')]")).click();
						Thread.sleep(3000);
						System.out.println("IN while 2");
						userRows = driver.findElements(By.xpath("//*[@id=\"pr_id_9-table\"]//descendant::i[contains(@class,'pi pi-ellipsis-v')]"));
						Thread.sleep(3000);
						isnext= checkNextButton2(driver,userRows,srcval);
						if (isnext == false)
						{
							System.out.println("IN while 3");
							break here;
						}
						else
						{
							System.out.println("IN while 4");
							break;
						}
					}
				} 
	}*/


	public void EditSearchandUser(WebDriver driver,String value) throws InterruptedException, BiffException, IOException
	{
		this.driver = driver;
		//locate the search button and then send the value from excel to search text box.Then press the enter key to actually search the desired user
		WebElement searchbtn = driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::input[@name='filterText']"));
		searchbtn.clear();
		Thread.sleep(100);
		searchbtn.sendKeys(value);
		searchbtn.sendKeys(Keys.RETURN);
		Thread.sleep(10000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[starts-with(@id,'pr_id_')]//descendant::a[contains(@class,'text-start')]")).click();
		Thread.sleep(1000);
		//create list of elements for action menu and then select edit menu to click
		List<WebElement>  actions = driver.findElements(By.xpath("//*[starts-with(@id,'pr_id_')]/tbody/tr/td//descendant::li//descendant::a"));
		for (int a=0;a<actions.size();a++)
		{
			System.out.println("actions = " + actions.get(a).getText());
			if (actions.get(a).getText().equalsIgnoreCase("Edit"))
			{
				actions.get(a).click();
			}
		}
		
		//Now change the extention number of selected user
		driver.findElement(By.xpath("//*[@id=\"Ext\"]")).clear();//first clear the existing contents
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"Ext\"]")).sendKeys("002");//send the new contents
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::button[@type='submit']")).click();// save the changes
		Thread.sleep(300);
	}
}









