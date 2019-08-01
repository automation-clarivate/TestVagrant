package TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageFactory.*;
import utility.TestUtil;

public class RunnerClass extends TestUtil {

	SignInTest sign;
	HotelBookingTest hotel;
	FlightBookingTest flight;

	private final String ApplicationURL = "https://www.cleartrip.com/";

	@BeforeClass

	public void launchUrl() {
		launchApplication(ApplicationURL);
	}

	@Test(priority = 0)
	public void LoginTest() {

		sign = new SignInTest(driver);
		sign.shouldThrowAnErrorIfSignInDetailsAreMissing();
		System.out.println("Sign-in Test Case Completed");
	}

	@Test(priority = 1)
	public void FlightBookingTest() {
		System.out.println("Flight Booking Test Case Running");
		flight = new FlightBookingTest(driver);
		
		
		System.out.println("Flight Booking Test Case Completed");

	}

	@Test(priority = 2)
	public void HotelBookingTest() {
		System.out.println("Hotel Booking Test Case Running");
		hotel = new HotelBookingTest(driver);
		hotel.shouldBeAbleToSearchForHotels();
		
		System.out.println("Hotel Booking Test Case Completed");

	}

	@AfterClass
	public void TearDown() {
		quitDriver();
	}

}
