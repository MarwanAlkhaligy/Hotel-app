package hotel;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GuestController implements Initializable {

    String GuestName;
    String GuestSN;
 
    @FXML
    private Label Guest_Name;

    @FXML
    private Label Guest_Email;

    @FXML
    private Label Guest_Gender;
    
    @FXML
    private Label Guest_PhoneNumber;

    @FXML
    private Label Guest_VisaCard;
    
    @FXML
    private Label Guest_BirthDate;
    
    @FXML
    private Label Guest_SN;

    @FXML
    private Label Selection_Status;
        
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
    private TableColumn<?, ?> Room_ID_Reserved_Table;
    
    @FXML
    private TableColumn<?, ?> Room_Number_of_Bed_Reserved_Table;
    
    @FXML
    private TableColumn<?, ?> Room_Description_Reserved_Table;
    
    @FXML
    private TableColumn<?, ?> Room_Reservation_Time_Reserved_Table;
    
    @FXML
    private TableView<roomReserved> Room_CheckOut_Table;
    
    @FXML
    private TableColumn<?, ?> Room_ID_CheckOut_Table;
    
    @FXML
    private TableColumn<?, ?> Room_Number_of_Bed_CheckOut_Table;
    
    @FXML
    private TableColumn<?, ?> Room_Description_CheckOut_Table;
    
    @FXML
    private TableColumn<?, ?> Room_Reservation_Time_CheckOut_Table;
    
    ObservableList<room> roomList = FXCollections.observableArrayList();
    ObservableList<room> roomBookList = FXCollections.observableArrayList();
    ObservableList<roomReserved> RoomReservedTable = FXCollections.observableArrayList();
    String DateTimeNow = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(Calendar.getInstance().getTime());
    
    public void passData(String GuestName){
        
        this.GuestName = GuestName;
        
        try {

            Connection con = DataBaseConnector.getConnection();
            String sql = "select * from Guest where name=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, GuestName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Guest_Name.setText(rs.getString("name"));
                Guest_Email.setText(rs.getString("email"));
                Guest_Gender.setText(rs.getString("gender"));
                Guest_PhoneNumber.setText(rs.getString("phone_number"));
                Guest_VisaCard.setText(rs.getString("visacardnumber"));
                Guest_BirthDate.setText(rs.getString("birthdate"));
                Guest_SN.setText(rs.getString("ssn"));
                GuestSN = rs.getString("ssn");
            }
            
            Room_Table_Show();
            Room_Reserved_Table_Show();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GuestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        Room_Reserved_Table.getItems().clear();

        String sql = "select * from reserved_rooms where Guest_ssn = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, GuestSN);
        ResultSet RR = ps.executeQuery();

        while (RR.next()) {
            RoomReservedTable.add(new roomReserved(RR.getString("Guest_SSN"), RR.getInt("Room_id"), RR.getString("Room_Description"), RR.getInt("Number_of_Bed"),RR.getString("Reservation_Time")));
        }

        Room_ID_Reserved_Table.setCellValueFactory(new PropertyValueFactory("Room_id"));
        Room_Number_of_Bed_Reserved_Table.setCellValueFactory(new PropertyValueFactory("numOfBed"));
        Room_Description_Reserved_Table.setCellValueFactory(new PropertyValueFactory("roomDescription"));
        Room_Reservation_Time_Reserved_Table.setCellValueFactory(new PropertyValueFactory("Reservation_Time"));
        Room_Reserved_Table.setItems(RoomReservedTable);

        Room_Reserved_Table.getSelectionModel().clearSelection();
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
        if(Room_Book_Table.getItems().isEmpty() == false){
            String GuestBookSN = Guest_SN.getText();
            
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

            Room_Table.getSelectionModel().clearSelection();
            Room_Book_Table.getSelectionModel().clearSelection();
            Room_Reserved_Table.getSelectionModel().clearSelection();
            Room_Book_Table.getItems().clear();
            Selection_Status.setText("");
            Room_Table_Show();
            Room_Reserved_Table_Show();
            
        }
        else {
            Selection_Status.setText("Please Select Room");
        }
    }
    
    @FXML
    public void CancelRoomButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException{
        if(Room_Reserved_Table.getSelectionModel().getSelectedItem() != null){
            roomReserved selection = Room_Reserved_Table.getSelectionModel().getSelectedItem();

            Connection con = DataBaseConnector.getConnection();
            String sql = "insert into Room (Room_Id ,Number_of_Bed,Room_Description ) VALUES (?,?,?)" ;
            String Del= "DELETE FROM reserved_rooms WHERE ROOM_ID = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement Ps_Del = con.prepareStatement(Del);
            ps.setString(1, String.valueOf(Room_Reserved_Table.getItems().get(0).getRoom_id()));
            ps.setString(2, String.valueOf(Room_Reserved_Table.getItems().get(0).getNumOfBed()));
            ps.setString(3, String.valueOf(Room_Reserved_Table.getItems().get(0).getRoomDescription()));
            Ps_Del.setString(1, String.valueOf(Room_Reserved_Table.getItems().get(0).getRoom_id()));
            ps.execute();
            Ps_Del.execute();
            
            Room_Table.getItems().add(new room(selection.getRoom_id(), selection.getRoomDescription(), selection.getNumOfBed()));

            Room_ID_Table.setCellValueFactory(new PropertyValueFactory("Room_id"));
            Room_Number_of_Bed_Table.setCellValueFactory(new PropertyValueFactory("numOfBed"));
            Room_Description_Table.setCellValueFactory(new PropertyValueFactory("roomDescription"));

            Room_Reserved_Table.getItems().remove(selection);
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
    public void AddRoomCheckOutButtonAction(ActionEvent event){
        if(Room_Reserved_Table.getSelectionModel().getSelectedItem() != null){
            roomReserved selection = Room_Reserved_Table.getSelectionModel().getSelectedItem();
            Room_CheckOut_Table.getItems().add(new roomReserved(selection.getGuest_SSN(),selection.getRoom_id(), selection.getRoomDescription(), selection.getNumOfBed(),selection.getReservation_Time()));
            Room_ID_CheckOut_Table.setCellValueFactory(new PropertyValueFactory("Room_id"));
            Room_Number_of_Bed_CheckOut_Table.setCellValueFactory(new PropertyValueFactory("numOfBed"));
            Room_Description_CheckOut_Table.setCellValueFactory(new PropertyValueFactory("roomDescription"));
            Room_Reservation_Time_CheckOut_Table.setCellValueFactory(new PropertyValueFactory("Reservation_Time"));
            Room_Reserved_Table.getItems().remove(selection);
            Room_Table.getSelectionModel().clearSelection();
            Room_CheckOut_Table.getSelectionModel().clearSelection();
            Room_Reserved_Table.getSelectionModel().clearSelection();
            Selection_Status.setText("");
        }
        else {
            Selection_Status.setText("Please Select Room");
        }
    }

    @FXML
    public void RemoveRoomCheckOutButtonAction(ActionEvent event){
        if(Room_CheckOut_Table.getSelectionModel().getSelectedItem() != null){
            roomReserved selection = Room_CheckOut_Table.getSelectionModel().getSelectedItem();
            Room_Reserved_Table.getItems().add(new roomReserved(selection.getGuest_SSN(),selection.getRoom_id(), selection.getRoomDescription(), selection.getNumOfBed(),selection.getReservation_Time()));
            Room_ID_Reserved_Table.setCellValueFactory(new PropertyValueFactory("Room_id"));
            Room_Number_of_Bed_Reserved_Table.setCellValueFactory(new PropertyValueFactory("numOfBed"));
            Room_Description_Reserved_Table.setCellValueFactory(new PropertyValueFactory("roomDescription"));
            Room_Reservation_Time_Reserved_Table.setCellValueFactory(new PropertyValueFactory("Reservation_Time"));
            Room_CheckOut_Table.getItems().remove(selection);
            
            Room_Table.getSelectionModel().clearSelection();
            Room_CheckOut_Table.getSelectionModel().clearSelection();
            Room_Reserved_Table.getSelectionModel().clearSelection();
            Selection_Status.setText("");
        }
        else {
            Selection_Status.setText("Please Select Room");
        }
    }
    
    @FXML
    public void CheckOutButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException, IOException{
        Connection con = DataBaseConnector.getConnection();
        
        if(Room_CheckOut_Table.getItems().isEmpty() == false){
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("CheckOut_GUI.fxml"));
            Parent root = (Parent) Loader.load();
            CheckOutController Data = Loader.getController();

            for(int i=0; i<Room_CheckOut_Table.getItems().size(); i++){
                Data.PassData(String.valueOf(Room_CheckOut_Table.getItems().get(i).getRoom_id()),GuestName);
            }
            
            Scene CheckOut_Scene = new Scene(root);
            Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            app_stage.setScene(CheckOut_Scene);
            app_stage.show();
            
            Room_Table.getSelectionModel().clearSelection();
            Room_Book_Table.getSelectionModel().clearSelection();
            Room_Reserved_Table.getSelectionModel().clearSelection();
            Room_CheckOut_Table.getItems().clear();
            Room_Book_Table.getItems().clear();
            Selection_Status.setText("");
            Room_Table_Show();
            Room_Reserved_Table_Show();
        }
        else {
            Selection_Status.setText("Please Select Room");
        }
    }
    
    @FXML
    public void RefreshButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException{
        Room_Table_Show();
        Room_Reserved_Table_Show();
        Room_Book_Table.getItems().clear();
        Room_CheckOut_Table.getItems().clear();
        Selection_Status.setText("");
    }
}