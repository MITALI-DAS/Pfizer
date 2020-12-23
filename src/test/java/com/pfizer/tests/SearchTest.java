package com.pfizer.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ofizer.utils.PageObjectManager;
import com.ofizer.utils.WebDriverManager;
import com.pfizer.pages.SearchResultsPage;

public class SearchTest {
	
	WebDriver driver;
	WebDriverManager driverManager;
	PageObjectManager pom;
	SearchResultsPage searchResults;
	
	@BeforeMethod
	public void setUp() {
		driverManager = new WebDriverManager();
		driver = driverManager.browserSetUp();
		pom = new PageObjectManager();
		searchResults = pom.getSearchResultsPage(driver);
	}
	
	@Test
	public void validateSearch() {
		searchResults.performSearch("vaccine");
		boolean result = searchResults.isSearchResultValid("vaccine");
		Assert.assertTrue(result, "One or more search result link do not have the search term");
	}
	
	@AfterMethod
	public void tearTown() {
		driver.quit();
	}
	
}
