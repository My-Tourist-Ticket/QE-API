Feature: Endpoint Packages

#  Scenario Outline: Register pengelola
#    Given Register pengelola with valid "<json>"
#    When Send request register pengelola
#    Then Status code should be 200
#    And Response body message was "success register data"
#    Examples:
#      | json                 |
#      | RegistPengelola.json |

  Scenario Outline: Login pengelola
    Given Login pengelola with valid "<json>"
    When Send request login pengelola
    Then Status code should be 200
    And Response body message was "success login"
    Examples:
      | json                       |
      | LoginPengelolaPackage.json |

  Scenario Outline: Create package with valid tour_id
    Given Create package with valid "<tour_id>"
    When Send request create package
    Then Status code should be 200
    And Response body message was "success insert data"
    And Validate package json schema "CreatePackageSchema.json"
    Examples:
      | tour_id |
      | 12      |

  Scenario Outline: Create package with invalid tour_id
    Given Create package with invalid "<tour_id>"
    When Send request create package
    Then Status code should be 500
    And Response body message was "error insert data"
    And Validate package json schema "CreatePackageInvalidSchema.json"
    Examples:
      | tour_id  |
      | 88888888 |

  Scenario Outline: Create package without tour_id
    Given Create package without "<tour_id>"
    When Send request create package
    Then Status code should be 404
    And Response body message was "Not Found"
    Examples:
      | tour_id |
      |         |

  Scenario Outline: Create package without login
    Given Create package with valid "<tour_id>" and without login
    When Send request create package without login
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    Examples:
      | tour_id |
      | 12      |

    Scenario Outline: Get package with valid tour_id
      Given Get package with valid "<tour_id>"
      When Send request get package
      Then Status code should be 200
      And Response body message was "success read data"
      Examples:
        | tour_id |
        | 12      |

    Scenario Outline: Get package with invalid tour_id
      Given Get package with invalid "<tour_id>"
      When Send request get package
      Then Status code should be 404
      And Response body message was "record not found"
      Examples:
        | tour_id  |
        | 88888888 |

    Scenario Outline: Get package without tour_id
      Given Get package without "<tour_id>"
      When Send request get package
      Then Status code should be 404
      And Response body message was "Not Found"
      Examples:
        | tour_id |
        |         |

    Scenario Outline: Delete Package with valid id
      Given Delete package with valid "<id>"
      When Send request delete package
      Then Status code should be 200
      And Response body message was "success delete data"
      Examples:
        | id |
        | 25 |

    Scenario Outline: Delete package with invalid id
      Given Delete package with invalid "<id>"
      When Send request delete package
      Then Status code should be 500
      And Response body message was "error delete data error record not found"
      Examples:
        | id     |
        | 222222 |

    Scenario Outline: Delete package without id
      Given Delete package without "<id>"
      When Send request delete package
      Then Status code should be 404
      And Response body message was "Not Found"
      Examples:
        | id |
        |    |

    Scenario Outline: Delete package without login
      Given Delete package with valid "<id>" and without login
      When Send request delete package without login
      Then Status code should be 401
      And Response body message was "missing or malformed jwt"
      Examples:
        | id |
        | 2  |