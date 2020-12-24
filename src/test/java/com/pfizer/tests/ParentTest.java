package com.pfizer.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ofizer.utils.PageObjectManager;
import com.ofizer.utils.WebDriverManager;
import com.pfizer.pages.HomePage;
import com.pfizer.pages.SearchResultsPage;

public class ParentTest {
	
	WebDriver driver;
	WebDriverManager driverManager;
	PageObjectManager pom;
	SearchResultsPage searchResults;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		driverManager = new WebDriverManager();
		driver = driverManager.browserSetUp();
		pom = new PageObjectManager();
		searchResults = pom.getSearchResultsPage(driver);
		homePage = pom.getHomePage(driver);
	}
	
	@AfterMethod
	public void tearTown() {
		driver.quit();
	}

}
