package com.ofizer.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonMethods {

	WebDriver driver;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTextFromElement(WebElement element) {
		String text = "";
		try {
			text = element.getText();
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return text;
	}
	
	public String getElementAttibValue(WebElement element, String attribute) {
		String text = "";
		try {
			text = element.getAttribute(attribute);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return text;
	}

	public void clickElement(WebElement element) {
		try {
			element.click();
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			throw new RuntimeException("Element you are trying to access does not exist on the page");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occurred while clicking a web element");
		}
	}

	public void clickElementUsingJS(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occurred while clicking a web element using javascript");
		}
	}
	
	public void clearTextFromInputBox(WebElement inputBoxElement) {
		try {
			inputBoxElement.click();
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			throw new RuntimeException("Element you are trying to access does not exist on the page");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occurred while clearing text from a web element");
		}
	}

	public void inputText(WebElement inputBoxElement, String text) {
		try {
			clearTextFromInputBox(inputBoxElement);
			inputBoxElement.sendKeys(text);
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			throw new RuntimeException("Element you are trying to access does not exist on the page");
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occurred while clearing text from a web element");
		}
	}

	public boolean isElementPresent(WebElement element) {
		try {
			setImplicitWait(5);
			return element.isDisplayed();
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Error occurred while validating the element presence");
		} finally {
			setImplicitWait(30);
		}
		return false;
	}

	public void setImplicitWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occurred while setting implicit wait time");
		}
	}

	public void waitForPageToLoad() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until((ExpectedCondition<Boolean>) wd -> executeJavascript("document.readyState").equals("complete"));
		} catch (Exception exception) {

		}
	}

	public String executeJavascript(String script) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			return String.valueOf(jse.executeScript("return " + script));
		} catch (Exception exception) {
			System.out.println("Error occurred while executing java script");
			exception.printStackTrace();
		}
		return "";
	}
	
	public void invokeKeyboardEvent(WebElement element, Keys key) {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(element, key).build().perform();
		} catch(Exception exception)  {
			System.out.println("Error occurred  while  invoking  keyboard event");
		}
	}

	public void quitDrivers() {
		driver.close();
	}
	
	public void waitForWebElement(WebElement element, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void scrollToElement(WebElement element) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}

}