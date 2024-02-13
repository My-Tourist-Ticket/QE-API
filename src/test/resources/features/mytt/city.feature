Feature: Endpoint City

  Scenario: Get all city with valid param
    Given Get all city with valid parameter
    When Send request get all city
    Then Status code should be 200
    And Response body message was "success get data"
    And Validate city json schema "GetAllCitySchema.json"

  Scenario: Get all city with invalid param
    Given Get all city with invalid parameter
    When Send request get all city with invalid param
    Then Status code should be 404
    And Response body message was "Not Found"
    And Validate city json schema "GetAllCityInvalidSchema.json"

#  Scenario Outline: Create city with valid data
#    Given Create city with valid data "<city_name>","<description>","<image>","<thumbnail>"
#    When Send request create city
#    Then Status code should be 200
#    And Response body message was "city created successfully"
#    Examples:
#      | city_name   | description               | image               | thumbnail           |  |  |  |  |
#      | jawa tengah | wisata alam kota semarang | dusun bambu_bdg.PNG | dusun bambu_bdg.PNG |  |  |  |  |

  Scenario Outline: Create city with empty city_name
    Given Create city with invalid "<json>"
    When Send request create city
    Then Status code should be 400
    And Response body message was "error retrieving the image file"
    And Validate city json schema "CreateCityInvalidSchema.json"
    Examples:
      | json                     |
      | CreateCityEmptyDesc.json |

  Scenario Outline: Create city with empty description
    Given Create city with invalid data "<json>"
    When Send request create city
    Then Status code should be 400
    And Response body message was "error retrieving the image file"
    And Validate city json schema "CreateCityInvalidSchema.json"
    Examples:
     | json                     |
     | CreateCityEmptyDesc.json |

  Scenario Outline: Create city with empty city_name and description
    Given Create city with empty "<json>"
    When Send request create city
    Then Status code should be 400
    And Response body message was "error retrieving the image file"
    And Validate city json schema "CreateCityInvalidSchema.json"
    Examples:
     | json                    |
     | CreateCityEmptyAll.json |

  Scenario: Create city without login
    Given Create city without login
    When Send request create city without login
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"

  Scenario Outline: Get detail city with valid param
    Given Get detail city with valid "<id>"
    When Send request get detail city
    Then Status code should be 200
    And Response body message was "City data retrieved successfully"
    And Validate city json schema "GetDetailCitySchema.json"
    Examples:
      | id |
      | 1  |

  Scenario Outline: Get detail city with invalid param
    Given Get detail city with invalid "<id>"
    When Send request get detail city
    Then Status code should be 500
    And Response body message was "Error retrieving city data"
    And Validate city json schema "GetDetailCityInvalidSchema.json"
    Examples:
      | id     |
      | 112345 |

  Scenario Outline: Get detail city without id
    Given Get detail city without "<id>"
    When Send request get detail city
    Then Status code should be 200
    And Response body message was "success get data"
    Examples:
      | id |
      |    |

  Scenario Outline: Update city with valid data
    Given Update city with valid "<id>"
    When Send request update city
    Then Status code should be 400
    And Response body message was "Error retrieving the image file"
    And Validate city json schema "UpdateCitySchema.json"
    Examples:
      | id |
      | 2  |
  Scenario Outline: Update city with invalid id
    Given Update city with invalid "<id>"
    When Send request update city
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    Examples:
      | id      |
      | 1234567 |

  Scenario Outline: Update city without id
    Given Update city without "<id>"
    When Send request update city
    Then Status code should be 405
    And Response body message was "Method Not Allowed"
    Examples:
      | id |
      |    |

  Scenario Outline: Update city without login
    Given Update city with valid "<id>" and without login
    When Send request update city without login
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    Examples:
      | id |
      | 4  |

#  Scenario Outline: Delete city with valid id
#    Given Delete city with valid "<id>"
#    When Send request delete city
#    Then Status code should be 200
#    And Response body message was "success delete city"
#    And Validate city json schema "DeleteCitySchema.json"
#    Examples:
#      | id |
#      | 4  |

  Scenario Outline: Delete city with invalid id
    Given Delete city with invalid "<id>"
    When Send request delete city
    Then Status code should be 500
    And Response body message was "error delete city. delete failed city not found"
    And Validate city json schema "DeleteCityInvalidSchema.json"
    Examples:
      | id     |
      | 888888 |

  Scenario Outline: Delete city without id
    Given Delete city without "<id>"
    When Send request delete city
    Then Status code should be 405
    And Response body message was "Method Not Allowed"
    And Validate city json schema "DeleteCityWithoutIdSchema.json"
    Examples:
      | id |
      |    |

 Scenario Outline: Delete city without login
   Given Delete city with valid "<id>" and without login
   When Send request delete without login
   Then Status code should be 401
   And Response body message was "missing or malformed jwt"
   Examples:
     | id |
     | 4  |

