package com.ios.appium.demo.steps;

import com.ios.appium.demo.screens.ContactInfoEditScreen;
import com.ios.appium.demo.screens.ContactInfoScreen;
import com.ios.appium.demo.screens.ContactListScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by darjandjamtovski on 3/19/17.
 */
public class ContactInfoSteps {

    private ContactListScreen contactListScreen = new ContactListScreen();
    private ContactInfoScreen contactInfoScreen = new ContactInfoScreen();
    private ContactInfoEditScreen contactInfoEditScreen = new ContactInfoEditScreen();

    @When("^The user has clicked the contact name \"(.*)\"$")
    public void whenTheUserHasClickedTheContactName(String contactName) throws Exception{
        contactListScreen.clickContant(contactName);
    }

    @And("^The user has changed the company field to \"(.*)\"$")
    public void andTheUserHasChangedTheCompanyFieldTo(String companyName){
        contactInfoEditScreen.enterCompany(companyName);
    }

    @And ("^The user has clicked the Edit button$")
    public void andTheUserHasClickedTheEditButton(){
        contactInfoScreen.clickEdit();
    }

    @And ("^The user has clicked the Done button$")
    public void andTheUserHasClickedTheDoneButton() throws Exception{
        contactInfoEditScreen.clickDone();
    }

    @Then("^Validate that the contact info is displayed with title \"(.*)\"$")
    public void thenValidateThatTheContactInfoIsDisplayedWithTitle(String contactName){
        Assert.assertTrue(contactInfoScreen.isContactNameDisplayed(contactName));
    }

    @Then ("^Validate the comapny is displayed in the Contact Info screen with name \"(.*)\"$")
    public void validateTheCompanyIsDisplayedInTheContactInfoScreenWithName(String companyName){
        Assert.assertTrue(contactInfoScreen.isCompanyInfoDisplayed(companyName));
    }
}
