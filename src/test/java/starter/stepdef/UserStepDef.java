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

import static org.hamcrest.Matchers.equalTo;

public class UserStepDef {
    @Steps
    MyttUserAPI myttUserAPI;

    @Given("Login users with valid {string}")
    public void loginUsersWithValid(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        myttUserAPI.postLoginUser(jsonLoginUser);
    }

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

    @Given("Get single user")
    public void getSingleUser() throws Exception {
        myttUserAPI.getSingleUsers();
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
    }

    @And("Response body message was {string}")
    public void responseBodyMessageWas(String message) {
        SerenityRest.and()
                .body(MyttResponses.MESSAGE, equalTo(message));
    }

    @And("Validate product json schema {string}")
    public void validateProductJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
