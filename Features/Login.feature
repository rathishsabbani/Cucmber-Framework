Feature: Login

  Scenario Outline: Search Customer by Email
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Home Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    And Page Title should be "Your store. Login"
    Then close browser

    