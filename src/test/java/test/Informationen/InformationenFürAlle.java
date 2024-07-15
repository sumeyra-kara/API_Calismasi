package test.Informationen;

public class InformationenFürAlle {
    /*
    - Response'in temel bilgilerini nasil test ediyoruz? assert.then().assertThat().

    - Response'in body'sini test etmek icin ?
            Matchers class'ina ihtiyac vardir
            assert. then . assertThat(). body()

    - Karmasik json objeleri varsa response'dan sonra then.assertThat ile body'i test edeceksek JsonPath ile yapariz

    - respose'i testNg ya da Junit ile test etmek istersek response json Path'E cevrilir
      hazirladigimiz expexteddata'lar jsonObject türünde oluyor.
        karmasik jsonpath test ederken -----> aralarina nokta koyarak kolayca
        karmasik jsonObject test ederken ----> katmanli her bir katmana ayri method ile giriyoruz getJsonObject().get(...)

    - expexted data formati (jsonObject, map, pojo) olarak hazirladik

    - expected data map olarak hazirlandiysa test etmek icin ne yapmali? (map zor ve ugrastiricidir)
          donen response map'e donusturulur. casting vs yapilir.





     *********** ADIMLAR ************+

    // 1- Gonderecegimiz Request icin gerekli olan Url ve ihtiyacimiz varsa request body hazirla
    // 2- Eger soruda bize acikca verilmisse Expected Data hazirla
    // 3- Bize donen response'i Actual Data olarak kaydet
    // 4- Expected Data ile Actual Datayi karsilastirmamiz yani Assertion yapmamiz gerek


    ******** GENEL ++++++*
    - Post bastan yeni create etmek
      Get gormek read icin
      Put degisiklik icin update
      Patch kismi degiisklik icin
      Delete silmek icin

    - Get icin body hazirlamya gerek yoktur
      Ama post Put Patch icin body gereklidir cunku yeni kayitdir veya degiiiskligi icin bilgi gereklidir
    - response io.restassured 'den import edilmek zorunda
    - prettyPrint() ile yazdirma yapabiliriz. prettyPekk diyince de header degerleri ile birlikte yazdirir
    - degerlerin testi icin
            1. response.then().assertThat().
            2. JsonObject (data turunu belirtmeye gerek yok. Her türlu konulabilir) // tercih edilen bu
            3. JsonPath
            4. Map (Dta turu belirtmek zorundasin olustururken)
            5. Pojo

     ** Json Object ***

    - JSONObject ilkJsonObject = new JSONObject(); // obje olusturulmali
      ilkJsonObject.put() ile de key value eklenir
    - Ic ice JsonObject de olusturulabilir. once inner olustur sonra outer olustur
    - eger put vs varsa body gereklidir ve body olusturulmak zorunda  ilkJsonObject.put() yapilir
    - get metodu oldugu durumda given().when().get(url); dmeek yeterlidir
      ama put varsa mesela; // body yazacagimiz icin body turunu de belirtmek zorundayiz
            given().contentType(ContentType.JSON)
            when().body(ilkJsonObject.toString()) // json objesini string'e cevirmis olduk
            put(url);



     ** Map *******

     - en uygun sey map'tir aslinda cunku key value seklinde
     - tek problem;
        expected Response bodysi(map) ile response kiyasliyoruz normalde ama ikisi de birbirine donusmeli
        response'dan map'e veya da tersi..

     * işlem yaptığımız nesneyi, sınıfı saklamak yada transfer etmek istediğimiz formata dönüştürme işlemine Serialization denir.
     * Verilen Json objesini testlerimizde kullanmak uzere Java objesine(map vs) cevirmeye ise De-Serialization denir
     * map objelerini api sorgulamasi icin json obesine cevirmeye de Serialization denir.

     - response objesini de-seralization ile map'e cevirmek icin gson kutuphanesi gerekli
     - Map<String,Object> responseMap= response.as(Map.class); bu sekilde mesela json objesi map'e donusebiliyor
     - map'i JsonObject'e cevirmek icin de Gson Class'indan yardim aliriz. ama once o classtan obje olusturmak gerek
       Gson gson = new Gson();
       String jsonFromJJavaObject = gson.toJson(actualDataMap); // map JsonObject'E uygundur. string jsonObject icin uygundur
     - map cevirmek yaparken int leri double olarak ceviriyor casting yapabiliriz veya int leri double olrak yazabilirsin
     - map icinde map varsa mutlaka castin yapmak gerekir
       Map<String,Object>    bu distaki map
        ama mesela icteki map icin o maptir ancak bize onceden object olrak tanimladigimiz icin map'E cating yapmak gerek
        ör :  assertEquals(((Map)expectedData.get("data")).get("profile_image"),((Map)responseMap.get("data")).get("profile_image"));

     -








     *** POJO *********

     POJO (Plain Old Java Object)

    - Pojo class zorunluluk degil, karmasik yapilan icin kullanilan yapidir.
    - Pojo'da java'nin encapsulation  ozellikleri kullanilir
       biz variableleri private yapicaz. sonra getter setter methodlari olusturulur,
       tum parametrelri constructor olarak yapicaz ve default costructor(parametresiz) olusturmaliyiz
       bir de toString() de yapilir

    - Pojo'da expected data pojo olarak hazirlandigi icin donen response'i da pojo obje'ye donustururuz
    - data typle'in ayni olmasina dikkat edilmeli
    - pojo'da eger katmanli bir yapi varsa en icteki pojo'dan olusturmaya baslamak gerekir









     */
}
