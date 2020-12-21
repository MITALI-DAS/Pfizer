package com.pfizer.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ofizer.utils.CommonMethods;

public class HomePage extends CommonMethods {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "(//ul[@id='slide-navbar-collapse'])/li")
	private List<WebElement> homePageHeaderLinks;

	@FindBy(xpath = "(//div[@class='dropdown-toggle'])/a")
	private List<WebElement> homePageAllLinks;

	public List<WebElement> getHomePageHeaderLinks() {
		return homePageHeaderLinks;
	}

	public List<WebElement> getHomePageAllLinks() {
		return homePageAllLinks;
	}

	
}