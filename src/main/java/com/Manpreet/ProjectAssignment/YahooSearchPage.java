package com.Manpreet.ProjectAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooSearchPage extends TestBase implements SearchPage {
	@FindBy(css = "input[type='text']")
	private WebElement searchBox;

	@FindBy(xpath = "//a[@aria-label='Java | Oracle']")
	private WebElement firstResult;

	public YahooSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void performSearch(String searchTerm) {
		searchBox.sendKeys(searchTerm);
		searchBox.submit();
	}

	public String getFirstResultText() {
		return firstResult.getText();
	}
}
