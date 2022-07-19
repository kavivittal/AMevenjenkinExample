package com.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LoginTest {
	public static RemoteWebDriver driver;

	@Test
    
    public void LoginTest1() throws MalformedURLException
    {
    
    
		String url = "http://192.168.0.9:4444/wd/hub";

		// Create an object for Desired Caps to send the appropriate command to Node
		// machine
		// DesiredCapabilities caps = DesiredCapabilities.chrome();

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setPlatform(Platform.WINDOWS);
		caps.setBrowserName("chrome");
		ChromeOptions options = new ChromeOptions();

		options.merge(caps);

		System.setProperty("webdriver.chrome.driver", "./BrowserUtils/chromedriver.exe");

		driver = new RemoteWebDriver(new URL(url), options);

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/login");
		WebElement userid = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.className("radius"));

		userid.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		login.click();

		driver.close();

    }

}
