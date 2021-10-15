Feature: Homework 5 Tests

  Scenario: Check Different Elements Page log row

    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    And I click on Checkboxes, Radio and Dropdown
    Then For every chosen item there is individual log row
    And The value is corresponded to the status of elements

  Scenario Outline: UserTable Page  test

    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown

    Then "User Table" page should be opened
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 Usernames should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And User table should contain following '<Number>' number '<User>' user '<Description>' description values:

    Examples:
      | Number | User             | Description                      |

      | 1      | Roman            | Wolverine                        |

      | 2      | Sergey Ivan      | Spider Man                       |

      | 3      | Vladzimir        | Punisher                         |

      | 4      | Helen Bennett    | Captain America some description |

      | 5      | Yoshi Tannamuri  | Cyclope some description         |

      | 6      | Giovanni Rovelli | Hulk some description             |


  Scenario: UserTable Page Droplist test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    And Droplist should contain values in column Type for user Roman

      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |

  Scenario: Check log row for Vip condition

    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    And I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section

