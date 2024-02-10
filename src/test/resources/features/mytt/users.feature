Feature: Endpoint Users

  #LOGIN
  Scenario Outline: Login users with valid credentials as costumer
    Given Login users with valid "<json>" as costumer
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login" and role was "costumer"
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
      | json           |
      | LoginUser.json |

  Scenario Outline: Login users with valid credentials as pengelola
    Given Login users with valid "<json>" as pengelola
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login" and role was "pengelola"
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
      | json                |
      | LoginPengelola.json |

  Scenario Outline: Login users with invalid credentials
    Given Login users with invalid credentials in "<json>"
    When Send request login user
    Then Status code should be 401
    And Response body message was "error login. record not found."
    And Validate login user json schema "LoginInvalidSchema.json"
    Examples:
      | json                         |
      | LoginInvalidCredentials.json |

  Scenario Outline: Login users with empty email field
    Given Login users with empty email in "<json>"
    When Send request login user
    Then Status code should be 401
    And Response body message was "error login. email wajib diisi."
    And Validate login user json schema "LoginInvalidSchema.json"
    Examples:
      | json                 |
      | LoginEmptyEmail.json |

  Scenario Outline: Login users with empty password field
    Given Login users with empty password in "<json>"
    When Send request login user
    Then Status code should be 401
    And Response body message was "error login. password wajib diisi."
    And Validate login user json schema "LoginInvalidSchema.json"
    Examples:
      | json                    |
      | LoginEmptyPassword.json |

  #GET SINGLE USER
  Scenario: Get single user as costumer
    Given Get single user as costumer
    When Send request get single user
    Then Status code should be 200
    And Response body message was "success read data"
    And Validate product json schema "GetSingleUserSchema.json"