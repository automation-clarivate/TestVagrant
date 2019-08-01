package PageFactory;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.TestUtil;

public class SignInTest extends TestUtil {

	WebDriver driver;

	@FindBy(xpath = "//span[contains(text(),'Your trips')]")
	WebElement yourTrips;

	@FindBy(xpath = "//input[@title='Sign In']")
	WebElement signIn;

	@FindBy(xpath = "//button[@id='signInButton']")
	WebElement signInButton;

	@FindBy(xpath = "//iframe[@name='modal_window']")
	WebElement signInPopIframe;

	@FindBy(id = "errors1")
	WebElement error;

	public SignInTest(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		System.out.println("SignIn Test Scenario initiated");

		pageRefresh(driver);
		waitforElement(driver, yourTrips);
		yourTrips.click();

		waitforElement(driver, signIn);
		signIn.click();

		waitforElement(driver, signInPopIframe);
		switchToFrame(driver, signInPopIframe);

		waitforElement(driver, signInButton);
		signInButton.click();

		waitFor(5000);
		waitforElement(driver, error);
		assertTrue(error.isDisplayed());

	}

}
