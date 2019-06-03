package tuto.eclipse.testCases;


import org.testng.annotations.Test;

//import org.junit.Test;

import tuto.eclipse.jal.selenium.loaders.BookingFlow;
import tuto.eclipse.jal.selenium.loaders.MyDriver;

/**
 * Test to check the booking flow until payment page
 */
public class TestBookingJAL1 extends BookingFlow{
	
	@Test
	public void testBooking1() {
		this.run(); //run default tests from the BookingFlow
		MyDriver.quitDriver();
	}
	
	@Override
	protected void run() {
		
	}
}
