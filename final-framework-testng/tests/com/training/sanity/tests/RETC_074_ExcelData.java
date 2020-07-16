// Test Objective: To Verify whether application allows admin to change the role of registered user in Users module 
 
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UsersPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_074_ExcelData {

	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
	public UsersPOM usersPOM;
	public static Properties properties;
	public ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
		

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		usersPOM=new UsersPOM(driver);
	    baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test(dataProvider = "excel-enter", dataProviderClass = LoginDataProviders.class)
	public void ChangeUserRoleTest(String usercheckbox, String changerole) throws InterruptedException {
		loginPOM.sendUserName("pallabuk1@gmail.com");
		loginPOM.sendPassword("password@12345");
		loginPOM.clickLoginBtn(); 
		usersPOM.clickOnUsers(); 					// Click on Users link
		usersPOM.clickOnAllUsers();					// Click on All Users link
		Thread.sleep(1000);
		usersPOM.sendSearchUser(usercheckbox);		//Passing the variabe "usercheckbox" and fetching the users from Excel (Realstates.xlsx). 
		Thread.sleep(1000);
		usersPOM.clickSearchUserBttn();
		Thread.sleep(1000);
		usersPOM.clickCheckBoxCheckAll();
		Thread.sleep(1000);
		WebElement role=driver.findElement(By.id("new_role")); //Passing the variable "changerole" and fetching user roles from Excel(Realstates.xlsx).
		Select select =new Select(usersPOM.changerole);
		select.selectByVisibleText(changerole);
		Thread.sleep(1000);
		usersPOM.clickChangeIt();
				
	    String expectedResult="Changed roles.";
        String actualResult=driver.findElement(By.xpath("//div[@id='message']//p")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        screenShot.captureScreenShot("RETC_074");
            
	}
}


