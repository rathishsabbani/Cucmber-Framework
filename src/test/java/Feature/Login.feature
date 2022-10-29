Feature: Login


  Scenario Outline: Search Customer by Email
    Given User Launch Chrome browser
    When User opens URL <url>
    And User enters Email as <username> and Password as <password>
    And Click on Login
    Then Home Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    And Page Title should be "Your store. Login"
    Then close browser

    Examples:
      | username            |  | password | url                                       |
      | admin@yourstore.com |  | admin    | "http://admin-demo.nopcommerce.com/login"

