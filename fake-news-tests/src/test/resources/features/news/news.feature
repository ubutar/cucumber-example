Feature: Exclusive resources

  Scenario: first example
    Given this does smth in thread
    When it is executed
    Then it will be executed

  Scenario: second example
    Given this does smth in another thread
    When it is executed
    Then it will be executed