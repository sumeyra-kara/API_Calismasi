package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class _6_Post_ResponseBodyTesti {
    /*
    https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request gonderdigimizde
    {
    "title":"API",
    "body":"API ogrenmek ne guzel",
    "userId":10,
    }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu (Matchers.equalTo)
        "userId" degerinin 100'den kucuk oldugunu (Matchers.lessThan)
        "body" nin "API" kelimesi icerdigini (Matchers.containsString)
        test edin
     */

    @Test
    public void post1(){
        // url ve request body hazirla
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        System.out.println("reqBody = " + reqBody);

        // 2- expected data hazirla (ama bizim yok
        // 3- response'i hazirla

        Response response = given()
                                    .contentType(ContentType.JSON)
                            .when()
                                    .body(reqBody.toString()).post(url);


        // 4- Assertion
        response.then().assertThat()
                            .statusCode(201)
                            .contentType("application/json")
                            .body("title", Matchers.equalTo("API"))
                            .body("userId", Matchers.lessThan(100))
                            .body("title", Matchers.containsString("API"));




    }


}
