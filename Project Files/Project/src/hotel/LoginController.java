package hotel;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{

    @FXML
    private TextField User_PhoneNum;
     
    @FXML
    private TextField User_Gender;
      
    @FXML
    private DatePicker User_BirthDate;
       
    @FXML
    private TextField User_SN;
        
    @FXML
    private TextField User_VisaCard;

    @FXML
    private TextField User_Email;

    @FXML
    private TextField User_SignUp_Name;
    
    @FXML
    private TextField User_SignUp_Pass;
    
    @FXML
    private TextField User_SignIn_Name;

    @FXML
    private PasswordField User_SignIn_Pass;

    @FXML
    private Label User_SignIn_Status;

    @FXML
    private Label User_SignUp_Status;
        
    @FXML
    private TextField Employee_Name;

    @FXML
    private PasswordField Employee_Pass;
    
    @FXML
    private Label Employee_SignIn_Status;
    
    @FXML
    void User_SignUpButtonAction(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {

        String name = User_SignUp_Name.getText();
        String pass = User_SignUp_Pass.getText();
        int phone = Integer.parseInt(User_PhoneNum.getText());
        String gender = User_Gender.getText();
        LocalDate date = User_BirthDate.getValue();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        String BirthDate = day+"/"+month+"/"+year;
        int ssn = Integer.parseInt(User_SN.getText());
        String email = User_Email.getText();
        int vc =Integer.parseInt( User_VisaCard.getText());
        
        Guest g = new Guest(pass,true,name,ssn,gender,email,vc,phone,BirthDate);
        String sql="insert into Guest (name,ssn,gender,email,VisaCardNumber,password,phone_number,birthdate) values('" + g.getname()+ "'," + g.getsecN()+ ",'" + g.getgender() + "','" + g.getEmail() + "'," +g.getVisaCardNum()+ ",'" + g.getPass() + "'," + g.getContactNum() + ",'" + g.getBirthDate() + "')";

        Connection connection = DataBaseConnector.getConnection();

        if (connection != null) {
            System.out.println("You made it, take control your database now!");

            try {
                connection.prepareStatement(sql).executeQuery();
                    User_SignUp_Status.setText("SignUp Success");
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    User_SignUp_Status.setText("SignUp Failed");
            }
        }
        else {
            System.out.println("Failed to make connection!");
        }

        FXMLLoader Loader = new FXMLLoader(getClass().getResource("Guest_GUI.fxml"));
        Parent root = (Parent) Loader.load();
        GuestController Data = Loader.getController();
        Data.passData(User_SignUp_Name.getText());
        Scene Guest_Scene = new Scene(root);
        Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        app_stage.setScene(Guest_Scene);
        app_stage.show();
    }

    @FXML
    void User_SignInButtonAction(ActionEvent event) throws IOException {

        String name = User_SignIn_Name.getText();
        String pass = User_SignIn_Pass.getText();

        try {
            Connection con = DataBaseConnector.getConnection();
            String sql = "select * from Guest where name=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User_SignIn_Status.setText("Login Success");

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("Guest_GUI.fxml"));
                Parent root = (Parent) Loader.load();
                GuestController Data = Loader.getController();
                Data.passData(User_SignIn_Name.getText());
                Scene Guest_Scene = new Scene(root);
                Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                app_stage.setScene(Guest_Scene);
                app_stage.show();
            }
            else {
                User_SignIn_Status.setText("Login Failed");
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
}

    @FXML
    void Employee_SignInButtonAction(ActionEvent event) throws IOException {

        String name = Employee_Name.getText();
        String pass = Employee_Pass.getText();

        try {
        Connection con = DataBaseConnector.getConnection();
        String sql = "select * from manager where name=? and password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Employee_SignIn_Status.setText("Login Success");
        
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Receptionist_GUI.fxml"));
            Parent root = (Parent) Loader.load();
            ReceptionistController Data = Loader.getController();
            Data.passData(Employee_Name.getText());
            Scene Guest_Scene = new Scene(root);
            Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            app_stage.setScene(Guest_Scene);
            app_stage.show();
        }
        else {
            Employee_SignIn_Status.setText("Login Failed");
        }

        } catch (ClassNotFoundException | SQLException ex) {
        }
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}