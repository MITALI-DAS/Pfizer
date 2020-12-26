package com.pfizer.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends ParentTest {
	
	@Test(enabled = true)
	public void validateSearch() {
		searchResults.performSearch("vaccine");
		boolean result = searchResults.isSearchResultValid("vaccine");
		Assert.assertTrue(result, "One or more search result link do not have the search term");
	}
	
	@Test
	public void sortTest() {
		homePage.mouseHoverMenuLink("our purpose");
		homePage.clickSubmenuLink("How does Pfizer price medicines?");
		homePage.waitForPageToLoad();
		homePage.staticWait(4);
	}
	
	
}
