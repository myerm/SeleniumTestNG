package tuto.eclipse.jal.selenium.ng;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tuto.eclipse.jal.constants.JALConstants;
import tuto.eclipse.jal.selenium.ng.pageObjects.AvaiPageNG;
import tuto.eclipse.jal.selenium.ng.pageObjects.HomePageNG;

public class TestBookingNG {
	private static final String PATH_CHROME_DRIVER = "C:\\Users\\formation\\Documents\\ChromeDrivers\\chromedriver.exe";
	private static final String HOME_PAGE = "> HOME_PAGE > Checks > ";
	private static final String EXPECTED_PAGE_TITLE = "JAPAN AIRLINES (JAL) - France Region - Airfare to Japan (Tokyo)";
	private static final String WRONG_EXPECTED_PAGE_TITLE = "JAPAN AIRLINES (JL) - France Region - Airfare to Japan (Tokyo)";
	public static WebDriver driver;
	private static SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void loadTheDriver() {
		System.out.println("Launching tests from : " + System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=0)
	public void verifyHomepageTitle() {
		driver.get(JALConstants.JAL_HOME_PAGE);
		String actualTitle = driver.getTitle();
//		softAssert.assertEquals(actualTitle, WRONG_EXPECTED_PAGE_TITLE, HOME_PAGE + "The title of the page does not match as expected"); //assert from testng
		softAssert.assertEquals(actualTitle, EXPECTED_PAGE_TITLE, HOME_PAGE + "The title of the page does not match as expected"); //assert from testng
		Assert.assertEquals(actualTitle, EXPECTED_PAGE_TITLE, HOME_PAGE + "The title of the page does not match >> ERROR");
		String actualArea = HomePageNG.getDepartureArea(driver);
		System.out.println(HOME_PAGE + "We got until HERE!!");
		softAssert.assertEquals(actualArea, "France");
		softAssert.assertAll();
	}
	
	@Test(priority=1)
	public void verifyWeFindFlights() {
		driver.get(JALConstants.JAL_HOME_PAGE);
		defaultHomePageOperations();
		AvaiPageNG.waitForPage(driver);
	}
	
	private void defaultHomePageOperations() {
		//Close the modal window
		HomePageNG.closeModal(driver);
		// Select Nice as departure city
		HomePageNG.selectDepartureCity("NCE", driver);
		// Set a departure date in 2 months
		LocalDate departureDate = LocalDate.now().plusMonths(2);
		HomePageNG.setDepartureDate(departureDate, driver);
		// Set a return date in 3 months
		HomePageNG.setReturnDate(departureDate.plusMonths(1), driver);
		
		//Continue to the following page
		HomePageNG.continueToNextPage(driver);		
	}
	
	@AfterTest
	public void closeTheDriver() {
		pausa(5); // Only for tuning the test and check the final screen
		driver.close();
	}
	
	private void pausa(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
