package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class HerokuappRequestBodyPojo { // BookingPojo // ortadaki json
    /**
     * @Data // getter setter ve toString olusturur
     * @AllArgsConstructor // constructorlari olusturur
     * @NoArgsConstructor // parametresiz constructorlari olusturur
     *
     *
     * {
     * "firstname" : "Ali",
     * "lastname" : “Bak",
     * "totalprice" : 500,
     * "depositpaid" : false,
     * "bookingdates" : {
     *      "checkin" : "2021-06-01",
     *      "checkout" : "2021-06-10"
     * },
     * "additionalneeds" : "wi-fi"
     * }
     */

    // 1- tum variable'lari private olarak olustur
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private HerokuappBookingDatesPojo bookingdates; // data type olarak baska class adi aliyoruz cunku orada olusturmustuk
    private String additionalneeds;


    // 2- tum variable'lar icin getter ve setter metodlari olusturalim
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public boolean isDepositpaid() {
        return depositpaid;
    }
    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }
    public HerokuappBookingDatesPojo getBookingdates() {
        return bookingdates;
    }
    public void setBookingdates(HerokuappBookingDatesPojo bookingdates) {
        this.bookingdates = bookingdates;
    }
    public String getAdditionalneeds() {
        return additionalneeds;
    }
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    // 3- tum parametreleri kullanarak bir constructor olusturalim
    public HerokuappRequestBodyPojo(String firstname, String lastname, int totalprice, boolean depositpaid, HerokuappBookingDatesPojo bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }


    // 4- default constructor yerine manuel olarak parametresiz bir constructor olusturalim
    public HerokuappRequestBodyPojo() {
    }

    // 5- toString metodu olusturalim
    @Override
    public String toString() {
        return "PojoHerokuappRequestBody{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }

}
