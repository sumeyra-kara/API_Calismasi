package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class _02_Get_ResponseBilgileriAssertion {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
    gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
     */

    @Test
    public void get01(){
        // 1- Gonderecegimiz Request icin gerekli olan Url hazirla (get methodu oldugu icin body gerekli degil)
        String url = "https://restful-booker.herokuapp.com/booking/10"; // 10 id'e ait olan

        // 2- Eger soruda bize acikca verilmisse Expected Data hazirla

        // 3- Bize donen response'i Actual Data olarak kaydet (gherkin language'den aldigimiz (given,then, wenn, and ..))
        Response response = given().when().get(url); // her zaman given ile baslanir
        response.prettyPrint(); // response body'sini verir
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");

        // bunun ile direkt response'n bilgilerini pespese assert edebilirim.




    }
}
