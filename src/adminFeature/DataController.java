/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package adminFeature;

import bducms.Notice;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Fahad Mahmud
 */
public class DataController implements Initializable {

    @FXML
    private TextField fid;
    @FXML
    private TableView<Notice> tableview;
    @FXML
    private TableColumn<Notice, String> tid;
    @FXML
    private TableColumn<Notice, String> tnotice;
    @FXML
    private TextField fnotice;
    
        Connection con;
    PreparedStatement pst;
    int myIndex;
    @FXML
    private AnchorPane anchor;
    
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/multiuser","root","");
        } catch (ClassNotFoundException | SQLException ex) {

        }
    }
    

    
    public void table()
      {
          Connect();
          ObservableList<Notice> notices = FXCollections.observableArrayList();
       try
       {
           pst= (PreparedStatement) con.prepareStatement("select nid,notice from notice"); 
           ResultSet rs = pst.executeQuery(); 
           
      {
        while (rs.next())
        {
            Notice st = new Notice();
            
            st.setNid(rs.getString("nid"));
            st.setNotice(rs.getString("notice"));
            
            notices.add(st);
       }
    }
                tableview.setItems(notices);
                
                tid.setCellValueFactory(f -> f.getValue().nidProperty());
                tnotice.setCellValueFactory(f -> f.getValue().noticeProperty());
               
                
              
 
       }
      
       catch (HeadlessException | SQLException e)
       {

       }
       
       tableview.setRowFactory( tv -> {
     TableRow<Notice> myRow = new TableRow<>();
     myRow.setOnMouseClicked (event ->
     {
        if (event.getClickCount() == 1 && (!myRow.isEmpty()))
        {
           myIndex = tableview.getSelectionModel().getSelectedIndex();
           
           
           fid.setText(tableview.getItems().get(myIndex).getNid());
           fnotice.setText(tableview.getItems().get(myIndex).getNotice());
        
                          
                        
                          
        }
     });
        return myRow;
                   });
    
      }
    
    
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        table();

    }    

    @FXML
    private void add(ActionEvent event) {
        
                String nid,notice;
       
        
            
            nid = fid.getText();
           notice = fnotice.getText();
           
        try
        {
            pst = (PreparedStatement) con.prepareStatement("insert into notice(nid,notice)values(?,?)");
          
            pst.setString(1, nid);
            pst.setString(2, notice);
        
            pst.executeUpdate();
          
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notice");
 
            alert.setHeaderText("Notice of the Club");
            alert.setContentText("Record Addedddd!");
 
            alert.showAndWait();
 
            table();
            
          
            fid.setText("");
            fnotice.setText("");
       
            
            fid.requestFocus();
        }
        catch (HeadlessException | SQLException e)
        {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int id;

    @FXML
    private void update(ActionEvent event) {
            String nid,notice;
        
         myIndex = tableview.getSelectionModel().getSelectedIndex();
         
        id = Integer.parseInt(String.valueOf(tableview.getItems().get(myIndex).getNid()));
        
            
           
           notice = fnotice.getText();
        try
        {
            pst = (PreparedStatement) con.prepareStatement("update notice set notice = ? where nid = ? ");
            
            pst.setString(1, notice);
          
            pst.setInt(2, id);
            
            pst.executeUpdate();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notice");
 
            alert.setHeaderText("Notice of the Club");
            alert.setContentText("Updateddd!");
 
            alert.showAndWait();
            table();
            
        }
        catch (HeadlessException | SQLException e)
        {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

    @FXML
    private void delete(ActionEvent event) {
        myIndex = tableview.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(tableview.getItems().get(myIndex).getNid()));
                    
 
        try
        {
            pst = (PreparedStatement) con.prepareStatement("delete from notice where nid = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notice");
 
            alert.setHeaderText("Notice of the Club");
            alert.setContentText("Deletedd!");
 
            alert.showAndWait();
            table();
            
        }
        catch (HeadlessException | SQLException e)
        {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        new SceneSwitcher(anchor, "/adminFeature/adminProgramming.fxml");
    }

    
    
}
