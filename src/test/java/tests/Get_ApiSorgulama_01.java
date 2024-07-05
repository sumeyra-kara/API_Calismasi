package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get_ApiSorgulama_01 {

    // postman'Da yazilanlar burada api otomasyonu yapiyoruz
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
    gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
    ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */

    // *********** ADIMLAR ************+

    // 1- Gonderecegimiz Request icin gerekli olan Url ve ihtiyacimiz varsa request body hazirla
    // 2- Eger soruda bize acikca verilmisse Expected Data hazirla
    // 3- Bize donen response'i Actual Data olarak kaydet
    // 4- Expected Data ile Actual Datayi karsilastirmamiz yani Assertion yapmamiz gerek


    @Test
    public void get01(){ // manuel test yapiyoruz burada
        // 1- Gonderecegimiz Request icin gerekli olan Url ve ihtiyacimiz varsa request body hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10"; // 10 id'e ait olan

        // 2- Eger soruda bize acikca verilmisse Expected Data hazirla

        // 3- Bize donen response'i Actual Data olarak kaydet (gherkin language'den aldigimiz (given,then, wenn, and ..))

        Response response = given().when().get(url); // get metodunu kullanacagim icin get methodunu yazdim
        response.prettyPrint(); // atadigimiz obje nesnesini görmek icin bu sekilde de yazdirma yapariz
        // bunu yazdirmazsak consolda bir sey gozukmez. hatta her zaman yazdirmazsak daha iyi olur

        // 4- Expected Data ile Actual Datayi karsilastirmamiz yani Assertion yapmamiz gerek
        System.out.println("StatusCode = " + response.getStatusCode());
        System.out.println("ContentType = " + response.getContentType());
        System.out.println("Header = " + response.getHeader("Server"));
        System.out.println("StatusLine = " + response.getStatusLine());
        System.out.println("response süresi = " + response.getTime());
    }




}
