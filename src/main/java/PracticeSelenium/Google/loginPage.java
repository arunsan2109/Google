package PracticeSelenium.Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import coreUtility.util;


public class loginPage {
	
	@FindBy(xpath="//input[@type='text']")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@type='submit' and @value='Google Search']")
	WebElement searchButton;

	WebDriver driver;
	
	public loginPage(WebDriver driver) {

		this.driver = driver;
	}

	
	public void getGoogleSearch(WebDriver driver, String userData){
		try{
				util.getEditBox(driver, searchBox, userData);
				util.getBRIC(driver, searchButton);	
		}
		catch(Exception e){
		
		}
	}

}
