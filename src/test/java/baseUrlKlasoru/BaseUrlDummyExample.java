package baseUrlKlasoru;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlDummyExample {

    protected RequestSpecification specDummyExample; //  Olusturdugumuz objeyi child class’lardan ulasabilme icin protected yapalim

    @Before
    public void setup(){

        specDummyExample= new RequestSpecBuilder()
                .setBaseUri("http://dummy.restapiexample.com/api/v1")
                .build();
    }
}
