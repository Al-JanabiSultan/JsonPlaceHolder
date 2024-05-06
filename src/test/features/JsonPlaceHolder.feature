@GETPosts
Feature: GET Posts

  Background:
    Given the JSONPlaceholder is reachable

  @GETVerifyNumberOfPosts
  Scenario: Verify the Number of Posts Returned
    When the user sends a GET request
    Then the response status code should be 200
    And the response contains 100 posts

  @GETVerifyResponseFormat
  Scenario: Verify the Response Format Of The Request
    When the user sends a GET request
    Then the response status code should be 200
    And the response should be in JSON format
    And the response contains 100 posts

  @GETVerifyStructureOfPosts
  Scenario: Verify the Structure of  Posts
    When the user sends a GET request
    Then the response status code should be 200
    And the response contains 100 posts
    And each post should have correct fields

  @GETVerifyBehaviorInvalidEndpoint
  Scenario: Verify behavior with invalid endpoint
    When the user sends a GET request to the invalid endpoint
    Then the response should indicate a client error

  @GETVerifyUserPostIntegration
  Scenario: Verify User and Post are Integrated
    When the user sends a GET request
    Then the response status code should be 200
    Then the user can find the name of the post publisher

  @GETVerifyResponseTime
  Scenario: Verify response is an acceptable time
    Given the user sends a GET request
    Then the response time should be less than 1000 milliseconds

