package tuto.eclipse.jal.selenium.ng.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tuto.eclipse.jal.selenium.pageObjects.avaiPage.AvaiPageIDs;

public class AvaiPageNG {
	
	// CHECKs
	
	public static void waitForPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(AvaiPageIDs.LOGIN_RADIO_BUTTON_ID)));
	}

}
