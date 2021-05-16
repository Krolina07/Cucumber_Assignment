
@OrangeHRM
Feature: Assignment 16, Dashboard page is available
  Automate below cucumber scenario:

  @Dashboard_Page
  Scenario: Dashboard page is available
    Given I am in OrangeHRP Application "https://opensource-demo.orangehrmlive.com/"
  	When I enters "admin" and "admin123"
		And clicked on Login Button
		Then Dashboard page is available
		And click on Admin menu
		

