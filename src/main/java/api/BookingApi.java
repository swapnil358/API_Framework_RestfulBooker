package api;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.BookingPayload;

import static io.restassured.RestAssured.given;

//This is class is responsible for sending Request and responses
public class BookingApi extends BaseApi{

    public static final String apiURL = baseUrl + "booking/";


    public static Response getBookings(){
        return given().log().all().get(apiURL);

    }

    public static Response getBookingId(String bookingId, String mediaType){
        return given()
                .header("Accept", mediaType)
                .log().all().get(apiURL+bookingId);
    }

   /* public static Response postBooking(bookingPayload Payload){
        return given().contentType(ContentType.JSON)
                    .body(Payload)
                    .when()
                    .post(apiURL);
    }*/

    public static Response postBooking(BookingPayload bookingPayload){
    return given()
            .contentType(ContentType.JSON)
            .body(bookingPayload)
            .when()
            .post(apiURL);
}

    public static Response deleteBooking(String bookingId, String token){
    return given()
            .header("Cookie","token=" + token)
            .delete(apiURL + bookingId);
    }

}
