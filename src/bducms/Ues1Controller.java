
package bducms;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Fahad Mahmud
 */
public class Ues1Controller implements Initializable {

    @FXML
    private AnchorPane anchor5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBck(ActionEvent event) throws IOException {
        new SceneSwitcher(anchor5,"ProgClub.fxml");
    }

    @FXML
    private void event1(ActionEvent event) throws URISyntaxException,IOException {
        System.out.println("Link Clicked");
        Desktop.getDesktop().browse(new URI("https://forms.gle/tUDwgA75hNbKAbWW7"));
    }

    @FXML
    private void event2(ActionEvent event) throws URISyntaxException,IOException {
        
        System.out.println("Link Clicked");
        Desktop.getDesktop().browse(new URI("https://forms.gle/tUDwgA75hNbKAbWW7"));
    }
    
}
