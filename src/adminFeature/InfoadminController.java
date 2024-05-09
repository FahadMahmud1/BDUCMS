/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package adminFeature;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.io.File;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import javafx.stage.Window;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.FileChooser;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * FXML Controller class
 *
 * @author Fahad Mahmud
 */
public class InfoadminController implements Initializable {

    @FXML
    private TableView<Student> tabledata1;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> email;
    @FXML
    private TableColumn<Student, String> pnumber;
    @FXML
    private TableColumn<Student, String> iduni;
    @FXML
    private TableColumn<Student, String> department;
    @FXML
    private TableColumn<Student, String> session;
    @FXML
    private TableColumn<Student, String> bgroup;
    @FXML
    private TableColumn<Student, String> prevexp;
    @FXML
    private TableColumn<Student, String> tserial;
    @FXML
    private TextField inpname;
    @FXML
    private TextField inpemail;
    @FXML
    private TextField inpnumber;
    @FXML
    private TextField inpdep;
    @FXML
    private TextField inpsession;
    @FXML
    private TextField inpbgroup;
    @FXML
    private TextField inpid;
    @FXML
    private TextField inpprevexp;
    @FXML
    private AnchorPane infoAnchor;
    @FXML
    private Button insert;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Button back;
    
    Connection con;
    PreparedStatement pst;
    int myIndex;
    int serial;
    @FXML
    private Button clsbtn;

    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/multiuser","root","");
        } catch (ClassNotFoundException | SQLException ex) {

        }
    }
    
    
    public void table()
      {
          Connect();
          ObservableList<Student> students = FXCollections.observableArrayList();
       try
       {
           pst = (PreparedStatement) con.prepareStatement("select serial,name,email,phone,id,session,department,blood,experience from prog_member");  
           ResultSet rs = pst.executeQuery();
      {
        while (rs.next())
        {
            Student st = new Student();
            
            st.setSerial(rs.getString("serial"));
            st.setName(rs.getString("name"));
            st.setEmail(rs.getString("email"));
            st.setPhone(rs.getString("phone"));
            st.setId(rs.getString("id"));
            st.setSession(rs.getString("session"));
            st.setDepartment(rs.getString("department"));
            st.setBlood(rs.getString("blood"));
            st.setExperience(rs.getString("experience"));
            
            
            
            
            
            students.add(st);
       }
    }
                tabledata1.setItems(students);
                
                tserial.setCellValueFactory(f -> f.getValue().serialProperty());
                name.setCellValueFactory(f -> f.getValue().nameProperty());
                email.setCellValueFactory(f -> f.getValue().emailProperty());
                pnumber.setCellValueFactory(f -> f.getValue().phoneProperty());
                iduni.setCellValueFactory(f -> f.getValue().idProperty());
                session.setCellValueFactory(f -> f.getValue().sessionProperty());
                department.setCellValueFactory(f -> f.getValue().departmentProperty());
                bgroup.setCellValueFactory(f -> f.getValue().bloodProperty());
                prevexp.setCellValueFactory(f -> f.getValue().experienceProperty());
                
                
                
                
       }
      
       catch (HeadlessException | SQLException e)
       {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
 
                tabledata1.setRowFactory( tv -> {
     TableRow<Student> myRow = new TableRow<>();
     myRow.setOnMouseClicked (event ->
     {
        if (event.getClickCount() == 1 && (!myRow.isEmpty()))
        {
           myIndex =  tabledata1.getSelectionModel().getSelectedIndex();
           serial = Integer.parseInt(String.valueOf(tabledata1.getItems().get(myIndex).getSerial()));
           
           
           inpname.setText(tabledata1.getItems().get(myIndex).getName());
           inpemail.setText(tabledata1.getItems().get(myIndex).getEmail());
           inpnumber.setText(tabledata1.getItems().get(myIndex).getPhone());
           inpid.setText(tabledata1.getItems().get(myIndex).getId());
           inpsession.setText(tabledata1.getItems().get(myIndex).getSession());
           inpdep.setText(tabledata1.getItems().get(myIndex).getDepartment());
           inpbgroup.setText(tabledata1.getItems().get(myIndex).getBlood());
           inpprevexp.setText(tabledata1.getItems().get(myIndex).getExperience());
           
                          
                        
                          
        }
     });
        return myRow;
                   });
    
    
      }
    
    
    
    
    
    
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        table();
        
    }    

    @FXML
    private void progInsert(ActionEvent event) {
        
        
        String name,email,phone,id,session,department,blood,experience;
       
        
//          
            name = inpname.getText();
            email = inpemail.getText();
            phone = inpnumber.getText();
            id = inpid.getText();
            session = inpsession.getText();
            department = inpdep.getText();
            blood = inpbgroup.getText();
            experience = inpprevexp.getText();
            
        try
        {
            pst = (PreparedStatement) con.prepareStatement("insert into prog_member(name,email,phone,id,session,department,blood,experience)values(?,?,?,?,?,?,?,?)");
//            pst.setString(1, id);

            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, phone);
            pst.setString(4, id);
            pst.setString(5, session);
            pst.setString(6, department);
            pst.setString(7, blood);
            pst.setString(8, experience);
            
            pst.executeUpdate();
          
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registation");
 
            alert.setHeaderText("Student Registation");
            alert.setContentText("Record Addedddd!");
 
            alert.showAndWait();
 
            table();
            
//            tid.setText(name);
            inpname.setText("");
            inpemail.setText("");
            inpnumber.setText("");
            inpid.setText("");
            inpsession.setText("");
            inpdep.setText("");
            inpbgroup.setText("");
            inpprevexp.setText("");
            inpname.requestFocus();
        }
        catch (HeadlessException | SQLException e)
        {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        

        
    }

    @FXML
    private void progUpdate(ActionEvent event) {
        
        String name,email,phone,id,session,department,blood,experience;
        
         myIndex = tabledata1.getSelectionModel().getSelectedIndex();
         
        serial = Integer.parseInt(String.valueOf(tabledata1.getItems().get(myIndex).getSerial()));
        
            
            name = inpname.getText();
            email = inpemail.getText();
            phone = inpnumber.getText();
            id = inpid.getText();
            session = inpsession.getText();
            department = inpdep.getText();
            blood = inpbgroup.getText();
            experience = inpprevexp.getText();
            
        try
        {
            pst = (PreparedStatement) con.prepareStatement("update prog_member set name = ?,email = ?,phone = ?,id = ?,session = ?,department = ?,blood = ?,experience = ? where serial = ? ");
            
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, phone);
            pst.setString(4, id);
            pst.setString(5, session);
            pst.setString(6, department);
            pst.setString(7, blood);
            pst.setString(8, experience);
            pst.setInt(9, serial);
           
            
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registationn");
 
            alert.setHeaderText("Student Registation");
            alert.setContentText("Updateddd!");
 
            alert.showAndWait();
            table();
        }
        catch (HeadlessException | SQLException e)
        {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
        
    }

    @FXML
    private void progDelete(ActionEvent event) {
        
        myIndex = tabledata1.getSelectionModel().getSelectedIndex();
        serial = Integer.parseInt(String.valueOf(tabledata1.getItems().get(myIndex).getSerial()));
                    
 
        try
        {
            pst = (PreparedStatement) con.prepareStatement("delete from prog_member where serial = ? ");
            pst.setInt(1, serial);
            pst.executeUpdate();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Registationn");
 
            alert.setHeaderText("Student Registation");
            alert.setContentText("Deletedd!");
 
            alert.showAndWait();
            table();
        }
        catch (HeadlessException | SQLException e)
        {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void bckBtn(ActionEvent event)throws IOException {
        new SceneSwitcher(infoAnchor, "/adminFeature/adminProgramming.fxml");
    }

    @FXML
    private void printCpy(ActionEvent event) {
             Connect();
       Student selectedItem = tabledata1.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            Window window = ((Button) event.getSource()).getScene().getWindow();

            File file = fileChooser.showSaveDialog(window);
            if (file != null) {
                try {
                    PDDocument document = new PDDocument();

                    // Create a new page
                    PDPage page = new PDPage();
                    document.addPage(page);

                    // Create a new content stream
                    PDPageContentStream contentStream = new PDPageContentStream(document, page);

                    // Set font and font size
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);

                    // Add the selected item's information to the content stream
                    contentStream.beginText();
                    contentStream.newLineAtOffset(25, 700);
                    contentStream.showText("BDU Programming Club ");
                    contentStream.newLine();
                    contentStream.newLineAtOffset(0, -20);
                    contentStream.showText("Members Info ");
                    contentStream.newLine();

                    contentStream.setFont(PDType1Font.HELVETICA, 14);
                    contentStream.newLineAtOffset(0, -20); // Adjust the vertical position of the next line
                    contentStream.showText("Your Unique Serial Registration ID: BDUCMS-" + selectedItem.getSerial());
                    
                    
                    contentStream.newLineAtOffset(0, -20); // Adjust the vertical position of the next line
                    contentStream.showText("Member's Name: " + selectedItem.getName());
                    contentStream.newLine();

                    contentStream.newLineAtOffset(0, -20); // Adjust the vertical position of the next line
                    contentStream.showText("Member's Email: " + selectedItem.getEmail());
                    contentStream.newLine();

                    contentStream.newLineAtOffset(0, -20); // Adjust the vertical position of the next line
                    contentStream.showText("Student ID: " + selectedItem.getId());
                    
                    contentStream.newLineAtOffset(0, -20); // Adjust the vertical position of the next line
                    contentStream.showText("Department Name: " + selectedItem.getDepartment());
                    
                    contentStream.newLineAtOffset(0, -20); // Adjust the vertical position of the next line
                    contentStream.showText("Session: " + selectedItem.getSession());
                    
                    contentStream.newLineAtOffset(0, -20); // Adjust the vertical position of the next line
                    contentStream.showText("Phone Number: " + selectedItem.getPhone());
                    



                    contentStream.endText();

                    // Close the content stream
                    contentStream.close();

                    // Save the document
                    document.save(file);

                    // Close the document
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void close(ActionEvent event) throws IOException {
        System.exit(0);
    }
        
        
         
        
        
    }


    

