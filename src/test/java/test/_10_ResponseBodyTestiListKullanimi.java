package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class _10_ResponseBodyTestiListKullanimi {
    /**
     * http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request
     * yolladigimizda
     * donen Response'in
     * status code'unun 200,
     * ve content type'inin Aplication.JSON,
     * ve response body'sindeki
     * employees sayisinin 24
     * ve employee'lerden birinin "Ashton Cox"
     * ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin
     * test edin.
     */

    @Test
    public void get1(){
        // 1- url hazirla ve gerekli ise request body hazirla
        String url = "http://dummy.restapiexample.com/api/v1/employees";

        // 2- expected Data hazirla (burada yok ama)
        // 3- Response'i kaydet

        Response response = given().when().get(url); // get sorgusu oldugu icin content type'a gerek yok
        response.prettyPrint();

        // 4- assert
        response.then().assertThat()
                            .statusCode(200)
                            .contentType("application/json")
                            .body("data.id", Matchers.hasSize(24))//data.id listesinin 24 elemani var mi diye
                            .body("data.employee_name",hasItem("Ashton Cox")) //employee.name icinde bu var mi
                            .body("data.employee_age",hasItems(61,21,35)); // yaslarin icinde bu yaslar var mi yok mu




    }
}
