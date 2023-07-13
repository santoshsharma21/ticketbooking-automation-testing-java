package com.ticketbooking.tests;

import org.testng.annotations.Test;

import com.ticketbooking.base.BaseClass;
import com.ticketbooking.pages.HomePage;
import com.ticketbooking.pages.OrderConfirmationPage;
import com.ticketbooking.pages.PaymentPage;
import com.ticketbooking.pages.TicketBookingPage;

import dataprovider.DataProviders;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TicketBookingTest extends BaseClass {

	HomePage homePage;
	TicketBookingPage ticketBookingPage;
	PaymentPage paymentPage;
	OrderConfirmationPage orderConfirmationPage;

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		initBrowser(browser);
	}

	@Test(dataProvider = "bookingDetails", dataProviderClass = DataProviders.class)
	void oneWayTicketBookingTest(String fname, String lname, String sex, String scity, String dcity, String phone,
			String email, String ctry, String address, String city, String state, String pin, String cNum,
			String cexpiry, String cvv, String cardholderName) {
		homePage = new HomePage(driver);
		ticketBookingPage = homePage.clickBuyTicket();
		log.info("clicked on byticket");
		ticketBookingPage.clickBookingType();
		log.info("selected booking type");
		ticketBookingPage.inputPassengerDetails(fname, lname, sex);
		log.info("added passenger details");
		ticketBookingPage.inputTravelDetails(scity, dcity);
		log.info("added travel details");
		ticketBookingPage.inputBillingDetails(phone, email, ctry, address, city, state, pin);
		log.info("added billing details");
		paymentPage = ticketBookingPage.clickPlaceOrder();
		log.info("clicked on place order button");
		orderConfirmationPage = paymentPage.paymentProcess(cNum, cexpiry, cvv, cardholderName);
		log.info("added card details for payment");
		boolean status = orderConfirmationPage.verifyBooking("Thank you. Your order has been received.");
		log.info("verifying booking");

		if (status == true) {
			Assert.assertTrue(true);
			log.info("Passed");
		} else {
			log.info("Failed");
			Assert.assertTrue(false);
		}
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
