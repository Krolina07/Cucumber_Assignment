@OrangeHRM
Feature: Assignment 17,- validate text – Job Title
  Automate below cucumber scenario:
  
Background: I am logged into Orange Application
   Given I am in application "https://opensource-demo.orangehrmlive.com/"
   When I add "admin" and "admin123"
	 And select on Login Button
    
  @Job_Title
  Scenario: validate text – Job Title
    Given when I click on Admin Link
		Then Click on Job
		And validate text of Job Title 
		

  
