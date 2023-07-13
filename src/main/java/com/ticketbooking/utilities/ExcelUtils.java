/**
 * 
 */
package com.ticketbooking.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Santosh Sharma
 *
 */
public class ExcelUtils {

	private FileInputStream fi;
	private XSSFWorkbook wb;
	private XSSFSheet ws;
	private XSSFRow row;
	private XSSFCell cell;

	private String path;

	public ExcelUtils(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		int nrows = ws.getLastRowNum();
		wb.close();
		fi.close();
		return nrows;
	}

	public int getCellCount(String sheetName, int rownum) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		int ncells = row.getLastCellNum();
		wb.close();
		fi.close();
		return ncells;
	}

	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		cell = row.getCell(cellnum);

		String data = null;
		DataFormatter dformat = new DataFormatter();

		try {
			data = dformat.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		return data;
	}
}