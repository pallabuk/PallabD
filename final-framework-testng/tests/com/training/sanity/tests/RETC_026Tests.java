//Test Objective: TO Verify whether application allows admin to move properties details into trash.
//Test Case Name: RETC_026
//Test Result: Passed.

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.PropertiesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_026Tests {
	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
	public PropertiesPOM propertiesPOM;
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
		propertiesPOM = new PropertiesPOM(driver);
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
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("pallabuk1@gmail.com");
		loginPOM.sendPassword("password@12345");
		loginPOM.clickLoginBtn();
		Thread.sleep(3000);
		propertiesPOM.hoverOnProperties(); 			//Click on Properties link
		propertiesPOM.clickOnAllProperties();		//Click on All Properties link
        propertiesPOM.clickCheckBox(); 				//Click on the checkbox beside the Property details 
		propertiesPOM.selectFromBulkActions();		//Click on Bulk Actions list box
		propertiesPOM.clickOnApply();				//Click on Apply button
		Thread.sleep(3000);
        String expectedResult="1 post moved to the Trash. Undo";
        String actualResult=driver.findElement(By.xpath("//p[contains(text(),'1 post moved to the Trash.')]")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        screenShot.captureScreenShot("RETC026");
            
	}
}


