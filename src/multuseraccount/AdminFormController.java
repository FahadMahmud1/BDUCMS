/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package multuseraccount;




import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Fahad Mahmud
 */
public class AdminFormController implements Initializable {

    @FXML
    private AnchorPane adminscene;
    @FXML
    private Button ja1;
    @FXML
    private Button robo;
    @FXML
    private Button sp;
    @FXML
    private Button lang;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void btnBck(ActionEvent event)throws IOException {

        System.exit(0);
        
    }

    @FXML
    private void adminP(ActionEvent event) throws IOException,Exception {

            new SceneSwitcher(adminscene, "/adminFeature/adminProgramming.fxml");

    }

    @FXML
    private void robotics(ActionEvent event) {
    }

    @FXML
    private void sports(ActionEvent event) {
    }

    @FXML
    private void language(ActionEvent event) {
    }




    
    
}
