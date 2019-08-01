package PageFactory;

import utility.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelBookingTest extends TestUtil {

	WebDriver driver;

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	WebElement localityTextBox;

	@FindBy(xpath = "(//li[@class='list']//a)[1]")
	WebElement searchResult;

	@FindBy(xpath = "//a[contains(@class,'highlight')]")
	WebElement toDaydate;

	@FindBy(xpath = "//a[contains(@class,'state-active')]//ancestor::tr//following-sibling::tr[1]//td[2]")
	WebElement endDate;

	@FindBy(id = "SearchHotelsButton")
	WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	WebElement travellerSelection;

	public HotelBookingTest(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public void shouldBeAbleToSearchForHotels() {

		pageRefresh(driver);
		waitforElement(driver, hotelLink);
		hotelLink.click();
		localityTextBox.sendKeys("Indiranagar, Bangalore");

		waitFor(3000);
		waitforElement(driver, searchResult);
		searchResult.click();

		waitFor(300);
		waitforElement(driver, toDaydate);
		toDaydate.click();
		
		waitforElement(driver, endDate);
		endDate.click();
		
		waitforElement(driver, searchButton);
		searchButton.click();
		
		System.out.println("Hotel Results Displayed");

	}
}
