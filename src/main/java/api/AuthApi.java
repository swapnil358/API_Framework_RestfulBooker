package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.AuthPayload;

import static io.restassured.RestAssured.given;

public class AuthApi extends BaseApi{

    public static final String apiURL = baseUrl + "auth/";

    public static Response postAuth(AuthPayload AuthPayload){
        return given()
                .contentType(ContentType.JSON)
                .body(AuthPayload)
                .when()
                .post(apiURL);

    }
}
