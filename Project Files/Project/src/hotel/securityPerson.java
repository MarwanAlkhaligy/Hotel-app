
package hotel;

import java.util.Date;

public class securityPerson extends Employee {
    private String securityPersonArea;
    private Login l1;
    
    
 securityPerson(Login l1,String name,long secN,int Age,String birthDate,String gender,String Email,String Address,int ID,double salary,String shiftTime,String paidPeriod,String workHour,int contactNum,String securityPersonArea){
             super(name,secN,birthDate,gender,Email,ID,salary,shiftTime,paidPeriod,workHour,contactNum);
             this.securityPersonArea=securityPersonArea;
             this. l1 = l1;
 }
    public String getSecurityPersonArea() {
        return securityPersonArea;
    }

  
    public void setSecurityPersonArea(String securityPersonArea) {
        this.securityPersonArea = securityPersonArea;
    }

    public Login getL1() {
        return l1;
    }

    public void setL1(Login l1) {
        this.l1 = l1;
    }
    
	
}
    

