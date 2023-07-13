/**
 * 
 */
package com.ticketbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Santosh Sharma
 *
 */
public class TicketBookingPage extends BasePage {

	WebDriver driver;

	// page objects
	private By ticketAndHotelBookinhBtn = By.xpath("//input[@id='product_3186']");
	private By fname = By.id("travname");
	private By lname = By.id("travlastname");
	private By dob = By.id("dob");
	private By month = By.xpath("//select[@aria-label='Select month']");
	private By year = By.xpath("//select[@aria-label='Select year']");
	private By date = By.xpath("//a[normalize-space()='6']");
	private By gender = By.xpath("//p[@id='sex_field']//span[@class='woocommerce-input-wrapper']/label");
	private By tripType = By.id("traveltype_1");
	private By fromCity = By.id("fromcity");
	private By toCity = By.id("tocity");
	private By departureDate = By.id("departon");
	private By departDay = By.xpath("//a[normalize-space()='18']");
	private By phoneNum = By.id("billing_phone");
	private By emailAddress = By.id("billing_email");
	private By country = By.id("billing_country");
	private By address1 = By.id("billing_address_1");
	private By city = By.id("billing_city");
	private By state = By.id("billing_state");
	private By postalCode = By.id("billing_postcode");
	private By placeOrderBtn = By.id("place_order");

	// constructor
	public TicketBookingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickBookingType() {
		performClick(ticketAndHotelBookinhBtn);
	}

	public void inputPassengerDetails(String firstName, String lastName, String sex) {
		performSendKeys(fname, firstName);
		performSendKeys(lname, lastName);
		performClick(dob);
		performSelectByText(month, "Feb");
		performSelectByText(year, "1990");
		performClick(date);
		performClickByValue(gender, sex);
	}

	public void inputTravelDetails(String sourceCity, String destCity) {
		performClick(tripType);
		performSendKeys(fromCity, sourceCity);
		performSendKeys(toCity, destCity);
		performClick(departureDate);
		performSelectByText(month, "Aug");
		performSelectByText(year, "2023");
		performClick(departDay);
	}

	public void inputBillingDetails(String phone, String mail, String countryName, String address, String cityName,
			String stateName, String pin) {
		performSendKeys(phoneNum, phone);
		performSendKeys(emailAddress, mail);
		performSelectByText(country, countryName);
		performSendKeys(address1, address);
		performSendKeys(city, cityName);
		performSelectByText(state, stateName);
		performSendKeys(postalCode, pin);
	}

	public PaymentPage clickPlaceOrder() {
		performClick(placeOrderBtn);
		return new PaymentPage(driver);
	}
}