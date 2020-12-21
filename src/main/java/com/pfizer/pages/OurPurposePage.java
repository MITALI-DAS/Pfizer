package com.pfizer.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ofizer.utils.CommonMethods;

public class OurPurposePage extends CommonMethods {

	public OurPurposePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Our Purpose']")
	private WebElement ourPurposeLink;

	@FindBy(xpath = "//a[@href='/purpose/health-policy/prescription-drug-prices']")
	private WebElement howDoesPfizerMedicinePriceMedicineLink;

	@FindBy(css = "select#edit-sort-by")
	private WebElement sortByLink;

	@FindBy(css = "select#edit-sort-order")
	private WebElement orderByLink;

	@FindBy(css = "button#edit-submit-featured-stories")
	private WebElement applyButton;

}