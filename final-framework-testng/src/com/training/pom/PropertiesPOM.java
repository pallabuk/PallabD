package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PropertiesPOM {
private WebDriver driver; 
	
	public PropertiesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="post-query-submit")
	private WebElement filterBtn;
	
	@FindBy(id="tag-name")
	private WebElement featureName;
	
	@FindBy(id="tag-slug")
	private WebElement slug;
	
	@FindBy(id="tag-description")
	private WebElement description;
	
	@FindBy(id = "submit")
	private WebElement submitBtn; 
	
	@FindBy(id = "doaction")
	private WebElement applyBtn;
	
	@FindBy(id = "tag-search-input")
	private WebElement fsearch;
	
	//@FindBy (xpath="//input[@type='submit' and @value='Search Features']")
	@FindBy (id = "search-submit")
	 private WebElement searchbtn;
	
	public void sendFeatureSearch(String fsearch) {
		this.fsearch.clear();
		this.fsearch.sendKeys(fsearch);
		}
	
	public void clickSearchFeatureBtn() throws InterruptedException {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	//Thread.sleep(10000);
		Actions act= new Actions(driver);
		act.moveToElement(this.searchbtn).click().perform();
		//act.sendKeys(Keys.ENTER);
		act.sendKeys(Keys.ENTER);
		//act.moveToElement(this.searchbtn).click().perform();
//		this.searchbtn.click();
	}
	
	public void clickOnApply() {
		this.applyBtn.click();
	}
	
	public void sendFeatureName(String featureName) {
		this.featureName.clear();
		this.featureName.sendKeys(featureName);
	}
	
	public void sendSlug(String slug) {
		this.slug.clear();
		this.slug.sendKeys(slug);
	}
	
	public void sendDescription(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	}
	
	public void clickFilterBtn() {
		this.filterBtn.click(); 
	}
	
	public void clickSubmitBtn() {
		this.submitBtn.click();
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
        
    public void clickCheckBox() {
    	boolean checkbox=driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr[1]/th[1]/input")).isSelected();
        System.out.println("remember checkbos is selected "+checkbox);
        driver.findElement(By.xpath("//table[@class='wp-list-table widefat fixed striped posts']/tbody/tr[1]/th[1]/input")).click();	
    }


    public void selectFromBulkActions() {
    	
    	WebElement bulkactions=driver.findElement(By.id("bulk-action-selector-top"));
        Select selectValue = new Select(bulkactions);
        selectValue.selectByIndex(2);
        }
        
    public void clickOnFeatures() {
    	WebElement features=driver.findElement(By.xpath("//a[contains(text(),'Features')]"));
    	Actions act=new Actions(driver);
        act.moveToElement(features).click().build().perform();
    
    }
    }
    

	


