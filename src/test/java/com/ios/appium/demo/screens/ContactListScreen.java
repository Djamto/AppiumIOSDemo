package com.ios.appium.demo.screens;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * Created by darjandjamtovski on 3/19/17.
 */
public class ContactListScreen extends BaseScreen{

    public void searchForContact(String contactName) throws InterruptedException {
        MobileElement searchElement = waitForElementPresent(By.xpath("//XCUIElementTypeImage[1]"));
        searchElement.clear();
        searchElement.setValue(contactName);
        Thread.sleep(300);
    }

    public void clickContant(String contactName) throws InterruptedException {
        MobileElement contantCellElement = waitForElementPresent(By.xpath("//XCUIElementTypeTable//XCUIElementTypeStaticText[@value = \'"+contactName+"\']"));
        contantCellElement.click();
        Thread.sleep(2300);
    }

    public boolean isContactCellVisible(String contactName){
        try {
            waitForElementPresent(By.xpath("//XCUIElementTypeTable//XCUIElementTypeStaticText[@value = \'"+contactName+"\']"), 3);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
