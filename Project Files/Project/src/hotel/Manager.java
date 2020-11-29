
package hotel;

import java.util.Date;
public class Manager extends Employee{
    private Receptioist list1[];
    private chief list2[];
    private cleanmanger cleanmanger;
    private boolean checkBills;
    private securityLeader list3;
    Manager(String name,long secN,String birthDate, String gender,String Email,int ID,
            double salary,String shiftTime,String paidPeriod,
            String workHour,int contactNum,Receptioist list11[],
            chief list22[],cleanmanger cleanmanger,securityLeader 
                    list3, boolean checkBills){
        
        super(name,secN,birthDate,gender,Email,ID,salary,shiftTime,paidPeriod,workHour,contactNum);
        this.checkBills=checkBills;
        this.list3=list3;
        this.cleanmanger=cleanmanger;
        for(int i=0;i<list1.length;i++)
		{
			this.list1[i]=list11[i];
		}
        for(int i=0;i<list2.length;i++)
		{
			this.list2[i]=list22[i];
		}
    }



    public void setList1(Receptioist[] list1) {
        this.list1 = list1;
    }

    public void setList2(chief list2[]) {
        this.list2 = list2;
    }

 
    public cleanmanger getCleanmanger() {
        return cleanmanger;
    }

    public void setCleanmanger(cleanmanger cleanmanger) {
        this.cleanmanger = cleanmanger;
    }

  
    public boolean isCheckBills() {
        return checkBills;
    }

  
    public void setCheckBills(boolean checkBills) {
        this.checkBills = checkBills;
    }

 
    public securityLeader getList3() {
        return list3;
    }

 
    public void setList3(securityLeader list3) {
        this.list3 = list3;
    }
    
}
