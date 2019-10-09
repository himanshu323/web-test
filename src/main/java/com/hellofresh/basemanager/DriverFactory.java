package com.hellofresh.basemanager;

public class DriverFactory {

	private String chromeDriverPath;
	public String ieDriverPath;
	public String firefoxDriverPath;
	public String configPropPath;
	public String getConfigPropPath() {
		return configPropPath;
	}
	public void setConfigPropPath(String configPropPath) {
		this.configPropPath = configPropPath;
	}
	public String getChromeDriverPath() {
		return chromeDriverPath;
	}
	public void setChromeDriverPath(String chromeDriverPath) {
		this.chromeDriverPath = chromeDriverPath;
	}
	public String getIeDriverPath() {
		return ieDriverPath;
	}
	public void setIeDriverPath(String ieDriverPath) {
		this.ieDriverPath = ieDriverPath;
	}
	public String getFirefoxDriverPath() {
		return firefoxDriverPath;
	}
	public void setFirefoxDriverPath(String firefoxDriverPath) {
		this.firefoxDriverPath = firefoxDriverPath;
	}
}
