package com.pfizer.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ofizer.utils.PageObjectManager;
import com.ofizer.utils.WebDriverManager;
import com.pfizer.pages.SearchResultsPage;

public class SearchTest {
	
	WebDriver driver;
	WebDriverManager driverManager;
	PageObjectManager pom;
	SearchResultsPage searchResults;
	
	@BeforeTest
	public void setUp() {
		driverManager = new WebDriverManager();
		driver = driverManager.browserSetUp();
		pom = new PageObjectManager();
		searchResults = pom.getSearchResultsPage(driver);
	}
	
	@Test
	public void validateSearch() {
		searchResults.performSearch("vaccine");
	}
	
	@AfterTest
	public void tearTown() {
		driver.quit();
	}
	
}
