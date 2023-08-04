@tag2
Feature: Adding Residences Sakancom Application.

  Scenario: Check if owner logged in and selected add residence option
    Given owner wants to login and add a residence
    And owner enters "Ahmad mohammed" as username and "11223344" as a password
    Then owner logged in with "Ahmad mohammed" as username and "11223344" as a password and dashboard appears and adding list appears

  Scenario: owner wants to enter the department name
    Given owner is logged in with username "Ahmad mohammed" and  password "11223344" and selected "1" for housing then selected "1" to add housing.
    And enters "Academia" as department name using function departmentName
    Then department added successfully for owner "Ahmad mohammed"

  Scenario: owner wants to add photo to the housing
    Given owner is logged in with username "Ahmad mohammed" and  password "11223344" and selected "1" for housing then selected "1" for add housing
    And adding to the housing options appears and owner added "https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.aps.dz%2Far%2Fmedia%2Fk2%2Fitems%2Fcache%2Fba7d48d5da3d06214a58712cd912e2d8_M.jpg&tbnid=CZGpKyFyg6UDbM&vet=12ahUKEwiP98WcxreAAxVMnCcCHRPSBwgQMygBegUIARDzAQ..i&imgrefurl=https%3A%2F%2Fwww.aps.dz%2Far%2Fsociete%2F73518-2019-07-06-17-22-18&docid=1eDk2pf58SZW5M&w=580&h=320&q=%D8%B3%D9%83%D9%86&hl=en&authuser=0&ved=2ahUKEwiP98WcxreAAxVMnCcCHRPSBwgQMygBegUIARDzAQ" by function addPhoto
    Then photo added successfully for owner "Ahmad mohammed"

  Scenario: owner wants to add location
    Given owner is logged in with username "Ahmad mohammed" and  password "11223344" and selected "1" for housing and "1" for add housing
    And adding to the housing options appears and owner entered "description" as location and information by function addLocationInfo
    Then location and information added successfully for owner "Ahmad mohammed"

  Scenario: owner wants to add services
    Given owner is logged in with username "Ahmad mohammed" and  password "11223344" then selected "1" for housing and "1" for add housing
    And adding to the housing options appears and owner entered "Washing machine, iron, free internet" as services by function addServices
    Then services added successfully for owner "Ahmad mohammed"

  Scenario: owner wants to add price
    Given owner is logged in with username "Ahmad mohammed",  password "11223344" and selected "1" for housing and "1" for add housing
    And adding to the housing options appears and owner entered "1000 with electricity and water" as monthly rent by function addPrice
    Then monthly rent added successfully for owner "Ahmad mohammed"

    Scenario: show housings
      Given owner logged in
      And dashboard appears then selected "1" for housing then selected "2" for show housings full information using two queries from database
      Then housings and contact information appears for owner "Ahmad mohammed"

