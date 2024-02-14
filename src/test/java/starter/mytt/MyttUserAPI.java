package starter.mytt;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.parser.JSONParser;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import starter.utils.Constants;
import starter.utils.Token;
import starter.utils.Token2;

import java.io.File;
import java.io.FileReader;
import java.util.Map;

public class MyttUserAPI {

    public static String LOGIN_USER = Constants.BASE_URL + "/login";
    public static String GET_SINGLE_USER = Constants.BASE_URL + "/users";
    public static String GET_LIST_USER = Constants.BASE_URL + "/users/admin";
    public static String CREATE_USER = Constants.BASE_URL + "/users";
    public static String UPDATE_USER = Constants.BASE_URL + "/users";
    public static String UPDATE_STATUS_PENGELOLA = Constants.BASE_URL + "/users/admin/{id}?status={status}";
    public static String DELETE_USER = Constants.BASE_URL + "/users";


    @Step("Post Login User")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get Single User as Costumer")
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
    @Step("Get Single User as Costumer")
    public void getSingleUsers2() throws Exception {
        try {
            // Obtain the token
            File jsonToken = new File(Constants.REQ_BODY_DIR + "LoginPengelola.json");
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
    @Step("Get List User")
    public void getListUser() throws Exception {
        try {
            // Obtain the token
            File jsonToken = new File(Constants.REQ_BODY_DIR + "LoginAdmin.json");
            String token = Token.GetToken(jsonToken);

            if (token == null || token.isEmpty()) {
                throw new Exception("Token is empty or null.");
            }

            // Use the obtained token in the request
            Response response = SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("application/json")
                    .get(MyttUserAPI.GET_LIST_USER);

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

    @Step("Create New User")
    public void createNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Update User")
    public void updateUser(Map<String, ?> formData) {
        try {
            File credentialsFile = new File(Constants.REQ_BODY_DIR + "LoginUser.json"); // Provide the path to your credentials file
            JSONObject credentials = readCredentialsFromFile(credentialsFile);
            String email = (String) credentials.get("email");
            String password = (String) credentials.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token) // Assuming it's a Bearer token
                    .contentType("multipart/form-data")
                    .multiPart("full_name", formData.get("full_name"))
                    .multiPart("phone_number", formData.get("phone_number"))
                    .multiPart("email", formData.get("email"))
                    .multiPart("password", formData.get("password"))
                    .multiPart("image", formData.get("image"));
        } catch (Exception e) {
            System.out.println("Error creating customer: " + e.getMessage());
        }
    }
    private JSONObject readCredentialsFromFile(File credentialsFile) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(credentialsFile));
            return (JSONObject) obj;
        } catch (Exception e) {
            System.out.println("Error reading credentials from file: " + e.getMessage());
            return null;
        }
    }

    @Step("Update status pengelola")
    public void updateStatusPengelola(int id, String status) throws Exception {
        File credentialsFile = new File(Constants.REQ_BODY_DIR + "LoginAdmin.json"); // Provide the path to your credentials file
        JSONObject credentials = readCredentialsFromFile(credentialsFile);
        String email = (String) credentials.get("email");
        String password = (String) credentials.get("password");
        String token = Token2.GetToken(email, password);
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", id)
                .pathParam("status", status);
    }

    @Step("Delete user")
    public void deleteUser() throws Exception {
        File credentialsFile = new File(Constants.REQ_BODY_DIR + "LoginFordelete.json"); // Provide the path to your credentials file
        JSONObject credentials = readCredentialsFromFile(credentialsFile);
        String email = (String) credentials.get("email");
        String password = (String) credentials.get("password");
        String token = Token2.GetToken(email, password);
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }
}
