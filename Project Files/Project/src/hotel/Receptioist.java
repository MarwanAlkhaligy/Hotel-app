/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.Date;

class Receptioist extends Employee
{
	room hotelroom[];
	boolean checkcleanessReceptionist ;
	Booking GuestDetail[];
	Receptioist(String name,long secN,String birthDate,String gender,String Email,int ID,double salary,String shiftTime,String paidPeriod,String workHour,int contactNum,boolean checkAvailableroom,room hotelroom[],boolean checkcleanessReceptionist,Booking GuestDetail[])
	{
super(name,secN,birthDate,gender,Email,ID,salary,shiftTime,paidPeriod,workHour,contactNum);
		this.checkcleanessReceptionist=checkcleanessReceptionist;
		for(int i=0;i<hotelroom.length;i++)
		{
			this.hotelroom[i]=hotelroom[i];
		}
		
		for(int i=0;i<GuestDetail.length;i++)
		{
			this.GuestDetail[i]=GuestDetail[i];
		}
		
	}
	
	public void setcheckcleanessReceptionist(boolean checkcleanessReceptionist)
	{
		this.checkcleanessReceptionist=checkcleanessReceptionist;
	}
	public boolean getcheckcleanessReceptionist(boolean checkcleanessReceptionist)
	{
		return checkcleanessReceptionist;
	}
	
	public void setGuestDetail(Booking GuestDetail[])
	{
		for(int i=0;i<GuestDetail.length;i++)
		{
			this.GuestDetail[i]=GuestDetail[i];
		}
	}
	
	
}