
package com.ofizer.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverManager {

	public static String browserName;
	public static String browserVersion;
	public static String _OS_Name;
	public static String _OS_Version;
	public static String environment;
	public static String location;
	public static String appURL;
	private WebDriver driver;
	private ConfigReader configReader = ConfigReader.getInstance();

	public WebDriverManager() {
		initialSetUp();
	}

	public void initialSetUp() {
		setBrowserName();
		setEnvironment();
		setAppURL();
		setExecutionLocation();
		setOSName();
		setBrowserVersion();
		setBrowserVersion();
		setOSVersion();
	}

	public void setBrowserName() {
		if (System.getProperty("browser") != null)
			browserName = System.getProperty("browser");
		else
			browserName = configReader.getBrowserName();
	}

	public void setEnvironment() {
		if (System.getProperty("browser") != null)
			environment = System.getProperty("environment");
		else
			environment = configReader.getEnvironment();
	}

	public void setExecutionLocation() {
		if (System.getProperty("browser") != null)
			location = System.getProperty("location");
		else
			location = configReader.getExecutionLocation();
	}

	public void setOSName() {
		if (location == null)
			throw new RuntimeException("Location value needs to be set before setting OS name");
		if (location.equalsIgnoreCase("local")) {
			_OS_Name = getLocalOSName();
		} else if (location.equalsIgnoreCase("remote")) {
			if (System.getProperty("os.name") != null)
				_OS_Name = System.getProperty("os.name");
			else
				_OS_Name = configReader.getOSName();
		} else {
			throw new RuntimeException("Invaliad location value, acceptable values can be local/remote");
		}
		System.out.println("Local OS: " + _OS_Name);
	}

	public void setBrowserVersion() {
		if (location.equalsIgnoreCase("remote")) {
			if (System.getProperty("browser.version") != null)
				browserVersion = System.getProperty("browser.version");
			else
				browserVersion = configReader.getBrowserVersion();
		}
	}

	public void setOSVersion() {
		if (location.equalsIgnoreCase("remote")) {
			if (System.getProperty("os.version") != null)
				_OS_Version = System.getProperty("os.version");
			else
				_OS_Version = configReader.getOSVersion();
		}
	}

	public void setAppURL() {
		if (environment == null)
			setEnvironment();
		appURL = configReader.getAppURL();
	}

	public WebDriver browserSetUp() {
		if (location.equalsIgnoreCase("local")) {
			if (_OS_Name.toUpperCase().contains("WINDOWS")) {
				setBrowserForWindows(browserName);
			} else if (_OS_Name.toUpperCase().contains("OS X")) {
				setBrowserForMac(browserName);
			} else {
				throw new RuntimeException(
						"Tests are designed to work on " + "WINDOWS/OS X when selected to executed on local");
			}
		} else {
			setUpRemoteBrowser("GIVE GIRD URL HERE");
		}
		return driver;
	}

	public void setBrowserForWindows(String browserName) {
		String baseDriverPath = configReader.getDriversLocationForWindows();
		switch (browserName.toUpperCase()) {
		case "CHROME":
			String chromeDriverPath = baseDriverPath + "/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			String firefoxDriverPath = baseDriverPath + "/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Automated  tests can run only on Chrome/Firefox browsers on Windows OS. "
					+ "Please change the browser selection");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get(appURL);
	}

	public void setBrowserForMac(String browserName) {
		String baseDriverPath = configReader.getDriversLocationForMac();
		switch (browserName.toUpperCase()) {
		case "CHROME":
			String chromeDriverPath = baseDriverPath + "/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			String firefoxDriverPath = baseDriverPath + "/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
			break;
		case "SAFARI":
			driver = new SafariDriver();
			break;
		default:
			throw new RuntimeException("Automated  tests can run only on Chrome/Firefox browsers on Windows OS. "
					+ "Please change the browser selection");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appURL);
	}

	public void setUpRemoteBrowser(String gridURL) {
		throw new RuntimeException("GIRD not implemented yet");
	}

	public String getLocalOSName() {
		return System.getProperty("os.name");
	}

}
