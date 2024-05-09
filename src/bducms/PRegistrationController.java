
package bducms;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Fahad Mahmud
 */
public class PRegistrationController implements Initializable {

    @FXML
    private AnchorPane anchorReg;
    @FXML
    private TextField pname;
    @FXML
    private TextField pemail;
    @FXML
    private TextField pnumber;
    @FXML
    private TextField puid;
    @FXML
    private TextField pdepartment;
    @FXML
    private TextField pblood;
    @FXML
    private TextField psession;
    @FXML
    private TextField pexperience;
    @FXML
    private Button psubmit;
    @FXML
    private Button dd;
    @FXML
    private FontAwesomeIcon ddd;

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
    private void pclick(ActionEvent event) throws IOException {
        String name=pname.getText();
        String email=pemail.getText();
        String phone=pnumber.getText();
        String id=puid.getText();
        String session=psession.getText();
        String department=pdepartment.getText();
        String blood=pblood.getText();
        String experience=pexperience.getText(); 
        
        if (pname.getText().isEmpty() || pemail.getText().isEmpty() || pnumber.getText().isEmpty() || puid.getText().isEmpty() || psession.getText().isEmpty() || pdepartment.getText().isEmpty() || pblood.getText().isEmpty() || pexperience.getText().isEmpty())  {
            errorMessage("Please fill all blank fields") ;
        } 
        
       
        
        
        else {
        
        
    try {

            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/multiuser", "root", ""); 

           pst =conn.prepareStatement("insert into prog_member(name,email,phone,id,session,department,blood,experience)values(?,?,?,?,?,?,?,?)");
           pst.setString(1, name);
           pst.setString(2, email);
           pst.setString(3, phone);
           pst.setString(4, id);
           pst.setString(5, session);
           pst.setString(6, department);
           pst.setString(7, blood);
           pst.setString(8, experience); 
           
           int status =pst.executeUpdate();
           
           if(status==1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Programming Club");
 
            alert.setHeaderText("Member Registation");
            alert.setContentText("Added Successfullly");
 
            alert.showAndWait();
            
               pname.setText("");
               pemail.setText("");
               pnumber.setText("");
               puid.setText("");
               psession.setText("");
               pdepartment.setText("");
               pblood.setText("");
               pexperience.setText("");
               
               pname.requestFocus();
               
               new SceneSwitcher(anchorReg, "/bducms/paymentadmin.fxml");

           }
           else{
               JOptionPane.showMessageDialog(null, "Registration Failed");
           }
          
        
           
           
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
        }
        }
  
    }

    @FXML
    private void bckBtn(ActionEvent event) throws Exception {
        new SceneSwitcher(anchorReg, "ProgClub.fxml");
    }

    @FXML
    private void already(ActionEvent event)throws IOException,Exception {
        new SceneSwitcher(anchorReg, "/bducms/paymentadmin.fxml");
    }
    
    private Alert alert;
    
    private void errorMessage(String message) {

        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }


    
    }
        
        
    
    
    
    
    

