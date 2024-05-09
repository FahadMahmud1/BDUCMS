
package bducms;


import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import java.util.Objects;

public class SceneSwitcher {
    public SceneSwitcher(AnchorPane currentAnchorPane, String fxml) throws IOException {

        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(BDUCMS.class.getResource(fxml))); 
        
        currentAnchorPane.getChildren().removeAll();

        currentAnchorPane.getChildren().setAll(nextAnchorPane);
}

}




