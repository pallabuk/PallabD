package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Sign In']")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	@FindBy(id="post-query-submit")
	private WebElement filterBtn;
	
	public void clickFilterBtn() {
		this.filterBtn.click(); 
	}
	
	public void hoverOnProperties() {
		WebElement property=driver.findElement(By.xpath("//div[contains(text(),'Properties')]"));
	    Actions act=new Actions(driver);
	    act.moveToElement(property).build().perform();
		}
	
	public void clickOnAllProperties() {
		WebElement allproperty=driver.findElement(By.xpath("//a[contains(text(),'All Properties')]"));
		Actions act=new Actions(driver);
        act.moveToElement(allproperty).click().build().perform();
	   }
	
	public void selectFromAllDatea() {
		WebElement alldates=driver.findElement(By.id("filter-by-date"));
        Select selectValue = new Select(alldates);
        selectValue.selectByIndex(1);
	}
}
