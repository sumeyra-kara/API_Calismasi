package test;

import baseUrlKlasoru.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class _15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseUrl { //  extends  keyword ile base url class’ini inherit edelim.

    /**
     * Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
     * 1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request
     * gonderdigimizde donen response’un status code’unun 200 oldugunu ve
     * Response’ta 100 kayit oldugunu test edin
     * 2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request
     * gonderdigimizde donen response’un status code’unun 200 oldugunu ve “title”
     * degerinin “optio dolor molestias sit” oldugunu test edin
     * 3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
     * gonderdigimizde donen response’un status code’unun 200 oldugunu ve response
     * body’sinin null oldugunu test edin
     */

    @Test
    public void test1() {
        /**
         * 1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request
         * gonderdigimizde donen response’un status code’unun 200 oldugunu ve
         * Response’ta 100 kayit oldugunu test edin
         */

        // 1- url hazirla
        // path parametresi 1 tane ise pathparam, path parametreleri birden fazla ise pathparams metodu kullanilir
        specJsonPlace.pathParam("pp1","posts"); // pp1 ismini kendim verdim genel adlandirma boyledir // baseurl'2 path param eklemis oluyoruz

        // 2- expected data hazirla
        // 3- response'i kaydet
        // Response degerini hesaplarken given() metodundan sonra spec(istenenSpec) metodu yazilir ve
        // when() metodundan sonra yazilan HTTP metodunun icine parametre isimleri { } icinde yazilir.
        Response response = given().spec(specJsonPlace).when().get("/{pp1}"); // body gondermedigimiz icin contenttype ve body eklemiyoruz
        response.prettyPrint();

        // 4- assertion
        response.then().assertThat().statusCode(200)
                .body("title", Matchers.hasSize(100)); // title'in 100 tane oldugu
    }


    @Test
    public void test2() {
        /**
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request
        * gonderdigimizde donen response’un status code’unun 200 oldugunu ve “title”
        * degerinin “optio dolor molestias sit” oldugunu test edin
         */
        // 1- url hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",44); // birden fazla param varsa pathParams kullanilir

        // expected data hazirla
        // response'i kaydet
        Response response = given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4- assertion
        response.then().assertThat().statusCode(200)
                                        .body("title", equalTo("optio dolor molestias sit"),"userId",is(5));
    }



    @Test
    public void test3() {
        /**
         * 3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
         * gonderdigimizde donen response’un status code’unun 200 oldugunu ve response
         * body’sinin null oldugunu test edin
         */

        // 1- url hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",50);

        // expected data hazirla
        // response'i kaydet
        Response response = given().spec(specJsonPlace).when().delete("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4- assertion
        response.then().assertThat().statusCode(200).body("body", nullValue());
    }
}
