package test;

import baseUrlKlasoru.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _16_BaseUrlHerokuapp extends HerokuappBaseUrl {
    /**
     * Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
     *
     * 1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
     * gonderdigimizde donen response’un status code’unun 200 oldugunu ve
     * Response’ta 12 booking oldugunu test edin
     *
     * 2- https://restful-booker.herokuapp.com/booking
     * endpointine asagidaki body’ye sahip bir POST
     * request gonderdigimizde donen response’un
     * status code’unun 200 oldugunu ve “firstname”
     * degerinin “Ahmet” oldugunu test edin
     *  {
     *             "firstname" : "Ahmet",
     *             "lastname" : “Bulut",
     *             "totalprice" : 500,
     *             "depositpaid" : false,
     *             "bookingdates" : {
     *                    "checkin" : "2021-06-01",
     *                    "checkout" : "2021-06-10"
     *                       },
     *             "additionalneeds" : "wi-fi" }
     */


    @Test
    public void test01(){

        // 1- endpoint ve request body olustur

        specHerokuApp.pathParam("pp1","booking");

        // 2- expected data olustur
        // 3- request gonder ve donen response'i kaydet

        Response response=given()
                         .when().spec(specHerokuApp)
                         .get("/{pp1}");

        // 4- Assertion
        JsonPath responseJsonpath = response.jsonPath();
        System.out.println(responseJsonpath.getList("bookingid").size()); // kac tane oldugunu buluruz

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(2292)); // bu sayi surekli degistigi icin failed veriyor. guncellemek lazim

    }

    @Test
    public void test02(){
        /**
         * 2- https://restful-booker.herokuapp.com/booking
         *      * endpointine asagidaki body’ye sahip bir POST
         *      * request gonderdigimizde donen response’un
         *      * status code’unun 200 oldugunu ve “firstname”
         *      * degerinin “Ahmet” oldugunu test edin
         *      *  {
         *      *             "firstname" : "Ahmet",
         *      *             "lastname" : “Bulut",
         *      *             "totalprice" : 500,
         *      *             "depositpaid" : false,
         *      *             "bookingdates" : {
         *      *                    "checkin" : "2021-06-01",
         *      *                    "checkout" : "2021-06-10"
         *      *                       },
         *      *             "additionalneeds" : "wi-fi" }
         */
        // 1- endpoint ve request body olustur

        specHerokuApp.pathParam("pp1","booking"); // endpoint

        JSONObject requestBody= new JSONObject();
        JSONObject rezervasyonTarihleriJson= new JSONObject();

        rezervasyonTarihleriJson.put("checkin","2021-06-01");
        rezervasyonTarihleriJson.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",rezervasyonTarihleriJson);
        requestBody.put("additionalneeds","wi-fi");

        // 2- expected data olustur
        // 3- request gonder ve donen response'i kaydet

        Response response= given().contentType(ContentType.JSON) // body oldugu icin  contentType'ini yazmaliyiz
                           .when().spec(specHerokuApp).body(requestBody.toString())
                           .post("/{pp1}");

        // 4- Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname", equalTo("Ahmet"));


    }
}
