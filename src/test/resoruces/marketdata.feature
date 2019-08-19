Feature: Market data
  The API shows different information about Market Data

  Scenario: Obtain quotes of the Market
    Given I have the symbols of quote
    When I call the quotes
    Then I the receive the quotes

  Scenario: Add quotes of the API
    Given I have the symbols of quote
    When I call the quotes
    Then I the receive the quotes

  Scenario: Obtain quotes of the API with a option chain
    Given I have the symbols of quote and the expiration day
    When I call the quote
    Then I the receive the quotes with the expiration day

  Scenario: Obtain option's strikes prices
    Given I have the symbols of quote and the strikes expiration day
    When I call the strikes with the expiration day
    Then I the receive the strikes with the expiration day

  Scenario: Obtain option's expiration dates
    Given I have the symbol, roots and strikes
    When I call the strikes with the expiration day
    Then I receive the expiration dates

  Scenario: Obtain historical quotes
    Given I have the symbol, interval, start and end
    When I call the historical pricing
    Then I receive the historical pricing