Feature: Testing of Web Page Challenging Dom

  Scenario: Verify Web page is opening and user can see Title as "Challenging DOM" on the web page
    Given Open the browser
    When I open Challenging Dom website
    And Verify Web Page Title as Challenging DOM is displayed on UI
    Then Close the browser

  Scenario: Verify buttons on the Web page changing Id's on click event
    Given  Open the browser
    When I open Challenging Dom website
    Then Verify three buttons on UI in blue Red and Green
    Then Close the browser

  Scenario: Verify table header on the Web Page
    Given Open the browser
    When I open Challenging Dom website
    Then Verify table header on webPage
    Then Close the browser

  Scenario: Verify table edit button on the Web Page
    Given Open the browser
    When I open Challenging Dom website
    And Verify edit  button in the Action column
    Then Close the browser

  Scenario: Verify table delete button on the Web Page
    Given Open the browser
    When I open Challenging Dom website
    And Verify delete  button in the Action column
    Then Close the browser

