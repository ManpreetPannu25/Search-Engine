package com.Manpreet.ProjectAssignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class TestBase {
	public static WebDriver driver;
	private final String DEFAULT_BROWSER = "Chrome";

	public void initialisation() {
		switch (DEFAULT_BROWSER.toUpperCase()) {
		case "CHROME":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "EDGE":
			driver = WebDriverManager.edgedriver().create();
			break;
		case "FIREFOX":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		default:
			throw new IllegalArgumentException();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

	public void tearDown() {
		driver.quit();
	}
}
