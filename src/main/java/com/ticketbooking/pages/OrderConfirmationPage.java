/**
 * 
 */
package com.ticketbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Santosh Sharma
 *
 */
public class OrderConfirmationPage extends BasePage {

	WebDriver driver;

	// page objects
	private By confirmationMessage = By.xpath("//h3[normalize-space()='Thank you. Your order has been received.']");

	// constructor
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean verifyBooking(String expectedOutcome) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(confirmationMessage));
		String actualText = element.getText();
		boolean status;
		if (actualText.equals(expectedOutcome)) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}
}