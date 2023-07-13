/**
 * 
 */
package dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.ticketbooking.utilities.ExcelUtils;

/**
 * @author Santosh Sharma
 *
 */
public class DataProviders {

	String excelPath = System.getProperty("user.dir") + "/src/test/resources/testdata/ticket_details.xlsx";

	@DataProvider(name = "bookingDetails")
	public String[][] getTestData() throws IOException {

		ExcelUtils xlutils = new ExcelUtils(excelPath);
		int nrows = xlutils.getRowCount("Sheet1");
		int ncells = xlutils.getCellCount("Sheet1", nrows);

		String[][] data = new String[nrows][ncells];
		for (int row = 1; row <= nrows; row++) {
			for (int col = 0; col < ncells; col++) {
				data[row - 1][col] = xlutils.getCellData("Sheet1", row, col);
			}
		}
		return data;
	}
}