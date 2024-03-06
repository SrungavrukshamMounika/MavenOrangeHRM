package com.OrangeHRMApplicationTestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Uitility.log;



public class OrangeHRMApplication_EmployeeListTest extends BaseTest
{
	
FileInputStream numberOfRowValues;
	
	XSSFWorkbook workBook;
	
	XSSFSheet testDataSheet;
	
    FileInputStream propertiesFile;
	
	Properties properties;
	
	@Test(priority = 1,description = "OrangeHRM Application Capturing AddEmployeeList")
	public void capturingAddEmployeeList() throws IOException
	{
        numberOfRowValues=new FileInputStream("./src/main/java/com/OrangeHRMApplicationTestDataFiles/capturingEmployeeListTestData.xlsx");
		
		workBook=new XSSFWorkbook(numberOfRowValues);
		
		testDataSheet=workBook.getSheet("TestData");
		
		
		propertiesFile= new FileInputStream("./src/main/java/com/Config/OrangeHRMApplication.properties");

		properties = new Properties();

		properties.load(propertiesFile);
		
		String UsernameTextData="mounika";
		By userNameProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));
		WebElement userName=driver.findElement(userNameProperty);
		userName.sendKeys(UsernameTextData);
		
		String PasswordTextData="Mounika@123";
		By passwordProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(PasswordTextData);
		
		By loginProperty=By.className(properties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
		WebElement login=driver.findElement(loginProperty);
		login.click();
		By pimProperty=By.id(properties.getProperty("orangeHRMApplicationHomePagePIMProperty"));
		WebElement PIM=driver.findElement(pimProperty);
		
		Actions mouseAction=new Actions(driver);
		mouseAction.moveToElement(PIM).build().perform();
		
		
		By emplyeeListProperty=By.id(properties.getProperty("orangeHRMApplicationHomePageEmployeeListProperty"));
		WebElement employeeList=driver.findElement(emplyeeListProperty);
		employeeList.click();
		
		By webTableProperty=By.xpath(properties.getProperty("orangeHRMApplicationHomePageEmployeeListWebTableProperty"));
		WebElement webTable=driver.findElement(webTableProperty);
		
		
		
		By TableRowProperty=By.tagName(properties.getProperty("orangeHRMApplicationHomePageEmployeeListWebTableRowsProperty"));
		List<WebElement> TableRow=webTable.findElements(TableRowProperty);
		for(int rowindex=0;rowindex<TableRow.size();rowindex++)
		{
			WebElement webtable=TableRow.get(rowindex);
			
			
			Row rows=testDataSheet.createRow(rowindex);
     
			By TableCellProperty=By.tagName(properties.getProperty("orangeHRMApplicationHomePageEmployeeListWebTableRowsTagProperty"));
			List<WebElement> TableCell=webtable.findElements(TableCellProperty);
			for(int cellindex=0;cellindex<TableCell.size();cellindex++)
			{
				WebElement webtableCell=TableCell.get(cellindex);
				String webTableData=webtableCell.getText();
				//System.out.print(webTableData+" ");
				log.info(webTableData+" ");
				Cell rowOfCell=rows.createCell(cellindex);
				rowOfCell.setCellValue(webTableData);
			}
			System.out.println();	
			//log.info();
			
			
		}
	
	
    FileOutputStream resultData=new FileOutputStream("./src/main/java/com/OrangeHRMApplicationTestResultFiles/capturingEmployeeListTestData.xlsx");
	workBook.write(resultData);
	
	}


}
