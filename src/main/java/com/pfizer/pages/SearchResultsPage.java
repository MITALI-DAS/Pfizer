package com.pfizer.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ofizer.utils.CommonMethods;

public class SearchResultsPage extends CommonMethods {

	WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(css = "input#edit-keys")
	private WebElement searchTextBox;
	
	@FindBy(xpath = "//span[@class='field-content']//a")
	private List<WebElement> searchResultLinks;
	 
	@FindBy(xpath = "//li[@class='pager__item']/a")
	private List<WebElement> paginationLinks;

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public List<WebElement> getSearchResultLinks() {
		return searchResultLinks;
	}

	public List<WebElement> getPaginationLinks() {
		return paginationLinks;
	}
	

}
