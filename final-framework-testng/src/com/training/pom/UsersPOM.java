package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UsersPOM {
private WebDriver driver; 
	
	public UsersPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(id="user-search-input")
	private WebElement searchuser;	
	
	@FindBy(xpath="//input[@id='search-submit']")
	private WebElement searchuserbttn;
	
	@FindBy(id="changeit")
	private WebElement clickchangeit;
	
	
    public void clickChangeIt() {
    	this.clickchangeit.click();
    }
	
    public void clickSearchUserBttn() {
        this.searchuserbttn.click();
    }	
	
	public void sendSearchUser(String searchuser) {
		this.searchuser.sendKeys(searchuser);
	}
	
	public void clickOnUsers() {
		WebElement users=driver.findElement(By.xpath("//div[contains(text(),'Users')]"));
		Actions act=new Actions(driver);
		act.moveToElement(users).click().build().perform();
	}
	
	public void clickOnAllUsers() {
		WebElement allusers=driver.findElement(By.xpath("//a[contains(text(),'All Users')]"));
		Actions act=new Actions(driver);
		act.moveToElement(allusers).click().build().perform();
	    }
	
	public void clickCheckBoxManzoorMehadi() {
    	boolean checkbox=driver.findElement(By.xpath("//tr[@id='user-337']//th[1]//input")).isSelected();
        System.out.println("remember checkbos is selected "+checkbox);
        driver.findElement(By.xpath("//tr[@id='user-337']//th[1]//input")).click();	
        }
	
	public void clickCheckBoxAlexHalse() {
    	boolean checkbox=driver.findElement(By.id("user_326")).isSelected();
        System.out.println("remember checkbos is selected "+checkbox);
        driver.findElement(By.id("user_326")).click();	
        }
	
	public void clickCheckBoxMariya() {
    	boolean checkbox=driver.findElement(By.id("user_327")).isSelected();
        System.out.println("remember checkbos is selected "+checkbox);
        driver.findElement(By.id("user_327")).click();	
        }
	
	public void clickCheckBoxCheckAll() {
    	boolean checkbox=driver.findElement(By.id("cb-select-all-1")).isSelected();
        System.out.println("remember checkbos is selected "+checkbox);
        driver.findElement(By.id("cb-select-all-1")).click();	
        }
	
	@FindBy(xpath="//div[@class='alignleft actions']//select[@id='new_role']")
	public WebElement changerole;
	
	public void selctFromChangeRoleToAgent() {
		WebElement role=driver.findElement(By.id("new_role"));
		Select selectValue=new Select(role);
		selectValue.selectByVisibleText("Agent");
		}
	
		public void selctFromChangeRoleToCustomer() {
		WebElement role=driver.findElement(By.id("new_role"));
		Select selectValue=new Select(role);
		selectValue.selectByVisibleText("Customer");
		}
		
		public void selctFromChangeRoleToShopManager() {
			WebElement role=driver.findElement(By.id("new_role"));
			Select selectValue=new Select(role);
			selectValue.selectByVisibleText("Shop manager");
			}
		
		@FindBy(linkText="Users")
		public WebElement userslink;
		public void clickuserslink() {
			this.userslink.click(); 
		}
		@FindBy(linkText="All Users")
		public WebElement alluserslink;
		public void clickalluserslink() {
			this.alluserslink.click(); 
		}
		@FindBy(id="user-search-input")
		public WebElement searchusertextbox;
		public void sendusersearchtextbox(String usersearchtext) {
			this.searchusertextbox.clear(); 
			this.searchusertextbox.sendKeys(usersearchtext); 
		}
		@FindBy(id="cb-select-all-1")
		public WebElement selectcommoncheckbox;
		public boolean clickcommoncheckboxbtn() {
			this.selectcommoncheckbox.click(); 
			return true;
		}
		
		@FindBy(id="search-submit")
		public WebElement searchuserbtn;
		public void clicksearchuserbtn() {
			this.searchuserbtn.click(); 
		}
		@FindBy(id="user_780")
		public WebElement selectcheckbox;
		public boolean clickmanzoorcheckboxbtn() {
			this.selectcheckbox.click(); 
			return true;
		}
		@FindBy(id="user_781")
		public WebElement selectcheckbox1;
		public boolean clickalexcheckboxbtn() {
			this.selectcheckbox1.click(); 
			return true;
		}
		@FindBy(id="user_782")
		public WebElement selectcheckbox2;
		public boolean clickmariyacheckboxbtn() {
			this.selectcheckbox2.click(); 
			return true;
		}
		
		
		@FindBy(id="changeit2")
		public WebElement changebtn;
		public void clickchangerolebtn() {
			this.changebtn.click(); 
		}
		
		
		


}
