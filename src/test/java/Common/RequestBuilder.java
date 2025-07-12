package Common;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


import com.microsoft.playwright.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class RequestBuilder {

    public static Response getListOfUsers() throws Exception {
        String apiKey = Config.getApiKey();
        Response response = given()
                .header("x-api-key", Config.getApiKey())
                .when().
                contentType("application/json").
                log().all().
                get(BasePaths.BaseURL + "/api/users?page=2").
                then().
                log().all().
                extract().response();

        return response;
    }

    public static Response ListOfUsers() throws Exception {
        String apiKey = Config.getApiKey();
        //return given().
        Response response = given().
                header("Authorization", "Bearer " + apiKey).
                when().
                contentType("application/json").
                log().all().
                get(BasePaths.BaseURL + "/api/users?page=2").
                then().
                log().all().
                extract().response();

        return response;
    }
}


