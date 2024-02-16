package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mytt.MyttBookingAPI;
import starter.mytt.MyttResponses;
import starter.mytt.MyttUserAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class BookingStepDef {

    @Steps
    MyttBookingAPI myttBookingAPI;

    @Given("Create booking valid data {string}")
    public void createBookingValidData(String json) {
        File jsonBookingValidData = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingValidData(jsonBookingValidData);
    }

    @When("Send request create booking valid data")
    public void sendRequestCreateBookingValidData() {
        SerenityRest.when()
                .post(MyttBookingAPI.BOOKING);
    }

    @And("Response body message was {string} and data {string}")
    public void responseBodyMessageWasAndData(String message, String data) {
        SerenityRest.and()
                .body(MyttResponses.MESSAGE, equalTo(message))
                .body(MyttResponses.DATA, equalTo(data));
    }

    @And("Validate create booking json schema {string}")
    public void validateCreateBookingJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Create booking invalid tour id {string}")
    public void createBookingInvalidTourId(String json) {
        File jsonBookingInvalidTourId = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingValidData(jsonBookingInvalidTourId);

    }

    @Given("Create booking invalid package id {string}")
    public void createBookingInvalidPackageId(String json) {
        File jsonBookingInvalidPackageId = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingValidData(jsonBookingInvalidPackageId);
    }

    @Given("Create booking invalid voucher id {string}")
    public void createBookingInvalidVoucherId(String json) {
        File jsonBookingInvalidVoucherId = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingValidData(jsonBookingInvalidVoucherId);
    }

    @Given("Create booking empty bank {string}")
    public void createBookingEmptyBank(String json) {
        File jsonBookingEmptyBank = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingValidData(jsonBookingEmptyBank);
    }

    @Given("Create booking empty date {string}")
    public void createBookingEmptyDate(String json) {
        File jsonBookingEmptyDate = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingValidData(jsonBookingEmptyDate);
    }

    @Given("Create booking empty phone number {string}")
    public void createBookingEmptyPhoneNumber(String json) {
        File jsonBookingEmptyPhoneNumber = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingValidData(jsonBookingEmptyPhoneNumber);
    }

    @Given("Create booking empty greeting {string}")
    public void createBookingEmptyGreeting(String json) {
        File jsonBookingEmptyGreeting = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingValidData(jsonBookingEmptyGreeting);
    }

    @Given("Create booking empty full name {string}")
    public void createBookingEmptyFullName(String json) {
        File jsonBookingEmptyFullname = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingValidData(jsonBookingEmptyFullname);
    }

    @Given("Create booking empty email {string}")
    public void createBookingEmptyEmail(String json) {
        File jsonBookingEmptyEmail = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingValidData(jsonBookingEmptyEmail);
    }

    @Given("Create booking empty quantity {string}")
    public void createBookingEmptyQuantity(String json) {
        File jsonBookingEmptyQuantity = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingValidData(jsonBookingEmptyQuantity);
    }


    @Given("Create review by booking {string} valid data {string}")
    public void createReviewByBookingValidData(String id, String json) {
        File jsonReviewByBookingIdValidData = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createReviewBookingValidDataId(id, jsonReviewByBookingIdValidData);
    }

    @When("Send request create review by booking valid data")
    public void sendRequestCreateReviewByBookingValidData() {
        SerenityRest.when()
                .post(MyttBookingAPI.REVIEW_BOOKING);
    }

    @Given("Create review by booking {string} empty text review {string}")
    public void createReviewByBookingEmptyTextReview(String id, String json) {
        File jsonReviewByBookingIdEmptyTR = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createReviewBookingValidDataId(id, jsonReviewByBookingIdEmptyTR);
    }

    @Given("Create review by booking {string} invalid star rate {string}")
    public void createReviewByBookingInvalidStarRate(String id, String json) {
        File jsonReviewByBookingIdInvalidSR = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createReviewBookingValidDataId(id, jsonReviewByBookingIdInvalidSR);
    }

    @Given("Create booking without login {string}")
    public void createBookingWithoutLogin(String json) {
        File jsonBookingValidData = new File(Constants.REQ_BODY + json);
        myttBookingAPI.createBookingWithoutLogin(jsonBookingValidData);
    }

    //=============================================GET BOOKING==================================================//

    @Given("Get booking as user")
    public void getBookingAsUser() {
        myttBookingAPI.getBookingAsUser();
    }

    @When("Send request get booking as user")
    public void sendRequestGetBookingAsUser() {
        SerenityRest.when()
                .get(MyttBookingAPI.GET_BOOKING_USER);
    }

    @Given("Get booking as pengelola")
    public void getBookingAsPengelola() {
        myttBookingAPI.getBookingAsPengelola();
    }

    @When("Send request get booking as pengelola")
    public void sendRequestGetBookingAsPengelola() {
        SerenityRest.when()
                .get(MyttBookingAPI.GET_BOOKING_PENGELOLA);
    }

    @Given("Get booking as pengelola when logged in as user")
    public void getBookingAsPengelolaWhenLoggedInAsUser() {
        myttBookingAPI.getBookingAsUser();
    }

    @Given("Get booking as pengelola when logged in as admin")
    public void getBookingAsPengelolaWhenLoggedInAsAdmin() {
        myttBookingAPI.getBookingAsAdmin();
    }

    @Given("Get booking as admin")
    public void getBookingAsAdmin() {
        myttBookingAPI.getBookingAsAdmin();
    }

    @When("Send request get booking as admin")
    public void sendRequestGetBookingAsAdmin() {
        SerenityRest.when()
                .get(MyttBookingAPI.GET_BOOKING_ADMIN);
    }

    @Given("Get booking as admin when logged in as user")
    public void getBookingAsAdminWhenLoggedInAsUser() {
        myttBookingAPI.getBookingAsUser();
    }

    @Given("Get booking as admin when logged in as pengelola")
    public void getBookingAsAdminWhenLoggedInAsPengelola() {
        myttBookingAPI.getBookingAsPengelola();
    }

    @Given("Get booking details by valid {string}")
    public void getBookingDetailsByValid(String id) {
        myttBookingAPI.getBookingDetailsById(id);
    }

    @When("Send request get booking details by valid id")
    public void sendRequestGetBookingDetailsByValidId() {
        SerenityRest.when()
                .get(MyttBookingAPI.GET_BOOKING_DETAILS);
    }

    @Given("Get booking details by invalid {string}")
    public void getBookingDetailsByInvalid(String id) {
        myttBookingAPI.getBookingDetailsById(id);
    }

  //==============================================PUT BOOKING=================================================//

    @Given("Cancel booking payment by {string}")
    public void cancelBookingPaymentBy(String id) {
        myttBookingAPI.cancelBookingPaymentId(id);
    }

    @When("Send request cancel booking payment by id")
    public void sendRequestCancelBookingPaymentById() {
        SerenityRest.when()
                .put(MyttBookingAPI.CANCEL_BOOKING);
    }

}
