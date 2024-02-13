Feature: Endpoint Tours

  Scenario Outline: Add tour by pengelola with valid data
    Given Add tour by pengelola with valid "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,<city_id>
    When Send request add tour by pengelola
    Then Status code should be 201
    And Response body message was "tour created successfully"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | tour_name      | description       | image              | thumbnail          | address      | latitude | longitude | city_id |
      | Pantai Pandawa | Pantai Pandawa is | pantai_pandawa.jpg | pantai_pandawa.jpg | Jl. kenangan | 3.4354634| -313.43546| 2       |


  Scenario Outline: Add tour by admin with valid data
    Given Add tour by admin with valid "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,<city_id>
    When Send request add tour by admin
    Then Status code should be 403
    And Response body message was "Forbidden - User is not a pengelola"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | tour_name      | description       | image              | thumbnail          | address      | latitude | longitude | city_id |
      | Pantai Pandawa | Pantai Pandawa is | pantai_pandawa.jpg | pantai_pandawa.jpg | Jl. kenangan | 3.4354634| -313.43546| 2       |


  Scenario Outline: Add tour by user with valid data
    Given Add tour by user with valid "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,<city_id>
    When Send request add tour by user
    Then Status code should be 403
    And Response body message was "Forbidden - User is not a pengelola"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | tour_name      | description       | image              | thumbnail          | address      | latitude | longitude | city_id |
      | Pantai Pandawa | Pantai Pandawa is | pantai_pandawa.jpg | pantai_pandawa.jpg | Jl. kenangan | 3.4354634| -313.43546| 2       |


  Scenario Outline: Add tour with empty tour name
    Given Add tour with empty tour name "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,<city_id>
    When Send request add tour with empty tour name
    Then Status code should be 400
    And Response body message was "tour name is required"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | tour_name | description       | image              | thumbnail          | address      | latitude  | longitude  | city_id |
      |           | Pantai Pandawa is | pantai_pandawa.jpg | pantai_pandawa.jpg | Jl. kenangan | 3.4354634 | -313.43546 | 2       |


  Scenario Outline: Add tour with empty description
    Given Add tour with empty description "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,<city_id>
    When Send request add tour with empty description
    Then Status code should be 400
    And Response body message was "description is required"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | tour_name      | description | image              | thumbnail          | address      | latitude  | longitude  | city_id |
      | Pantai Pandawa |             | pantai_pandawa.jpg | pantai_pandawa.jpg | Jl. kenangan | 3.4354634 | -313.43546 | 2       |


  Scenario Outline: Add tour with empty image
    Given Add tour with empty image "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,<city_id>
    When Send request add tour with empty image
    Then Status code should be 400
    And Response body message was "image is required"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | tour_name      | description       | image | thumbnail          | address      | latitude  | longitude  | city_id |
      | Pantai Pandawa | Pantai Pandawa is |       | pantai_pandawa.jpg | Jl. kenangan | 3.4354634 | -313.43546 | 2       |


  Scenario Outline: Add tour with empty thumbnail
    Given Add tour with empty thumbnail "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,<city_id>
    When Send request add tour with empty thumbnail
    Then Status code should be 400
    And Response body message was "thumbnail is required"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | tour_name      | description       | image              | thumbnail | address      | latitude  | longitude  | city_id |
      | Pantai Pandawa | Pantai Pandawa is | pantai_pandawa.jpg |           | Jl. kenangan | 3.4354634 | -313.43546 | 2       |


  Scenario Outline: Add tour with empty address
    Given Add tour with empty address "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,<city_id>
    When Send request add tour with empty address
    Then Status code should be 400
    And Response body message was "address is required"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | tour_name      | description       | image              | thumbnail          | address | latitude  | longitude  | city_id |
      | Pantai Pandawa | Pantai Pandawa is | pantai_pandawa.jpg | pantai_pandawa.jpg |         | 3.4354634 | -313.43546 | 2       |


  Scenario Outline: Add tour with empty latitude
    Given Add tour with empty latitude "<tour_name>","<description>","<image>","<thumbnail>","<address>","<latitude>",<longitude>,<city_id>
    When Send request add tour with empty latitude
    Then Status code should be 400
    And Response body message was "latitude is required"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | tour_name      | description       | image              | thumbnail          | address      | latitude | longitude  | city_id |
      | Pantai Pandawa | Pantai Pandawa is | pantai_pandawa.jpg | pantai_pandawa.jpg | Jl. kenangan |          | -313.43546 | 2       |


  Scenario Outline: Add tour with empty longitude
    Given Add tour with empty longitude "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,"<longitude>",<city_id>
    When Send request add tour with empty longitude
    Then Status code should be 400
    And Response body message was "longitude is required"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | tour_name      | description       | image              | thumbnail          | address      | latitude  | longitude | city_id |
      | Pantai Pandawa | Pantai Pandawa is | pantai_pandawa.jpg | pantai_pandawa.jpg | Jl. kenangan | 3.4354634 |           | 2       |


  Scenario Outline: Add tour with empty city id
    Given Add tour with empty city id "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,"<city_id>"
    When Send request add tour with empty city id
    Then Status code should be 400
    And Response body message was "city id is required"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | tour_name      | description       | image              | thumbnail          | address      | latitude  | longitude  | city_id |
      | Pantai Pandawa | Pantai Pandawa is | pantai_pandawa.jpg | pantai_pandawa.jpg | Jl. kenangan | 3.4354634 | -313.43546 |         |


  Scenario Outline: Add tour report with id when logged in as user
    Given Add tour report with id when logged in as user "<json>"
    When Send request add tour report with id when logged as user
    Then Status code should be 200
    And Response body message was "success insert data"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | json                     |
      | AddTourReportAsUser.json |


  Scenario Outline: Add tour report by id without login
    Given Add tour report by id without login "<json>"
    When Send request add tour report by id without login
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | json                     |
      | AddTourReportAsUser.json |

  ##=====================================================GET TOUR=======================================================##

  Scenario: Get all tour when logged in as pengelola
    Given Get all tour when logged in as pengelola
    When Send request get all tour when logged in as pengelola
    Then Status code should be 200
    And Response body message was "success get data"

  Scenario: Get all tour pengelola invalid path
    Given Get all tour pengelola invalid path
    When Send request get all tour pengelola invalid path
    Then Status code should be 404
    And Response body message was "Not found"

  Scenario Outline: Get tour with id
    Given Get all tour tour with <id>
    When Send request get tour with id
    Then Status code should be 200
    And Response body message was "Tour data retrieved successfully"
    Examples:
      | id |
      | 12 |

  Scenario Outline: Get tour with invalid id
    Given Get all tour tour with invalid <id>
    When Send request get tour with invalid id
    Then Status code should be 404
    And Response body message was "Error retrieving tour data"
    Examples:
      | id      |
      | 1234455 |

  Scenario Outline: Get tour with city id
    Given Get all tour tour with city <id>
    When Send request get tour with city id
    Then Status code should be 200
    And Response body message was "success get data"
    Examples:
      | id |
      | 1  |

  Scenario Outline: Get tour with invalid city id
    Given Get all tour tour with invalid city <id>
    When Send request get tour with city id
    Then Status code should be 404
    And Response body message was "City not found"
    Examples:
      | id |
      | 1212 |

  Scenario Outline: Get tour report with id
    Given Get all tour tour report with <id>
    When Send request get tour report with id
    Then Status code should be 200
    And Response body message was "success get data"
    Examples:
      | id |
      | 7  |

  Scenario Outline: Get tour search with param tour name
    Given Get tour search with param "<tour_name>"
    When Send request get tour search with param tour name
    Then Status code should be 200
    And Response body message was "success read data"
    Examples:
      | tour_name |
      | update    |

    ##===================================================UPDATE DATA=================================================##

  Scenario Outline: Update tour based on id
    Given Update tour based on <id> with "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,<city_id>
    When Send request update tour based on id
    Then Status code should be 200
    And Response body message was "Tour updated successfully"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | id | tour_name             | description              | image              | thumbnail          | address    | latitude  | longitude  | city_id |
      | 10 | Pantai Pandawa update | Pantai Pandawa update is | pantai_pandawa.jpg | pantai_pandawa.jpg | Jl. udpate | 3.4354634 | -313.43546 | 2       |

  Scenario Outline: Update tour based on invalid id
    Given Update tour based on invalid <id> with "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,<city_id>
    When Send request update tour based on id
    Then Status code should be 404
    And Response body message was "Error updating tour, error: tour not found"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | id      | tour_name             | description              | image              | thumbnail          | address    | latitude  | longitude  | city_id |
      | 1234567 | Pantai Pandawa update | Pantai Pandawa update is | pantai_pandawa.jpg | pantai_pandawa.jpg | Jl. udpate | 3.4354634 | -313.43546 | 2       |

  Scenario Outline: Update tour without login
    Given Update tour without login based on valid <id> with "<tour_name>","<description>","<image>","<thumbnail>","<address>",<latitude>,<longitude>,<city_id>
    When Send request update tour based on id
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    And Validate add tour json schema "SuccessMessageSchema.json"
    Examples:
      | id | tour_name             | description              | image              | thumbnail          | address    | latitude  | longitude  | city_id |
      | 10 | Pantai Pandawa update | Pantai Pandawa update is | pantai_pandawa.jpg | pantai_pandawa.jpg | Jl. udpate | 3.4354634 | -313.43546 | 2       |


    ##==================================================DELETE TOUR=====================================================##


  Scenario Outline: Delete tour by id
    Given Delete tour by <id>
    When Send request delete tour by id
    Then Status code should be 200
    And Response body message was "success delete tour"
    Examples:
      | id |
      | 25 |

  Scenario Outline: Delete tour without id
    Given Delete tour without "<id>"
    When Send request delete tour by id
    Then Status code should be 405
    And Response body message was "Method Not Allowed"
    Examples:
      | id |
      |    |

  Scenario Outline: Delete tour with invalid id
    Given Delete tour with invalid <id>
    When Send request delete tour by id
    Then Status code should be 404
    And Response body message was "error delete tour. delete failed tour not found"
    Examples:
      | id      |
      | 1234567 |