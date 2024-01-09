Feature: Order Products

  @test @smokeTest
  Scenario Outline: Search products by name
    Given User is on GreenCart Landing page
    When User search product using <Name> and extracts actual name of product
    Then User search <Name> in offers page if product product exists
    And Validate product name in offers page matches with Landing Page
    Examples:
      | Name |
      | Tom  |
      | Beet |

  @negative
  Scenario Outline: Search products by name products not in the list
    Given User is on GreenCart Landing page
    When User search product using <Name> and extracts actual name of product
    Then User search <Name> in offers page if product product exists
    And Validate product name in offers page matches with Landing Page
    Examples:
      | Name  |
      | salsa |
      | oi    |