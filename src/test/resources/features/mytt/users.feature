Feature: Endpoint Users

  #CREATE USER
#  Scenario Outline: Create users with valid data as costumer
#    Given Create users with valid data "<json>"
#    When Send request create users
#    Then Status code should be 200
#    And Response body message was "success register data"
#    And Validate login user json schema "RegisterSuccessSchema.json"
#    Examples:
#      | json               |
#      | CreateNewUser.json |

#  Scenario Outline: Create users with valid data as pengelola
#    Given Create users with valid data "<json>"
#    When Send request create users
#    Then Status code should be 200
#    And Response body message was "success register data"
#    And Validate login user json schema "RegisterSuccessSchema.json"
#    Examples:
#      | json                    |
#      | CreateNewPengelola.json |

#  Scenario Outline: Create users with valid data as admin
#    Given Create users with valid data "<json>"
#    When Send request create users
#    Then Status code should be 200
#    And Response body message was "success register data"
#    And Validate login user json schema "RegisterSuccessSchema.json"
#    Examples:
#      | json                |
#      | CreateNewAdmin.json |

  Scenario Outline: Create users with duplicate in phone number field
    Given Create users with duplicate in "<json>" field
    When Send request create users
    Then Status code should be 400
    And Response body message was "error register data"
    And Validate login user json schema "RegisterFailedSchema.json"
    Examples:
      | json                           |
      | CreateUserDuplicateNumber.json |

  Scenario Outline: Create users with duplicate in email field
    Given Create users with duplicate in "<json>" field
    When Send request create users
    Then Status code should be 400
    And Response body message was "error register data"
    And Validate login user json schema "RegisterFailedSchema.json"
    Examples:
      | json                          |
      | CreateUserDuplicateEmail.json |

  Scenario Outline: Create users pengelola with duplicate in no ktp field
    Given Create users with duplicate in "<json>" field
    When Send request create users
    Then Status code should be 400
    And Response body message was "error register data"
    And Validate login user json schema "RegisterFailedSchema.json"
    Examples:
      | json                        |
      | CreateUserDuplicateKTP.json |

  #LOGIN
  Scenario Outline: Login users with valid credentials as costumer
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login" and role was "costumer"
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
      | json           |
      | LoginUser.json |

  Scenario Outline: Login users with valid credentials as pengelola
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login" and role was "pengelola"
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
      | json                |
      | LoginPengelola.json |

  Scenario Outline: Login users with valid credentials as admin
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login" and role was "admin"
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
      | json        |
      | LoginAdmin.json |

  Scenario Outline: Login users with invalid credentials
    Given Login users with invalid credentials in "<json>"
    When Send request login user
    Then Status code should be 401
    And Response body message was "error login"
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


  #GET USER
  Scenario: Get single user when logged in as costumer
    Given Get single user as costumer
    When Send request get single user
    Then Status code should be 200
    And Response body message was "success read data"
    And Validate product json schema "GetSingleUserSchema.json"

  Scenario: Get single user when logged in as pengelola
    Given Get single user as pengelola
    When Send request get single user
    Then Status code should be 200
    And Response body message was "success read data"
    And Validate product json schema "GetSingleUserSchema.json"

  Scenario: Get user without logged in
    Given Get single user
    When Send request get single user
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    And Validate product json schema "LoginInvalidSchema.json"

  Scenario: Get user with invalid or expired token
    Given Get single user with invalid token
    When Send request get single user
    Then Status code should be 401
    And Response body message was "invalid or expired jwt"
    And Validate product json schema "LoginInvalidSchema.json"

  Scenario: Get list user
    Given Get list user
    When Send request get list user
    Then Status code should be 200
    And Response body message was "success read data"

  #Update User
  Scenario Outline: Update user with valid data
    Given Update user with valid "<full_name>","<phone_number>","<email>","<password>","<image>"
    When Send request update user
    Then Status code should be 200
    And Response body message was "success update data"
    And Validate product json schema "SuccessMessageSchema.json"
    Examples:
      | full_name | phone_number | email             | password | image |
      | dummy4    | +6200000000  | dumdum3@gmail.com | 123456   |       |

  Scenario Outline: Update user with same email as other user
    Given Update user with same email "<email>"
    When Send request update user
    Then Status code should be 400
    And Response body message was "error update data."
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | email              |
      | rayhan12@gmail.com |

  Scenario Outline: Update user with same phone number as other user
    Given Update user with same phone number "<phone_number>"
    When Send request update user
    Then Status code should be 400
    And Response body message was "error update data."
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | phone_number   |
      | +6281987654321 |

#  Scenario Outline: Update status pengelola with valid id
#    Given Update status "<status>" pengelola with valid <id>
#    When Send request update status pengelola
#    Then Status code should be 200
#    And Response body message was "success update data"
#    And Validate product json schema "SuccessMessageSchema.json"
#    Examples:
#      | status   | id |
#      | approved | 17 |

  Scenario Outline: Update status pengelola with invalid id
    Given Update status "<status>" pengelola with invalid <id>
    When Send request update status pengelola
    Then Status code should be 404
    And Response body message was "error update data."
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | status   | id      |
      | approved | 1203912 |

#  Scenario: Delete user when logged in
#    Given Delete user
#    When Send request delete user
#    Then Status code should be 200
#    And Response body message was "success delete data"
#    And Validate product json schema "SuccessMessageSchema.json"

  Scenario: Delete user without logged in
    Given Delete user without logged in
    When Send request delete user
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    And Validate product json schema "FailedMessageSchema.json"