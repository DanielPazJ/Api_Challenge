Feature: Account
#  The API shows the information of an specific
#  account
#
#  Background:
#    Given There is an account with the account id: account_id
#
#  Scenario: See account's balance
#    When I request the account balance
#    Then I receive the actual account balance
#
#  Scenario: See account's positions
#    When I request the account's positions
#    Then I receive information of the positions held in the account
#
#  Scenario: See account's history
#    When I request the account's historical activity
#    And I select the number of pages: #_pages and the number of results per page: #_results
#    Then I receive the history information within the wanted parameters
#
#  Scenario: See account's cost basis
#    When I request the account's cost basis
#    And I select the number of pages: #_pages and the number of results per page: #_results
#    Then I receive the cost basis information for the account within the wanted parameters.
#
#  Scenario: See account's orders
#    When I request the account's orders
#    And I select the number of pages: #_pages, the number of results per page: #_results and the date: date
#    Then I receive the orders placed with the account
#
#  Scenario: See account's individual order
#    When I request an order by the id: order_id
#    Then I receive detailed information about an specific order