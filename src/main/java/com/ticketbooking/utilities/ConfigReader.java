/**
 * 
 */
package com.ticketbooking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Santosh Sharma
 *
 */
public class ConfigReader {

	public static Properties prop;

	public ConfigReader() {

		File file = new File(System.getProperty("user.dir") + "/configurations/config.properties");

		try {
			FileInputStream fileinput = new FileInputStream(file);
			prop = new Properties();
			prop.load(fileinput);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return prop.getProperty("url");
	}
}