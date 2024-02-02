package com.Manpreet.ProjectAssignment;

public enum Browser {
	CHROME("Chrome"),
	EDGE("Edge"), 
	FIREFOX("Firefox");

	String browser;

	public String getBrowser() {
		return browser;
	}

	private Browser(String browser) {
		this.browser = browser;
	}

}
