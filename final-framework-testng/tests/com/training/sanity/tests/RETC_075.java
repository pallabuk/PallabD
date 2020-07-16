//Test Objective: To verify whether application allows admin to add new category while adding new post & same getting displayed on home screen for user

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class RETC_075 {

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
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("pallabuk1@gmail.com");
		loginPOM.sendPassword("password@12345");
		loginPOM.clickLoginBtn(); 
		postsPOM.hoverOnPostsLink();		//Hover on Posts link
		postsPOM.clickOnAddNewLink();       //Click on Add New link 
		postsPOM.clickOnCategories();		//Click on Categories link
		postsPOM.sendCategoryName("Plots101");  	//Enter Valid Credentials in Name textbox
		Thread.sleep(1000);
		postsPOM.sendCatgSlug("Plots");			//Enter Valid Credentials in Slug textbox
		Thread.sleep(1000);
		postsPOM.selectFromParentCategory();			// Select value from Parent Category list box
		Thread.sleep(1000);
		postsPOM.sendCatgDescription("New Launches of villas, apartments, flats");		//Enter Valid Credentials in Description textbox
		postsPOM.clickSubmitBtn();		//Click on Add New Category button
		Thread.sleep(1000);
		postsPOM.refreshCurrentPage();  //refresh the page
		postsPOM.scrollingPage();
		postsPOM.sendSearchText("Plots101");
		postsPOM.clickSearchBtn();
		postsPOM.clickOnAddNewLink();
		postsPOM.enterTitle("vihar");			
		postsPOM.sendParagraph();
		postsPOM.clickCategoryCheckBox();
		postsPOM.clickPublish();		// Click on Publish button
		postsPOM.hoverOnProfile();
		postsPOM.clickOnLogOut();		// Click on Logout
		postsPOM.clickOnReatEstate();	// Click on Real Estate icon
		postsPOM.sendSearchProperty("vihar");
		postsPOM.clickOnVihar();		
		postsPOM.scrollingPage();
		
	    String expectedResult="New Launches111";
        String actualResult=driver.findElement(By.xpath("//tr[@id='tag-1418']//td[1]//strong//a")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        screenShot.captureScreenShot("RETC_075");
            
	}
}




