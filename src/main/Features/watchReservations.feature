@tag1
Feature: admin sees the housing reservations on the system
  Scenario: Watching reservations with all information
  Given admin pressed "2" to show housing reservations
  And   admin is logged in with "admin" and "123456"
  Then  housing reservations appears using function showReservations with many database Queries to print all information


