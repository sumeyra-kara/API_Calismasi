package test;

import baseUrlKlasoru.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.HerokuappBookingDatesPojo;
import pojos.HerokuappRequestBodyPojo;
import pojos.HerokuappResponseBody;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class _26_Post_Pojo extends HerokuappBaseUrl {


     /**
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ali",
    	                "lastname" : “Bak",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }
    	            	Response Body // expected data
    	            {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                        ,
                        "additionalneeds":"wi-fi"
                    }
     */

    @Test
    public void test01(){
        // 1- Request url ve body olustur
        specHerokuApp.pathParam("pp1","booking");

        // doldurmaya en icten baslamaliyim
        HerokuappBookingDatesPojo bookingdatesPojo=new HerokuappBookingDatesPojo("2021-06-01","2021-06-10");

        HerokuappRequestBodyPojo requestBodyPojo=
                new HerokuappRequestBodyPojo("Ali","Bak",500,false,bookingdatesPojo,"wi-fi");

        HerokuappResponseBody expectedResponseBodyPojo = new HerokuappResponseBody(24, requestBodyPojo);


        // 2- Soruda varsa expected data olustur
        //bookingdatesPojo= new HerokuappBookingDatesPojo("2021-06-01","2021-06-10");

        //HerokuappRequestBodyPojo bookingPojo=
                //new HerokuappRequestBodyPojo("Ali","Bak",500,false,bookingdatesPojo,"wi-fi");

        /*
        PojoHerokuappResponseBody{
            bookingid=24,
            booking= PojoHerokuappRequestBody{
                        firstname='Ali',
                        lastname='Bak',
                        totalprice=500,
                        depositpaid=false,
                        bookingdates=PojoHerokuappBookingdates{
                                        checkin='2021-06-01',
                                        checkout='2021-06-10'},
                        additionalneeds='wi-fi'}}

         */
        // 3 - Response olustur, request gonderip sonucu response'a ata
        Response response= given().spec(specHerokuApp).contentType(ContentType.JSON)
                            .when()
                                    .body(requestBodyPojo)
                                    .post("{pp1}");


        /*
        PojoHerokuappResponseBody{
                bookingid=3090,
                booking=PojoHerokuappRequestBody{
                            firstname='Ahmet',
                            lastname='Bulut',
                            totalprice=500,
                            depositpaid=false,
                            bookingdates=PojoHerokuappBookingdates{
                                            checkin='2021-06-01',
                                            checkout='2021-06-10'},
                            additionalneeds='wi-fi'}}

         */

        // 4- Assertion
        //   expectedResponseBodyPojo  <=====> responsePojo
        HerokuappResponseBody responsePojo= response.as(HerokuappResponseBody.class);

        assertEquals(expectedResponseBodyPojo.getBooking().getFirstname(),responsePojo.getBooking().getFirstname());

        assertEquals(expectedResponseBodyPojo.getBooking().getLastname(),responsePojo.getBooking().getLastname());

        assertEquals(expectedResponseBodyPojo.getBooking().getTotalprice(),responsePojo.getBooking().getTotalprice());

        assertEquals(expectedResponseBodyPojo.getBooking().isDepositpaid(),responsePojo.getBooking().isDepositpaid());
        // booleanlar'i is seklinde yazar

        assertEquals(expectedResponseBodyPojo.getBooking().getAdditionalneeds(),responsePojo.getBooking().getAdditionalneeds());

        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckin(),
                        responsePojo.getBooking().getBookingdates().getCheckin());

        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckout(),
                        responsePojo.getBooking().getBookingdates().getCheckout());

    }
}
