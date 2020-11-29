package hotel;

import java.util.Date;

public class Booking {
    private Guest Gues;
    private Date BookingTime;
    private double Paidmoney;
    private room BookedRoom;
    
    public Booking(Guest Gues,Date BookingTime, double Paidmoney,room BookedRoom){
    this.Gues = Gues;
    this.BookingTime = BookingTime;
    this.Paidmoney = Paidmoney;
    this.BookedRoom = BookedRoom; 
    }
    public void setGuest(Guest Gues){
        this.Gues = Gues;
    }
    public Guest getGuest(){
        return  this.Gues;
    }
    public void setBookingTime(Date BookingTime){
        this.BookingTime = BookingTime;
    }
    public Date getBookingTime(){
        return  this.BookingTime;
    }
     public void setPaidmoney(double Paidmoney){
        this.Paidmoney = Paidmoney;
    }
    public double getPaidmoney(){
        return this.Paidmoney;
    }
    public void setBookedRoom(room BookedRoom){
        this.BookedRoom = BookedRoom;
    }
    public room getBookedRoom(){
        return this.BookedRoom;
    }
    
    
    
}
