package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mytt.MyttUserAPI;
import starter.mytt.MyttResponses;
import starter.utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class UserStepDef {
    @Steps
    MyttUserAPI myttUserAPI;

    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when()
                .post(MyttUserAPI.LOGIN_USER);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @And("Response body message was {string} and role was {string}")
    public void responseBodyMessageWas(String message, String role) {
        SerenityRest.and()
                .body(MyttResponses.MESSAGE, equalTo(message))
                .body(MyttResponses.ROLE, equalTo(role));
    }

    @And("Validate login user json schema {string}")
    public void validateLoginUserJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
    }
    @When("Send request get list user")
    public void sendRequestGetListUser() {
    }

    @And("Response body message was {string}")
    public void responseBodyMessageWas(String message) {
        SerenityRest.and()
                .body(MyttResponses.MESSAGE, containsString(message));
    }

    @And("Validate product json schema {string}")
    public void validateProductJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Login users with valid {string}")
    public void loginUsersWithValidAsPengelola(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        myttUserAPI.postLoginUser(jsonLoginUser);
    }

    @Given("Login users with empty email in {string}")
    public void loginUsersWithEmptyEmailIn(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        myttUserAPI.postLoginUser(jsonLoginUser);
    }

    @Given("Login users with empty password in {string}")
    public void loginUsersWithEmptyPasswordIn(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        myttUserAPI.postLoginUser(jsonLoginUser);
    }

    @Given("Login users with invalid credentials in {string}")
    public void loginUsersWithInvalidCredentialsIn(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        myttUserAPI.postLoginUser(jsonLoginUser);
    }

    @Given("Create users with valid data {string}")
    public void createUsersWithValidDataAsCostumer(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY + json);
        myttUserAPI.createNewUser(jsonCreateUser);
    }

    @When("Send request create users")
    public void sendRequestCreateUsers() {
        SerenityRest.when()
                .post(MyttUserAPI.CREATE_USER);
    }

    @Given("Create users with duplicate in {string} field")
    public void createUsersWithDuplicateInField(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY + json);
        myttUserAPI.createNewUser(jsonCreateUser);
    }

    @Given("Get single user as costumer")
    public void getSingleUser() throws Exception {
        myttUserAPI.getSingleUsers();
    }
    @Given("Get single user as pengelola")
    public void getSingleUserAsPengelola() throws Exception {
        myttUserAPI.getSingleUsers2();
    }

    @Given("Get single user")
    public void getSingleUserWithout() {
        SerenityRest.given()
                .get(MyttUserAPI.GET_SINGLE_USER);
    }

    @Given("Get single user with invalid token")
    public void getSingleUserWithInvalidToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer asbdjkasfkjafbkadfa")
                .get(MyttUserAPI.GET_SINGLE_USER);
    }

    @Given("Get list user")
    public void getListUser() throws Exception {
        myttUserAPI.getListUser();
    }

    @Given("Update user with valid {string},{string},{string},{string},{string}")
    public void updateUserWithValidData(String full_name, String phone_number, String email, String password, String image) {
        Map<String, Object> formData = ValidData(full_name, phone_number, email, password, image);
        myttUserAPI.updateUser(formData);
        SerenityRest.when()
                .put(MyttUserAPI.UPDATE_USER);
    }
    private Map<String, Object> ValidData(String full_name, String phone_number, String email, String password, String image) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("full_name", full_name);
        formData.put("phone_number", phone_number);
        formData.put("email", email);
        formData.put("password", password);
        formData.put("image", image);

        return formData;
    }

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when()
                .put(MyttUserAPI.UPDATE_USER);
    }

    @Given("Update user with same email {string}")
    public void updateUserWithSame(String email) {
        Map<String, Object> formData = DuplicateEmail(email);
        myttUserAPI.updateUser(formData);
    }
    private Map<String, Object> DuplicateEmail(String email) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("email", email);

        return formData;
    }

    @Given("Update user with same phone number {string}")
    public void updateUserWithSamePhoneNumber(String phone_number) {
        Map<String, Object> formData = DuplicatePhone(phone_number);
        myttUserAPI.updateUser(formData);
    }
    private Map<String, Object> DuplicatePhone(String phone_number) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("phone_number", phone_number);

        return formData;
    }

    @Given("Update status {string} pengelola with valid {int}")
    public void updateStatusPengelolaWithValid(String status, int id) throws Exception {
        myttUserAPI.updateStatusPengelola(id,status);
    }

    @When("Send request update status pengelola")
    public void sendRequestUpdateStatusPengelola() {
        SerenityRest.when()
                .put(MyttUserAPI.UPDATE_STATUS_PENGELOLA);
    }

    @Given("Delete user")
    public void deleteUser() throws Exception {
        myttUserAPI.deleteUser();
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .delete(MyttUserAPI.DELETE_USER);
    }

    @Given("Delete user without logged in")
    public void deleteUserWithoutLoggedIn() {
        SerenityRest.given()
                .delete(MyttUserAPI.DELETE_USER);
    }

    @Given("Update status {string} pengelola with invalid {int}")
    public void updateStatusPengelolaWithInvalid(String status, int id) throws Exception {
        myttUserAPI.updateStatusPengelola(id,status);
    }
}
