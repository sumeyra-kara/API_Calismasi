package test;

import TestDatalari.TestDataHerokuapp;
import baseUrlKlasoru.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _21_Post_TestDataKullanimi extends HerokuappBaseUrl {
    /**
               https://restful-booker.herokuapp.com/booking url’ine
               asagidaki body'ye sahip bir POST request gonderdigimizde
               donen response’un id haric asagidaki gibi oldugunu test edin.
               Request body
                      {
                       "firstname" : "Ahmet",
                       "lastname" : “Bulut",
                       "totalprice" : 500,
                       "depositpaid" : false,
                       "bookingdates" : {
                               "checkin" : "2021-06-01",
                               "checkout" : "2021-06-10"
                               },
                       "additionalneeds" : "wi-fi"
                       }
              Expected response body
                       {
                        "bookingid":24,
                        "booking":{
                           "firstname":"Ahmet",
                           "lastname":"Bulut",
                           "totalprice":500,
                           "depositpaid":false,
                           "bookingdates":{
                                   "checkin":"2021-06-01",
                                   "checkout":"2021-06-10"
                                           },
                           "additionalneeds":"wi-fi"
                                   }
                         }
        */
    @Test
    public void test01(){

        // 1- endpoint ve request body olustur
        specHerokuApp.pathParam("pp1","booking");
        //TestDataHerokuapp testDataHerokuapp =new TestDataHerokuapp();
        JSONObject requestBody= TestDataHerokuapp.jsonRequestBodyOlustur();

        // 2- Soruda varsa expected data olustur
        JSONObject expectedData= TestDataHerokuapp.jsonResponseBodyOlustur();

        // 3- Request gonder donen response'i kaydet
        Response response = given().spec(specHerokuApp).contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post("/{pp1}");

        // Assertion
        JsonPath responseJP= response.jsonPath(); // assert icin jsonpath'e cevirmem lazim

        assertEquals(TestDataHerokuapp.basariliStatusCode,response.statusCode());

        assertEquals(expectedData.getJSONObject("booking").get("firstname"),responseJP.get("booking.firstname"));

        assertEquals(expectedData.getJSONObject("booking").get("lastname"),responseJP.get("booking.lastname"));

        assertEquals(expectedData.getJSONObject("booking").get("totalprice"), responseJP.get("booking.totalprice"));

        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),responseJP.get("booking.depositpaid"));

        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),
                responseJP.getString("booking.additionalneeds"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin")
                                                                ,responseJP.get("booking.bookingdates.checkin"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout")
                                                ,responseJP.get("booking.bookingdates.checkout"));
    }
}
