package com.ios.appium.demo.steps;

import com.ios.appium.demo.screens.ContactListScreen;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by darjandjamtovski on 4/11/17.
 */
public class ContactListSteps {

    private ContactListScreen contactListScreen = new ContactListScreen();

    @When ("^The user has searched for contact with name \"(.*)\"$")
    public void whenTheUserHasSearchedForContactWithName(String contactName) throws InterruptedException {
        contactListScreen.searchForContact(contactName);
    }

    @Then ("^Validate that the searched contact \"(.*)\" is displayed in the list$")
    public void thenValidateThatTheSearchedContactIsDisplayedInTheList(String contactName){
        Assert.assertTrue(contactListScreen.isContactCellVisible(contactName));
    }
}
