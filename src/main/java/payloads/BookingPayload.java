package payloads;

/*{
        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
        }*/
/*
We are creating a JAVA object which basically matches the structure of Json object and
we are passing to tool called Jackson and Jackson going to read that class and turning into JSON object
So basically Json need some information for what you want me do, How do i know to turn this into the first
name and how would i know to assign variable correctly so to do this we have annotation JSON property
which matches every parameter in our object we have to put json peroperty
*/

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingPayload {

    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private int totalprice;
    @JsonProperty
    private Boolean depositpaid;
    @JsonProperty
    private BookingDatesPayload bookingdates;
    @JsonProperty
    private String additionalneeds;

    public BookingPayload(String firstname, String lastname, int totalprice, Boolean depositpaid, BookingDatesPayload bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }



}
