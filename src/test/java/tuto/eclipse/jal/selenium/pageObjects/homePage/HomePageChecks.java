package tuto.eclipse.jal.selenium.pageObjects.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tuto.eclipse.jal.selenium.loaders.BookingFlow;
import tuto.eclipse.jal.selenium.loaders.MyDriver;

public class HomePageChecks {
	
	public HomePageChecks() {
		
	}
	
	/*
	 * CHECKS
	 */
	
	protected void waitForThePage() {
		WebDriverWait wait = new WebDriverWait(MyDriver.driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(HomePageIDs.MODAL_CLOSE_BUTTON_CSS)));
//		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
	
	protected String getPageTitle() {
		return MyDriver.driver.getTitle();
	}
}
