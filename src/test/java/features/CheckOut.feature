Feature: Order Products

  @checkout
  Scenario Outline: Search products by name
    Given User is on GreenCart Landing page
    When User search product using <Name> and extracts actual name of product
    Then User search <Name> in offers page if product product exists
    And Validate product name in offers page matches with Landing Page
    Examples:
      | Name |
      | Tom  |
      | Beet |