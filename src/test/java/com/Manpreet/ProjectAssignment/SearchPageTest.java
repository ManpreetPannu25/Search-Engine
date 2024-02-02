package com.Manpreet.ProjectAssignment;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchPageTest extends TestBase {

	private SearchPage searchPage;

	@BeforeMethod
	public void setUpPage() {
		initialisation();
		searchPage = new SearchPage(driver);
		driver.get("https://www.google.com");
	}

	@Test
	public void testSearchForText() {
		searchPage.search("SDLC");
		String result = searchPage.getResultForText();
		Assert.assertTrue(result.contains("Amazon"), "Amazon Web Services");
	}

	@Test
	public void testSearchForMultipleTerms() {
		searchPage.search("Software Testing best practices");
		searchPage.getResultForMultipleTerms();
		Assert.assertEquals("Top 10 Best Practices for Software Testing in 2024",
				"Top 10 Best Practices for Software Testing in 2024", "Page Not found");
	}

	@Test
	public void testSearchForNumbers() {
		searchPage.search("1234567890");
		Assert.assertEquals(driver.getTitle(), "1234567890 - Google Search");
	}

	@Test
	public void testSearchForSpecialCharacters() {
		searchPage.search("!!!!!");
		Assert.assertEquals(driver.getTitle(), "!!!!! - Google Search");
	}

	@Test
	public void testSearchForNonExistentTerm() {
		searchPage.search("ThisTermShouldNotExist123");
		searchPage.getResultForInvalidEntry();
		Assert.assertEquals("ThisTermShouldNotExist123", "ThisTermShouldNotExist123");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
