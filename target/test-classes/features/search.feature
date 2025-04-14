Feature:Search Functionality

  Scenario: User searches for a product on Daraz.pk
    Given the user is on the Daraz homepage
    When the user searches for "iPhone 13"
    Then results for "iPhone 13" should be displayed
