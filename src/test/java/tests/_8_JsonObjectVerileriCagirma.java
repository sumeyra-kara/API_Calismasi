package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class _8_JsonObjectVerileriCagirma {
    /*

      kisiBilgisi = {
        "firstName":"John",
        "lastName":"Doe",
        "address":{
                    "streetAdress":"naist street",
                    "city":"Nara",
                    "postalCode":"630-0192"},#
        "age":26,
        "phoneNumbers":[
                        {"number":"0123-4567-8888",
                         "type":"iphone"
                        },
                        {
                          "number":"0123-4567-8910",
                          "type":"home"
                        }]
                }

     */

    @Test
    public void jsonPath01(){

        JSONObject cepTel = new JSONObject(); // ceptel icin
        cepTel.put("type","iphone");
        cepTel.put("number","0123-4567-8888");

        JSONObject evTel = new JSONObject();
        evTel.put("type","home");
        evTel.put("number","0123-4567-8910");

        JSONArray phoneNumbers  =new JSONArray(); // json array icine indeksleri ile birlikte koyduk
        phoneNumbers.put(0,cepTel);
        phoneNumbers.put(1,evTel);

        JSONObject address = new JSONObject();
        address.put("streetAdress","naist street");
        address.put("city","Nara");
        address.put("postalCode","630-0192");

        JSONObject kisiBilgisi = new JSONObject(); // en distaki json icin
        kisiBilgisi.put("firstName","John");
        kisiBilgisi.put("lastName","Doe");
        kisiBilgisi.put("age",26);
        kisiBilgisi.put("address",address);
        kisiBilgisi.put("phoneNumbers",phoneNumbers);

        //System.out.println("kisiBilgisi = " + kisiBilgisi);


        System.out.println("kisiBilgisi.get(address) = " + kisiBilgisi.get("address")); //  {"streetAdress":"naist street","city":"Nara","postalCode":"630-0192"}
        System.out.println("phoneNumbers = " + phoneNumbers); // [{"number":"0123-4567-8888","type":"iphone"},{"number":"0123-4567-8910","type":"home"}]

        System.out.println("isim : " + kisiBilgisi.get("firstName")); // John
        System.out.println("soyisim : " + kisiBilgisi.get("lastName")); // Doe
        System.out.println("yas : " + kisiBilgisi.get("age")); // 26
        System.out.println("sokak adi : " + kisiBilgisi.getJSONObject("address").get("streetAdress"));
        System.out.println("sehir adi : " + kisiBilgisi.getJSONObject("address").get("city")); // Nara
        System.out.println("posta code : " + kisiBilgisi.getJSONObject("address").get("postalCode")); // 630-0192

        // eger array olursa

        System.out.println("tel No: " + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(0).get("number")); // 0123-4567-8888
        System.out.println("tel marka: " + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(0).get("type")); // iphone

        System.out.println("tel No: " + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(1).get("number")); // 0123-4567-8910
        System.out.println("tel marka: " + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(1).get("type")); // home

    }
}
