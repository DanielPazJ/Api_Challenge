Feature: Watchlist
  The API shows different information about Watchlist

  Scenario: Obtain all watchlist of a user
    Given The user has a watchlist with name: default
    When I call the API with watchlist
    Then I receive a list of watchlist that has the user watchlist names

  Scenario: Obtain a specific watchlist of a user
    Given The user has a watchlist with id: default
    When I call the watchlist id: default
    Then I receive the watchlist by id with the correct name

  Scenario: Create a new watchlist
    Given I want to create a new watchlist with name: MyWatchlist that has symbol: AAPL
    When I call the API  with watchlist name: MyWatchlist symbol: AAPL
    Then I receive the new watchlist with symbols added

  Scenario: Update a watchlist
    Given I want to change name of a watchlist to UpdatedWatchlist
    When I send a request with the watchlist id: default and the updated name UpdatedWatchlist
    Then I get the watchlist with the updated information

    
