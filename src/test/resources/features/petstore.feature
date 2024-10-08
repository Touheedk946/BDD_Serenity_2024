Feature: Pet Store API

  Scenario: Fetching an already available pet
    Given Kitty is available in the pet store
    When I ask for a pet using Kitty's ID
    Then I get Kitty as a result
