/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bducms;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

        
        
public class ClubinfoController implements Initializable {

    @FXML
    private AnchorPane anchorflow;
    
    PreparedStatement pst;
    
    Connection con;
    @FXML
    private Text rowCountLabel;
    @FXML
    private PieChart pieChart;
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/multiuser","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            
        }
        
    }
    
    
    public class DatabaseUtils {
    public static int countRows() throws SQLException {
        int rowCount = 0;
        String query = "SELECT COUNT(*) AS row_count FROM prog_member";

            try ( Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/multiuser","root","");
                    PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    rowCount = resultSet.getInt("row_count");
                }
            }

            return rowCount;
        }
    }
    
    
    private void populatePieChart() {
        try {
            
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/multiuser","root","");

            
            Statement statement = con.createStatement();

           
            String registeredStudentsQuery = "SELECT COUNT(*) AS registeredStudents FROM prog_member";
            ResultSet registeredStudentsResult = statement.executeQuery(registeredStudentsQuery);

            
            int registeredStudents = 1;
            if (registeredStudentsResult.next()) {
                registeredStudents = registeredStudentsResult.getInt("registeredStudents");
            }

            
            registeredStudentsResult.close();
            statement.close();
            con.close();

            
            PieChart.Data totalStudentsData = new PieChart.Data("Participation", 100);
            PieChart.Data registeredStudentsData = new PieChart.Data("Registered Students", registeredStudents);

            
            pieChart.getData().addAll(totalStudentsData, registeredStudentsData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Connect();
        populatePieChart();
        
        try {
            int rowCount = DatabaseUtils.countRows();
            rowCountLabel.setText(String.valueOf(rowCount));
        } catch (SQLException e) {
            // Handle the exception as per your application's requirements
            
        }
    }    

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void left(ActionEvent event) throws IOException,Exception {
        new SceneSwitcher(anchorflow, "/adminFeature/adminProgramming.fxml");
    }
    
}
