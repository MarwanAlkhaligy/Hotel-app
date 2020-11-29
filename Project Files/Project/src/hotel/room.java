package hotel;

public class room {
    
    private int room_id ;
    private String roomPass;
    private boolean roomavailability;
    private int numOfBed;
    private String roomDescription;
    private String roomLocation;
    private boolean checkCleannessOfRooms[];
    private boolean DailyCheck [];

    public room(int room_id, String roomDescription, int numOfBed){
    this.room_id = room_id;
    this.roomPass = roomPass;
    this.roomavailability=roomavailability;
    this.numOfBed=numOfBed;
    this.roomDescription=roomDescription;
    this.roomLocation=roomLocation;
    this.checkCleannessOfRooms=checkCleannessOfRooms;
    this.DailyCheck=DailyCheck;   
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