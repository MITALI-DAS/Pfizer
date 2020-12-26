package com.pfizer.tests;

import org.testng.annotations.Test;

public class OtherTests extends ParentTest {
	
	@Test
	public void sortTest() {
		homePage.mouseHoverMenuLink("our purpose");
		homePage.clickSubmenuLink("How does Pfizer price medicines?");
		homePage.waitForPageToLoad();
		homePage.staticWait(4);
	}
	
	@Test
	public void homePageTest() {
		
	}
	
}
