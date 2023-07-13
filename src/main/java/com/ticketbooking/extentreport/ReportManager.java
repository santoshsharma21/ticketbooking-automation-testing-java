/**
 * 
 */
package com.ticketbooking.extentreport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.ticketbooking.utilities.ConfigReader;

/**
 * @author Santosh Sharma
 *
 */
public class ReportManager {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;

	public void setUpExtentReporter() {

		String dt = new SimpleDateFormat("dd.MM.yy_hh.mm.ss").format(new Date());
		String fileName = "Test-Report_" + dt + "_" + ".html";
		String destPath = System.getProperty("user.dir") + "./reports/" + fileName;

		sparkReporter = new ExtentSparkReporter(destPath);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("End To End Test Execution Report");
		sparkReporter.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST,
				ViewName.AUTHOR, ViewName.CATEGORY, ViewName.DEVICE }).apply();

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Project Name", "Online Ticket Booking");
		extentReports.setSystemInfo("Url", ConfigReader.prop.getProperty("url"));
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java", System.getProperty("java.version"));
	}
}