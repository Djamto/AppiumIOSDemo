Feature: Contact Info

  @ContactInfo
  Scenario: Validate that contact info is displayed
    When The user has clicked the contact name "John Appleseed"
    Then Validate that the contact info is displayed with title "John Appleseed"

  @ContactEditInfo
  Scenario: Validate that contact info is edited
    When The user has clicked the contact name "John Appleseed"
    And The user has clicked the Edit button
    And The user has changed the company field to "Company Test"
    And The user has clicked the Done button
    Then Validate the comapny is displayed in the Contact Info screen with name "Company Test"