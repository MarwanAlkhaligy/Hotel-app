/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.Date;

class cleanmanger extends Employee
{
	cleanworker cleanteam[];
	cleanmanger(String name,long secN,String birthDate,String gender,String Email,int ID,double salary,String shiftTime,String paidPeriod,String workHour,int contactNum,cleanworker x[])
	{
		super(name,secN,birthDate,gender,Email,ID,salary,shiftTime,paidPeriod,workHour,contactNum);
		for(int i=0;i<cleanteam.length;i++)
		{
			this.cleanteam[i]=x[i];
		}
	}
	public void setcleanworker(cleanworker cleanteam[])
	{
		for(int i=0;i<cleanteam.length;i++)
		{
			this.cleanteam[i]=cleanteam[i];
		}
	}
		
}
