package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mytt.MyttPackageAPI;
import starter.utils.Constants;

import java.io.File;

public class PackageStepDef {
    @Steps
    MyttPackageAPI myttPackageAPI;

    //Scenario 1
    @Given("Register pengelola with valid {string}")
    public void registerPengelolaWithValid(String json) {
        File jsonRegistPengelola = new File(Constants.REQ_BODY + json);
        myttPackageAPI.registPengelola(jsonRegistPengelola);
    }

    @When("Send request register pengelola")
    public void sendRequestRegisterPengelola() {
        SerenityRest.when().post(MyttPackageAPI.REGIST_PENGELOLA);
    }

    //Scenario 2
    @Given("Login pengelola with valid {string}")
    public void loginPengelolaWithValid(String json) {
        File jsonLoginPengelolaPackage = new File(Constants.REQ_BODY + json);
        myttPackageAPI.loginPengelola(jsonLoginPengelolaPackage);
    }

    @When("Send request login pengelola")
    public void sendRequestLoginPengelola() {
        SerenityRest.when().post(MyttPackageAPI.LOGIN_PENGELOLA);
    }

    //Scenario 3
    @Given("Create package with valid {string}")
    public void createPackageWithValid(String tour_id) {
        myttPackageAPI.createPackage(tour_id);
    }

    @When("Send request create package")
    public void sendRequestCreatePackage() {
        SerenityRest.when().post(MyttPackageAPI.CREATE_PACKAGE);
    }

    @And("Validate package json schema {string}")
    public void validatePackageJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 4
    @Given("Create package with invalid {string}")
    public void createPackageWithInvalid(String tour_id) {
        myttPackageAPI.createPackage(tour_id);
    }

    //Scenario 5
    @Given("Create package without {string}")
    public void createPackageWithout(String tour_id) {
        myttPackageAPI.createPackage(tour_id);
    }

    //Scenario 6
    @Given("Create package with valid {string} and without login")
    public void createPackageWithValidAndWithoutLogin(String tour_id) {
        myttPackageAPI.createPackageWithoutLogin(tour_id);
    }

    @When("Send request create package without login")
    public void sendRequestCreatePackageWithoutLogin() {
        SerenityRest.when().post(MyttPackageAPI.CREATE_PACKAGE);
    }

    //Scenario 7
    @Given("Get package with valid {string}")
    public void getPackageWithValid(String tour_id) {
        myttPackageAPI.getPackage(tour_id);
    }

    @When("Send request get package")
    public void sendRequestGetPackage() {
        SerenityRest.when().get(MyttPackageAPI.GET_PACKAGE);
    }

    //Scenario 8
    @Given("Get package with invalid {string}")
    public void getPackageWithInvalid(String tour_id) {
        myttPackageAPI.getPackage(tour_id);
    }

    //Scenario 9
    @Given("Get package without {string}")
    public void getPackageWithout(String tour_id) {
        myttPackageAPI.getPackage(tour_id);
    }

    //Scenario 10
    @Given("Delete package with valid {string}")
    public void deletePackageWithValid(String id) {
        myttPackageAPI.deletePackage(id);
    }

    @When("Send request delete package")
    public void sendRequestDeletePackage() {
        SerenityRest.when().delete(MyttPackageAPI.DELETE_PACKAGE);
    }

    //Scenario 11
    @Given("Delete package with invalid {string}")
    public void deletePackageWithInvalid(String id) {
        myttPackageAPI.deletePackage(id);
    }

    //Scenario 12
    @Given("Delete package without {string}")
    public void deletePackageWithout(String id) {
        myttPackageAPI.deletePackage(id);
    }

    //Scenario 13
    @Given("Delete package with valid {string} and without login")
    public void deletePackageWithValidAndWithoutLogin(String id) {
        myttPackageAPI.deletePackageWithoutLogin(id);
    }

    @When("Send request delete package without login")
    public void sendRequestDeletePackageWithoutLogin() {
        SerenityRest.when().delete(MyttPackageAPI.DELETE_PACKAGE);
    }
}
