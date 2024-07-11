package test;

import baseUrlKlasoru.JsonPlaceHolderBaseUrl;

import TestDatalari.TestDataJsonPlaceholder;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PlaceHolderRequestBodyPOJO;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class _25_Put_PojoClass extends JsonPlaceHolderBaseUrl {
    // Pojo jAVA OBJESIDIR
   /**
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in
        status kodunun 200,
        content type’inin “application/json; charset=utf-8”,
        Connection header degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body : // expected data
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */

    @Test
    public void test01(){
        // 1- request url ve body olustur
        specJsonPlace.pathParams("pp1","posts","pp2","70");

        PlaceHolderRequestBodyPOJO requestBodyPojo = new PlaceHolderRequestBodyPOJO("Ahmet","Merhaba",10,70);

        // 2- soruda varsa expected data olustur
        PlaceHolderRequestBodyPOJO expectedDataPojo=
                                             new PlaceHolderRequestBodyPOJO("Ahmet","Merhaba",10,70);

        // 3 - Response olustur, request gonderip sonucu response'a ata
        Response response = given().spec(specJsonPlace)
                                    .contentType(ContentType.JSON)
                            .when().body(requestBodyPojo)
                                    .put("/{pp1}/{pp2}");

        // response.jsonPath(); -- eskiden bunu yapmistik
        // response.as(Map.class); -- map icin buydu

        PlaceHolderRequestBodyPOJO responsePojo = response.as(PlaceHolderRequestBodyPOJO.class);

        // 4- Assert
        // expected data (Pojo) <====> response (Pojo)
        // expectedDataPojo             responsePojo

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());//status kodunun 200,

        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());//content type’inin “application/json; charset=utf-8”,

        assertEquals(TestDataJsonPlaceholder.headerConnection,response.header("Connection"));//Connection header degerinin “keep-alive”

        // response body’sinin asagida verilen ile ayni oldugunu test ediniz
        // artik bundan sonra keyler get olarak otomatik geliyor. mesela getTitle gibi
        assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());
        assertEquals(expectedDataPojo.getId(),requestBodyPojo.getId());

    }
}
