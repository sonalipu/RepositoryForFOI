package pageObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import CommonFunctions.ReadExcel;
import FOITest.ValidateRoles;
import jxl.Cell;
import jxl.read.biff.BiffException;

public class ValidateCPTCode {

	public WebDriver driver;

	public void ClickAdministration(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]//descendant::span[text()='Administration']")).click();
	}

	public void ClickCPTCode(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"#kt_aside_menu\"]//descendant::span[text()='CPT Codes']")).click();
	}

	public void SearchCPTCode(WebDriver driver, String srcval,int srch) throws InterruptedException, BiffException, IOException 
	{
		this.driver = driver;
		String value = "";
		if (srch == 1)
		{
			value = srcval;
		}
		else
		{
			ReadExcel rf = new ReadExcel();
			rf.ReadExcelFile(srcval, 1);
			
			int i = 1;
			for (i = 1; i < rf.excel_row; i++) // row
			{
	
				for (int j = 0; j < rf.excel_col; j++) // col
				{
	
					Cell c = rf.excel_Sheet.getCell(j, i);
					value = c.getContents();
					System.out.println("Value = " + value);
				}
			}
		}
		Thread.sleep(1000);
		//WebElement searchbtn = driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/div[1]/form/div/div/div[1]/input"));
		WebElement searchbtn = driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::input[@name='filterText']"));
		searchbtn.clear();
		searchbtn.sendKeys(value);
		searchbtn.sendKeys(Keys.RETURN);

	}

	/*
	 * In this function, an excel file of input cpt codes is read through a
	 * function. Each row contains one cpt code data. for loop traverse first row
	 * and then column to fetch each indivisual element of cpt code and then send
	 * the values to respective web elements and finally clicks on save button. This
	 * way one cpt code information is added. And then with outer for loop the cpt
	 * code data is added for each code. But if the cpt code already exists then it
	 * will click on the pop msg.
	 */
	public void AddCPTCode(WebDriver driver, String srcval) throws BiffException, IOException, InterruptedException {
		// *[@id="kt_wrapper"]/div[2]/ng-component/div/div/div[1]/form/div/div/div[2]/button
		this.driver = driver;
		// driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/div[1]/form/div/div/div[2]/button")).click();
		 Thread.sleep(1000);
		ReadExcel rf = new ReadExcel();
		rf.ReadExcelFile(srcval, 0);
		String value;
		String cptCode = null;
		int i = 1;
		
		for (i = 1; i < rf.excel_row; i++) // row
		{

			driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::ng-component//descendant::form//descendant::button[contains(@class,'btn btn-primary btn-sm')]")).click();
			//driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::form//descendant::button[contains(@class,'btn btn-primary btn-sm')]")).click();
			//driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/div[1]/form/div/div/div[2]/button")).click();
			Thread.sleep(1000);
			for (int j = 0; j < rf.excel_col; j++) // col
			{

				Cell c = rf.excel_Sheet.getCell(j, i);
				value = c.getContents();
				System.out.println("Value = " + value);
				switch (j) {
				case 0:cptCode = value;
					driver.findElement(By.xpath("//*[@id=\"CPTCode_Code\"]")).sendKeys(value);

					break;
				case 1:
					driver.findElement(By.xpath("//*[@id=\"CPTCode_ShortDescription\"]")).sendKeys(value);

					break;
				case 2:
					driver.findElement(By.xpath("//*[@id=\"CPTCode_LongDescription\"]")).sendKeys(value);

					break;
				case 3:
					driver.findElement(By.xpath("//*[@id=\"CPTCode_EffectiveDate\"]")).sendKeys(value);

					break;
				case 4:
					driver.findElement(By.xpath("//*[@id=\"CPTCode_ExpirationDate\"]")).sendKeys(value);

					break;

				case 5:
					driver.findElement(By.xpath("//*[@id=\"CPTCode_GlobalDays\"]")).sendKeys(value);
					break;

				case 6:
					driver.findElement(By.xpath("//*[@id=\"CPTCode_RVU\"]")).sendKeys(value);
					break;

				case 7:
					driver.findElement(By.xpath("//*[@id=\"CPTCode_EndoBase\"]")).sendKeys(value);
					break;

				case 8:
					driver.findElement(By.xpath("//*[@id=\"CPTCode_IsAscAllowed\"]")).click();
					driver.findElement(By.xpath("//*[@id=\"CPTCode_AscAllowed\"]")).sendKeys(value);
					break;
				case 9:
					driver.findElement(By.xpath("//*[@id=\"CPTCode_AscAllowed\"]")).sendKeys(value);
					
				case 10:
					driver.findElement(By.xpath("//*[@id=\"CPTCode_AllowModifier50\"]")).sendKeys(value);
					break;

				case 11:
					driver.findElement(By.xpath("//*[@id=\"CPTCode_AllowModifier62\"]")).sendKeys(value);
					break;

				}// close switch
			} // close inner for
			//driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/createoreditcptcodemodal/p-sidebar/div/div[2]/form/div/div[3]/button[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]//descendant::createoreditcptcodemodal//descendant::form//descendant::button[contains(@class,'btn btn-primary btn-sm')]")).click();
			Thread.sleep(1000);
			// click on popup message if cpt code entered is already added
			try {
				// click on ok button of popup message
				driver.findElement(By.xpath("//*[@id=\"kt_body\"]/div[2]/div/div[6]/button[1]")).click();
				Thread.sleep(1000);
				// click on cancel button of new cpt code.
				driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/createoreditcptcodemodal/p-sidebar/div/div[2]/form/div/div[3]/button[1]")).click();
				Thread.sleep(200);
			} catch (Exception e) {
				System.out.println("diffrent cptcode hence add it");

			}
			//check the added element is displayed after search
			SearchCPTCode(driver,cptCode,1);
			Thread.sleep(5000);
		} // outer for loop

		// click on save button
		// driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[2]/ng-component/div/div/createoreditcptcodemodal/p-sidebar/div/div[2]/form/div/div[3]/button[2]")).click();
		// Thread.sleep(1000);
		driver.navigate().refresh();
	}
}
