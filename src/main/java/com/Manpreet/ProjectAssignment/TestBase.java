package com.Manpreet.ProjectAssignment;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class TestBase {
	public static WebDriver driver;
	private final Browser DEFAULT_BROWSER = Browser.FIREFOX;

	public void initialisation() {
		switch (DEFAULT_BROWSER) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	public void tearDown() {
		driver.quit();
	}
}
