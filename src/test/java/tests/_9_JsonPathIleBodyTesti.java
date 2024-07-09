package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

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

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname","Ali");
        reqBody.put("lastname","Bak");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("additionalneeds","wi-fi");
        reqBody.put("bookingdates",bookingDates);

        // 2- expected Data hazirla
        // 3- Response'i kaydet

        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);
        response.prettyPrint();

        // 4 - Assertion -- JSON PATH ILE TEST ETME - response uzerinden json object ile test edeilir

        response.then().assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("booking.firstname", Matchers.equalTo("Ali"),
                    "booking.lastname",Matchers.equalTo("Bak"),
                    "booking.totalprice",Matchers.equalTo(500),
                    "booking.depositpaid",Matchers.equalTo(false),
                    "booking.additionalneeds",Matchers.equalTo("wi-fi"),
                    "booking.bookingdates.checkin",Matchers.equalTo("2021-06-01"),
                    "booking.bookingdates.checkout",Matchers.equalTo("2021-06-10"));
    }
}
