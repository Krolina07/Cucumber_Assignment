@TestSuite1
Feature: Create 4 scenarios and tag them with smoke and Regression, and run with cucumber

  Background: User is logged into application
    Given on home page of application "https://opensource-demo.orangehrmlive.com/"
    When I enter credentials "admin" and "admin123"
    Then I should be successfully log in

  @Directory @Regression
  Scenario: Validate Directory Functionality
    When I click on Directory tab
    And Search By Name
    Then I should be able to read employee details

  @JobGrades @Regression @smoke
  Scenario: Validate Job Grades Functionality
    When I move to JOb Grade under Admin Tab
    Then I should be able to read Grade info

    @MyInfo @Regression
  Scenario: Validate My Info screen
    When I move to My Info
    Then I should be able to read your info
    
    @Buzz @Regression
  Scenario: Validate Buzz Functionality
    When I move to Buzz
    Then I should be able to tipe on Update Status
  