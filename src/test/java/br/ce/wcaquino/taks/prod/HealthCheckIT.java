package br.ce.wcaquino.taks.prod;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HealthCheckIT {
	
	@Test
	public void healtyCheck() throws MalformedURLException {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
	    WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.193:4444/wd/hub"), cap);
	    try {
			driver.navigate().to("http://192.168.0.193:9999/tasks");
			String version = driver.findElement(By.id("version")).getText();
			Assert.assertTrue(version.startsWith("build"));
	    } finally {
	    	driver.quit();
	    }
	}
	
}
