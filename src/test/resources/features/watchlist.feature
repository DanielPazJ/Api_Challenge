Feature: Watchlist
  The API shows different information about Watchlist

  Scenario: Obtain watchlist of a user
    Given The user has a watchlist
    When I call the API with watchlist
    Then I receive a list of watchlist

  Scenario: Obtain a specific watchlist of a user
    Given The user has watchlist with id: default
    When I call the watchlist id: default
    Then I receive the watchlist with id: default

  Scenario: Create a new watchlist
    Given I want to create a new watchlist
    When I call the API  with watchlist name: My Watchlist
    And  symbols: AAPL,IBM,NFLX
    Then I receive the new watchlist with symbols added

  Scenario: Update an existing watchlist
    Given The user has watchlist
    When Ical the API 