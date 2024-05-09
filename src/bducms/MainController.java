
package bducms;
import bducms.SceneSwitcher;
import java.io.IOException;
import javafx.application.Application;
import java.net.URL;
import java.util.ResourceBundle;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author Fahad Mahmud
 */
public class MainController implements Initializable {
    
    private Label label;
    

    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void lgout(ActionEvent event) {
        
        System.exit(0);
    }
    
    @FXML
    private AnchorPane scene1Anchor;
    

    @FXML
    private void bdupc1(ActionEvent event) throws IOException  {
        
        new SceneSwitcher(scene1Anchor, "ProgClub.fxml");
         

    }

 
    
    
    
    

    
    
}



    
