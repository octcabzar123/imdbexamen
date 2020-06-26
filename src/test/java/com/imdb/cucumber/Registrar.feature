Feature: IMDB user
  
  Scenario: Create new account
    Given I go to IMDB page
    Then I go to the Login page
    When My email is jobar87@hotmail.com, my pass is 1234Test y my username is Equipo1Test
    And I create a new user in IMDB

