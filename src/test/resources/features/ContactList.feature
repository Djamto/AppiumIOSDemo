Feature: Contact List

  @ContactSearch
  Scenario: Validate that the searched contact is found
    When The user has searched for contact with name "Test Dummy"
    Then Validate that the searched contact "Test Dummy" is displayed in the list