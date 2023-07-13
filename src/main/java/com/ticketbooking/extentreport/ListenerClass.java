/**
 * 
 */
package com.ticketbooking.extentreport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.ticketbooking.base.BaseClass;
import com.ticketbooking.utilities.TestUtils;

/**
 * @author Santosh Sharma
 *
 */
public class ListenerClass extends ReportManager implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		setUpExtentReporter();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.assignAuthor("SANTOSH");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			try {
				extentTest.log(Status.PASS,
						MarkupHelper.createLabel(result.getName() + " - PASSED", ExtentColor.GREEN));
				extentTest.info(MarkupHelper.createLabel("Screenshot Attached", ExtentColor.GREY));
				String imgPath = TestUtils.captureScreen(BaseClass.driver, result.getName());
				extentTest.pass(MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String trace = result.getThrowable().getMessage().replaceAll(",", "<br>");
			String formatedTrace = "<details><summary>Exception Details</summary>" + trace + "</deatils>";
			try {
				extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - FAILED", ExtentColor.RED));
				// extentTest.log(Status.FAIL, MarkupHelper.createLabel(formatedTrace,
				// ExtentColor.RED));
				extentTest.fail(formatedTrace);
				extentTest.info(MarkupHelper.createLabel("Screenshot Attached", ExtentColor.GREY));
				String imgPath = TestUtils.captureScreen(BaseClass.driver, result.getName());
				extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - SKIPED", ExtentColor.YELLOW));
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
}