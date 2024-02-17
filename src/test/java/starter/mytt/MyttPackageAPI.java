package starter.mytt;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.runner.Description;
import starter.utils.Constants;
import starter.utils.Token2;

import java.io.File;

public class MyttPackageAPI {
    public static String REGIST_PENGELOLA = Constants.BASE_URL + "/users";
    public static String LOGIN_PENGELOLA = Constants.BASE_URL + "/login";
    public static String CREATE_PACKAGE = Constants.BASE_URL + "/packages/{tour_id}";
    public static String GET_PACKAGE = Constants.BASE_URL + "/packages/{tour_id}";
    public static String DELETE_PACKAGE = Constants.BASE_URL + "/packages/{id}";

    @Step("Register pengelola")
    public void registPengelola(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Login pengelola")
    public void loginPengelola(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Create Package")
    public void createPackage(String tour_id){
        SerenityRest.given().header("Authorization", Constants.TOKEN_PACKAGE)
                .pathParam("tour_id", tour_id);
    }
    @Step("Create package without login")
    public void createPackageWithoutLogin(String tour_id){
        SerenityRest.given().pathParam("tour_id", tour_id);
    }
    @Step("Get Packages")
    public void getPackage(String tour_id){
        SerenityRest.given().pathParam("tour_id", tour_id);
    }
    @Step("Delete Package")
    public void deletePackage(String id){
        SerenityRest.given().header("Authorization", Constants.TOKEN_PACKAGE)
                .pathParam("id", id);
    }
    @Step("Delete package without login")
    public void deletePackageWithoutLogin(String id){
        SerenityRest.given().pathParam("id", id);
    }
}
