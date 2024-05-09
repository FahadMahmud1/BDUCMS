
package multuseraccount;

import bducms.BDUCMS;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class SceneSwitcher {
    public SceneSwitcher(AnchorPane currentAnchorPane, String fxml) throws IOException {
        if (currentAnchorPane == null) {
            throw new IllegalArgumentException("currentAnchorPane cannot be null");
        }

        if (fxml == null) {
            throw new IllegalArgumentException("fxml path cannot be null");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(BDUCMS.class.getResource(fxml));
        AnchorPane nextAnchorPane = fxmlLoader.load();

        currentAnchorPane.getChildren().removeAll();

        currentAnchorPane.getChildren().setAll(nextAnchorPane);
    }
}






