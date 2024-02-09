package starter.mytt;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;
import starter.utils.Token;

import java.io.File;

public class MyttUserAPI {

    public static String LOGIN_USER = Constants.BASE_URL + "/login";
    public static String GET_SINGLE_USER = Constants.BASE_URL + "/users";

    @Step("Post Login User")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get Single User")
    public void getSingleUsers() throws Exception {
        try {
            // Obtain the token
            File jsonToken = new File(Constants.REQ_BODY_DIR + "LoginUser.json");
            String token = Token.GetToken(jsonToken);

            if (token == null || token.isEmpty()) {
                throw new Exception("Token is empty or null.");
            }

            // Use the obtained token in the request
            Response response = SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("application/json")
                    .get(MyttUserAPI.GET_SINGLE_USER);

            // Check the response status code
            if (response.getStatusCode() != 200) {
                System.out.println("Request failed with status code: " + response.getStatusCode());
                System.out.println("Response body: " + response.getBody().asString());
                throw new Exception("Request failed");
            }
            System.out.println("Request successful");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }


}
