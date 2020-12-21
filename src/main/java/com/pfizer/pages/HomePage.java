package com.pfizer.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ofizer.utils.CommonMethods;

public class HomePage extends CommonMethods {
	
	//https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);//used to initialise the page objects,its a concept
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