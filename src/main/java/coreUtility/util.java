package coreUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class util {

	
	/*
	 * Function to select browser
	 */

	/*
	 * Function to access edit box
	 */
	public static void getEditBox(WebDriver driver, WebElement searchElement, String userData) {

		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebDriverWait driverWait = new WebDriverWait(driver, 60);

			if (searchElement.isEnabled()) {
				//driverWait.until(ExpectedConditions.visibilityOf(searchElement));
				searchElement.sendKeys(userData);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	/*
	 * Function to select BRIC Button, Radio Button, Image and Check Box
	 */

	public static void getBRIC(WebDriver driver, WebElement searchElement) {

		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				WebDriverWait driverWait = new WebDriverWait(driver, 60);
				//driverWait.until(ExpectedConditions.visibilityOf(searchElement));
				searchElement.click();
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getDropdown(WebDriver driver,WebElement searchElement, String userData){
		
		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			if(searchElement.isEnabled()){
				WebDriverWait driverWait = new WebDriverWait(driver, 60);
				Select select = new Select(searchElement);
				if(!userData.equalsIgnoreCase("Null")||!userData.equalsIgnoreCase("NULL")){
					select.selectByVisibleText(userData);
				}
				else{
					select.selectByVisibleText(userData);
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
