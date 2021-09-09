    #Author
 #Date
  #Description
    Feature: User pass onboarding screens, add products from different category to basket, delete all products from basket
      Scenario: Scenario 2
        Given User should pass onboarding screensd
        Then User checks if home page exists or notd
        When User gets the number of categories and  write this number to console
        And User open a random category
        And User adds three random products to wishlist via mini heart icon
        And User opens the menu in the left
        And User go to ‘My Wishlist’
        Then User controls the page and products
        When User deletes all of them from Wishlist



