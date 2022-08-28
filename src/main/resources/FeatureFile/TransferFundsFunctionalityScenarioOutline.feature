Feature: Transfer Funds Functionality Test

  Scenario Outline: Transfer Funds
    Given User Navigate To Zero Bank2
    When User enter valid username and password2
    And User click on Transfer Funds
    And User send "<Amount2>" and "<Description>"
    Then User should the success message

    Examples:
    |Amount2|Description|
    |100    |Ken        |
