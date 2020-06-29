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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC025Tests {
	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
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
		WebElement property=driver.findElement(By.xpath("//div[contains(text(),'Properties')]"));
	    Actions act=new Actions(driver);
	    act.moveToElement(property).build().perform();
	    //Thread.sleep(3000);
        WebElement allproperty=driver.findElement(By.xpath("//a[contains(text(),'All Properties')]"));
        act.moveToElement(allproperty).click().build().perform();
        //WebElement alldates=driver.findElement(By.id("filter-by-date"));
        //Select selectValue= new Select(alldates);
        //selectValue.selectByIndex(0);
        WebElement alldates=driver.findElement(By.id("filter-by-date"));
        Select selectValue = new Select(alldates);
        selectValue.selectByIndex(1);
        driver.findElement(By.id("post-query-submit")).click();
        String expectedResult="2020/06/29";
        String actualResult=driver.findElement(By.xpath("//tr[@id='post-9918']//abbr[contains(text(),'2020')]")).getText();
        Assert.assertEquals(actualResult, expectedResult);
            
	}
}

