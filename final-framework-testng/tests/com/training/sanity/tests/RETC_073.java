//Test Objectiv: To Verify whether application allows multiple user to send the query in Contact Form Page & data should get displayed in database


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
import com.training.pom.LaunchPOM;
import com.training.pom.LoginPOM;
import com.training.pom.UsersPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_073 {

	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
	public LaunchPOM launchPOM;
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
		launchPOM=new LaunchPOM(driver);
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
	
	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void validLoginTest(String name, String email, String subject, String message) throws InterruptedException {
		launchPOM.clickOnLanuch();		// Click on New Launch tab
		launchPOM.sendAdress("New Launches");
		Thread.sleep(1000);
		launchPOM.clickLoginBtn();
		launchPOM.scrolingPage();
		launchPOM.clickDropUsLine();			// Click on Drop Us a Line link in Got Any Question? Section
		launchPOM.sendYourName(name);			// Fetching data from db "realstate101", table "launch01"in Your Name textbox
		launchPOM.sendYourEmail(email);			// Fetching data from db "realstate101", table "launch01" in Your Email textbox
		launchPOM.sendEmailSubject(subject); 	// Fetching data from db "realstate101", table "launch01" in Subject textbox
		launchPOM.sendEmailMessage(message);	// Fetching data from db "realstate101", table "launch01" in Your Message textbox	
		launchPOM.clickOnSend();				// Click on Send button
		
		String expectedResult="Thanks you for your message";
        String actualResult=driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        screenShot.captureScreenShot("RETC_073");
		
	}
}



