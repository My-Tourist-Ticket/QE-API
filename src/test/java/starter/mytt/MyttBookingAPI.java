package starter.mytt;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import starter.utils.Constants;
import starter.utils.Token2;

import java.io.File;
import java.io.FileReader;

public class MyttBookingAPI {

    public static String BOOKING = Constants.BASE_URL + "/bookings";
    public static String REVIEW_BOOKING = Constants.BASE_URL + "/bookings/{id}/review";
    public static String GET_BOOKING_USER = Constants.BASE_URL + "/bookings/users";
    public static String GET_BOOKING_PENGELOLA = Constants.BASE_URL + "/bookings/pengelola";
    public static String GET_BOOKING_ADMIN = Constants.BASE_URL + "/bookings/admin";
    public static String GET_BOOKING_DETAILS = Constants.BASE_URL + "/bookings/users/{id}";
    public static String CANCEL_BOOKING = Constants.BASE_URL + "/bookings/users/{id}";

    @Step("Create booking valid data")
    public void createBookingValidData(File json){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginUser.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(json);

        } catch (Exception e) {
            System.out.println("Error add tour report: " + e.getMessage());
        }
    }

    @Step("Create review by booking id valid data")
    public void createReviewBookingValidDataId(String id, File json){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginUser.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .pathParam("id", id)
                    .contentType(ContentType.JSON)
                    .body(json);

        } catch (Exception e) {
            System.out.println("Error add tour: " + e.getMessage());
        }
  }

    @Step("Create booking without login")
    public void createBookingWithoutLogin(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get booking as users")
    public void getBookingAsUser() {
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginUser.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token);

        } catch (Exception e) {
            System.out.println("Error add tour report: " + e.getMessage());

        }
    }

    @Step("Get booking as pengelola")
    public void getBookingAsPengelola() {
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginPengelola.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token);

        } catch (Exception e) {
            System.out.println("Error add tour report: " + e.getMessage());

        }
    }

    @Step("Get booking as admin")
    public void getBookingAsAdmin() {
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginAdmin.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token);

        } catch (Exception e) {
            System.out.println("Error add tour report: " + e.getMessage());

        }
    }

    @Step("Get booking details by valid id")
    public void getBookingDetailsById(String id){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginUser.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .pathParam("id", id);

        } catch (Exception e) {
            System.out.println("Error add tour: " + e.getMessage());
        }
    }

    @Step("Cancel booking payment by id")
    public void cancelBookingPaymentId(String id) {
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginUser.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .pathParam("id", id);

        } catch (Exception e) {
            System.out.println("Error add tour report: " + e.getMessage());

        }
    }

    private JSONObject readAddDataFromFile(File tourDataFile) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(tourDataFile));
            return (JSONObject) obj;
        } catch (Exception e) {
            System.out.println("Error reading tourData from file: " + e.getMessage());
            return null;
        }
    }
}
