package starter.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

public class Token2 {
    public static String LOGIN = Constants.BASE_URL + "/login";

    public static String GetToken(String email, String password) throws Exception {
        try {
            System.out.println("Requesting token from: " + LOGIN);
            Response response = RestAssured.given()
                    .baseUri(Constants.BASE_URL)
                    .contentType(ContentType.JSON)
                    .body("{\"email\":\"" + email + "\", \"password\":\"" + password + "\"}")
                    .post(LOGIN);

            if (response.getStatusCode() != 200) {
                System.out.println("Token request failed with status code: " + response.getStatusCode());
                System.out.println("Response body: " + response.getBody().asString());
                throw new Exception("Token request failed");
            }

            String token = response.jsonPath().getString("data.token");
            System.out.println("Token obtained successfully: " + token);
            return token;
        } catch (Exception e) {
            System.out.println("Error obtaining token: " + e.getMessage());
            throw e;
        }
    }
}

