package baseUrlKlasoru;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    protected RequestSpecification specJsonPlace; //  Olusturdugumuz objeyi child class’lardan ulasabilme icin protected yapalim

    @Before // her methottan onnce otomatik olarak calisiyor
    public void setUp(){
        // objeye degerler atiyoruz
        specJsonPlace= new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();
    }


    /**
     * Her sorguda Base url’i tekrar yazmak hem zor, hem de kodlama mantigi acisindan dusuk  kalitededir.
     * Bir framework olustururken hedeflenen temel amaclardan biri de framework’u dinamik yapmaktir.
     * Bunu saglamak icin base url ayri bir class’da olusturulur, test yaptigimiz classlar
     * inheritance metotlarini kullanarak base url’i bulundugu class’dan kullanirlar.
     * Boylece base url’de yapilacak bir degisiklikte tum class’lardaki url’leri kontrol edip duzeltmek
     * yerine base url’in bulundugu class’da tek bir degisiklik yapmak yeterli olmaktadir
     */
}
