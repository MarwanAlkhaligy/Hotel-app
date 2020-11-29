package hotel;
  
   public abstract class Employee implements person{
	protected String name;
	protected long secN;
	protected int Age;
        protected String birthDate;
	protected String gender;
	protected String Email;
	protected int ID;
	protected double salary ;
	protected String shiftTime;
        protected String paidPeriod;
        protected String workHour;
        protected int contactNum;
        
        Employee(String name,long secN,String birthDate,String gender,String Email,int ID,double salary,String shiftTime,String paidPeriod,String workHour,int contactNum)
	{
            this.name=name;
            this.secN=secN;
            this .birthDate=birthDate;
            this.gender=gender;
            this.Email=Email;
            this.ID=ID;
            this.salary=salary;
            this.shiftTime=shiftTime;
            this.paidPeriod=paidPeriod;
            this.workHour=workHour;
            this.contactNum=contactNum;
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
    public void setBirthDate(String birthDate) {
        this.birthDate=birthDate;
    }
    
    @Override
    public String getBirthDate() {
        return birthDate;
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
    
    public int getID() {
        return ID;
    }
 
    public void setID(int ID) {
        this.ID = ID;
    }

    public double getSalary() {
        return salary;
    }
 
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getShiftTime() {
        return shiftTime;
    }
 
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }
    
    public String getPaidPeriod() {
        return paidPeriod;
    }
  
    public void setPaidPeriod(String paidPeriod) {
        this.paidPeriod = paidPeriod;
    }
  
    public String getWorkHour() {
        return workHour;
    }
   
    public void setWorkHour(String workHour) {
        this.workHour = workHour;
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