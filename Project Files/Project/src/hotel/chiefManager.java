/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.Date;

class chiefManager extends Employee{

String order[];
chief Assistance[];
boolean orderstate;
String menuDetails;
String foodsupplies[];
boolean checkfoodneed;
chiefManager(String name,long secN,String birthDate,String gender,String Email,int ID,double salary,String shiftTime,String paidPeriod,String workHour,int contactNum,String order[],chief Assistance[],boolean orderstate,String menuDetails,String foodsupplies[],boolean checkfoodneed)
{
        super(name,secN,birthDate,gender,Email,ID,salary,shiftTime,paidPeriod,workHour,contactNum);
	this.menuDetails=menuDetails;
	this.orderstate=orderstate;
	this.checkfoodneed=checkfoodneed;
	for(int i=0;i<order.length;i++)
	{
		this.order[i]=order[i];
	}
	for(int i=0;i<Assistance.length;i++)
	{
		this.Assistance[i]=Assistance[i];
	}
	for(int i=0;i<foodsupplies.length;i++)
	{
		this.foodsupplies[i]=foodsupplies[i];
	}
	
	
}
public void setAssistance(chief Assistance[] )
{
	for(int i=0;i<Assistance.length;i++)
	{
		this.Assistance[i]=Assistance[i];
	}
}
public void setorder(String order[])
{
	for(int i=0;i<order.length;i++)
	{
		this.order[i]=order[i];
	}
}
public void setorderstate(boolean orderstate)
{
	this.orderstate=orderstate;
}
public boolean getorderstate(boolean orderstate)
{
	return orderstate;
}
public void setmenuDetails(String menuDetails)
{
	this. menuDetails= menuDetails;
}
public String getmenuDetails()
{
	return menuDetails;
}
public void setfoodsupplies(String foodsupplies[])
{
	for(int i=0;i<foodsupplies.length;i++)
	{
		this.foodsupplies[i]=foodsupplies[i];
	}
}
public void setcheckfoodneed(boolean checkfoodneed)
{
	this.checkfoodneed=checkfoodneed;
}
public boolean getcheckfoodneed()
{
	return checkfoodneed;
}
}

























