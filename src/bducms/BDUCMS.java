
package bducms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class BDUCMS extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("BDUCMS App");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        Thread.sleep(1500);

    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
