Feature: Read pet details from Excel file

  Scenario: Retrieve Pet ID and Pet Name for Test Case 1
    Given I read pet details for "Test Case 1" from the Excel file
    Then the Pet ID and Pet Name should be retrieved

  Scenario: Retrieve Pet ID and Pet Name for Test Case 2
    Given I read pet details for "Test Case 2" from the Excel file
    Then the Pet ID and Pet Name should be retrieved


