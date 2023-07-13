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
public class HomePage extends BasePage {

	WebDriver driver;

	// page objects
	By buyTicketLinkTxt = By.xpath("//a[contains(text(),'Buy Ticket')]");

	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public TicketBookingPage clickBuyTicket() {
		performClick(buyTicketLinkTxt);
		return new TicketBookingPage(driver);
	}
}