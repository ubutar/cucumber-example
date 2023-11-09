Feature: Exclusive resources

  Scenario: 0th example
    Given test always passes
    And everyone is happy

  Scenario: first example
    Given this does smth in thread
    When it is executed
    Then it will be executed

  @off
  Scenario: second example
    Given this does smth in another thread
    When it is executed
    Then it will be executed