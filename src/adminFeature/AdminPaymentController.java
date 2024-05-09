
package adminFeature;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

/**
 * FXML Controller class
 *
 * @author Fahad Mahmud
 */
public class AdminPaymentController implements Initializable {

    @FXML
    private TableView<PayBdUpc1> table21;
    @FXML
    private TableColumn<PayBdUpc1, Integer> tserial;

    @FXML
    private TableColumn<PayBdUpc1, String> id2;
    @FXML
    private TableColumn<PayBdUpc1, Integer> id1;
    
    @FXML
    private TableColumn<PayBdUpc1, String> status;

    @FXML
    private TextField search;
    @FXML
    private AnchorPane anchor23;
    @FXML
    private Button qa1;
    
    int myIndex;
    int serial1;
    
    @FXML
    private TextField fid;
    @FXML
    private TextField fstatus;
    
    private ObservableList<PayBdUpc1> data;

    private java.sql.Connection connection;

  

    private void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/multiuser";
        String username = "root";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
        }
    }

    private void loadData() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM paybdupc1");

            while (resultSet.next()) {
                int serial = resultSet.getInt("serial");
                String trxid = resultSet.getString("trxid");
                int uniId = resultSet.getInt("uni_id");
                String status = resultSet.getString("status");

                PayBdUpc1 item = new PayBdUpc1(serial, trxid, uniId, status);
                data.add(item);
            }

            table21.setItems(data);
//                tserial.setCellValueFactory(f -> f.getValue().serialProperty().asObject());
//
//                id2.setCellValueFactory(f -> f.getValue().trxidProperty());
//                id1.setCellValueFactory(f -> f.getValue().uniIdProperty().asObject());
//
//                status.setCellValueFactory(f -> f.getValue().statusProperty());
                
            
            
            
            
        } catch (SQLException e) {
        }
        
         table21.setRowFactory( tv -> {
     TableRow<PayBdUpc1> myRow = new TableRow<>();
     myRow.setOnMouseClicked (event ->
     {
        if (event.getClickCount() == 1 && (!myRow.isEmpty()))
        {
           myIndex =  table21.getSelectionModel().getSelectedIndex();
           serial1 = Integer.parseInt(String.valueOf(table21.getItems().get(myIndex).getSerial()));
           
           
           fid.setText(String.valueOf(table21.getItems().get(myIndex).getUniId()));
           fstatus.setText(table21.getItems().get(myIndex).getStatus());
          
                          
        }
     });
        return myRow;
                   });
    }

    private void searchItem(String keyword) {
        data.clear();

        if (keyword.isEmpty()) {
            loadData();
            
        } else {
            try {
                String query = "SELECT * FROM paybdupc1 WHERE uni_id LIKE ?";
                java.sql.PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, "%" + keyword + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int serial = resultSet.getInt("serial");
                    String trxid = resultSet.getString("trxid");
                    int uniId = resultSet.getInt("uni_id");
                    String status = resultSet.getString("status");

                    PayBdUpc1 item = new PayBdUpc1(serial, trxid, uniId, status);
                    data.add(item);
                }

                table21.setItems(data);
            } 
            
            catch (SQLException e) {
            }
        }
    } 



    @FXML
    private void bckBtn(ActionEvent event)throws IOException,Exception {
        new SceneSwitcher(anchor23, "/adminFeature/adminProgramming.fxml");
        
    }

    @FXML
    private void updateStatus(ActionEvent event) {
        String uni_id,status1;
        
         myIndex = table21.getSelectionModel().getSelectedIndex();
         
        serial1 = Integer.parseInt(String.valueOf(table21.getItems().get(myIndex).getSerial()));
        
            
            uni_id = fid.getText();
            status1 = fstatus.getText();
            
        try
        {
           
            String query = "update paybdupc1 set uni_id = ?,status = ? where serial = ?";
                java.sql.PreparedStatement statement = connection.prepareStatement(query);
                
            statement.setString(1, uni_id);
            statement.setString(2, status1);
           
            statement.setInt(3, serial1);
            
            statement.executeUpdate();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Payment Status");
 
            alert.setHeaderText("PAYMENT CONFIRMED");
            alert.setContentText("Updateddd!");
 
            alert.showAndWait();
            
        }
        catch (HeadlessException | SQLException e)
        {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchRecord(KeyEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data = FXCollections.observableArrayList();

        // Bind columns to model properties
        tserial.setCellValueFactory(new PropertyValueFactory<>("serial"));
        id2.setCellValueFactory(new PropertyValueFactory<>("trxid"));
        id1.setCellValueFactory(new PropertyValueFactory<>("uniId"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Connect to the MySQL database
        connectToDatabase();

        // Load initial data
        loadData();

        // Add listener to the search field
        search.textProperty().addListener((observable, oldValue, newValue) -> searchItem(newValue));
    }

  
    
    
    

        
        
        
    }
    

