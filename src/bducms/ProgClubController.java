
package bducms;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Fahad Mahmud
 */
public class ProgClubController implements Initializable {

    @FXML
    private AnchorPane anchor2;
    @FXML
    private TableView<Notice> tableview;
    @FXML
    private TableColumn<Notice, String> tnotice;
    
    
    Connection con;
    PreparedStatement pst;
    int myIndex;
    
    
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
           pst= (PreparedStatement) con.prepareStatement("select notice from notice"); 
           ResultSet rs = pst.executeQuery(); 
           
      {
        while (rs.next())
        {
            Notice st = new Notice();
            
            
            st.setNotice(rs.getString("notice"));
            
            notices.add(st);
       }
    }
                tableview.setItems(notices);
                
                
                tnotice.setCellValueFactory(f -> f.getValue().noticeProperty());
               
                
              
 
       }
      
       catch (HeadlessException | SQLException e)
       {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
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
    private void bdupc2(ActionEvent event) throws IOException {
           new SceneSwitcher(anchor2, "Main.fxml");
           
    }

    @FXML
    private void bdupc3(ActionEvent event) throws Exception{
        new SceneSwitcher(anchor2,"exMember1.fxml");
        
        

    }

    @FXML
    private void bdupc4(ActionEvent event) throws IOException {
        new SceneSwitcher(anchor2,"ues1.fxml");
    }

    @FXML
    private void regBtn(ActionEvent event) throws IOException, InterruptedException {
        
        Thread.sleep(2000);
        new SceneSwitcher(anchor2,"pRegistration.fxml");
    }

    @FXML
    private void clsBtn(ActionEvent event) {
        System.exit(0);
    }

    
    
}


  
