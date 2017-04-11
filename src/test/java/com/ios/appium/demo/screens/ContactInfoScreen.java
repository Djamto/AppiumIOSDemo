package com.ios.appium.demo.screens;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * Created by darjandjamtovski on 3/19/17.
 */
public class ContactInfoScreen extends BaseScreen{

    public void clickEdit(){
        MobileElement editButton = waitForElementPresent(By.xpath("//XCUIElementTypeButton[@name=\'Edit\']"));
        editButton.click();
    }

    public boolean isContactNameDisplayed(String contactName){
        try{
            waitForElementPresent(By.xpath("//XCUIElementTypeStaticText[@label = \'"+contactName+"\']"));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isCompanyInfoDisplayed(String companyName){
        try{
            waitForElementPresent(By.xpath("//XCUIElementTypeStaticText[@value = \'"+companyName+"\']"));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
