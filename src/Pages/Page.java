package Pages;

import org.openqa.selenium.WebDriver;

public class Page {
	
	protected static WebDriver driver;
	public Page(WebDriver driver){
		this.driver = driver;
	}
	
	public void waitFor20Seconds(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
