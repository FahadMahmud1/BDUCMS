
package bducms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;


public class ExMember1Controller implements Initializable {

    @FXML
    private AnchorPane anchor3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void bckBtn(ActionEvent event) throws IOException{
        new SceneSwitcher(anchor3,"ProgClub.fxml");
    }
    
}
