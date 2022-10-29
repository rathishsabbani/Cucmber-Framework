
Feature: Customers

Background: Below are common steps for every scenario
  Given User Launch Chrome browser
  When  User opens URL "http://admin-demo.nopcommerce.com/login"
  And  User enters Email as "admin@yourstore.com" and Password as "admin"
  And Click on Login
  Then User can view Dashboard
@Regression
  Scenario: Add a new Customer
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully"
    And close browser
@Regression
  Scenario: Search Customer by Name
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should found Email in the Search table
    And close browser

@sanity
  Scenario Outline: Search Customer by Email
    Given User Launch Chrome browser
    When User opens URL <url>
    And User enters Email as <email> and Password as <password>
    And Click on Login
    Then User can view Dashboard
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer Email
    When Click on search button
    Then User should found Email in the Search table
    And close browser
    Examples:
      | url                                       | email                 | password |
      | "http://admin-demo.nopcommerce.com/login" | "admin@yourstore.com" | "admin"  |



