
package adminFeature;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fahad Mahmud
 */
public class AdminProgrammingController implements Initializable {

    @FXML
    private AnchorPane adminProg;
    @FXML
    private Button upinfo;
    @FXML
    private Button payment;
    @FXML
    private Button back;
    @FXML
    private Button cls;
    @FXML
    private Button clubs;
    private Object SceneSwitcher;
    @FXML
    private Button updateNotice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateInfo(ActionEvent event)throws IOException,Exception{
        new SceneSwitcher(adminProg, "/adminFeature/infoadmin.fxml");
       
        // Create a new Stage
        Stage largerStage = new Stage();

        // Set the size of the new Stage
        largerStage.setWidth(1045); // Set the desired width
        largerStage.setHeight(549); // Set the desired height

        
 
        
    }

    @FXML
    private void clubInfo(ActionEvent event) throws IOException {
        new SceneSwitcher(adminProg, "/bducms/clubinfo.fxml");
    }

    @FXML
    private void payInfo(ActionEvent event) throws IOException,Exception {
        new SceneSwitcher(adminProg, "/adminFeature/adminPayment.fxml");
    }

    @FXML
    private void bckBtn(ActionEvent event) throws IOException,Exception {
     
        new SceneSwitcher(adminProg,"/multuseraccount/AdminForm.fxml");
    
    }

    @FXML
    private void clsBtn(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void noticeUpdate(ActionEvent event) throws IOException {
        new SceneSwitcher(adminProg, "/adminFeature/data.fxml");
    }
    
}
