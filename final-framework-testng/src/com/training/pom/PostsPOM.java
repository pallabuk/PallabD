package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PostsPOM {
private WebDriver driver; 
	
	public PostsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(id="tag-name")
	private WebElement categoryName;
	
	
	@FindBy(id="tag-slug")
	private WebElement slug;
	
	@FindBy(id="tag-description")
	private WebElement description;
	
	@FindBy(id = "submit")
	private WebElement submitBtn; 
	
	@FindBy (id="search-submit")
	private WebElement searchbtn;
	
	@FindBy(id = "tag-search-input")
	private WebElement searchtext; 
	
	@FindBy(xpath = "//input[@name='post_title']")
	private WebElement entertitle;
	
	@FindBy(id="publish")
	private WebElement publish;
	
	@FindBy(xpath="//a[contains(text(),'Real Estate')]")
	private WebElement realstate;
	
	@FindBy(xpath="//input[@placeholder='Search here for Properties..']")
	private WebElement searchproperty;
	
	@FindBy(xpath="//a[@class='asl_res_url']")
	private WebElement vihar;
	
	public void clickOnVihar() {
		this.vihar.click();
	}
	
	public void sendSearchProperty(String searchproperty) {
		this.searchproperty.sendKeys(searchproperty);
	}
	
	public void clickOnReatEstate() {
		this.realstate.click();
	}
	
	public void clickPublish() {
		this.publish.click();
	}
	
	public void sendParagraph() {
		driver.switchTo().frame("content_ifr");
        driver.findElement(By.xpath("//body[@id='tinymce']//p")).sendKeys("New Launch in Plots");
        driver.switchTo().defaultContent();
	}
	
	public void clickCategoryCheckBox() {
    	boolean checkbox=driver.findElement(By.xpath("//label[@class='selectit']//input[@id='in-category-973']")).isSelected();
        System.out.println("remember checkbos is selected "+checkbox);
        driver.findElement(By.xpath("//label[@class='selectit']//input[@id='in-category-973']")).click();	
    }
	
	
	public void enterTitle(String entertitle) {
		this.entertitle.clear();
		this.entertitle.sendKeys(entertitle);
	    }
	
	public void sendCategoryName(String categoryName) {
		this.categoryName.clear();
		this.categoryName.sendKeys(categoryName);
	}
	
	public void sendCatgSlug(String slug) {
		this.slug.clear();
		this.slug.sendKeys(slug);
	}
	
	public void sendCatgDescription(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	}
	
	public void sendSearchText(String searchtext) {	
		this.searchtext.clear();
		this.searchtext.sendKeys(searchtext);
	}
	
	public void clickSubmitBtn() {
		this.submitBtn.click();
	}
	
	public void clickSearchBtn() {
		this.searchbtn.click();
	}
	
	public void hoverOnPosts() {
		WebElement posts=driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		Actions act=new Actions(driver);
	    act.moveToElement(posts).click().build().perform();
	    }
	
	public void hoverOnProfile() {
		WebElement profile=driver.findElement(By.xpath("//a[@class='ab-item']//span[contains(text(),'Pallab Dutta')]"));
		Actions act=new Actions(driver);
		act.moveToElement(profile).build().perform();
	    }
	
	public void clickOnLogOut() throws InterruptedException {
		WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
		Actions act=new Actions(driver);
		act.moveToElement(logout).click().build().perform();
		Alert alertpop=driver.switchTo().alert();
        Thread.sleep(1000);
        alertpop.accept();
	    }
	
	public void hoverOnPostsLink() {
		WebElement posts=driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		Actions act=new Actions(driver);
	    act.moveToElement(posts).build().perform();
	    }
	
	public void clickOnAddNewLink() {
		WebElement addnew=driver.findElement(By.xpath("//a[contains(text(),'Add New')]"));
		Actions act=new Actions(driver);
		act.moveToElement(addnew).click().build().perform();
	    }
	
	public void clickOnCategories() {
		WebElement category = driver.findElement(By.xpath("//a[contains(text(),'Categories')]"));
		Actions act = new Actions (driver);
		act.moveToElement(category).click().build().perform();
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
	
	public void selectFromParentCategory() {
		WebElement category = driver.findElement(By.id("parent"));
		Select selectValue=new Select(category);
		selectValue.selectByIndex(9);
	}
	
	public void refreshCurrentPage() {
		driver.navigate().refresh();
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
        driver.findElement(By.id("doaction")).click();
    }
        
    public void clickOnFeatures() {
    	WebElement features=driver.findElement(By.xpath("//a[contains(text(),'Features')]"));
    	Actions act=new Actions(driver);
        act.moveToElement(features).click().build().perform();
        }
     
    public void scrollingPage() throws InterruptedException {
    	 JavascriptExecutor js= (JavascriptExecutor)driver;
    	 js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    	 //js.executeScript("window.scrollBy(0,50)");
         //Thread.sleep(3000);
         //js.executeScript("window.scrollBy(0,50)");
         //Thread.sleep(3000);
         //js.executeScript("window.scrollBy(0,-50)");
         //Thread.sleep(3000);
         //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
         }
     
    public void scrollingDown() throws InterruptedException {
   	 JavascriptExecutor js= (JavascriptExecutor)driver;
   	 js.executeScript("window.scrollBy(0,50)");
   	 //Thread.sleep(3000);
   	 js.executeScript("window.scrollBy(0,50)");
   	 //Thread.sleep(3000);
   	 js.executeScript("window.scrollBy(0,-50)");
   	 //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    }


	
    

	

