package com.ios.appium.demo.base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by darjandjamtovski on 1/21/17.
 */
public class DriverHelper {

    private AppConfig appConfig;
    private static AppiumDriver driver;
    private URL serverUrl;
    private DesiredCapabilities capabilities;

    @Before
    public void initDriver() throws MalformedURLException {
        appConfig = new AppConfig();
        capabilities = new DesiredCapabilities();
        //capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, appConfig.getProperty(AppConfig.PROPERTY_PLATFORM_VERSION));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, appConfig.getProperty(AppConfig.PROPERTY_PLATFORM_NAME));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, appConfig.getProperty(AppConfig.PROPERTY_DEVICE_NAME));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, appConfig.getProperty(AppConfig.PROPERTY_AUTOMATION_INSTRUMENTATION));
        capabilities.setCapability("bundleId", appConfig.getProperty(AppConfig.PROPERTY_PACKAGE_NAME));
        capabilities.setCapability("noReset", true);
        capabilities.setCapability(MobileCapabilityType.UDID, appConfig.getProperty(AppConfig.PROPERTY_DEVICE_UDID));
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
        serverUrl = new URL("http://localhost:" + appConfig.getProperty(AppConfig.PROPERTY_APPIUM_SERVER_PORT) + "/wd/hub");
        driver = new IOSDriver(serverUrl, capabilities);
    }

    @After
    public void destroyDriver(Scenario scenario){
        if(scenario.isFailed()){
            takeScreenshot(driver);
        }

        driver.quit();
    }

    public static AppiumDriver<? extends MobileElement> getDriver(){
        return driver;
    }

    private void takeScreenshot(AppiumDriver driver){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String stamp = dateFormat.format(new Date());
        String extension = ".jpg";
        String screenshotLocation = "/Users/darjandjamtovski/Desktop/Screenshots/";
        String screenshotName = "screenshot" + "-" + stamp;
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotLocation + screenshotName + extension));
        }catch (IOException e){
            System.out.println("Screenshot not taken.");
        }
    }
}
