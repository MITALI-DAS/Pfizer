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

	@FindBy(xpath = "(//ul[@id='slide-navbar-collapse'])/li/div/a")
	private List<WebElement> homePageHeaderLinks;

	@FindBy(xpath = "(//div[@class='dropdown-toggle'])/a")
	private List<WebElement> submenuLinks;

	public List<WebElement> getHomePageHeaderLinks() {
		return homePageHeaderLinks;
	}

	public List<WebElement> getSubMenuLinks() {
		return submenuLinks;
	}

	public void mouseHoverMenuLink(String linkName) {
		List<WebElement> menuLinks = getHomePageHeaderLinks();
		for(WebElement link: menuLinks){	
			if(getTextFromElement(link).toUpperCase().equals(linkName.toUpperCase())) {
				mouseHover(link);
				break;
			}
		}
	}
	
	public void clickSubmenuLink(String submenuLinkName) {
		List<WebElement> menuLinks = getSubMenuLinks();
		for(WebElement link: menuLinks){	
			if(getTextFromElement(link).toUpperCase().equals(submenuLinkName.toUpperCase())) {
				clickElementUsingActions(link);
				waitForPageToLoad();
				System.out.print("Current page is: " + driver.getCurrentUrl());
				break;
			}
		}
	}
		
}