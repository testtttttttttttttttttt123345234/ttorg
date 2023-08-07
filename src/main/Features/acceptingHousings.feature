@tag1
Feature: Scenes of requests for advertisement of housing and the ability to accept and reject it

  Scenario: admin accepts housings
    Given admin logged in with "admin" as username and "123456" as password and dashboard appears
    And selected "1" from dashboard to see the pending housings using function pending housings
    And entered "11" to select pending housing then Selected "Yes" to accept the housing
    Then housing accepted

  Scenario: admin rejects housings
    Given admin logged in with "admin" as username and "123456" as password then dashboard appears
    And selected "1" from dashboard and see the pending housings
    And entered "12" to select pending housing and Selected "No" to accept the housing
    Then housing rejected
