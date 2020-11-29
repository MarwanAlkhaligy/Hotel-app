package hotel;

/**
 *
 * @author Kimo Store
 */
public class Login {
    private String ID;
    private String Password;

    public Login(String ID, String Password) {
        this.ID = ID;
        this.Password = Password;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
