package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends Page {
	static WebDriver driver;
	
	@FindBy(id="lst-ib")
	private static WebElement searchBar;
	@FindBy(id="gb_70")	
	private static WebElement signInButton;
	@FindBy(id="identifierId")
	private static WebElement emailSlot;
	@FindBy(id="identifierNext")
	private static WebElement next1;
	@FindBy(name="password")
	private static WebElement passSlot;
	@FindBy(id="passwordNext")
	private static WebElement next2;
	@FindBy(linkText="Gmail")
	private static WebElement gmail;
		
	public GoogleHomePage(WebDriver driver){
		super(driver);
		driver.get(getUrl());
		PageFactory.initElements(driver,this);
		
	}
	
	public static String getUrl(){
		return "https://www.google.com";
	}
	
	public static WebElement getSearchBar(){
		return searchBar;
	}
	
	public static WebElement getSignInButton() throws InterruptedException {
		sleepForXSeconds(1.5);
		return signInButton;
	}
	
	public static void initialize(){
		System.setProperty("webdriver.chrome.driver", "/Users/breinhard/Desktop/chromedriver");
		driver = new ChromeDriver();
	}
	
	public static void inputSearch(String search) {
		searchBar.sendKeys(search);
	}
	
	public static void sleepForXSeconds(double sec) throws InterruptedException{
		Thread.sleep((long) (1000*sec));
	}
	
	public WebElement getSignIn() throws InterruptedException{
		sleepForXSeconds(1.5);
		return signInButton;
	}
	
	public WebElement getEmail() throws InterruptedException{
		sleepForXSeconds(1.5);
		return emailSlot;
	}
	
	public WebElement getNextButton1() throws InterruptedException{
		sleepForXSeconds(1.5);
		return next1;
	}
	
	public WebElement getPassword() throws InterruptedException{
		sleepForXSeconds(1.5);
		return passSlot;
	}
	
	public WebElement getNextButton2() throws InterruptedException{
		sleepForXSeconds(1.5);
		return next2;
	}
	
	public static WebElement getGmail() throws InterruptedException{
		sleepForXSeconds(1.5);
		return gmail;
	}
	
	
	
	
}
