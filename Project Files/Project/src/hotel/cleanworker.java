/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.Date;

class cleanworker extends Employee
{
	String cleanarea;
	cleanworker(String name,long secN,String birthDate,String gender,String Email,int ID,double salary,String shiftTime,String paidPeriod,String workHour,int contactNum,String cleanarea)
	{
		super(name,secN,birthDate,gender,Email,ID,salary,shiftTime,paidPeriod,workHour,contactNum);
                this.cleanarea=cleanarea;
	}
	public void setcleanarea(String cleanarea)
	{
		this.cleanarea=cleanarea;
	}
	public String getcleanarea()
	{
		return cleanarea;
	}
	
	
}