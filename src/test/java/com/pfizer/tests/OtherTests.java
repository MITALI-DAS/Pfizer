package com.pfizer.tests;

import org.testng.annotations.Test;


public class OtherTests extends ParentTest {
	
	@Test()
	public void vaccine() {
		searchResults.performSearch("vaccine");
		
	}
	
	@Test
	public void homePageTest() {
		
	}
	
}
