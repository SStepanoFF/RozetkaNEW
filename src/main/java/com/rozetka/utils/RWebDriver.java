package com.rozetka.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class RWebDriver {
    private static RWebDriver instance;
    public String browser="";
    private WebDriver driver;

    private RWebDriver() {
    	switch (browser) {
		case "chrome":
			String chromePath = "/Applications/chromedriver";
			if (getOperatingSystemType().toString() == "Windows") {
				chromePath += ".exe";
			}
			System.setProperty("webdriver.chrome.driver", chromePath);
			System.out.println("Trying to start chrome driver from: " + chromePath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver();
			break;
		case "ie":
			String iePath = System.getenv("webdrivers") + "IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", iePath);
			driver = new InternetExplorerDriver();
			break;
		default:
			driver = new FirefoxDriver();
			break;
		}
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static synchronized RWebDriver getInstance() {
        if (instance == null) {
            instance = new RWebDriver();
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public static void closeWebDriver() {
        RWebDriver.getInstance().getWebDriver().close();
    }

    public enum OSType {
        Windows, MacOS, Linux, Other
    }

    protected static OSType detectedOS;

    public static OSType getOperatingSystemType() {
        if (detectedOS == null) {
            String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
            if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
                detectedOS = OSType.MacOS;
            } else if (OS.indexOf("win") >= 0) {
                detectedOS = OSType.Windows;
            } else if (OS.indexOf("nux") >= 0) {
                detectedOS = OSType.Linux;
            } else {
                detectedOS = OSType.Other;
            }
        }
        return detectedOS;
    }
}
