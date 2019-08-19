Feature: Market data
  The API shows different information about Market Data

  Scenario: Obtain quotes of the Market
    Given I want to have a list of symbols
    When I call the API  for quotes with symbols: AAPL,VXX190517P00016000
    Then I receive a list of symbols quotes

  Scenario: Post quotes of the API
    Given I want to post a symbols of quote
    When I call the API with the symbols: AAPL,VXX190517P00016000
    Then I receive a list of symbols quotes with my post symbol

  Scenario: Obtain quotes of the API with an option chain
    Given I want to see quotes of a chain
    When I call the API with the symbol: VXX
    And expiration: 2019-05-17
    Then I receive quotes with the expiration date only

  Scenario: Obtain API quotes of option's strikes prices
    Given I want to see option's strikes prices
    When I call the API with the symbol: VXX
    And expiration: 2019-05-17
    Then I receive the strikes with the expiration day only

  Scenario: Obtain the expiration dates of an option
    Given I want to see the expiration dates
    When I call the API with symbol: VXX
    Then I receive the expiration dates

  Scenario: Obtain historical pricing information
    Given I want to see the history of pricing
    When I call the API with symbol: AAPL
    Then I receive the correct historical pricing

  Scenario: Obtain timesales information
    Given I want to see timesales
    When I call the API with symbol: AAPL
    Then I receive timesales information

    #Not in sandbox
  Scenario: Obtain ETB information
    Given I want to see the ETB list
    When I call the API for etb
    Then I receive an ETB list

  Scenario: Obtain intraday status
    Given I want to see the intrady market status
    When I call the API for clock
    Then I receive information about the current day status

  Scenario: Obtain market information of a month
    Given I want to see the market status of a month
    When I call the API for calendar with month: 08
    Then I receive information about the current month status

  Scenario: Obtain information of a company
    Given I want to see information of a company
    When I call the API for calendar with q: alphabet
    Then I receive information about company

  Scenario: Search for symbols
    Given I want to lookup a symbol
    When I call the API for q: goog
    Then I receive information about the symbol


