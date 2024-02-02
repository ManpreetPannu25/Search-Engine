package com.Manpreet.ProjectAssignment;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchEnginePageTest extends TestBase {

	@BeforeMethod
	public void setUpPage() {
		initialisation();
	}

	@Test
	public void testGoogleSearch() {
		testSearchEngine(new GoogleSearchPage(driver), "https://www.google.com/", "java");
	}

	@Test
	public void testBingSearch() {
		testSearchEngine(new BingSearchPage(driver), "https://www.bing.com/", "java");
	}

	@Test
	public void testYahooSearch() {
		testSearchEngine(new YahooSearchPage(driver), "https://search.yahoo.com/", "java");
	}

	private void testSearchEngine(SearchPage searchPage, String baseUrl, String searchItem) {
		driver.get(baseUrl);
		searchPage.performSearch(searchItem);
		String actualResult = searchPage.getFirstResultText();
		String expectedResult = "Java | Oracle";
		Assert.assertTrue(actualResult.contains("Java"), expectedResult);
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
