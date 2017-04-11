package com.ios.appium.demo.screens;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * Created by darjandjamtovski on 3/21/17.
 */
public class ContactInfoEditScreen extends BaseScreen{

    public void enterFirstName(String firstName){

    }

    public void enterLastName(String lastName){

    }

    public void enterCompany(String company){
        MobileElement companyElement  = waitForElementPresent(By.xpath("//XCUIElementTypeTextField[@name = \'Company\']"));
        companyElement.clear();;
        companyElement.setValue(company);
    }

    public void clickDone() throws InterruptedException {
        MobileElement doneButton = waitForElementPresent(By.xpath("//XCUIElementTypeButton[@name=\'Done\']"));
        doneButton.click();
        Thread.sleep(2300);
    }
}
