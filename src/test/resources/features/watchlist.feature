Feature: Watchlist
  The API shows different information about Watchlist

  Scenario: Obtain all watchlist of a user
    Given I have a watchlist with name: default
    When I call the API with watchlist
    Then I receive a list of watchlist that has the user watchlist names

  Scenario: Obtain a specific watchlist of a user
    Given I have a watchlist with id: default
    When I call the watchlist id: default
    Then I receive the watchlist by id with the correct name

  Scenario: Create a new watchlist
    Given I want to create a new watchlist with name: MyWatchlist that has symbol: AAPL
    When I call the API with watchlist name: MyWatchlist symbol: AAPL
    Then I receive the new watchlist with symbols added

  Scenario: Update a watchlist
    Given I want to change name of a watchlist to UpdatedWatchlist
    When I call the API with the watchlist id: default and the updated name UpdatedWatchlist
    Then I receive the watchlist with the updated information

  Scenario: Delete a specific watchlist
    Given I want to delete the watchlist with the id: MyWatchlist
    When I call the API with watchlist id: MyWatchlist
    Then I receive the deleted watchlist

  Scenario: Add symbol to specific watchlist
    Given I want to add the symbol NFLX to a watchlist with name: MyWatchlist
    When I call the API by watchlist id: default and symbol: NFLX
    Then I receive the watchlist with the added symbol

  Scenario: Remove a symbol of a specific watchlist
    Given I want to remove the NFLX symbol from the watchlist with name: MyWatchlist
    When I call the API to delete the watchlist by watchlist id: default and symbol: NFLX
    Then I receive the watchlist without the deleted symbol
