Feature: Routinely confirming that top news in 'The Guardian' feed is somewhat authentic

  Imagine you are building news validation mechanism to prevent fake news.
  You would need to take news and check them v. other sources

  Background:
    Given The Guardian news feed is open

  Scenario: Top news is usually authentic
    When first news on the tone feed is taken
    And news title is searched for in Google
    Then there should be at least 2 Google search results