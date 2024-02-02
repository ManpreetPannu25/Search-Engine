package com.Manpreet.ProjectAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage implements SearchPage {

	public GoogleSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "textarea[name='q']")
	private WebElement searchBox;

	@FindBy(xpath = "//h3[text()='Java | Oracle']")
	private WebElement firstResult;

	public void performSearch(String searchTerm) {
		searchBox.sendKeys(searchTerm);
		searchBox.submit();
	}

	public String getFirstResultText() {
		return firstResult.getText();
	}

	public String actualResult() {
		return getFirstResultText();
	}

}
