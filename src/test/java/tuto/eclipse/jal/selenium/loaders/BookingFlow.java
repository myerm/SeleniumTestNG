package tuto.eclipse.jal.selenium.loaders;

import tuto.eclipse.jal.constants.JALConstants;
import tuto.eclipse.jal.selenium.pageObjects.homePage.HomePage;

public class BookingFlow {

	public BookingFlow() {
		super();
		new MyDriver();
		MyDriver.driver.get(JALConstants.JAL_HOME_PAGE);
//		MyDriver.driver.get("http://www.fr.jal.co.jp/frl/en/?utm_source=google&utm_medium=search&utm_campaign=07_fr_eu_acquisition_general_435169997_27673035317_263326966681_201712&utm_term=e_japan%20airlines&sl=11_0030&gclid=Cj0KCQiA14TjBRD_ARIsAOCmO9ag8AeRyWlLKpqNLdMQHJMx2eNtKJCW_MfSh6oWWzDY6aD6wbCQlGIaAhBXEALw_wcB");
	}

	protected void homePageRun() {
		HomePage home = new HomePage();
		home.run();
	}

	protected void run() {
		homePageRun();
	}
}
