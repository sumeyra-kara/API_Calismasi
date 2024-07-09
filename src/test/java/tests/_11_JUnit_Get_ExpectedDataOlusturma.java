package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _11_JUnit_Get_ExpectedDataOlusturma {
    /**
     * https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
     * yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test ediniz
     * Response body :
     * {
     * "userId": 3,
     * "id": 22,
     * "title": "dolor sint quo a velit explicabo quia nam",
     * "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
     * }
     */

    @Test
    public void test(){
        // 1- end point ve varsa request body hazirla
        String url ="https://jsonplaceholder.typicode.com/posts/22";

        // 2- Expected Data hazirla

        JSONObject expData = new JSONObject();
        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        System.out.println("expData = " + expData);

        // 3- response'i kaydet

        Response response = given().when().get(url); // get methodu oldugu icin baska seylere ihtiyac yok
        // response.prettyPrint();
        response.prettyPeek(); // prettyprint'Den farkli olarak bu header degerleri ile birlikte yazdirilir

        // 4- Assert

        JsonPath responseJsonPath=response.jsonPath(); // actual degerler icin

        assertEquals(expData.get("userId"), responseJsonPath.getInt("userId"));
        assertEquals(expData.get("id"), responseJsonPath.getInt("id"));
        assertEquals(expData.get("body"), responseJsonPath.getString("body"));
        assertEquals(expData.get("title"), responseJsonPath.getString("title"));

    }
}
