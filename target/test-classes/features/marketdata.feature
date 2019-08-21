Feature: Market data
  The API shows different information about Market Data

  Background:
    Given I have an authorization token

  Scenario: Obtain quotes of the Market
    When I call the quotes with symbols: AAPL,VXX190517P00016000
    Then I receive a list with only the called symbols

  Scenario: Post quotes to the market
    When I post quotes with symbols: AAPL,VXX190517P00016000
    Then I receive a list of symbols quotes with only the symbols called

  Scenario: Obtain quotes with an option chain
    When I call quotes with symbol: VXX expiration date: 2019-05-17
    Then I receive quotes related to the symbol with the expiration date only

  Scenario: Obtain quotes of options strikes prices
    When I call the options strikes with the symbol: VXX expiration date: 2019-05-17
    Then I receive the strikes related to the symbol with the expiration date only

  Scenario: Obtain the expiration dates of an option
    When I call the options expiration with symbol: VXX
    Then I receive the expiration dates related to the symbol

  Scenario: Obtain historical pricing information
    When I call the historical with symbol: AAPL
    Then I receive the historical pricing related to the symbol

  Scenario: Obtain time sales information
    When I call the time sales with symbol: AAPL
    Then I receive time sales information related to the symbol

  Scenario: Obtain intraday status
    When I call the clock
    Then I receive information about the current day status

  Scenario: Obtain market information of a month
    When I call the calendar with month: 08
    Then I receive information about the month status

  Scenario: Obtain information of a company
    When I call a query for q: alphabet
    Then I receive information of the searched company

  Scenario: Search for symbols
    When I call the symbol for q: goog
    Then I receive information about the searched symbol


