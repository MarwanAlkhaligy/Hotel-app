/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.Date;


class chief extends Employee {
	
	 
	private String cookspecialist;
	private String yearofexperience;
	
	
	chief(String name,long secN,String birthDate,String gender,String Email,int ID,double salary,String shiftTime,String paidPeriod,String workHour,int contactNum,String cookspecialist,String yearofexperience){
                super(name,secN,birthDate,gender,Email,ID,salary,shiftTime,paidPeriod,workHour,contactNum);
		this.cookspecialist=cookspecialist;
		this.yearofexperience=yearofexperience;
	}
	public void setcookspecialist (String cookspecialist)
	{
		this.cookspecialist=cookspecialist;
	}
	public String getcookspecialist ()
	{
		return cookspecialist;
	}
	public void setyearofexperience(String yearofexperience)
	{
		this.yearofexperience=yearofexperience;
	}
	public String getyearofexperience()
	{
		return yearofexperience;
	}	
}