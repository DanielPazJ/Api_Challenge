Feature: Trading
  The API let me interact with an order,
  I can modify or cancel an exiting order


  Scenario: Modify an order
    Given I have an order I want to Modify
    When I call the API with new order data
    Then The data of the order changes

  Scenario: Cancel an order
    Given I have an order I want to Cancel
    When I call the API with account id: account_id and order id: order_id
    Then The order is canceled