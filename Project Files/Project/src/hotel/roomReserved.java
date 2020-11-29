package hotel;

public class roomReserved {
    private String Guest_SSN;
    private int room_id ;
    private String roomPass;
    private boolean roomavailability;
    private int numOfBed;
    private String roomDescription;
    private String Reservation_Time;
    private String roomLocation;
    private boolean checkCleannessOfRooms[];
    private boolean DailyCheck [];

    public roomReserved(String Guest_SSN,int room_id, String roomDescription, int numOfBed, String Reservation_Time){
    this.Guest_SSN = Guest_SSN;
    this.room_id=room_id;
    this.roomPass=roomPass;
    this.roomavailability=roomavailability;
    this.numOfBed=numOfBed;
    this.roomDescription=roomDescription;
    this.Reservation_Time = Reservation_Time;
    this.roomLocation=roomLocation;
    this.checkCleannessOfRooms=checkCleannessOfRooms;
    this.DailyCheck=DailyCheck;   
    }

    public String getReservation_Time() {
        return Reservation_Time;
    }

    public void setReservation_Time(String Reservation_Time) {
        this.Reservation_Time = Reservation_Time;
    }

    public String getGuest_SSN() {
        return Guest_SSN;
    }

    public void setGuest_SSN(String Guest_SSN) {
        this.Guest_SSN = Guest_SSN;
    }
    
    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoomPass() {
        return roomPass;
    }

    public void setRoomPass(String roomPass) {
        this.roomPass = roomPass;
    }

    public boolean isRoomavailability() {
        return roomavailability;
    }

    public void setRoomavailability(boolean roomavailability) {
        this.roomavailability = roomavailability;
    }
   
    public int getNumOfBed() {
        return numOfBed;
    }
 
    public void setNumOfBed(int numOfBed) {
        this.numOfBed = numOfBed;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    public boolean[] getCheckCleannessOfRooms() {
        return checkCleannessOfRooms;
    }

    public void setCheckCleannessOfRooms(boolean[] checkCleannessOfRooms) {
        this.checkCleannessOfRooms = checkCleannessOfRooms;
    }

    public boolean[] getDailyCheck() {
        return DailyCheck;
    }

    public void setDailyCheck(boolean[] DailyCheck) {
        this.DailyCheck = DailyCheck;
    }   
}