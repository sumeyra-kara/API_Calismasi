package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _12_Post_ExpectedDataVeJsonPathIleAssertion {
    /**
     * https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
     * request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin. (id cunku hep degisir)
     *  Request body
     * {
     * "firstname" : "Ahmet",
     * "lastname" : “Bulut",
     * "totalprice" : 500,
     * "depositpaid" : false,
     * "bookingdates" : {
     *          "checkin" : "2021-06-01",
     *          "checkout" : "2021-06-10"
     * },
     * "additionalneeds" : "wi-fi"
     * }
     *
     *
     * Response Body
     * {
     * "bookingid": 24,
     * "booking": {
     * "firstname": "Ahmet",
     * "lastname": "Bulut",
     * "totalprice": 500,
     * "depositpaid": false,
     * "bookingdates": {
     *          "checkin": "2021-06-01",
     *          "checkout": "2021-06-10"
     * },
     * "additionalneeds": "wi-fi"
     * }
     * }
     */

    @Test
    public void test(){
        // 1- url hazirla ve request body hazirla
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin" , "2021-06-01");
        bookingDates.put("checkout" , "2021-06-10");

        JSONObject reqBody = new JSONObject(); // request body
        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid",false);
        reqBody.put("additionalneeds", "wi-fi");
        reqBody.put("bookingdates", bookingDates);

        // 2- expected data hazirla

        JSONObject expData = new JSONObject();
        expData.put("bookingid", 24);
        expData.put("booking", reqBody); // reqbody kismi ayni oldugu icin zaten eski olusturdugumuzu koyariz

        // 3- Response kaydet
        // post'ta bir body gondermek zorunda oldugumdan contenttype'ini da gondermem lazim

        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        response.prettyPrint();

        // 4- assert
        // jsonPATH'de noktalarla ilerliyorken, jsonObject'De bir seylern icine katmanlara giriyoruz

        JsonPath respJP = response.jsonPath(); // test etmeye yarayan
        Assert.assertEquals(expData.getJSONObject("booking").get("firstname"),respJP.get("booking.firstname"));

        Assert.assertEquals(expData.getJSONObject("booking").get("lastname"),respJP.get("booking.lastname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("totalprice"),respJP.get("booking.totalprice"));
        Assert.assertEquals(expData.getJSONObject("booking").get("depositpaid"),respJP.get("booking.depositpaid"));
        Assert.assertEquals(expData.getJSONObject("booking").get("additionalneeds"),respJP.get("booking.additionalneeds"));

        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                                respJP.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                                respJP.get("booking.bookingdates.checkout"));





    }


}
