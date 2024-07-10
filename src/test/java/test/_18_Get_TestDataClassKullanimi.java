package test;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrlKlasoru.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    @Test
    public void test01(){
        /**
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda
        donen response’in
            status kodunun 200
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                         um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
        */

        // 1- endpoint ve request body olustur
        specJsonPlace.pathParams("pp1","posts","pp2",22);

        // 2- expected data olustur
        TestDataJsonPlaceholder testDataJsonPlaceholder = new TestDataJsonPlaceholder();
        JSONObject expData = testDataJsonPlaceholder.responseBodyOlustur22();

        // veya da method static yapilarak bu sekilde tek satirda yapilir(asagidaki)
        //JSONObject expectedData= TestDataJsonPlaceholder.responseBodyOlustur22(); // testdata'Dan method cagirarak kisaca yapiyoruz

        /* UZUN YOL BUYDU
        JSONObject expectedData=new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear um mollitia molestiae aut atque rem suscipit\nnam impedit esse");
         */

        // 3- request gonder ve donen response'i kaydet

        Response response= given().spec(specJsonPlace).when().get("{pp1}/{pp2}");
        JsonPath responseJsonpath= response.jsonPath(); // assert yapmak icin jsonpath'e donusturmek gerek

        // 4- Assertion
        // status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
        // assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());

        assertEquals(expData.get("userId"),responseJsonpath.get("userId"));
        assertEquals(expData.get("id"),responseJsonpath.get("id"));
        assertEquals(expData.get("title"),responseJsonpath.get("title"));
        assertEquals(expData.get("body"),responseJsonpath.get("body"));
    }

    @Test
    public void test2() {
        /**
        https://jsonplaceholder.typicode.com/posts/40 url'ine bir GET request yolladigimizda donen response’in
            status kodunun 200
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
            "userId":4,
            "id":40,
            "title":"enim quo cumque",
            "body":"ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
        }
        */
        // 1- endpoint ve request body olustur
        specJsonPlace.pathParams("pp1","posts","pp2",40);

        // 2- expected data olustur
        JSONObject expData= TestDataJsonPlaceholder.JsonBodyOlustur(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");


        // 3- request gonder ve donen response'i kaydet

        Response response= given().spec(specJsonPlace)
                .when()
                .get("{pp1}/{pp2}");

        // 4- Assertion status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        JsonPath responseJsonpath= response.jsonPath();

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        assertEquals(expData.get("userId"),responseJsonpath.get("userId"));
        assertEquals(expData.get("id"),responseJsonpath.get("id"));
        assertEquals(expData.get("title"),responseJsonpath.get("title"));
        assertEquals(expData.get("body"),responseJsonpath.get("body"));








    }
}
