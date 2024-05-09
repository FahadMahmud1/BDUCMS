/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bducms;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Fahad Mahmud
 */
public class PaymentadminController implements Initializable {

    @FXML
    private TextField trx;
    @FXML
    private TextField unid;
    @FXML
    private AnchorPane payAnchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    Connection conn;
    PreparedStatement pst;


    @FXML
    private void sbmt(ActionEvent event) throws SQLException,ClassNotFoundException, IOException {
        String trxid=trx.getText();
        String uni_id=unid.getText();
        String status1 = null;
        
        
    try {

            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/multiuser", "root", ""); 

           pst =conn.prepareStatement("insert into paybdupc1(trxid,uni_id,status)values(?,?,?)");
           pst.setString(1, trxid);
           pst.setString(2, uni_id);
           pst.setString(3,"Not Yet");
           int status =pst.executeUpdate();
           
           if(status==1){
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Programming Club");
 
            alert.setHeaderText("Payment Information");
            alert.setContentText("Added Successfullly!");
 
            alert.showAndWait();
            
               trx.setText("");
               unid.setText("");
               
               trx.requestFocus();
               
               new SceneSwitcher(payAnchor, "Congo.fxml");

           }
           else{
               JOptionPane.showMessageDialog(null, "Record Failed");
           }
          
        
           
           
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
        }

       
    }

    
    
    @FXML
    private void bckBtn(ActionEvent event) throws IOException,Exception{
        new SceneSwitcher(payAnchor, "/bducms/Main.fxml");
    }
    
}
