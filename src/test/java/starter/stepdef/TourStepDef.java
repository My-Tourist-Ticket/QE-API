package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.mytt.MyttTourAPI;
import starter.utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TourStepDef {

    @Steps
    MyttTourAPI myttTourAPI;

    @Given("Add tour by pengelola with valid {string},{string},{string},{string},{string},{double},{double},{int}")
    public void addTourByPengelolaWithValid(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidData(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTour(formData);
    }
    private Map<String, Object> ValidData(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("tour_name", tour_name);
        formData.put("description", description);
        File imageFile = new File(Constants.IMAGE_DIR, image);
        formData.put("image", imageFile);
        File thumbnailFile = new File(Constants.IMAGE_DIR, thumbnail);
        formData.put("thumbnail", thumbnailFile);
        formData.put("address", address);
        formData.put("latitude", latitude);
        formData.put("longitude", longitude);
        formData.put("city_id", city_id);
        return formData;
    }

    @When("Send request add tour by pengelola")
    public void sendRequestAddTourByPengelola() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR);
    }

    @And("Validate add tour json schema {string}")
    public void validateAddTourJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Add tour by admin with valid {string},{string},{string},{string},{string},{double},{double},{int}")
    public void addTourByAdminWithValid(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidData(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTourAdmin(formData);
    }

    @When("Send request add tour by admin")
    public void sendRequestAddTourByAdmin() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR);
    }

    @Given("Add tour by user with valid {string},{string},{string},{string},{string},{double},{double},{int}")
    public void addTourByUserWithValid(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidData(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTourUser(formData);
    }

    @When("Send request add tour by user")
    public void sendRequestAddTourByUser() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR);
    }

    @Given("Add tour with empty tour name {string},{string},{string},{string},{string},{double},{double},{int}")
    public void addTourWithEmptyTourName(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidData(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTour(formData);
    }

    @When("Send request add tour with empty tour name")
    public void sendRequestAddTourWithEmptyTourName() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR);
    }

    @Given("Add tour with empty description {string},{string},{string},{string},{string},{double},{double},{int}")
    public void addTourWithEmptyDescription(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidData(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTour(formData);
    }

    @When("Send request add tour with empty description")
    public void sendRequestAddTourWithEmptyDescription() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR);
    }

    @Given("Add tour with empty image {string},{string},{string},{string},{string},{double},{double},{int}")
    public void addTourWithEmptyImage(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidDataEmptyImage(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTourEmptyImage(formData);
    }
    private Map<String, Object> ValidDataEmptyImage(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("tour_name", tour_name);
        formData.put("description", description);
        formData.put("image", image);
        File thumbnailFile = new File(Constants.IMAGE_DIR, thumbnail);
        formData.put("thumbnail", thumbnailFile);
        formData.put("address", address);
        formData.put("latitude", latitude);
        formData.put("longitude", longitude);
        formData.put("city_id", city_id);
        return formData;
    }

    @When("Send request add tour with empty image")
    public void sendRequestAddTourWithEmptyImage() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR);
    }

    @Given("Add tour with empty thumbnail {string},{string},{string},{string},{string},{double},{double},{int}")
    public void addTourWithEmptyThumbnail(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidDataEmptyThumbnail(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTourEmptyThumbnail(formData);
    }
    private Map<String, Object> ValidDataEmptyThumbnail(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("tour_name", tour_name);
        formData.put("description", description);
        File imageFile = new File(Constants.IMAGE_DIR, image);
        formData.put("image", imageFile);
        formData.put("thumbnail", thumbnail);
        formData.put("address", address);
        formData.put("latitude", latitude);
        formData.put("longitude", longitude);
        formData.put("city_id", city_id);
        return formData;
    }

    @When("Send request add tour with empty thumbnail")
    public void sendRequestAddTourWithEmptyThumbnail() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR);
    }

    @Given("Add tour with empty address {string},{string},{string},{string},{string},{double},{double},{int}")
    public void addTourWithEmptyAddress(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidData(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTour(formData);
    }

    @When("Send request add tour with empty address")
    public void sendRequestAddTourWithEmptyAddress() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR);
    }

    @Given("Add tour with empty latitude {string},{string},{string},{string},{string},{string},{double},{int}")
    public void addTourWithEmptyLatitude(String tour_name, String description, String image, String thumbnail, String address, String latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidDataEmptyLatitude(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTour(formData);
    }
    private Map<String, Object> ValidDataEmptyLatitude(String tour_name, String description, String image, String thumbnail, String address, String latitude, double longitude, int city_id) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("tour_name", tour_name);
        formData.put("description", description);
        File imageFile = new File(Constants.IMAGE_DIR, image);
        formData.put("image", imageFile);
        File thumbnailFile = new File(Constants.IMAGE_DIR, thumbnail);
        formData.put("thumbnail", thumbnailFile);
        formData.put("address", address);
        formData.put("latitude", latitude);
        formData.put("longitude", longitude);
        formData.put("city_id", city_id);
        return formData;
    }

    @When("Send request add tour with empty latitude")
    public void sendRequestAddTourWithEmptyLatitude() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR);
    }

    @Given("Add tour with empty longitude {string},{string},{string},{string},{string},{double},{string},{int}")
    public void addTourWithEmptyLongitude(String tour_name, String description, String image, String thumbnail, String address, double latitude, String longitude, int city_id) {
        Map<String, Object> formData = ValidDataEmptyLongitude(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTour(formData);
    }
    private Map<String, Object> ValidDataEmptyLongitude(String tour_name, String description, String image, String thumbnail, String address, double latitude, String longitude, int city_id) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("tour_name", tour_name);
        formData.put("description", description);
        File imageFile = new File(Constants.IMAGE_DIR, image);
        formData.put("image", imageFile);
        File thumbnailFile = new File(Constants.IMAGE_DIR, thumbnail);
        formData.put("thumbnail", thumbnailFile);
        formData.put("address", address);
        formData.put("latitude", latitude);
        formData.put("longitude", longitude);
        formData.put("city_id", city_id);
        return formData;
    }

    @When("Send request add tour with empty longitude")
    public void sendRequestAddTourWithEmptyLongitude() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR);
    }

    @Given("Add tour with empty city id {string},{string},{string},{string},{string},{double},{double},{string}")
    public void addTourWithEmptyCityId(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, String city_id) {
        Map<String, Object> formData = ValidDataEmptyCityId(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTour(formData);
    }
    private Map<String, Object> ValidDataEmptyCityId(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, String city_id) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("tour_name", tour_name);
        formData.put("description", description);
        File imageFile = new File(Constants.IMAGE_DIR, image);
        formData.put("image", imageFile);
        File thumbnailFile = new File(Constants.IMAGE_DIR, thumbnail);
        formData.put("thumbnail", thumbnailFile);
        formData.put("address", address);
        formData.put("latitude", latitude);
        formData.put("longitude", longitude);
        formData.put("city_id", city_id);
        return formData;
    }

    @When("Send request add tour with empty city id")
    public void sendRequestAddTourWithEmptyCityId() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR);
    }

    @Given("Add tour report with id when logged in as user {string}")
    public void addTourReportWithIdWhenLoggedInAsUser(String json) {
        File addTourReportAsUser = new File(Constants.REQ_BODY+json);
        myttTourAPI.addTourReport(addTourReportAsUser);
    }

    @When("Send request add tour report with id when logged as user")
    public void sendRequestAddTourReportWithIdWhenLoggedAsUser() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR_REPORT);
    }

    @Given("Add tour report by id without login {string}")
    public void addTourReportByIdWithoutLogin(String json) {
        File addTourReportByIdWithoutLogin = new File(Constants.REQ_BODY+json);
        myttTourAPI.addTourReportByIdWithoutLogin(addTourReportByIdWithoutLogin);
    }

    @When("Send request add tour report by id without login")
    public void sendRequestAddTourReportByIdWithoutLogin() {
        SerenityRest.when()
                .post(MyttTourAPI.ADD_TOUR_REPORT);
    }

    //==================================================GET TOUR======================================================//

    @Given("Get all tour when logged in as pengelola")
    public void getAllTourWhenLoggedInAsPengelola() {
        myttTourAPI.getAllTourPengelola();
    }

    @When("Send request get all tour when logged in as pengelola")
    public void sendRequestGetAllTourWhenLoggedInAsPengelola() {
        SerenityRest.when()
                .get(MyttTourAPI.GET_ALL_TOUR);
    }

    @Given("Get all tour pengelola invalid path")
    public void getAllTourPengelolaInvalidPath() {
        myttTourAPI.getAllTourPengelola();
    }

    @When("Send request get all tour pengelola invalid path")
    public void sendRequestGetAllTourPengelolaInvalidPath() {
        SerenityRest.when()
                .get(MyttTourAPI.GET_ALL_TOUR_INVALID);
    }

    @Given("Get all tour tour with {int}")
    public void getAllTourTourWithId(int id) {
        myttTourAPI.getTourWithId(id);
    }

    @When("Send request get tour with id")
    public void sendRequestGetTourWithId() {
        SerenityRest.when()
                .get(MyttTourAPI.GET_TOUR_ID);
    }

    @Given("Get all tour tour with invalid {int}")
    public void getAllTourTourWithInvalid(int id) {
        myttTourAPI.getTourWithId(id);
    }

    @When("Send request get tour with invalid id")
    public void sendRequestGetTourWithInvalidId() {
        SerenityRest.when()
                .get(MyttTourAPI.GET_TOUR_ID);
    }

    @Given("Get all tour tour with city {int}")
    public void getAllTourTourWithCity(int id) {
        myttTourAPI.getTourWithId(id);
    }

    @When("Send request get tour with city id")
    public void sendRequestGetTourWithCityId() {
        SerenityRest.when()
                .get(MyttTourAPI.GET_TOUR_CITY_ID);
    }

    @Given("Get all tour tour with invalid city {int}")
    public void getAllTourTourWithInvalidCity(int id) {
        myttTourAPI.getTourWithId(id);
    }

    @Given("Get all tour tour report with {int}")
    public void getAllTourTourReportWith(int id) {
        myttTourAPI.getTourWithId(id);
    }

    @When("Send request get tour report with id")
    public void sendRequestGetTourReportWithId() {
        SerenityRest.when()
                .get(MyttTourAPI.GET_TOUR_REPORT_ID);
    }

    @Given("Get tour search with param {string}")
    public void getTourSearchWithParam(String tour_name) {
        myttTourAPI.getTourSearch(tour_name);
    }

    @When("Send request get tour search with param tour name")
    public void sendRequestGetTourSearchWithParamTourName() {
        SerenityRest.when()
                .get(MyttTourAPI.GET_TOUR_SEARCH);
    }


    //================================================UPDATE TOUR=====================================================//

    @Given("Update tour based on {int} with {string},{string},{string},{string},{string},{double},{double},{int}")
    public void updateTourBasedOnWith(int id, String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidDataUpdateId(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTourBasedId(id, formData);
    }
    private Map<String, Object> ValidDataUpdateId(String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("tour_name", tour_name);
        formData.put("description", description);
        File imageFile = new File(Constants.IMAGE_DIR, image);
        formData.put("image", imageFile);
        File thumbnailFile = new File(Constants.IMAGE_DIR, thumbnail);
        formData.put("thumbnail", thumbnailFile);
        formData.put("address", address);
        formData.put("latitude", latitude);
        formData.put("longitude", longitude);
        formData.put("city_id", city_id);
        return formData;
    }

    @When("Send request update tour based on id")
    public void sendRequestUpdateTourBasedOnId() {
        SerenityRest.when()
                .put(MyttTourAPI.GET_TOUR_ID);
    }

    @Given("Update tour based on invalid {int} with {string},{string},{string},{string},{string},{double},{double},{int}")
    public void updateTourBasedOnInvalidWith(int id, String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidDataUpdateId(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTourBasedId(id, formData);
    }

    @Given("Update tour without login based on valid {int} with {string},{string},{string},{string},{string},{double},{double},{int}")
    public void updateTourWithoutLoginBasedOnValidWith(int id, String tour_name, String description, String image, String thumbnail, String address, double latitude, double longitude, int city_id) {
        Map<String, Object> formData = ValidDataUpdateId(tour_name,description,image,thumbnail,address,latitude,longitude,city_id);
        myttTourAPI.addTourWithoutLoginBasedId(id, formData);
    }

    //====================================================DELETE TOUR=====================================================//

    @Given("Delete tour by {int}")
    public void deleteTourBy(int id) {
        myttTourAPI.deleteTourById(id);
    }

    @When("Send request delete tour by id")
    public void sendRequestDeleteTourById() {
        SerenityRest.when()
                .delete(MyttTourAPI.GET_TOUR_ID);
    }

    @Given("Delete tour without {string}")
    public void deleteTourWithout(String id) {
        myttTourAPI.deleteTourWithoutId(id);
    }

    @Given("Delete tour with invalid {int}")
    public void deleteTourWithInvalid(int id) {
        myttTourAPI.deleteTourById(id);
    }
}
