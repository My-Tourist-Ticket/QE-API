package starter.mytt;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.runner.Description;
import starter.utils.Constants;
import starter.utils.Token2;

import java.io.File;
import java.io.FileReader;
import java.util.Map;
public class MyttCityAPI {
    public static String GET_CITY = Constants.BASE_URL + "/citys";
    public static String GET_CITY_INVALID = Constants.BASE_URL + "/city";
    public static String CREATE_CITY = Constants.BASE_URL + "/citys";
    public static String GET_DETAIL_CITY = Constants.BASE_URL + "/citys/{id}";
    public static String UPDATE_CITY = Constants.BASE_URL + "/citys/{id}";
    public static String DELETE_CITY = Constants.BASE_URL + "/citys/{id}";

    @Step("Get all city")
    public void getCity(){
        SerenityRest.given();
    }

    @Step("Create city")
    public void createCity(Map<String, ?> formData){
        try {
            SerenityRest.given()
                    .header("Authorization", Constants.TOKEN_CITY)
                    .contentType("multipart/form-data")
                    .multiPart("city_name", formData.get("city_name"))
                    .multiPart("description", formData.get("description"))
                    .multiPart("image",(File) formData.get("image"))
                    .multiPart("thumbnail",(File) formData.get("thumbnail"));
        } catch (Exception e) {
            System.out.println("city created successfully: " + e.getMessage());
        }
    }
    @Step("Create city with invalid json")
    public void createCityWithInvalidJson(File json){
        SerenityRest.given().header("Authorization", Constants.TOKEN_CITY)
                .contentType(ContentType.JSON)
                .body(json);;
    }
    @Step("Create city without login")
    public void createCityWithoutLogin(){
        SerenityRest.given();
    }
    @Step("Get detail city")
    public void getDetailCity(String id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Update city")
     public void updateCity(String id){
        SerenityRest.given().header("Authorization", Constants.TOKEN_CITY).pathParam("id", id);
    }
    @Step("Update city with invalid id")
    public void updateCityWithInvalidId(String id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Update city without login")
    public void updateCityWithoutLogin(String id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete city")
    public void deleteCity(String id){
        SerenityRest.given().header("Authorization", Constants.TOKEN_CITY)
                .pathParam("id", id);
    }
    @Step("Delete city without login")
    public void deleteCityWithoutLogin(String id){
        SerenityRest.given().pathParam("id", id);
    }


}
