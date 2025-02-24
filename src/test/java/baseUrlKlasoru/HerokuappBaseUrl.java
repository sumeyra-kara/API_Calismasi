package baseUrlKlasoru;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuappBaseUrl {

    protected RequestSpecification specHerokuApp;
    //  Olusturdugumuz objeyi child class’lardan ulasabilme icin(cunku kullanacagimiz classlar farkli package'da olabilir) protected yapalim

    @Before // her test methottan once otomatik olarak calisiyor
    public void setUp(){
        // objeye degerler atiyoruz
        specHerokuApp= new RequestSpecBuilder()
                        .setBaseUri("https://restful-booker.herokuapp.com") // base url olmasini istedigim kisim
                        .build();
    }
}
