package tests;

import org.json.JSONObject;
import org.junit.Test;

public class _9_JsonPathIleBodyTesti {
    /*
    {
    "firstname" : "Ali",
    "lastname" : “Bak",
    "totalprice" : 500,
    "depositpaid" : false,
    "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
    },
    "additionalneeds" : "wi-fi"
                }   donen Response’un, status code’unun 200,
        ve content type’inin application-json,
        ve response body’sindeki
        "firstname“in,"Ali",
        ve "lastname“in, "Bak",
        ve "totalprice“in,500,
        ve "depositpaid“in,false,
        ve "checkin" tarihinin 2021-06-01
        ve "checkout" tarihinin 2021-06-10
        ve "additionalneeds“in,"wi-fi"
        oldugunu test edin

     */


    @Test
    public void post1(){

        // url ve reqquest body hazirla
        String url = "https://restful-booker.herokuapp.com/booking";

        // request body hazirla

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin","2021-06-01");
        bookingDates.put("checkout","2021-06-10");

        JSONObject booking = new JSONObject();
        booking.put("firstname","Ali");
        booking.put("lastname","Bak");
        booking.put("totalprice",500);
        booking.put("depositpaid",false);
        booking.put("additionalneeds","wi-fi");
        booking.put("bookingdates",bookingDates);
    }
}
