//Test Objective: TO verify whether application allows admin to add post based on the created category
//Test Case Name: RETC_039
//Test Result: Passed


package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.PostsPOM;
import com.training.pom.PropertiesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC039Tests {
	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
	public PropertiesPOM propertiesPOM;
	public PostsPOM postsPOM;
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
	    postsPOM = new PostsPOM(driver);
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
		screenShot.captureScreenShot("First");
		postsPOM.hoverOnPosts();		//Click on Posts link
		postsPOM.clickOnCategories();	//Click on Categories link
		postsPOM.sendCategoryName("New Launches111");  	//Enter Valid Credentials in Name textbox
		postsPOM.sendCatgSlug("Launches111");			//Enter Valid Credentials in Slug textbox
		postsPOM.sendCatgDescription("New Launches of villas, apartments, flats");		//Enter Valid Credentials in Description textbox
		postsPOM.clickSubmitBtn();		//Click on Add New Category button
		postsPOM.sendSearchText("New Launches111");
		postsPOM.clickSearchBtn();
		Thread.sleep(1000);
		
	    String expectedResult="New Launches111";
        String actualResult=driver.findElement(By.xpath("//tr[@id='tag-1418']//td[1]//strong//a")).getText();
        Assert.assertEquals(actualResult, expectedResult);
            
	}
}



