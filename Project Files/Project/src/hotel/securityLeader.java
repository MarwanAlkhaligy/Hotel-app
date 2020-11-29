
package hotel;

import java.util.Date;


public class securityLeader extends Employee {
    private securityPerson securityAssistance[];
    private String securedArea;
    private boolean checkSecurity;
    private int numberOfSecurityPerson;


    securityLeader(String name,long secN,String birthDate,String gender,String Email, int ID,double salary,String shiftTime,String paidPeriod,
                String workHour,int contactNum,securityPerson securityAssistance[] ,
                String securedArea,boolean checkSecurity,int numberOfSecurityPerson){
                super(name,secN,birthDate,gender,Email,ID,salary,shiftTime,paidPeriod,workHour,contactNum);
		this.securedArea=securedArea;
                this.checkSecurity=checkSecurity;
                this.numberOfSecurityPerson=numberOfSecurityPerson;
                for(int i=0;i<securityAssistance.length;i++)
                {
                    this.securityAssistance[i]=securityAssistance[i];
                }
                
 }
 

   
    public void setSecurityAssistance(securityPerson[] securityAssistance) {
          for(int i=0;i<securityAssistance.length;i++)
                {
                    this.securityAssistance[i]=securityAssistance[i];
                }
    }

   
    public String getSecuredArea() {
        return securedArea;
    }

   
    public void setSecuredArea(String securedArea) {
        this.securedArea = securedArea;
    }

   
    public boolean isCheckSecurity() {
        return checkSecurity;
    }

  
    public void setCheckSecurity(boolean checkSecurity) {
        this.checkSecurity = checkSecurity;
    }

   
    public int getNumberOfSecurityPerson() {
        return numberOfSecurityPerson;
    }

   
    public void setNumberOfSecurityPerson(int numberOfSecurityPerson) {
        this.numberOfSecurityPerson = numberOfSecurityPerson;
    }
    
}
