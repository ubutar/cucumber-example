Feature: Detecting suspicious reposting of news from 'The Guardian'

  If certain news titles are posted by many media outlets almost unchanged,
  it could be a likely indicator of possible clickbait campaign

  Background:
    Given The Guardian news feed is open

  Scenario Outline: Limited literal reposts
    When first news having "<keyword>" in title is searched
    And such news title was found
    Then news title is searched for in Google
    And there should be at least 5 Google search results except from "The Guardian"
    But no more than 3 results with similarity more than <score>
    Examples:
      | keyword | score |
      | war     | 0.9   |
      | trump   | 0.85  |

  Scenario Outline: Avoiding reporting style of tabloids
    When first news having "<keyword>" in title is searched
    And such news title was found
    And news title is searched for with Google on "thesun.co.uk"
    Then title should not have similarity more than <score> to any of results
    Examples:
      | keyword | score   |
      | ukraine | 0.85    |
      | israel  | 0.825   |