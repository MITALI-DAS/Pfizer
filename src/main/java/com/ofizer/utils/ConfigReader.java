package com.ofizer.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {
	
	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir") + "//config.properties";

	public ConfigReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occurred while reading config file: " + propertyFilePath);
		}
	}

	static ConfigReader configReader = new ConfigReader();
	

	public static ConfigReader getInstance() {
		return configReader;
	}
	
	public String getValueIfNotNull(String key) {
		String returnedValue = properties.getProperty(key);
		if(returnedValue == null || returnedValue.equals("")) 
			throw new RuntimeException("Null or Empty value is returned for the key: " + key + " from property file: " + propertyFilePath);
		return returnedValue;
	}
	
	public String getBrowserName() {
		String browserName = getValueIfNotNull("browser");
		return browserName;
	}
	
	public String getBrowserVersion() {
		String browserVersion = getValueIfNotNull("browser.version");
		return browserVersion;
	}
	
	public String getOSName() {
		String _OSName = getValueIfNotNull("os.name");
		return _OSName;
	}
	
	public String getOSVersion() {
		String _OSVersion = getValueIfNotNull("os.version");
		return _OSVersion;
	}
	
	public String getEnvironment() {
		String environment = getValueIfNotNull("environment");
		return environment;
	}
	
	public String getExecutionLocation() {
		String location = getValueIfNotNull("location");
		return location;
	}
	
	public String getScreenshotFlag() {
		String screenshotFlag = getValueIfNotNull("captureScreenshots");
		return screenshotFlag;
	}
	
	public String getDriversLocationForWindows() {
		String driverPath = getValueIfNotNull("windows.drivers");
		return driverPath;
	}
	
	public String getDriversLocationForMac() {
		String driverPath = getValueIfNotNull("mac.drivers");
		return driverPath;
	}
	
	public String getAppURL() {
		String environment = getEnvironment();
		String application = getApplicationUnderTest();
		String appURL = getValueIfNotNull(application + "-" + environment);
		return appURL;
	}
	
	public String getApplicationUnderTest() {
		String application = System.getProperty("application");
		if(application != null)
			return application;
		application	= getValueIfNotNull("application");
		return application;
	}
}