package com.ofizer.utils;

import org.openqa.selenium.WebDriver;

import com.pfizer.pages.HomePage;
import com.pfizer.pages.SearchResultsPage;

public class PageObjectManager {

	private HomePage homePage;
	private CommonMethods commonMethods;
	private SearchResultsPage searchResultsPage;
	
	public HomePage getHomePage(WebDriver driver) {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public CommonMethods getCommonMethods(WebDriver driver) {
		return commonMethods == null ? commonMethods = new CommonMethods(driver) : commonMethods;
	}
	
	public SearchResultsPage getSearchResultsPage(WebDriver driver) {
		return searchResultsPage == null ? searchResultsPage = new SearchResultsPage(driver) : searchResultsPage;
	}
	
}
