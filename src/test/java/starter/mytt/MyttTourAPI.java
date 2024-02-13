package starter.mytt;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.checkerframework.checker.units.qual.C;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import starter.utils.Constants;
import starter.utils.Token2;

import java.io.File;
import java.io.FileReader;
import java.util.Map;

public class MyttTourAPI {
    public static String ADD_TOUR = Constants.BASE_URL + "/tours";
    public static String ADD_TOUR_REPORT = Constants.BASE_URL + "/tours/15/report";
    public static String GET_ALL_TOUR = Constants.BASE_URL + "/tours/pengelola";
    public static String GET_ALL_TOUR_INVALID = Constants.BASE_URL + "/tours/pengelolaaa";
    public static String GET_TOUR_ID = Constants.BASE_URL + "/tours/{id}";
    public static String GET_TOUR_CITY_ID = Constants.BASE_URL + "/tours/bycity/{id}";
    public static String GET_TOUR_REPORT_ID = Constants.BASE_URL + "/tours/{id}/report";
    public static String GET_TOUR_SEARCH = Constants.BASE_URL + "/tours/search?tour_name={string}";

    @Step("Add tour pengelola")
    public void addTour(Map<String, ?> formData){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginPengelola.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("multipart/form-data")
                    .multiPart("tour_name", formData.get("tour_name"))
                    .multiPart("description", formData.get("description"))
                    .multiPart("image", (File) formData.get("image"))
                    .multiPart("thumbnail",(File) formData.get("thumbnail"))
                    .multiPart("address", formData.get("address"))
                    .multiPart("latitude", formData.get("latitude"))
                    .multiPart("longitude", formData.get("longitude"))
                    .multiPart("city_id", formData.get("city_id"));
        } catch (Exception e) {
            System.out.println("Error add tour: " + e.getMessage());
        }
    }

    @Step("Add tour admin")
    public void addTourAdmin(Map<String, ?> formData){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginAdmin.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("multipart/form-data")
                    .multiPart("tour_name", formData.get("tour_name"))
                    .multiPart("description", formData.get("description"))
                    .multiPart("image",(File) formData.get("image"))
                    .multiPart("thumbnail",(File) formData.get("thumbnail"))
                    .multiPart("address", formData.get("address"))
                    .multiPart("latitude", formData.get("latitude"))
                    .multiPart("longitude", formData.get("longitude"))
                    .multiPart("city_id", formData.get("city_id"));
        } catch (Exception e) {
            System.out.println("Error add tour: " + e.getMessage());
        }
    }

    @Step("Add tour user")
    public void addTourUser(Map<String, ?> formData){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginUser.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("multipart/form-data")
                    .multiPart("tour_name", formData.get("tour_name"))
                    .multiPart("description", formData.get("description"))
                    .multiPart("image",(File) formData.get("image"))
                    .multiPart("thumbnail",(File) formData.get("thumbnail"))
                    .multiPart("address", formData.get("address"))
                    .multiPart("latitude", formData.get("latitude"))
                    .multiPart("longitude", formData.get("longitude"))
                    .multiPart("city_id", formData.get("city_id"));
        } catch (Exception e) {
            System.out.println("Error add tour: " + e.getMessage());
        }
    }

    @Step("Add tour empty image")
    public void addTourEmptyImage(Map<String, ?> formData){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginPengelola.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("multipart/form-data")
                    .multiPart("tour_name", formData.get("tour_name"))
                    .multiPart("description", formData.get("description"))
                    .multiPart("image", formData.get("image"))
                    .multiPart("thumbnail",(File) formData.get("thumbnail"))
                    .multiPart("address", formData.get("address"))
                    .multiPart("latitude", formData.get("latitude"))
                    .multiPart("longitude", formData.get("longitude"))
                    .multiPart("city_id", formData.get("city_id"));
        } catch (Exception e) {
            System.out.println("Error add tour: " + e.getMessage());
        }
    }

    @Step("Add tour empty thumbnail")
    public void addTourEmptyThumbnail(Map<String, ?> formData){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginPengelola.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .contentType("multipart/form-data")
                    .multiPart("tour_name", formData.get("tour_name"))
                    .multiPart("description", formData.get("description"))
                    .multiPart("image", (File) formData.get("image"))
                    .multiPart("thumbnail", formData.get("thumbnail"))
                    .multiPart("address", formData.get("address"))
                    .multiPart("latitude", formData.get("latitude"))
                    .multiPart("longitude", formData.get("longitude"))
                    .multiPart("city_id", formData.get("city_id"));
        } catch (Exception e) {
            System.out.println("Error add tour: " + e.getMessage());
        }
    }

    @Step("Add tour report")
    public void addTourReport(File json){
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

    @Step("Add tour report by id without login")
    public void addTourReportByIdWithoutLogin(File json){
            SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    //===================================================GET TOUR=====================================================//

    @Step("Get all tour when logged in as pengelola")
    public void getAllTourPengelola(){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginPengelola.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token);
        } catch (Exception e) {
            System.out.println("Error add tour: " + e.getMessage());
        }
    }

    @Step("Get tour with id")
    public void getTourWithId(int id){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginAdmin.json");
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

    @Step("Get tour search with param tour name")
    public void getTourSearch(String tour_name){
            SerenityRest.given()
                    .pathParam("string", tour_name);
    }

//===================================================UPDATE TOUR======================================================//

    @Step("Update tour based on id")
    public void addTourBasedId(int id, Map<String, ?> formData){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginPengelola.json");
            JSONObject tourData = readAddDataFromFile(tourDataFile);
            String email = (String) tourData.get("email");
            String password = (String) tourData.get("password");
            String token = Token2.GetToken(email, password);

            SerenityRest.given()
                    .header("Authorization", "Bearer " + token)
                    .pathParam("id", id)
                    .contentType("multipart/form-data")
                    .multiPart("tour_name", formData.get("tour_name"))
                    .multiPart("description", formData.get("description"))
                    .multiPart("image", (File) formData.get("image"))
                    .multiPart("thumbnail",(File) formData.get("thumbnail"))
                    .multiPart("address", formData.get("address"))
                    .multiPart("latitude", formData.get("latitude"))
                    .multiPart("longitude", formData.get("longitude"))
                    .multiPart("city_id", formData.get("city_id"));
        } catch (Exception e) {
            System.out.println("Error add tour: " + e.getMessage());
        }
    }

    @Step("Update tour without login based on id")
    public void addTourWithoutLoginBasedId(int id, Map<String, ?> formData){
        try {
            SerenityRest.given()
                    .pathParam("id", id)
                    .contentType("multipart/form-data")
                    .multiPart("tour_name", formData.get("tour_name"))
                    .multiPart("description", formData.get("description"))
                    .multiPart("image", (File) formData.get("image"))
                    .multiPart("thumbnail",(File) formData.get("thumbnail"))
                    .multiPart("address", formData.get("address"))
                    .multiPart("latitude", formData.get("latitude"))
                    .multiPart("longitude", formData.get("longitude"))
                    .multiPart("city_id", formData.get("city_id"));
        } catch (Exception e) {
            System.out.println("Error add tour: " + e.getMessage());
        }
    }

    //==============================================DELETE TOUR=======================================================//

    @Step("Delete tour by id")
    public void deleteTourById(int id){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginPengelola.json");
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

    @Step("Delete tour without id")
    public void deleteTourWithoutId(String id){
        try {
            File tourDataFile = new File(Constants.REQ_BODY_DIR + "LoginPengelola.json");
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
