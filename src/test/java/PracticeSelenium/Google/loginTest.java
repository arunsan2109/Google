package PracticeSelenium.Google;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import coreUtility.util;

public class loginTest {

	WebDriver driver;
	String url = "https://www.google.com";

	@Test(priority = 0)
	public void getLoginTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Learning\\Selenium\\chromedriver_97.exe");
		driver = new ChromeDriver();

		loginPage lPage = PageFactory.initElements(driver, loginPage.class);
		PageFactory.initElements(driver, util.class);

		driver.get(url);
		lPage.getGoogleSearch(driver, "gmail");

		Thread.sleep(5000);
		driver.close();
	}

}
