Feature: Endpoint Users

  #LOGIN
  Scenario Outline: Login users with valid data
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login" and role was "costumer"
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
      | json           |
      | LoginUser.json |

  #GET SINGLE USER
  Scenario: Get single user
    Given Get single user
    When Send request get single user
    Then Status code should be 200
    And Response body message was "success read data"
    And Validate product json schema "GetSingleUserSchema.json"