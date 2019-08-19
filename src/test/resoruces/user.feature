Feature: User
  The API shows the information of an specific
  user


  Background:
    Given There is an user

  Scenario: See user's profile
    When I request the user's profile
    Then I receive information of the user profile

  Scenario: See user´s balances
    When I request the user's balances
    Then I receive the actual information of the user´s balances

  #there is a note  this will be removed from here
  Scenario: See user's positions
    When I request the user's position
    Then I receive information about the positions of the user

  Scenario: See user's history
    When I request the user's history
    Then I receive history information of the user

  Scenario: See user's cost basis
    When I request cost basis information of a user
    Then I receive the cost basis information for the user

  Scenario: See user´s orders
    When I request the user's orders
    Then I receive the orders made by the user