package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mytt.MyttCityAPI;
import starter.utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CityStepDef {
    @Steps
    MyttCityAPI myttCityAPI;

    //Scenario 1
    @Given("Get all city with valid parameter")
    public void getAllCityWithValidParameter() {
        myttCityAPI.getCity();
    }

    @When("Send request get all city")
    public void sendRequestGetAllCity() {
        SerenityRest.when().get(MyttCityAPI.GET_CITY);
    }

    @And("Validate city json schema {string}")
    public void validateCityJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 2
    @Given("Get all city with invalid parameter")
    public void getAllCityWithInvalidParameter() {
        myttCityAPI.getCity();
    }

    @When("Send request get all city with invalid param")
    public void sendRequestGetAllCityWithInvalidParam() {
        SerenityRest.when().get(MyttCityAPI.GET_CITY_INVALID);
    }

    //Scenario 3
    @Given("Create city with valid data {string},{string},{string},{string}")
    public void createCityWithValidData(String city_name, String description, String image, String thumbnail) {
        Map<String, Object> formData = ValidData(city_name,description,image,thumbnail);
        myttCityAPI.createCity(formData);
    }
    private Map<String, Object> ValidData(String city_name, String description, String image, String thumbnail) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("city_name", city_name);
        formData.put("description", description);
        File imageFile = new File(Constants.IMAGE_DIR, image);
        formData.put("image", imageFile);
        File thumbnailFile = new File(Constants.IMAGE_DIR, thumbnail);
        formData.put("thumbnail", thumbnailFile);
        return formData;
    }

    @When("Send request create city")
    public void sendRequestCreateCity() {
        SerenityRest.when().post(MyttCityAPI.CREATE_CITY);
    }

    //Scenario 4
    @Given("Create city with invalid {string}")
    public void createCityWithInvalid(String json) {
        File jsonCreateCityInvalid = new File(Constants.REQ_BODY + json);
        myttCityAPI.createCityWithInvalidJson(jsonCreateCityInvalid);
    }

    //Scenario 5
    @Given("Create city with invalid data {string}")
    public void createCityWithInvalidData(String json) {
        File jsonCreateCityInvalid = new File(Constants.REQ_BODY + json);
        myttCityAPI.createCityWithInvalidJson(jsonCreateCityInvalid);
    }

    //Scenario 6
    @Given("Create city with empty {string}")
    public void createCityWithEmpty(String json) {
        File jsonCreateCityInvalid = new File(Constants.REQ_BODY + json);
        myttCityAPI.createCityWithInvalidJson(jsonCreateCityInvalid);
    }

    //Scenario 7
    @Given("Create city without login")
    public void createCityWithoutLogin() {
        myttCityAPI.createCityWithoutLogin();
    }
    @When("Send request create city without login")
    public void sendRequestCreateCityWithoutLogin() {
        SerenityRest.when().post(MyttCityAPI.CREATE_CITY);
    }

    //Scenario 8
    @Given("Get detail city with valid {string}")
    public void getDetailCityWithValid(String id) {
        myttCityAPI.getDetailCity(id);
    }

    @When("Send request get detail city")
    public void sendRequestGetDetailCity() {
        SerenityRest.when().get(MyttCityAPI.GET_DETAIL_CITY);
    }

    //Scenario 9
    @Given("Get detail city with invalid {string}")
    public void getDetailCityWithInvalid(String id) {
        myttCityAPI.getDetailCity(id);
    }

    //Scenario 10
    @Given("Get detail city without {string}")
    public void getDetailCityWithout(String id) {
        myttCityAPI.getDetailCity(id);
    }

    //Scenario 11
    @Given("Update city with valid {string}")
    public void updateCityWithValid(String id) {
        myttCityAPI.updateCity(id);
    }

    @When("Send request update city")
    public void sendRequestUpdateCity() {
        SerenityRest.when().put(MyttCityAPI.UPDATE_CITY);
    }

    //Scenario 12
    @Given("Update city with invalid {string}")
    public void updateCityWithInvalid(String id) {
        myttCityAPI.updateCityWithInvalidId(id);
    }

    //Scenario 13
    @Given("Update city without {string}")
    public void updateCityWithout(String id) {
        myttCityAPI.updateCityWithInvalidId(id);
    }

    //Scenario 14
    @Given("Update city with valid {string} and without login")
    public void updateCityWithValidAndWithoutLogin(String id) {
        myttCityAPI.updateCityWithoutLogin(id);
    }

    @When("Send request update city without login")
    public void sendRequestUpdateCityWithoutLogin() {
        SerenityRest.when().put(MyttCityAPI.UPDATE_CITY);
    }

    //Scenario 15
    @Given("Delete city with valid {string}")
    public void deleteCityWithValid(String id) {
        myttCityAPI.deleteCity(id);

    }

    @When("Send request delete city")
    public void sendRequestDeleteCity() {
        SerenityRest.when().delete(MyttCityAPI.DELETE_CITY);
    }

    //Scenario 16
    @Given("Delete city with invalid {string}")
    public void deleteCityWithInvalid(String id) {
        myttCityAPI.deleteCity(id);
    }

    //Scenario 17
    @Given("Delete city without {string}")
    public void deleteCityWithout(String id) {
        myttCityAPI.deleteCity(id);
    }

    //Scenario 18
    @Given("Delete city with valid {string} and without login")
    public void deleteCityWithValidAndWithoutLogin(String id) {
        myttCityAPI.updateCityWithoutLogin(id);
    }

    @When("Send request delete without login")
    public void sendRequestDeleteWithoutLogin() {
        SerenityRest.when().delete(MyttCityAPI.DELETE_CITY);
    }



}
