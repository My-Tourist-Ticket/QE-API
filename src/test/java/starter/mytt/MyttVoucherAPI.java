package starter.mytt;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import starter.utils.Constants;
import starter.utils.Token2;

import java.io.File;
import java.io.FileReader;

public class MyttVoucherAPI {
    MyttUserAPI myttUserAPI;
    public static String CREATE_NEW_VOUCHER = Constants.BASE_URL + "/vouchers";
    public static String GET_LIST_VOUCHER = Constants.BASE_URL + "/vouchers";
    public static String UPDATE_VOUCHER = Constants.BASE_URL + "/vouchers/{id}";
    public static String DELETE_VOUCHER = Constants.BASE_URL + "/vouchers/{id}";

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
    @Step("Create New Voucher")
    public void createNewVoucher(File json) throws Exception {
        File credentialsFile = new File(Constants.REQ_BODY_DIR + "LoginAdmin.json"); // Provide the path to your credentials file
        JSONObject credentials = readCredentialsFromFile(credentialsFile);
        String email = (String) credentials.get("email");
        String password = (String) credentials.get("password");
        String token = Token2.GetToken(email, password);

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get list voucher admin")
    public void getListVoucherAdmin() throws Exception {
        File credentialsFile = new File(Constants.REQ_BODY_DIR + "LoginAdmin.json"); // Provide the path to your credentials file
        JSONObject credentials = readCredentialsFromFile(credentialsFile);
        String email = (String) credentials.get("email");
        String password = (String) credentials.get("password");
        String token = Token2.GetToken(email, password);
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }
    @Step("Get list voucher costumer")
    public void getListVoucherCostumer() throws Exception {
        File credentialsFile = new File(Constants.REQ_BODY_DIR + "LoginAdmin.json"); // Provide the path to your credentials file
        JSONObject credentials = readCredentialsFromFile(credentialsFile);
        String email = (String) credentials.get("email");
        String password = (String) credentials.get("password");
        String token = Token2.GetToken(email, password);
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }
    @Step("Get list voucher costumer")
    public void getListVoucherUnauth(){
        SerenityRest
                .given();
    }
    @Step("Update Voucher")
    public void updateVoucher(File json, int id) throws Exception {
        File credentialsFile = new File(Constants.REQ_BODY_DIR + "LoginAdmin.json"); // Provide the path to your credentials file
        JSONObject credentials = readCredentialsFromFile(credentialsFile);
        String email = (String) credentials.get("email");
        String password = (String) credentials.get("password");
        String token = Token2.GetToken(email, password);

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json)
                .pathParam("id", id);
    }

    @Step("Update Voucher")
    public void updateVoucher1(File json, String id) throws Exception {
        File credentialsFile = new File(Constants.REQ_BODY_DIR + "LoginAdmin.json"); // Provide the path to your credentials file
        JSONObject credentials = readCredentialsFromFile(credentialsFile);
        String email = (String) credentials.get("email");
        String password = (String) credentials.get("password");
        String token = Token2.GetToken(email, password);

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json)
                .pathParam("id", id);
    }
    @Step("Delete Voucher")
    public void deleteVoucher(int id) throws Exception {
        File credentialsFile = new File(Constants.REQ_BODY_DIR + "LoginAdmin.json"); // Provide the path to your credentials file
        JSONObject credentials = readCredentialsFromFile(credentialsFile);
        String email = (String) credentials.get("email");
        String password = (String) credentials.get("password");
        String token = Token2.GetToken(email, password);

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .pathParam("id", id);
    }
    @Step("Delete Voucher")
    public void deleteVoucherUnauth(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

}
