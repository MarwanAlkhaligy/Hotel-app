package hotel;

import java.util.Date;

class Guest implements person {
        private String birthdate;
        private String name;
	private long secN;
	private String gender;
	private String Email;
        private int visaCardNum;
        private int numberOfRoomsChecked;
        private int numberOfBeds;
        private int badgedMoney;
        private boolean checkState;
        private int contactNum;
        private boolean CheckComformablity;
        private String pass;
        
        public Guest(String pass,boolean CheckComformablity,String name,long secN,String gender,String Email, int visaCardNum,int contactNum,String birthDate){
        this.CheckComformablity = CheckComformablity;
        this.name=name;
	this.secN=secN;
	this.gender=gender;
        this.Email=Email;
        this.visaCardNum=visaCardNum;
        this.contactNum=contactNum;
        this.pass = pass;
        this.birthdate = birthDate;
        }

    public String getPass() {
        return pass;
    }

        @Override
    public void setBirthDate(String birthdate) {
        this.birthdate = birthdate;
    }

        @Override
    public String getBirthDate() {
        return birthdate;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
        
    @Override
    public String getname() {
        return name;
    }

    @Override
    public void setname(String name) {
        this.name = name;
    }
 
    @Override
    public long getsecN() {
        return secN;
    }
    
    @Override
    public void setsecN(long secN) {
        this.secN = secN;
    }
    
    @Override
    public String getgender() {
        return gender;
    }
    
    @Override
    public void setgender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getEmail() {
        return Email;
    }
   
    @Override
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getVisaCardNum() {
        return visaCardNum;
    }

    public void setVisaCardNum(int visaCardNum) {
        this.visaCardNum = visaCardNum;
    }
   
    public int getNumberOfRoomsChecked() {
        return numberOfRoomsChecked;
    }

    public void setNumberOfRoomsChecked(int numberOfRoomsChecked) {
        this.numberOfRoomsChecked = numberOfRoomsChecked;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getBadgedMoney() {
        return badgedMoney;
    }

    public void setBadgedMoney(int badgedMoney) {
        this.badgedMoney = badgedMoney;
    }

    public boolean isCheckState() {
        return checkState;
    }

    public void setCheckState(boolean checkState) {
        this.checkState = checkState;
    }

    public void checkIn(){
        checkState=true;
    }
    
    public void checkOut(){
        checkState=false;
    }

    @Override
    public void setContactNum(int contactNum) {
        this.contactNum=contactNum;
    }

    @Override
    public int getContactNum() {
        return contactNum;
    }

}