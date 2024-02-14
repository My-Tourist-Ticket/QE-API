Feature: Endpoint Vouchers

  #CREATE VOUCHERS
#  Scenario Outline: Create vouchers with valid data
#    Given Create voucher with valid data in "<json>"
#    When Send request create voucher
#    Then Status code should be 200
#    And Response body message was "success insert data"
#    And Validate product json schema "SuccessMessageSchema.json"
#    Examples:
#      | json               |
#      | CreateVoucher.json |

  Scenario Outline: Create voucher with empty name field
    Given Create voucher with "<json>"
    When Send request create voucher
    Then Status code should be 400
    And Response body message was "error insert data"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | json                        |
      | CreateVoucherEmptyName.json |

  Scenario Outline: Create voucher with empty code field
    Given Create voucher with "<json>"
    When Send request create voucher
    Then Status code should be 400
    And Response body message was "error insert data"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | json                        |
      | CreateVoucherEmptyCode.json |

  Scenario Outline: Create voucher with duplicate name field
    Given Create voucher with "<json>"
    When Send request create voucher
    Then Status code should be 400
    And Response body message was "error insert data"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | json                            |
      | CreateVoucherDuplicateName.json |

  Scenario Outline: Create voucher with duplicate code field
    Given Create voucher with "<json>"
    When Send request create voucher
    Then Status code should be 400
    And Response body message was "error insert data"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | json                            |
      | CreateVoucherDuplicateCode.json |

  Scenario Outline: Create voucher with invalid discount value
    Given Create voucher with "<json>"
    When Send request create voucher
    Then Status code should be 400
    And Response body message was "error bind data"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | json                              |
      | CreateVoucherInvalidDiscount.json |

  #GET LIST VOUCHER
  Scenario: Get list vouchers when logged in as admin
    Given Get list voucher as admin
    When Send request get list voucher as admin
    Then Status code should be 200
    And Response body message was "success get data"
    And Validate product json schema "SuccessMessageSchema.json"

  Scenario: Get list vouchers when logged in as admin
    Given Get list voucher as costumer
    When Send request get list voucher as costumer
    Then Status code should be 200
    And Response body message was "success get data"
    And Validate product json schema "SuccessMessageSchema.json"

  Scenario: Get list vouchers without logged in
    Given Get list voucher
    When Send request get list voucher
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    And Validate product json schema "FailedMessageSchema.json"

  #UPDATE VOUCHER
  Scenario Outline: Update vouchers with valid data and valid id
    Given Update voucher with data in "<json>" and <id>
    When Send request update voucher
    Then Status code should be 200
    And Response body message was "success update data"
    And Validate product json schema "SuccessMessageSchema.json"
    Examples:
      | json               | id |
      | UpdateVoucher.json | 3  |

  Scenario Outline: Update vouchers with id using character
    Given Update voucher with data in "<json>" and "<id>"
    When Send request update voucher
    Then Status code should be 400
    And Response body message was "Invalid voucher ID"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | json               | id |
      | UpdateVoucher.json | a  |

  Scenario Outline: Update vouchers with id does not exist
    Given Update voucher with data in "<json>" and <id>
    When Send request update voucher
    Then Status code should be 400
    And Response body message was "error update data"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | json               | id      |
      | UpdateVoucher.json | 1010101 |

  Scenario Outline: Update vouchers when name field is same as other voucher
    Given Update voucher with data in "<json>" and <id>
    When Send request update voucher
    Then Status code should be 400
    And Response body message was "error update data"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | json                            | id |
      | CreateVoucherDuplicateName.json | 3  |

  Scenario Outline: Update vouchers when code field is same as other voucher
    Given Update voucher with data in "<json>" and <id>
    When Send request update voucher
    Then Status code should be 400
    And Response body message was "error update data"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | json                            | id |
      | CreateVoucherDuplicateCode.json | 3  |

  Scenario Outline: Update vouchers with invalid discount value
    Given Update voucher with data in "<json>" and <id>
    When Send request update voucher
    Then Status code should be 400
    And Response body message was "error bind data"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | json                              | id |
      | CreateVoucherInvalidDiscount.json | 3  |

  #DELETE VOUCHER
#  Scenario Outline: Delete voucher with valid id
#    Given Delete voucher with <id>
#    When Send request delete voucher
#    Then Status code should be 200
#    And Response body message was "success delete data"
#    And Validate product json schema "SuccessMessageSchema.json"
#    Examples:
#      | id |
#      | 42 |

  Scenario Outline: Delete voucher with id does not exist
    Given Delete voucher with <id>
    When Send request delete voucher
    Then Status code should be 404
    And Response body message was "error delete data error record not found"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | id     |
      | 101011 |

  Scenario Outline: Delete voucher without logged in
    Given Delete voucher wih <id> without login
    When Send request delete voucher
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"
    And Validate product json schema "FailedMessageSchema.json"
    Examples:
      | id |
      | 42  |

