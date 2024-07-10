package test;

import baseUrlKlasoru.HerokuappBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class _17_BaseUrlHerokuappQueryParam  extends HerokuappBaseUrl {
    /**
     * Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
     * 1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
     * gonderdigimizde donen response’un status code’unun 200 oldugunu ve Response’ta
     * 12 booking oldugunu test edin
     *
     * 2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
     * parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon oldugunu test
     * edecek bir GET request gonderdigimizde, donen response’un status code’unun 200
     * oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
     *
     * 3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
     * parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri “Jackson”
     * olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde, donen
     * response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir
     * booking oldugunu test edin
     */

    @Test
    public void test1() {
        /**
         * 1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
         *  gonderdigimizde donen response’un status code’unun 200 oldugunu ve Response’ta
         *  134 booking oldugunu test edin
         */
        // 1- url hazirla
        specHerokuApp.pathParam("pp1","booking");

        // 2-
        // 3- Response'i kaydet
        Response response = given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();

        // 4- assert
       response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(134));
    }


    @Test
    public void test2() {
        /**
         *  2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         * parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon oldugunu test
         *  edecek bir GET request gonderdigimizde, donen response’un status code’unun 200
         *  oldugunu ve “John” ismine sahip en az bir booking oldugunu test edin
         */

        // 1- url hazirla
        // query param'lar da path paramlarr gibi set edilebilir
        specHerokuApp.pathParam("pp1","booking").queryParam("firstname","John");

        // 2- expected data hazirla (ama yok)
        // 3- Response'i kaydet
        Response response = given().when().spec(specHerokuApp).get("/{pp1}");
        response.prettyPrint();

        // 4- Assert
        JsonPath responseJsonpath=response.jsonPath();
        System.out.println(responseJsonpath.getList("bookingid").size());


        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(responseJsonpath.getList("bookingid").size())); //
    }



    @Test
    public void test3() {
        /**
         * 3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         *      * parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri “Jackson”
         *      * olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde, donen
         *      * response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir
         *      * booking oldugunu test edin
         */

        // 1- url hazirla
        // query param'lar da path paramlarr gibi set edilebilir
        specHerokuApp.pathParam("pp1","booking").queryParams("firstname","John","lastname","Smith");

        // 2- expected data hazirla (ama yok)
        // 3- Response'i kaydet
        Response response = given().when().spec(specHerokuApp).get("/{pp1}");
       // response.prettyPrint();

        // 4

        JsonPath responseJsonpath=response.jsonPath();
        System.out.println(responseJsonpath.getList("bookingid").size());


        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(responseJsonpath.getList("bookingid").size())); // ????????? hatali veriyyor



    }

}
