package com.ios.appium.demo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:cucumber.json",
        features = {
                "src/test/resources/features/ContactInfo.feature",
                "src/test/resources/features/ContactList.feature"
        },
        glue = {"com.ios.appium.demo.steps", "com.ios.appium.demo.base"},
        tags = {"@ContactInfo"}
)
public class RunTest {

}
