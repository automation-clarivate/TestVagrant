package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestUtil {

	public WebDriver driver;
	private String chromeDriverInstance = "webdriver.chrome.driver";

	
	public void launchApplication(String url) {
		System.out.println("Launching the Application");
		setDriverPath();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (Exception e) {
			System.out.println("Wait method intterputed with error :: " + e); // To change body of catch statement use
																				// File | Settings | File Templates.
		}
	}
	
	
	public void waitforElement(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	

	public void setDriverPath() {
		
		String platform = System.getProperty("os.name");
		if (platform.contains("mac")) {
			System.setProperty(chromeDriverInstance, "chromedriver");	
			driver = new ChromeDriver();
			
		}
		if (platform.contains("Windows")) {
			System.setProperty(chromeDriverInstance, System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (platform.contains("linux")) {
			System.setProperty(chromeDriverInstance, "chromedriver_linux");
			driver = new ChromeDriver();
		}
	}
	
	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	
	public void pageRefresh(WebDriver driver) {
		driver.navigate().refresh();	
	}
	
	@SuppressWarnings("unused")
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void quitDriver() {

		driver.quit();
	}

	public void closeDriver() {

		driver.close();
	}
}
