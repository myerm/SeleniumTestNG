package tuto.eclipse.jal.selenium.ng.pageObjects;

import java.time.LocalDate;

import org.apache.bcel.generic.GETSTATIC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import tuto.eclipse.jal.selenium.pageObjects.homePage.HomePageIDs;

public class HomePageNG {

	// CONSTANTS for the SELECTORS are defined in pageObjects.HomePage.HomePageIDs

	/*
	 * ACTIONS
	 */
	public static void closeModal(WebDriver driver) {
		driver.findElements(By.cssSelector(HomePageIDs.MODAL_CLOSE_BUTTON_CSS)).get(1).click();
	}

	public static void selectDepartureCity(String cityCode, WebDriver driver) {
		Select s = new Select(driver.findElement(By.id(HomePageIDs.DEPARTURE_FROM_CITY_ID)));
		s.selectByValue(cityCode);
	}

	public static void setDepartureDate(LocalDate ld, WebDriver driver) {
		Select selector = new Select(driver.findElement(By.id(HomePageIDs.DEPARTURE_DATE_1_MONTH)));
		selector.selectByValue(String.valueOf(ld.getMonthValue()));
		selector = new Select(driver.findElement(By.id(HomePageIDs.DEPARTURE_DATE_1_DAY)));
		selector.selectByValue(String.valueOf(ld.getDayOfMonth()));
	}

	public static void setReturnDate(LocalDate ld, WebDriver driver) {
		Select selector = new Select(driver.findElement(By.id(HomePageIDs.DEPARTURE_DATE_2_MONTH)));
		selector.selectByValue(String.valueOf(ld.getMonthValue()));
		selector = new Select(driver.findElement(By.id(HomePageIDs.DEPARTURE_DATE_2_DAY)));
		selector.selectByValue(String.valueOf(ld.getDayOfMonth()));
	}

	public static void continueToNextPage(WebDriver driver) {
		driver.findElement(By.id(HomePageIDs.CONTINUE_BUTTON_ID)).click();
	}

	public static String getDepartureArea(WebDriver driver) {
		Select selector = new Select(driver.findElement(By.id(HomePageIDs.DEPARTURE_FROM_AREA_ID)));
		return selector.getFirstSelectedOption().getText();
	}

}
