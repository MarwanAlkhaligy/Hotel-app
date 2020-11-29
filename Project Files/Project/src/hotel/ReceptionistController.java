package hotel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ReceptionistController implements Initializable {
    
    String EmployeeName;
    
    @FXML
    private AnchorPane Employee_GUI;
    
    @FXML
    private Label Employee_Name;
    
    @FXML
    private Label Employee_Email;
    
    @FXML
    private Label Employee_Gender;
    
    @FXML
    private Label Employee_SN;
    
    @FXML
    private Label Employee_ID;
    
    @FXML
    private Label Employee_BirthDate;
    
    @FXML
    private Label Employee_Salary;
        
    @FXML
    private Label Employee_ShiftTime;

    @FXML
    private Label Guest_Book_Name;
        
    @FXML
    private Label Guest_Book_SN;
    
    @FXML
    private Label Selection_Status;
    
    @FXML
    private TableView<GuestTable> Guest_Table;
    
    @FXML
    private TableColumn<?,?> Guest_Name_Table;
        
    @FXML
    private TableColumn<?,?> Guest_Pass_Table;
    
    @FXML
    private TableColumn<?,?> Guest_SN_Table;
    
    @FXML
    private TableColumn<?,?> Guest_Gender_Table;

    @FXML
    private TableColumn<?,?> Guest_Email_Table;

    @FXML
    private TableColumn<?,?> Guest_BirthDate;

    @FXML
    private TableView<room> Room_Table;
        
    @FXML
    private TableColumn<?,?> Room_ID_Table;
        
    @FXML
    private TableColumn<?,?> Room_Number_of_Bed_Table;
    
    @FXML
    private TableColumn<?,?> Room_Description_Table;
    
    @FXML
    private TableView<room> Room_Book_Table;

    @FXML
    private TableColumn<?, ?> Room_ID_Book_Table;
    
    @FXML
    private TableColumn<?, ?> Room_Number_of_Bed_Book_Table;
    
    @FXML
    private TableColumn<?, ?> Room_Description_Book_Table;

    @FXML
    private TableView<roomReserved> Room_Reserved_Table;

    @FXML
    private TableColumn<?, ?> Room_Guest_SN_Reserved_Table;
    
    @FXML
    private TableColumn<?, ?> Room_ID_Reserved_Table;
    
    @FXML
    private TableColumn<?, ?> Room_Number_of_Bed_Reserved_Table;
    
    @FXML
    private TableColumn<?, ?> Room_Description_Reserved_Table;
    
    @FXML
    private TableColumn<?, ?> Room_Reservation_Time_Reserved_Table;
    
    ObservableList<GuestTable> obList = FXCollections.observableArrayList();
    ObservableList<room> roomList = FXCollections.observableArrayList();
    ObservableList<room> roomBookList = FXCollections.observableArrayList();
    ObservableList<roomReserved> RoomReservedTable = FXCollections.observableArrayList();
    String DateTimeNow = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(Calendar.getInstance().getTime());
    
    public void passData(String EmployeeName){

        this.EmployeeName = EmployeeName;
        
        try {
            Connection con = DataBaseConnector.getConnection();
            
            String sql = "select * from manager where name=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, EmployeeName);
            ResultSet emp = ps.executeQuery();
            
            while (emp.next()) {
                Employee_Name.setText(emp.getString("name"));
                Employee_Email.setText(emp.getString("email"));
                Employee_Gender.setText(emp.getString("gender"));
                Employee_SN.setText(emp.getString("ssn"));
                Employee_ID.setText(emp.getString("work_id"));
                Employee_BirthDate.setText(emp.getString("birthdate"));
                Employee_Salary.setText(emp.getString("salary"));
            }
            Guest_Table_Show();
            Room_Table_Show();
            Room_Reserved_Table_Show();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReceptionistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    public void Guest_Table_Show() throws ClassNotFoundException, SQLException{
        Connection con = DataBaseConnector.getConnection();
        ResultSet rs = con.createStatement().executeQuery("select * from Guest");
        Guest_Table.getItems().clear();
        while (rs.next()) {
            obList.add(new GuestTable(rs.getString("name"),rs.getString("password"),rs.getLong("ssn"),rs.getString("gender"),rs.getString("Email"),rs.getString("birthdate")));
        }
        
        Guest_Name_Table.setCellValueFactory(new PropertyValueFactory("name"));
        Guest_Pass_Table.setCellValueFactory(new PropertyValueFactory("pass"));
        Guest_SN_Table.setCellValueFactory(new PropertyValueFactory("secN"));
        Guest_Gender_Table.setCellValueFactory(new PropertyValueFactory("gender"));
        Guest_Email_Table.setCellValueFactory(new PropertyValueFactory("Email"));
        Guest_BirthDate.setCellValueFactory(new PropertyValueFactory("birthDate"));
        Guest_Table.setItems(obList);
        
        Guest_Table.getSelectionModel().clearSelection();
    }
    
    public void Room_Table_Show() throws ClassNotFoundException, SQLException{
        Connection con = DataBaseConnector.getConnection();
        ResultSet room = con.createStatement().executeQuery("select * from room");
        Room_Table.getItems().clear();
        while (room.next()) {
            roomList.add(new room(room.getInt("Room_id"), room.getString("Room_Description"), room.getInt("Number_of_Bed")));
        }

        Room_ID_Table.setCellValueFactory(new PropertyValueFactory("Room_id"));
        Room_Number_of_Bed_Table.setCellValueFactory(new PropertyValueFactory("numOfBed"));
        Room_Description_Table.setCellValueFactory(new PropertyValueFactory("roomDescription"));
        Room_Table.setItems(roomList);
        
        Room_Table.getSelectionModel().clearSelection();
    }
    
    public void Room_Reserved_Table_Show() throws ClassNotFoundException, SQLException{
        Connection con = DataBaseConnector.getConnection();
        ResultSet RR = con.createStatement().executeQuery("select * from reserved_rooms");
        Room_Reserved_Table.getItems().clear();
        while (RR.next()) {
            RoomReservedTable.add(new roomReserved(RR.getString("Guest_SSN"), RR.getInt("Room_id"), RR.getString("Room_Description"), RR.getInt("Number_of_Bed"),RR.getString("Reservation_Time")));
        }
        
        Room_Guest_SN_Reserved_Table.setCellValueFactory(new PropertyValueFactory("Guest_SSN"));
        Room_ID_Reserved_Table.setCellValueFactory(new PropertyValueFactory("Room_id"));
        Room_Number_of_Bed_Reserved_Table.setCellValueFactory(new PropertyValueFactory("numOfBed"));
        Room_Description_Reserved_Table.setCellValueFactory(new PropertyValueFactory("roomDescription"));
        Room_Reservation_Time_Reserved_Table.setCellValueFactory(new PropertyValueFactory("Reservation_Time"));
        Room_Reserved_Table.setItems(RoomReservedTable);
        
        Room_Reserved_Table.getSelectionModel().clearSelection();
    }

    @FXML
    void SelectGuestButtonAction(ActionEvent event){
        if(Guest_Table.getSelectionModel().getSelectedItem() != null){
        Guest_Book_Name.setText(Guest_Table.getSelectionModel().getSelectedItems().get(0).getName());
        Guest_Book_SN.setText(String.valueOf(Guest_Table.getSelectionModel().getSelectedItems().get(0).getSecN()));

        Guest_Table.getSelectionModel().clearSelection();
        Room_Table.getSelectionModel().clearSelection();
        Selection_Status.setText("");
        }
        else {
            Selection_Status.setText("Please Select Guest");
        }
    }
    @FXML
    void AddRoomButtonAction(ActionEvent event){
        if(Room_Table.getSelectionModel().getSelectedItem() != null){
            room selection = Room_Table.getSelectionModel().getSelectedItem();
            Room_Book_Table.getItems().add(new room(selection.getRoom_id(), selection.getRoomDescription(), selection.getNumOfBed()));

            Room_ID_Book_Table.setCellValueFactory(new PropertyValueFactory("Room_id"));
            Room_Number_of_Bed_Book_Table.setCellValueFactory(new PropertyValueFactory("numOfBed"));
            Room_Description_Book_Table.setCellValueFactory(new PropertyValueFactory("roomDescription"));

            Room_Table.getItems().remove(selection);
            Guest_Table.getSelectionModel().clearSelection();
            Room_Table.getSelectionModel().clearSelection();
            Room_Reserved_Table.getSelectionModel().clearSelection();
            Selection_Status.setText("");
        }
        else {
            Selection_Status.setText("Please Select Room");
        }
    }
    
    @FXML
    void RemoveRoomButtonAction(ActionEvent event){
        if(Room_Book_Table.getSelectionModel().getSelectedItem() != null){
            room selection = Room_Book_Table.getSelectionModel().getSelectedItem();
            Room_Table.getItems().add(new room(selection.getRoom_id(), selection.getRoomDescription(), selection.getNumOfBed()));

            Room_ID_Table.setCellValueFactory(new PropertyValueFactory("Room_id"));
            Room_Number_of_Bed_Table.setCellValueFactory(new PropertyValueFactory("numOfBed"));
            Room_Description_Table.setCellValueFactory(new PropertyValueFactory("roomDescription"));

            Room_Book_Table.getItems().remove(selection);
            Guest_Table.getSelectionModel().clearSelection();
            Room_Table.getSelectionModel().clearSelection();
            Room_Book_Table.getSelectionModel().clearSelection();
            Room_Reserved_Table.getSelectionModel().clearSelection();
            Selection_Status.setText("");
        }
        else {
            Selection_Status.setText("Please Select Room");
        }
    }
    
    @FXML
    void BookRoomButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException{
        if(Room_Book_Table.getItems().isEmpty() == false && Guest_Book_Name.getText() != ""){
            String GuestBookSN = Guest_Book_SN.getText();
            
            Connection con = DataBaseConnector.getConnection();
            String sql = "INSERT INTO reserved_rooms (GUEST_SSN, ROOM_ID, NUMBER_OF_BED,ROOM_DESCRIPTION,RESERVATION_TIME) VALUES ( "+ GuestBookSN +" ,?,?,?,?)" ;
            String Del= "DELETE FROM ROOM WHERE ROOM_ID = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement Ps_Del = con.prepareStatement(Del);

            for(int i=0; i<Room_Book_Table.getItems().size(); i++){
                 ps.setString(1, String.valueOf(Room_Book_Table.getItems().get(i).getRoom_id()));
                 ps.setString(2, String.valueOf(Room_Book_Table.getItems().get(i).getNumOfBed()));
                 ps.setString(3, String.valueOf(Room_Book_Table.getItems().get(i).getRoomDescription()));
                 ps.setString(4, String.valueOf(DateTimeNow));
                 Ps_Del.setString(1, String.valueOf(Room_Book_Table.getItems().get(i).getRoom_id()));
                 ps.execute();
                 Ps_Del.execute();
            }

            Guest_Table.getSelectionModel().clearSelection();
            Room_Table.getSelectionModel().clearSelection();
            Room_Book_Table.getSelectionModel().clearSelection();
            Room_Reserved_Table.getSelectionModel().clearSelection();
            Room_Book_Table.getItems().clear();
            Guest_Book_Name.setText("");
            Guest_Book_SN.setText("");
            Selection_Status.setText("");
            Room_Table_Show();
            Room_Reserved_Table_Show();
            
        }
        else {
            Selection_Status.setText("Please Choose Guest & Room");
        }
    }
    
    @FXML
    public void RefreshButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException{
        Room_Table_Show();
        Room_Reserved_Table_Show();
        Room_Book_Table.getItems().clear();
        Guest_Book_Name.setText("");
        Guest_Book_SN.setText("");
        Selection_Status.setText("");
    }
}