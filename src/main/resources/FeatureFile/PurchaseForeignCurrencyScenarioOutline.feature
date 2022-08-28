Feature: Purchase Foreign Currency Functionality

    Scenario Outline: Purchase Foreign Currency
      Given User Navigate To Zero Bank1
      When User enter valid username and password1
      When User click on Paybills and Purchase Foreign Currency
      And User select for currency amount "<Amount>"
      Then User should see the success message

   Examples:
      |Amount|
      |100   |