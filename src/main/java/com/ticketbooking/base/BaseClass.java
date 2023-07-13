/**
 * 
 */
package com.ticketbooking.base;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ticketbooking.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Santosh Sharma
 *
 */
public class BaseClass {

	ConfigReader read = new ConfigReader();
	String baseUrl = read.getUrl();

	public static WebDriver driver;
	public static Logger log;

	public void initBrowser(String browserName) {

		log = Logger.getLogger("dummyticket");
		PropertyConfigurator.configure("log4j.properties");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Invalid Browser");
		}

		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}