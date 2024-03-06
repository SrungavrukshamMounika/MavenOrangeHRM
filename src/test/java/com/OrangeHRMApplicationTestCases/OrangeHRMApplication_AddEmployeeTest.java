package com.OrangeHRMApplicationTestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Uitility.log;


public class OrangeHRMApplication_AddEmployeeTest extends BaseTest
{
FileInputStream testDataFile;
	
	XSSFWorkbook workBook;
	
	XSSFSheet testSheet;
	
	@Test(priority = 1,description = "OrangeHRM Application Login Details")
	public void OrangeHRMlogindetails() throws IOException
	{
		testDataFile=new FileInputStream("./src/main/java/com/OrangeHRMApplicationTestDataFiles/OrangeHRMAddEmployeeFunctionalityFile.xlsx");
	    workBook =new XSSFWorkbook(testDataFile);
	    testSheet=workBook.getSheet("testdata");
		
		Row row=testSheet.createRow(1);
		
		Cell usernameCell7=row.createCell(7);
		usernameCell7.setCellValue("mounika");
		
		Cell passwordCell8=row.createCell(8);
		passwordCell8.setCellValue("Mounika@123");
		
		Cell loginPageText=row.createCell(0);
		loginPageText.setCellValue("LOGIN Panel");
		
		Cell invalidtext=row.createCell(1);
		invalidtext.setCellValue("Invalid Credentials");
		
		Cell homePageTitle=row.createCell(4);
		homePageTitle.setCellValue("orangeHRM");
		
		Cell adminText=row.createCell(9);
		adminText.setCellValue("Admin");
		
		Cell firatnameCell15=row.createCell(15);
		firatnameCell15.setCellValue("Mounika");
		
		Cell middlenameCell16=row.createCell(16);
		middlenameCell16.setCellValue("Sri");
		
		Cell lastnameCell17=row.createCell(17);
        lastnameCell17.setCellValue("Srungavruksham");
		
        Row secondrow=testSheet.createRow(2);
		
        firatnameCell15=secondrow.createCell(15);
		firatnameCell15.setCellValue("Madhu");
		
		middlenameCell16=secondrow.createCell(16);
		middlenameCell16.setCellValue("priya");
		
		lastnameCell17=secondrow.createCell(17);
        lastnameCell17.setCellValue("Nadipudi");
		
        Row thirdrow=testSheet.createRow(3);
		
        firatnameCell15=thirdrow.createCell(15);
		firatnameCell15.setCellValue("Mahitha");
		
		middlenameCell16=thirdrow.createCell(16);
		middlenameCell16.setCellValue("Sri");
		
		lastnameCell17=thirdrow.createCell(17);
        lastnameCell17.setCellValue("Thupakula");
        
        
	}
	
	@Test(priority = 2,description = "OrangeHRM Application Title Validating")
	public void OrangeHRMTitle() throws IOException
	{
		
		Row row=testSheet.getRow(1);
		
		String Expeceted_homePageTitle=row.getCell(4).getStringCellValue();
		//System.out.println(Expeceted_homePageTitle);
		log.info(Expeceted_homePageTitle);
		
		String Actual_homePageTitle=driver.getTitle();
		//System.out.println(Actual_homePageTitle);
		log.info(Actual_homePageTitle);
		Cell orangeHRMTitle=row.createCell(5);
		orangeHRMTitle.setCellValue(Actual_homePageTitle);
		
		if(Actual_homePageTitle.equals(Expeceted_homePageTitle))
		{
			
			log.info("pass");
			//System.out.println("pass");
			Cell result=row.createCell(6);
			result.setCellValue("pass");
		}
		else
		{
			log.info("fail");
			//System.out.println("fail");
			
			Cell result=row.createCell(6);
			result.setCellValue("fail");
		}
		
		
		
	}
	FileInputStream propertiesFile;
	
	Properties properties;
	
	
	@Test(priority = 3,description = "OrangeHRM LoginPage Login")
	public void loginTheOrangeHRM() throws IOException
	{
		propertiesFile= new FileInputStream("./src/main/java/com/Config/OrangeHRMApplication.properties");

		properties = new Properties();

		properties.load(propertiesFile);
		Row rows=testSheet.getRow(1);
		
		String usernameTestdata=rows.getCell(7).getStringCellValue();
		By usernameProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPageUserNameProperty"));;
		WebElement username=driver.findElement(usernameProperty);
		username.sendKeys(usernameTestdata);
		System.out.println(usernameTestdata);
		
	String passwordTestData=rows.getCell(8).getStringCellValue();
		By passwordProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPagePasswordProperty"));
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(passwordTestData);
		System.out.println(passwordTestData);
		
		By loginProperty=By.className(properties.getProperty("orangeHRMApplicationLogInPageLogInButtonProperty"));
	    WebElement Login=driver.findElement(loginProperty);
	    Login.click();
	}
	@Test(priority = 4,description = "OrangeHRM Home Page Text Admin")
	public void OrangeHRMHomePageTextAdmin() throws IOException
	{
	    Row rows=testSheet.getRow(1);
	    
	    By adminProperty=By.id(properties.getProperty("orangeHRMApplicationHomePageAdminProperty"));
		    WebElement admin=driver.findElement(adminProperty);
		    String admintext=admin.getText();
		    
		    Cell resultCell10=rows.createCell(10);
		    resultCell10.setCellValue(admintext);
		    	 	
		    String expected_HomePageText=rows.getCell(9).getStringCellValue();
		    System.out.println(expected_HomePageText);
		    	
		    String actual_HomePageText=rows.getCell(10).getStringCellValue();
		    System.out.println(actual_HomePageText);
		    	if(actual_HomePageText.equals(expected_HomePageText))
		    	{
		    		log.info("pass");
		    		//System.out.println("Pass");
		    		Cell result=rows.createCell(11);
		    		result.setCellValue("Pass");
		    	}
		    	else
		    	{
		    		log.info("fail");
		    		//System.out.println("Fail");
		    		Cell result=rows.createCell(11);
		    		result.setCellValue("Fail");
		    	}
		    	
		   Cell validData=rows.createCell(2);
		   validData.setCellValue("Valid Credentials");
		           
          String Expected_ValidData=rows.getCell(1).getStringCellValue();
		  System.out.println(Expected_ValidData);
		           
		   String Actual_ValidData=rows.getCell(2).getStringCellValue();
		   System.out.println(Actual_ValidData);
		           
		           if(Actual_ValidData.equals(Expected_ValidData))
		           {
		        	   log.info("pass");
		        	   //System.out.println("pass");
		        	   Cell validText=rows.createCell(3);
		        	   validText.setCellValue("pass");
		        	   
		           }
		           else
		           {
		        	   log.info("fail");
		        	   //System.out.println("pass");
		        	   Cell validText=rows.createCell(3);
		        	   validText.setCellValue("pass");
		        	   
		           }
	
	
	}
	
	
     @Test(priority = 5,description = "OrangeHRM PIM Page")
     public void OrangeHRMPIMPage() throws IOException
     {
	   
	   
	   By pimProperty=By.id(properties.getProperty("orangeHRMApplicationHomePagePIMProperty"));
		WebElement PIM=driver.findElement(pimProperty);
		
		Actions mouseAction=new Actions(driver);
		mouseAction.moveToElement(PIM).build().perform();
		
		
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
		By addEmployeePropery=By.id(properties.getProperty("orangeHRMApplicationPIMPageAddEmployeeProperty"));
		WebElement addEmployee=driver.findElement(addEmployeePropery);
		
		addEmployee.click();
     
    
		    	
	    
	   
     }
     
     @Test(priority = 6,description = "Add Employee Validating")
     public void addEmployeeValidating() throws IOException
     {
    	 Row rows=testSheet.getRow(1);
    	 
    	 Cell addemployeeTextCell11=rows.createCell(12);
    	 addemployeeTextCell11.setCellValue("Add Employee");
    	 //class="head"
    	 
    	 By addEMployeeProperty=By.className(properties.getProperty("orangeHRMApplicationAddEmployeePageAddEmployeeProperty"));
    	 WebElement addEmployeeText=driver.findElement(addEMployeeProperty);
    	 String Actual_addEmployeeText=addEmployeeText.getText();
    	 
    	 Cell addemployeeTextCell12=rows.createCell(13);
    	 addemployeeTextCell12.setCellValue(Actual_addEmployeeText);
    	 
         String Expected_AddEmployee= rows.getCell(12).getStringCellValue();
         //System.out.println(Expected_AddEmployee);
         log.info(Expected_AddEmployee);
         String Actual_AddEmployee=rows.getCell(13).getStringCellValue();
         //System.out.println(Actual_AddEmployee);
         log.info(Actual_AddEmployee);
         
         if(Actual_AddEmployee.equals(Expected_AddEmployee))
         {
        	 log.info("pass");
        	 //System.out.println("pass");
        	 Cell result=rows.createCell(14);
        	 result.setCellValue("pass");
         }
         else
         {
        	 log.info("fail");
        	 //System.out.println("fail");
        	 Cell result=rows.createCell(14);
        	 result.setCellValue("fail");
         }
    	 
         
    	 
     }
     
     @Test(priority = 7,description = "validating Add Employee Details")
     public void validatingAddEmployeeDetails() throws IOException, InterruptedException
     {
    	 
    	 
    	 for(int rowindex=1;rowindex<=3;rowindex++)
    		 
    	 {
    		 
    		 Row rows=testSheet.getRow(rowindex);
    		String expected_firstName=rows.getCell(15).getStringCellValue();
 			By firstNameProperty=By.id(properties.getProperty("orangeHRMApplicationAddEmployeePageFirstNameProperty"));
 			WebElement Firstname=driver.findElement(firstNameProperty);
 			Firstname.sendKeys(expected_firstName);
 			
            Actions keyBoardActions=new Actions(driver);
			
			keyBoardActions.sendKeys(Keys.TAB).build().perform();
			
			String expected_middleName=rows.getCell(16).getStringCellValue();
			keyBoardActions.sendKeys(expected_middleName).build().perform();
			
			keyBoardActions.sendKeys(Keys.TAB).build().perform();
			
		    String expected_lastName=rows.getCell(17).getStringCellValue();
			keyBoardActions.sendKeys(expected_lastName).build().perform();
			
			
			By employeeIdProperty=By.id(properties.getProperty("orangeHRMApplicationAddEmployeePageEmployeeIdProperty"));
			WebElement employeeId=driver.findElement(employeeIdProperty);
			String expected_EmployeeID=employeeId.getAttribute("value");
			Cell rowOfCell18=rows.createCell(18);
			rowOfCell18.setCellValue(expected_EmployeeID);
			//System.out.println(expected_EmployeeID);
			log.info(expected_EmployeeID);
			
			keyBoardActions.sendKeys(Keys.TAB).build().perform();

			keyBoardActions.sendKeys(Keys.TAB).build().perform();
			
		keyBoardActions.sendKeys(Keys.ENTER).build().perform();
		
		    Thread.sleep(3000);
		
		//java.lang.Runtime.getRuntime().exec("C:\\Users\\Mounika\\eclipse-workspace\\MavenOrangeHRM\\AutoITScripts\\AutoITScript7.exe");
		
		java.lang.Runtime.getRuntime().exec("C:\\Users\\Mounika\\eclipse-workspace\\MavenOrangeHRM\\AutoITScripts\\AutoITScript.exe");
			Thread.sleep(3000);
			
		    By savebuttonProperty=By.id(properties.getProperty("orangeHRMApplicationAddEmployeePageSaveButtonProperty"));
			WebElement save=driver.findElement(savebuttonProperty);
			save.click();
			
			Cell PersonalDetails=rows.createCell(19);
            PersonalDetails.setCellValue("Personal Details");
			
			//<div class="head">
			
           By PersonalDtailsProperty=By.className(properties.getProperty("orangeHRMApplicationPersonalDetailsPagePersonalDetailsProperty")); 
           WebElement personalDetails=driver.findElement(PersonalDtailsProperty);
           String personalDatailsText=personalDetails.getText();
           
           Cell personalDetailsText=rows.createCell(20);
           personalDetailsText.setCellValue(personalDatailsText);
           
           By FirstNameProperty=By.id(properties.getProperty("orangeHRMApplicationpersonalDetailsPageFirstNameProperty"));
	    	WebElement FirstName=driver.findElement(FirstNameProperty);
	    	String firstNameText=FirstName.getAttribute("value");
	    	Cell rowOfCell22=rows.createCell(22);
	    	rowOfCell22.setCellValue(firstNameText);
	    	log.info(firstNameText);
	    	//System.out.println(firstNameText);
	    	
	    	By MiddleNameProperty=By.id(properties.getProperty("orangeHRMApplicationpersonalDetailsPageMiddleNametNameProperty"));
	    	WebElement MiddleName=driver.findElement(MiddleNameProperty);
	    	String MiddleNameText=MiddleName.getAttribute("value");
	    	Cell rowOfCell24=rows.createCell(24);
	    	rowOfCell24.setCellValue(MiddleNameText);
	    	log.info(MiddleNameText);
	    	//System.out.println(MiddleNameText);
	    	
	    	By LastNameProperty=By.id(properties.getProperty("orangeHRMApplicationpersonalDetailsPageLastNameProperty"));
	    	WebElement LastName=driver.findElement(LastNameProperty);
	    	String LastNameText=LastName.getAttribute("value");
	    	Cell rowOfCell26=rows.createCell(26);
	    	rowOfCell26.setCellValue(LastNameText);
	    	log.info(LastNameText);
	    	//System.out.println(LastNameText);
	    	
	    	//<input value="0035" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable" id="personal_txtEmployeeId" disabled="disabled">
	    	
	    	By employeeIDProperty=By.id(properties.getProperty("orangeHRMApplicationPersonalDetailsPageEmployeeIdProperty"));
	    	WebElement employeeID=driver.findElement(employeeIDProperty);
	    	String employeeIDText=employeeID.getAttribute("value");
	    	Cell rowOfCell28=rows.createCell(28);
	    	rowOfCell28.setCellValue(employeeIDText);
	    	log.info(employeeIDText);
	    	//System.out.println(employeeIDText);
	    	
	    	By addEmployeePropery=By.id(properties.getProperty("orangeHRMApplicationPersonalDetailsClickOnAddEmployeeProperty"));
			WebElement addEmployee=driver.findElement(addEmployeePropery);
			
			addEmployee.click();
           
			
			
    	 }
    	 
     }
 
	     @Test(priority = 8,description = "Validating the Employee Details")
	 	public void ValidatingTheEmployeeDetails() throws IOException
	 	{
	 		int row=testSheet.getLastRowNum();
	 		for(int rowindex=1;rowindex<=row;rowindex++)
	 		{
	 			Row rows=testSheet.getRow(rowindex);
	 			
	 			String Expected_FullName=rows.getCell(19).getStringCellValue();
	 			//System.out.println(Expected_FullName);
	 			log.info(Expected_FullName);
	 			
	 			String Actual_FullName=rows.getCell(20).getStringCellValue();
	 			//System.out.println(Actual_FullName);
	 			log.info(Actual_FullName);
	 			if(Actual_FullName.equals(Expected_FullName))
	 			{
	 				log.info("pass");
	 				//System.out.println("pass");
	 				Cell result=rows.createCell(21);
	 				result.setCellValue("Pass");
	 			}
	 			else
	 			{
	 				log.info("fail");
	 				//System.out.println("fail");
	 				Cell result=rows.createCell(21);
	 				result.setCellValue("fail");
	 			}
	 			
	 			String expected_firstName=rows.getCell(15).getStringCellValue();
	 			System.out.println(expected_firstName);
	 			String actual_firstName=rows.getCell(22).getStringCellValue();
	 			System.out.println(actual_firstName);
	 			if(actual_firstName.equals(expected_firstName))
	 			{
	 				log.info("pass");
	 				//System.out.println("pass");
	 				Cell result=rows.createCell(23);
	 				result.setCellValue("Pass");
	 			}
	 			else
	 			{
	 				log.info("fail");
	 				//System.out.println("fail");
	 				Cell result=rows.createCell(23);
	 				result.setCellValue("fail");
	 			}
	 			
	 			String expected_middleName=rows.getCell(16).getStringCellValue();
	 			System.out.println(expected_middleName);
	 			String actual_middleName=rows.getCell(24).getStringCellValue();
	 			System.out.println(actual_middleName);
	 			if(actual_middleName.equals(expected_middleName))
	 			{
	 				log.info("pass");
	 				//System.out.println("pass");
	 				Cell result=rows.createCell(25);
	 				result.setCellValue("Pass");
	 			}
	 			else
	 			{
	 				log.info("fail");
	 				//System.out.println("fail");
	 				Cell result=rows.createCell(25);
	 				result.setCellValue("fail");
	 			}
	 			
	 			String expected_LastName=rows.getCell(17).getStringCellValue();
	 			System.out.println(expected_LastName);
	 			String actual_LastName=rows.getCell(26).getStringCellValue();
	 			System.out.println(actual_LastName);
	 			if(actual_LastName.equals(expected_LastName))
	 			{
	 				log.info("pass");
	 				//System.out.println("pass");
	 				Cell result=rows.createCell(27);
	 				result.setCellValue("Pass");
	 			}
	 			else
	 			{
	 				log.info("fail");
	 				//System.out.println("fail");
	 				Cell result=rows.createCell(27);
	 				result.setCellValue("fail");
	 			}
	 			
	 			String Expecte_employeeID=rows.getCell(18).getStringCellValue();
	 			//System.out.println(Expecte_employeeID);
	 			log.info(Expecte_employeeID);
	 			String Actual_employeeID=rows.getCell(28).getStringCellValue();
	 			//System.out.println(Actual_employeeID);
	 			log.info(Actual_employeeID);
	 			if(Actual_employeeID.equals(Expecte_employeeID))
	 			{
	 				log.info(Actual_employeeID);
	 				//System.out.println("pass");
	 				Cell result=rows.createCell(29);
	 				result.setCellValue("Pass");
	 			}
	 			else
	 			{
	 				
	 				log.info("fail");
	 				//System.out.println("fail");
	 				Cell result=rows.createCell(29);
	 				result.setCellValue("fail");
	 			}
	 		}
	 		
	 	}
	 	@Test(priority = 9,description = "OrangeHRM Home Page LogOut Functionality")
	 	public void logoutFunctionality()
	 	{
	 			
	 			By welcomeAdminProperty=By.id(properties.getProperty("orangeHRMApplicationHomePageWelcomeAdminProperty"));
	 			WebElement welcomeAdmin=driver.findElement(welcomeAdminProperty);
	 			welcomeAdmin.click();
	 			
	 			
	 			By logoutProperty=By.linkText(properties.getProperty("orangeHRMApplicationHomePageWelcomeAdminClickOnlogoutProperty"));
	 			WebElement logout=driver.findElement(logoutProperty);
	 			
	 			logout.click();
	 				
	 			
	 			
	 		
	 		
	 	}
	 	
	 	@Test(priority = 10,description = "OrangeHRM Login Page LOGIN Panel Text")
	 	public void loginPanelText() throws IOException
	 	{
	 		Row rows=testSheet.getRow(1);
	 		
	 		Cell loginPageText=rows.createCell(30);
			loginPageText.setCellValue("LOGIN Panel");
			
	 		By loginPanelProperty=By.id(properties.getProperty("orangeHRMApplicationLogInPageLOGINPanelProperty"));
	 		WebElement LoginPanel=driver.findElement(loginPanelProperty);
	 		String LoginPanelText=LoginPanel.getText();
	 		Cell rowsOfCell=rows.createCell(31);
	 		rowsOfCell.setCellValue(LoginPanelText);
	 		
	 		
	 		
	 		String Expected_LOGINPanel=rows.getCell(30).getStringCellValue();
	 		//System.out.println(Expected_LOGINPanel);
	 		log.info(Expected_LOGINPanel);
	 		String Actual_LOGINPanel=rows.getCell(31).getStringCellValue();
	 		//System.out.println(Actual_LOGINPanel);
	 		log.info(Actual_LOGINPanel);
	 		
	 		if(Actual_LOGINPanel.equals(Expected_LOGINPanel))
	 		{
	 			log.info("pass");
	 			//System.out.println("pass");
	 			Cell result=rows.createCell(32);
	 			result.setCellValue("pass");
	 		}
	 		else
	 		{
	 			log.info("fail");
	 			//System.out.println("fail");
	 			Cell result=rows.createCell(32);
	 			result.setCellValue("fail");
	 		}
	 		FileOutputStream testDataResult=new FileOutputStream("./src/main/java/com/OrangeHRMApplicationTestResultFiles/OrangeHRMAddEmployeeFunctionalityFile.xlsx");
		     workBook.write(testDataResult);
	 		
	 	}
	 	
	 	
	 	
    	 


}
