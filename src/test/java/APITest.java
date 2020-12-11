import api.AuthApi;
import api.BookingApi;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import payloads.AuthPayload;
import payloads.AuthResponsePayload;
import payloads.BookingDatesPayload;
import payloads.BookingPayload;

import java.util.Date;

public class APITest {

    @Test
    public static void getBookingReturn200(){
       // assertEquals(resp.getStatusCode(), 200);
        Response resp = BookingApi.getBookings();
                        assertEquals(resp.statusCode(), 200);
    }

    @Test
    public static void getBookingIDReturn200(){
        Response resp = BookingApi.getBookingId("1", "application/json");
                    assertEquals(resp.getStatusCode(),200);
    }

    @Test
    public static void getBookingIdReturns418(){
        Response resp = BookingApi.getBookingId("1", "text/plain");
        assertEquals(resp.getStatusCode(),418);

    }

    @Test
    public static void postBookingReturns200(){

        BookingDatesPayload bookingDatesPayload = new BookingDatesPayload(new Date(), new Date());
        BookingPayload bookingPayload = new BookingPayload("Mark", "Winter", 200,
                false, bookingDatesPayload, "My name is swapnil");

        Response response = BookingApi.postBooking(bookingPayload);
        assertEquals(response.getStatusCode(),200);
        }

    @Test
    public void deleteBookingReturn201(){
        //Create booking and get the ID and pass it to delete it again

        //Log in and get token
        AuthPayload authPayload = new AuthPayload("admin", "password123");
        Response authResponse = AuthApi.postAuth(authPayload);
        System.out.println(authResponse.getBody().prettyPrint());
        //Here we have to extract token from "token: dbe9ee4018f60e8"


        //It returna a string. now we have to covert Response body(Jason object) back to java object
        //for that we have to create another pojo for token

        //AuthResponsePayload token = authResponse.as(AuthResponsePayload.class);

        String  token = authResponse.as(AuthResponsePayload.class).getToken();

        //here 'as' rest assured function which return body of authResponse
        //AuthResponsePayload.class  --It saying this is the class i want to use
        //to understnad what you are getting back as a response ---This entire process is called Reflection

        //System.out.println(token.getToken());
        //This will print only token

        //Use token to delete booking
        Response bookingResponse = BookingApi.deleteBooking("1", token);
        assertEquals(bookingResponse.getStatusCode(),201);


    }


}
