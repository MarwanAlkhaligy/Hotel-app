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

public class CheckOutController implements Initializable {
    
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
    
    @FXML
    private TableColumn<?, ?> Room_End_Time_CheckOut_Table1;
    
    @FXML
    private Label CheckOutCost;
    
    ObservableList<roomReserved> RoomCheckOutTable = FXCollections.observableArrayList();
    String Guest_Name;
    String Room_ID ;
    int TotalCost = 0;
    String DateTimeNow = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(Calendar.getInstance().getTime());
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public void PassData(String Room_ID, String GueStName) throws ClassNotFoundException, SQLException{
        this.Guest_Name = GueStName;
        this.Room_ID = Room_ID;
        
        Connection con = DataBaseConnector.getConnection();
        String sql = "select * from reserved_rooms WHERE Room_id = ? ";
        PreparedStatement RR = con.prepareStatement(sql);
        RR.setString(1, Room_ID);
        ResultSet rs = RR.executeQuery();
        while (rs.next()) {
            RoomCheckOutTable.add(new roomReserved(rs.getString("Guest_SSN"), rs.getInt("Room_id"), rs.getString("Room_Description"), rs.getInt("Number_of_Bed"),rs.getString("Reservation_Time")));
            TotalCost += rs.getInt("Number_of_Bed")*500;
        }

        CheckOutCost.setText(Integer.toString(TotalCost));

        Room_ID_CheckOut_Table.setCellValueFactory(new PropertyValueFactory("Room_id"));
        Room_Number_of_Bed_CheckOut_Table.setCellValueFactory(new PropertyValueFactory("numOfBed"));
        Room_Description_CheckOut_Table.setCellValueFactory(new PropertyValueFactory("roomDescription"));
        Room_Reservation_Time_CheckOut_Table.setCellValueFactory(new PropertyValueFactory("Reservation_Time"));
        Room_CheckOut_Table.setItems(RoomCheckOutTable);
        Room_CheckOut_Table.getSelectionModel().clearSelection();
    }
    
    @FXML
    public void CheckOutButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException, IOException{
        Connection con = DataBaseConnector.getConnection();

        String sql = "INSERT INTO room (ROOM_ID, NUMBER_OF_BED,ROOM_DESCRIPTION) VALUES (?,?,?)" ;
        String Del= "DELETE FROM reserved_rooms WHERE ROOM_ID = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        PreparedStatement Ps_Del = con.prepareStatement(Del);

        for(int i=0; i<Room_CheckOut_Table.getItems().size(); i++){
            ps.setString(1, String.valueOf(Room_CheckOut_Table.getItems().get(i).getRoom_id()));
            ps.setString(2, String.valueOf(Room_CheckOut_Table.getItems().get(i).getNumOfBed()));
            ps.setString(3, String.valueOf(Room_CheckOut_Table.getItems().get(i).getRoomDescription()));
            Ps_Del.setString(1, String.valueOf(Room_CheckOut_Table.getItems().get(i).getRoom_id()));
            ps.execute();
            Ps_Del.execute();
        }

        FXMLLoader Loader = new FXMLLoader(getClass().getResource("Guest_GUI.fxml"));
        Parent root = (Parent) Loader.load();
        GuestController Data = Loader.getController();
        Data.passData(Guest_Name);

        Scene Guest_Scene = new Scene(root);
        Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        app_stage.setScene(Guest_Scene);
        app_stage.show();
    }
}