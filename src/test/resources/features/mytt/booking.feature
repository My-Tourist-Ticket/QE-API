Feature: Booking

  Scenario: Create booking valid data
    Given Create booking valid data "CreateBookingValidData.json"
    When Send request create booking valid data
    Then Status code should be 200
    And Response body message was "success insert booking"
    And Validate create booking json schema "CreateBookingSchema.json"

  Scenario: Create booking invalid tour id
    Given Create booking invalid tour id "CreateBookingInvalidTourId.json"
    When Send request create booking valid data
    Then Status code should be 400
    And Response body message was "error bind data. data booking not valid"

  Scenario: Create booking invalid package id
    Given Create booking invalid package id "CreateBookingInvalidPackageId.json"
    When Send request create booking valid data
    Then Status code should be 400
    And Response body message was "error bind data. data booking not valid"

  Scenario: Create booking invalid voucher id
    Given Create booking invalid voucher id "CreateBookingInvalidVoucherId.json"
    When Send request create booking valid data
    Then Status code should be 400
    And Response body message was "error bind data. data booking not valid"

  Scenario: Create booking empty bank
    Given Create booking empty bank "CreateBookingEmptyBank.json"
    When Send request create booking valid data
    Then Status code should be 400
    And Response body message was "bank is required"

  Scenario: Create booking empty date
    Given Create booking empty date "CreateBookingEmptyDate.json"
    When Send request create booking valid data
    Then Status code should be 400
    And Response body message was "booking date is required"

  Scenario: Create booking empty phone number
    Given Create booking empty phone number "CreateBookingEmptyPhoneNumber.json"
    When Send request create booking valid data
    Then Status code should be 400
    And Response body message was "phone number is required"

  Scenario: Create booking empty greeting
    Given Create booking empty greeting "CreateBookingEmptyGreeting.json"
    When Send request create booking valid data
    Then Status code should be 400
    And Response body message was "greeting is required"

  Scenario: Create booking empty full name
    Given Create booking empty full name "CreateBookingEmptyFullName.json"
    When Send request create booking valid data
    Then Status code should be 400
    And Response body message was "full name number is required"

  Scenario: Create booking empty email
    Given Create booking empty email "CreateBookingEmptyEmail.json"
    When Send request create booking valid data
    Then Status code should be 400
    And Response body message was "email is required"

  Scenario: Create booking empty quantity
    Given Create booking empty quantity "CreateBookingInvalidQuantity.json"
    When Send request create booking valid data
    Then Status code should be 400
    And Response body message was "error bind data. data booking not valid"

  Scenario Outline: Create review by booking id valid data
    Given Create review by booking "<id>" valid data "CreateReviewBookingValidData.json"
    When Send request create review by booking valid data
    Then Status code should be 201
    And Response body message was "review created successfully"
    And Validate create booking json schema "CreateReviewBookingSchema.json"
    Examples:
      | id                                   |
      | 454e99ef-c4be-4988-924f-7ae2d6603c6a |

  Scenario Outline: Create review by booking id empty text review
    Given Create review by booking "<id>" empty text review "CreateReviewBookingEmptyTextReview.json"
    When Send request create review by booking valid data
    Then Status code should be 400
    And Response body message was "text review is required"
    And Validate create booking json schema "CreateReviewBookingSchema.json"
    Examples:
      | id                                   |
      | 454e99ef-c4be-4988-924f-7ae2d6603c6a |

  Scenario Outline: Create review by booking id invalid star rate
    Given Create review by booking "<id>" invalid star rate "CreateReviewBookingInvalidStarRate.json"
    When Send request create review by booking valid data
    Then Status code should be 400
    And Response body message was "star rate is not valid"
    And Validate create booking json schema "CreateReviewBookingSchema.json"
    Examples:
      | id                                   |
      | 454e99ef-c4be-4988-924f-7ae2d6603c6a |

  Scenario: Create booking without login
    Given Create booking without login "CreateBookingValidData.json"
    When Send request create booking valid data
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    And Validate create booking json schema "CreateReviewBookingSchema.json"


    ##============================================GET BOOKING==================================================##

  Scenario: Get booking as user
    Given Get booking as user
    When Send request get booking as user
    Then Status code should be 200
    And Response body message was "success read data."

  Scenario: Get booking as pengelola
    Given Get booking as pengelola
    When Send request get booking as pengelola
    Then Status code should be 200
    And Response body message was "success get data"

  Scenario: Get booking as pengelola when logged in as user
    Given Get booking as pengelola when logged in as user
    When Send request get booking as pengelola
    Then Status code should be 403
    And Response body message was "Forbidden - User is not an pengelola"

  Scenario: Get booking as pengelola when logged in as admin
    Given Get booking as pengelola when logged in as admin
    When Send request get booking as pengelola
    Then Status code should be 403
    And Response body message was "Forbidden - User is not an pengelola"

  Scenario: Get booking as admin
    Given Get booking as admin
    When Send request get booking as admin
    Then Status code should be 200
    And Response body message was "success get data"

  Scenario: Get booking as admin when logged in as user
    Given Get booking as admin when logged in as user
    When Send request get booking as admin
    Then Status code should be 403
    And Response body message was "Forbidden - User is not an admin"

  Scenario: Get booking as admin when logged in as pengelola
    Given Get booking as admin when logged in as pengelola
    When Send request get booking as admin
    Then Status code should be 403
    And Response body message was "Forbidden - User is not an admin"

  Scenario Outline: : Get booking details by valid id
    Given Get booking details by valid "<id>"
    When Send request get booking details by valid id
    Then Status code should be 200
    And Response body message was "success read data."
    Examples:
      | id                                   |
      | d297178b-0e1d-4ea4-af29-b650df9f0223 |

  Scenario Outline: Get booking details by invalid id
    Given Get booking details by invalid "<id>"
    When Send request get booking details by valid id
    Then Status code should be 404
    And Response body message was "booking id not found"
    Examples:
      | id                 |
      | @@@@@@@@@@@@@@@@@@ |

  ##===========================================PUT BOOKING====================================================##

  Scenario Outline: Cancel booking payment by id
    Given Cancel booking payment by "<id>"
    When Send request cancel booking payment by id
    Then Status code should be 200
    And Response body message was "success cancel booking"
    Examples:
      | id                                   |
      | 454e99ef-c4be-4988-924f-7ae2d6603c6a |

  Scenario Outline: Cancel booking payment by id
    Given Cancel booking payment by "<id>"
    When Send request cancel booking payment by id
    Then Status code should be 404
    And Response body message was "booking id not found"
    Examples:
      | id                                   |
      | 454e99ef-c4be-4988-924f-7ae2d6603c6a |