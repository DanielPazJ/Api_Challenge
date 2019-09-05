Feature: Market data
  The API shows different information about Market Data

  Background:
    Given I have an authorization token

  Scenario Outline: Obtain quotes of the Market
    Given In the market exist <symbols>
    When I call the quotes with <symbols>
    Then I receive a list with only the called symbols

    Examples:
      | symbols |
      | DIS,VXX |

  Scenario: Post quotes to the market
    When I post quotes with symbols: AAPL,VXX
    Then I receive a list with only the called symbols

  Scenario Outline: Obtain quotes with an option chain
    Given I have an option chain of <symbol> with expiration date: <date>
    When I call quotes with symbol: <symbol> expiration date: <date>
    Then I receive quotes related to the symbol with the expiration date only

    Examples:
      | symbol | date       |
      | VXX    | 2019-09-20 |

  Scenario Outline: Obtain quotes of options strikes prices
    Given I have an option strikes of <symbol> with expiration date: <date>
    When I call the options strikes with the symbol: <symbol> expiration date: <date>
    Then I receive the strikes related to the symbol with the expiration date only

    Examples:
      | symbol | date       |
      | DIS    | 2019-09-20 |

  Scenario Outline: Obtain the expiration dates of an option
    Given The <symbol> exist in the market with <expiration date>
    When I call the options expiration with <symbol>
    Then I receive expiration dates with <expiration date>

    Examples:
      | symbol  | expiration date |
      |    VXX  |   2019-09-06    |

  Scenario Outline: Obtain historical pricing information
    Given In the market there is a <symbol> with a transaction on the date <historical date>
    When I call the historical with <symbol>
    Then I receive the historical pricing related to the symbol

    Examples:
      | symbol | historical date |
      | AC     | 2019-01-02      |

  Scenario: Obtain time sales information of a specific symbol
    When I call the time sales with symbol: AC
    Then I receive time sales information of the current day related to the symbol

  Scenario: Obtain intraday status
    When I call the clock
    Then I receive information about the current day status

  Scenario Outline: Obtain information of a company
    Given There exist content related to <keyword>
    When I call a query for q: <keyword>
    Then I receive information of the searched company

    Examples:
      | keyword  |
      | alphabet |

  Scenario Outline: Search for symbols
    Given There are symbols related with <keyword>
    When I call the symbol for q: <keyword>
    Then I receive information about the searched symbol

    Examples:
      | keyword |
      | goog    |

  Scenario Outline: Obtain market information of a month
    Given I want the calendar of <month> of <year>
    When I call the calendar with the <month> of the <year>
    Then I receive information about the month status

    Examples:
      | month | year |
      | 3     | 2019 |