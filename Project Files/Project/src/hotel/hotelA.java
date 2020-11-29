
package hotel;


public class hotelA {
    private String hotelName;
    private String hotelAddress;
    private  String hotelManager;
    private int hotelContactNumber;
    private room hotelRooms[];
    private String hotelEmail;

    hotelA(String hotelName,String hotelAddress,String hotelManager,int hotelContactNumber ,String hotelEmail,room hotelRooms[] )
    {
        this.hotelName=hotelName;
        this.hotelAddress=hotelAddress;
        this.hotelManager=hotelManager;
        this.hotelContactNumber=hotelContactNumber;
        this.hotelRooms=hotelRooms;
        this.hotelEmail=hotelEmail;
    }
    public String getHotelName() {
        return hotelName;
    }

 
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

 
    public void setHotelAddres(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

  
    public String getHotelManager() {
        return hotelManager;
    }


    public void setHotelMnagaer(String hotelManager) {
        this.hotelManager = hotelManager;
    }


    public int getHotelContactNumber() {
        return hotelContactNumber;
    }


    public void setHotelContactNumber(int hotelContactNumber) {
        this.hotelContactNumber = hotelContactNumber;
    }

    public room[] getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(room[] hotelRooms) {
        this.hotelRooms = hotelRooms;
    }


    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }
}
