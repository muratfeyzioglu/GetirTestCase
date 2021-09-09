    #Author
 #Date
  #Description
    Feature: User pass onboarding screens, add products from different category to basket, delete all products from basket
      Scenario: Scenario 1
        Given User should pass onboarding screens
        Then User checks if home page exists or not
        When User changes category to ‘Baby Care’
        And  User open a random product detailb
        Then User adds this product to basket
        And Return last page
        When User changes category to ‘Snacks’
        And User open a random product detail
        Then User adds this product to basketb
        And Return last pageb
        When User goes to basket
        And Control added products and prices
        When User should deletes all products from basket
        Then Makes controls





