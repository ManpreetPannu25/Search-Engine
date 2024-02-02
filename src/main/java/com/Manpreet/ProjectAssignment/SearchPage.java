package com.Manpreet.ProjectAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends TestBase {

	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	private WebElement searchBox;

	public void search(String searchTerm) {
		searchBox.sendKeys(searchTerm);
		searchBox.sendKeys(Keys.RETURN);
	}

	public String getResultForText() {
		return searchBox.findElement(By.xpath("//span[text()='Amazon Web Services']")).getText();
	}

	public String getResultForMultipleTerms() {
		return searchBox.findElement(By.xpath("//h3[contains(text(),'2024')]")).getText();
	}

	public String getResultForInvalidEntry() {
		return searchBox.findElement(By.xpath("//em[contains(text(),'This')]")).getText();
	}
}
