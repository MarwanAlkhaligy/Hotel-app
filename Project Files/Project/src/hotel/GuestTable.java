package hotel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class GuestTable implements Initializable{
        private String name;
        private String pass;
	private long secN;
	private String gender;
	private String Email;
        private int visaCardNum;
        private int numberOfRoomsChecked;
        private int numberOfBeds;
        private int badgedMoney;
        private int contactNum;
        private String BirthDate;

    public GuestTable( String name, String pass, Long secN, String gender, String Email, String BirthDate) {
        this.name = name;
        this.pass = pass;
        this.secN = secN;
        this.gender = gender;
        this.Email = Email;
        this.visaCardNum = visaCardNum;
        this.numberOfRoomsChecked = numberOfRoomsChecked;
        this.numberOfBeds = numberOfBeds;
        this.badgedMoney = badgedMoney;
        this.contactNum = contactNum;
        this.BirthDate = BirthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long getSecN() {
        return secN;
    }

    public void setSecN(long secN) {
        this.secN = secN;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return Email;
    }

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

    public int getContactNum() {
        return contactNum;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }
      
        @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }   
}