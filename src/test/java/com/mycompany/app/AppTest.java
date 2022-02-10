package com.mycompany.app;

import org.testng.annotations.Test;

import com.saucelabs.common.SauceOnDemandAuthentication;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppTest  {
	
	/*********************************************************************/

	private static String sauce_username = System.getenv("SAUCE_USERNAME");
	private static String sauce_accesskey = System.getenv("SAUCE_ACCESS_KEY");

	private static SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(sauce_username, sauce_accesskey);

	private static String seleniumURI = "@ondemand.us-west-1.saucelabs.com:443";
    
	private static String SAUCE_URL = "https://" + authentication.getUsername() + ":" + authentication.getAccessKey() + seleniumURI + "/wd/hub";
	
	/*********************************************************************/

    @Test
    public void runTest() {
    	
        try {
        	
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            capabilities.setCapability(CapabilityType.VERSION, "latest");
            capabilities.setCapability(CapabilityType.PLATFORM, "Windows 10");
            capabilities.setCapability("name", "SimpleSauceDemo");

            WebDriver driver = new RemoteWebDriver(new URL(SAUCE_URL),capabilities);

            driver.get("http://www.saucedemo.com/v1");
            
	        driver.quit();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
    
}
