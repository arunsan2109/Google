package coreUtility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utility {

	static WebDriver driver;
	static String scenarioName;

	/*
	 * Driver initiation
	 */
	public utility(WebDriver driver) {
		utility.driver = driver;
	}

	/*
	 * Function to initiate the browser Internet explorer, chrome, firefox
	 */
	public static WebDriver getBrowser(String browserName, String url) {

		try {
			if (browserName.equalsIgnoreCase("internetExplorer") || (browserName.equalsIgnoreCase("ie"))) {
				System.setProperty("webdriver.ie.driver",
						"D:\\Learning\\Selenium\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe");
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				WebDriver driver = new InternetExplorerDriver(caps);
				// driver = new InternetExplorerDriver();
				driver.get(url);
				return driver;
			} else if (browserName.equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko.driver", "C:\\Users\\as7060\\Desktop\\UAT SystemX\\Selenium\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(url);
				return driver;
				
			} else
				
				driver = new ChromeDriver();
				driver.get(url);
				return driver;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * Scenario initiation
	 */
	public static void getTestCaseName(String scenarioNameUser) {
		scenarioName = scenarioNameUser;

	}

	/*
	 * Function to capture screen shots
	 */
	public static boolean getScreenshots(String screenshotname) {

		try {
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			TakesScreenshot ts = (TakesScreenshot) driver;

			File file = ts.getScreenshotAs(OutputType.FILE);
			String time = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
			FileUtils.copyFile(file, new File("./screenshot/" + scenarioName + "/" + screenshotname + " " + time + ".png"));
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Function to access edit box
	 */
	public static boolean getEditBoxElement(WebElement searchElement, String userData) {

		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebDriverWait driverWait = new WebDriverWait(driver, 60);
			if (searchElement.isEnabled()) {
				//driverWait.until(ExpectedConditions.visibilityOf(searchElement));
				searchElement.sendKeys(userData);
				return true;

			} else {
				System.out.println("Edit Box Not Found");
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	/*
	 * Function to access edit box mask
	 */
		public static boolean getEditBoxElementMask(WebElement searchElement, String userData)
				 {

			try {
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				WebDriverWait driverWait = new WebDriverWait(driver, 60);
				
				if (searchElement.isEnabled()) {
					//driverWait.until(ExpectedConditions.visibilityOf(searchElement));

					int cvv = Integer.parseInt(userData);
					int length = (int) Math.log10(cvv) + 1;
					String[] j = new String[length];

					for (int i = length; i >= 1; i--) {
						int z = i - 1;
						int x = cvv % 10;
						j[z] = Integer.toString(x);
						int a = cvv / 10;
						cvv = a;
						z = z--;
					}

					for (int i = 0; i < length; i++) {
						searchElement.sendKeys(j[i]);
						Thread.sleep(200);
					}
					return true;
				}
				else
					System.out.println("Edit box is not enable");
				return false;
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}

	/*
	 * Function to access the Web Button, Radio Button, Image, Check box
	 */
	public static boolean getBRIC(WebElement searchElement) {

		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebDriverWait driverWait = new WebDriverWait(driver, 60);
			if (searchElement.isEnabled()) {
				//driverWait.until(ExpectedConditions.visibilityOf(searchElement));
				searchElement.click();
				return true;
			} else {
				System.out.println("BRIC Element Not Found");
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Function to access the drop down
	 */
	public static boolean getDropdown(WebElement searchElement, String userData) {
		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebDriverWait driverWait = new WebDriverWait(driver, 60);
			if (searchElement.isEnabled()) {
				//driverWait.until(ExpectedConditions.visibilityOf(searchElement));
				Select select = new Select(searchElement);
				if (!userData.equalsIgnoreCase("null")) {
					select.selectByVisibleText(userData);
					return true;
				} else {
					System.out.println("null value selected");
					return true;
				}
			} else {
				System.out.println("Dropdown Element Not Found");
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Function to access the drop down by Index
	 */
	public static boolean getDropdownIndex(WebElement searchElement, int userData) {
		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebDriverWait driverWait = new WebDriverWait(driver, 60);
			if (searchElement.isEnabled()) {
				//driverWait.until(ExpectedConditions.visibilityOf(searchElement));
				Select select = new Select(searchElement);
				select.selectByIndex(userData);
				return true;
			} else {
				System.out.println("Dropdown not found");
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Function to get the List WebElement type
	 */
	public static List<WebElement> getElements(String elementXpath) {

		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			List<WebElement> elementList = driver.findElements(By.xpath(elementXpath));
			return elementList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
