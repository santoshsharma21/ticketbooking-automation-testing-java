/**
 * 
 */
package com.ticketbooking.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Santosh Sharma
 *
 */
public class BasePage {

	// WebDriver driver;
	WebDriverWait wait;

	// constructor
	public BasePage(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	}

	public void performClick(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public void performSendKeys(By locator, String value) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void performSelectByText(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void performClickByValue(By locator, String value) {
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(value)) {
				element.click();
				break;
			}
		}
	}

}
