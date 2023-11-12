Feature: Routinely confirming that top news in 'The Guardian' feed are somewhat authentic

  Imagine you are building news validation mechanism to prevent fake news.
  You would need to take news and check them for some known fake news markers

  Background:
    Given The Guardian news feed is open

  Scenario: Top news is usually authentic
    When first news on the tone feed is taken
    And news title is searched for in Google
    Then there should be at least 2 Google search results except from "The Guardian"

  Scenario Outline: Selected important topics are covered
    When first news having "<keyword>" in title is searched
    And such news title was found
    Then news title is searched for in Google
    And there should be at least 5 Google search results
    And there are at least 3 results with similarity <score> or more
    Examples:
      | keyword  | score |
      | football | 0.7   |
      | violence | 0.6   |