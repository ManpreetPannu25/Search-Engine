package com.Manpreet.ProjectAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingSearchPage extends TestBase implements SearchPage {

	@FindBy(css = "textarea[id='sb_form_q']")
	private WebElement searchBox;

	@FindBy(xpath = "//a[text()='Java | Oracle']")
	private WebElement firstResult;

	public BingSearchPage(WebDriver driver) {
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
