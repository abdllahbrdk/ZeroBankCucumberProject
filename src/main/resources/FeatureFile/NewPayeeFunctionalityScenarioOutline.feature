Feature: Zero Bank Function Test
  Scenario Outline: Add new Payee in Zero Bank

    Given User Navigate To Zero Bank
    When User enter valid username and password
    When User click on both PayBills and then AddNewPayee
    Then User should Fill "<Name>"
    Then User should fill the "<Address>"
    Then User should filll the "<Account>"
    Then User should fills the "<PayeeDetails>"

    Examples:
    |Name|Address|Account|PayeeDetails|
    |KEN|Hckensck|Kenny  |Thor        |
