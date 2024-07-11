package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter setter ve toString olusturur
@AllArgsConstructor // constructorlari olusturur
@NoArgsConstructor // parametresiz constructorlari olusturur
public class HerokuappResponseBody { // HerokuappExpBodyPojo // en distaki json

    // 1- tum variable'lari private olarak olustur
    private int bookingid;
    private HerokuappRequestBodyPojo booking;

    // 2- tum variable'lar icin getter ve setter metodlari olusturalim
    public int getBookingid() {
        return bookingid;
    }
    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }
    public HerokuappRequestBodyPojo getBooking() {
        return booking;
    }
    public void setBooking(HerokuappRequestBodyPojo booking) {
        this.booking = booking;
    }


    // 3- tum parametreleri kullanarak bir constructor olusturalim
    public HerokuappResponseBody(int bookingid, HerokuappRequestBodyPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }


    // 4- default constructor yerine manuel olarak parametresiz bir constructor olusturalim
    public HerokuappResponseBody() {
    }


    // 5- toString metodu olusturalim
    @Override
    public String toString() {
        return "PojoHerokuappResponseBody{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
