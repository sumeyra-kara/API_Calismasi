package test;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrlKlasoru.HerokuappBaseUrl;
import baseUrlKlasoru.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _22_Put_DeSerialization extends JsonPlaceHolderBaseUrl {
    /**
     * https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
     * PUT request yolladigimizda donen response’in response body’sinin asagida
     * verilen ile ayni oldugunu test ediniz
     *
     * Request Body
     * {
     * "title": "Ahmet",
     * "body": "Merhaba",
     * "userId": 10,
     * "id": 70
     * }
     *
     * Expected Data :
     * {
     * "title": "Ahmet",
     * "body": "Merhaba",
     * "userId": 10,
     * "id": 70
     * }
     */

    @Test
    public void test01(){
        // 1- endpoint ve request body olustur
        specJsonPlace.pathParams("pp1","posts","pp2",70); // path paramatreleri ekliyoruz

        // Request body'sini Map olarak olusturalim
        Map<String,Object> requestBodyMap= TestDataJsonPlaceholder.requestBodyOlusturMap();

        // 2- Soruda varsa expected data olustur
        Map<String,Object> expectedData= TestDataJsonPlaceholder.requestBodyOlusturMap();

        // 3- Request gonder donen response'i kaydet
        Response response = given().spec(specJsonPlace).contentType(ContentType.JSON)
                            .when().body(requestBodyMap)
                            .put("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4- Assertion
        //    expected Response body  <=====> response
        //        Map                         Response

        // Assertion yapabilmemiz icin response'i Map'e cevirmemiz gerekir (De-Serialization)

        Map<String,Object> responseMap= response.as(Map.class);

        // expectedData (Map) <===> responseMap(Map)

        assertEquals(expectedData.get("title"),responseMap.get("title"));
        assertEquals(expectedData.get("body"),responseMap.get("body"));
        assertEquals(expectedData.get("id"),responseMap.get("id"));
        assertEquals(expectedData.get("userId"),responseMap.get("userId"));

    }
}
