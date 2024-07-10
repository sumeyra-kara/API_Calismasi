package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class _7_GetBodyTekrarlardanKurtulma {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application-json,
    ve response body’sindeki
        "firstname“in, "Mary",
        ve "lastname“in, "Ericsson",
        ve "totalprice“in, 416,
        ve "depositpaid“in, false,
        ve "additionalneeds“in, "Breakfast"
        oldugunu test edin

     */

    @Test
    public void get1(){
        // 1- URL
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected Data
        // 3- Response'i kaydet

        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- assertion

        response
                .then().assertThat()
                        .statusCode(200)
                        .contentType("application/json; charset=utf-8")
                        .body("firstname", Matchers.equalTo("Mary"),
                                "lastname",Matchers.equalTo("Ericsson"),
                                "totalprice",Matchers.equalTo(416),
                                "depositpaid",Matchers.equalTo(false),
                                "additionalneeds",Matchers.equalTo("Breakfast"));



        /* matchers tekrarlarindan kurtulmak icin ve sadece mesela equalTo() kullanmak istersek import edebiliriz
        response
                .then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Mary"),
                        "lastname", equalTo("Ericsson"),
                        "totalprice", equalTo(416),
                        "depositpaid", equalTo(false),
                        "additionalneeds", equalTo("Breakfast"));

         */





    }



}
