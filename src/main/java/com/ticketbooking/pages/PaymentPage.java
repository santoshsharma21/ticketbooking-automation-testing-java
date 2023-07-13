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
public class PaymentPage extends BasePage {

	WebDriver driver;

	// page objects
	private By debitCard = By.xpath("//small[normalize-space()='Pay using any credit or debit card']");
	private By cardNumber = By.xpath("//input[@id='cardNumber']");
	private By cardExpiryDate = By.id("cardExpiry");
	private By cardCvv = By.xpath("//input[@id='cardCvv']");
	private By nameOnCard = By.xpath("//input[@id='cardOwnerName']");
	private By checkBox = By.xpath("//img[@class='check-box left']");
	private By proceedBtn = By.xpath("//span[normalize-space()='PROCEED']");

	// constructor
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public OrderConfirmationPage paymentProcess(String cardNum, String expiryDate, String cvv, String cardholderName) {
		performClick(debitCard);
		performSendKeys(cardNumber, cardNum);
		performSendKeys(cardExpiryDate, expiryDate);
		performSendKeys(cardCvv, cvv);
		performSendKeys(nameOnCard, cardholderName);
		performClick(checkBox);
		performClick(proceedBtn);
		return new OrderConfirmationPage(driver);
	}
}