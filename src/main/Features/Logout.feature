@tag2
Feature: admin, tenant or owner logging out.

  Scenario: owner wants to logout
  Given owner is logged in
  And  selected "2" from the dashboard
  Then owner logged out successfully

  Scenario: admin wants to logout
    Given admin is logged in
    And  selected "3" from admin dashboard
    Then admin logged out successfully

  Scenario: tenant wants to logout
    Given tenant is logged in
    And  selected "4" from tenant dashboard
    Then tenant logged out successfully by checking a flag