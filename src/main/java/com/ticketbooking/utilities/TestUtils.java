/**
 * 
 */
package com.ticketbooking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Santosh Sharma
 *
 */
public class TestUtils {

	public static String captureScreen(WebDriver driver, String img) {

		String dt = new SimpleDateFormat("dd.MM.yy_hh.mm.ss").format(new Date());
		String fileName = img + "_" + dt + "_" + ".png";
		String destPath = System.getProperty("user.dir") + "./screenshots/" + fileName;

		TakesScreenshot scr = (TakesScreenshot) driver;
		File sourcePath = scr.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(sourcePath, new File(destPath));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return destPath;
	}
}