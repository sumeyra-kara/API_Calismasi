package test;


import TestDatalari.TestDataDummyExample;

import baseUrlKlasoru.BaseUrlDummyExample;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _23_Get_DeSerialization extends BaseUrlDummyExample {
    /**
     * işlem yaptığımız nesneyi, sınıfı saklamak yada transfer etmek istediğimiz formata
     * dönüştürme işlemine Serialization denir.
     * Verilen Json objesini testlerimizde kullanmak uzere Java objesine cevirmeye ise De-Serialization denir
     */

    /**
     * http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     * gonderdigimizde donen response’un status code’unun 200, content Type’inin
     * application/json ve body’sinin asagidaki gibi oldugunu test edin.
     * Response Body
     * {
     * "status": "success",
     * "data": {
     *      "id": 3,
     *      "employee_name": "Ashton Cox",
     *      "employee_salary": 86000,
     *      "employee_age": 66,
     *      "profile_image": ""
     * },
     * "message": "Successfully! Record has been fetched."
     * }
     */
    @Test
    public void test01(){
        // 1- endpoint ve request body olustur
        specDummyExample.pathParams("pp1","employee","pp2","3");

        // 2- Soruda varsa expected data olustur
        Map<String,Object> expectedData = TestDataDummyExample.mapBodyOlustur();// expected data bir map

        // 3- Request gonder donen response'i kaydet
        Response response =  given().spec(specDummyExample) // body olmadigi icin content type'i koymuyoruz
                            .when()
                            .get("{pp1}/{pp2}");

        Map<String,Object> responseMap= response.as(Map.class); // response'i map'e cevirdik cunku assert yapmak icin her ikisinin data type'i ayni olmali
        // response objesini De-Serialization ile Map’e cevirmek icin Gson kutuphanesi gerekli

        // 4- Assertion
        assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());// donen response’un status code’unun 200,
        assertEquals(TestDataDummyExample.contentType,response.contentType());// content Type’inin application/json

        // ve body’sinin asagidaki gibi oldugunu test edin.
        assertEquals(expectedData.get("message"),responseMap.get("message"));
        assertEquals(expectedData.get("status"),responseMap.get("status"));

        // map icerisinde map oldugu icin casting yapmak gerekiyor
        assertEquals(((Map)expectedData.get("data")).get("profile_image"),((Map)responseMap.get("data")).get("profile_image"));

        assertEquals(((Map) expectedData.get("data")).get("employee_name"),((Map) responseMap.get("data")).get("employee_name"));

        assertEquals(((Map) expectedData.get("data")).get("employee_salary"),((Map) responseMap.get("data")).get("employee_salary"));

        assertEquals(((Map) expectedData.get("data")).get("id"),((Map) responseMap.get("data")).get("id"));

        assertEquals(((Map) expectedData.get("data")).get("employee_age"),((Map) responseMap.get("data")).get("employee_age"));


    }
}
