/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminFeature;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Fahad Mahmud
 */
public class Student {
    
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty  phone;
    private final StringProperty id;
    private final StringProperty session;
    private final StringProperty department;
    private final StringProperty blood;
    private final StringProperty experience;
    private final StringProperty serial;
    
 
    
    public Student()
    {
        
        name = new SimpleStringProperty(this, "name");
        email = new SimpleStringProperty(this, "email");
        phone = new SimpleStringProperty(this, "phone");
        id = new SimpleStringProperty(this, "id");
        session = new SimpleStringProperty(this, "session");
        department = new SimpleStringProperty(this, "department");
        blood = new SimpleStringProperty(this, "blood");
        experience = new SimpleStringProperty(this, "experience");
        serial = new SimpleStringProperty(this, "serial");

    }
    
    public StringProperty serialProperty() { return serial; }
    public String getSerial() { return serial.get(); }
    public void setSerial(String newSerial) { serial.set(newSerial); }
    
    
    public StringProperty nameProperty() { return name; }
    public String getName() { return name.get(); }
    public void setName(String newName) { name.set(newName); }
    
    public StringProperty emailProperty() { return email; }
    public String getEmail() { return email.get(); }
    public void setEmail(String newEmail) { email.set(newEmail); }
    
    public StringProperty phoneProperty() { return phone; }
    public String getPhone() { return phone.get(); }
    public void setPhone(String newPhone) { phone.set(newPhone); }
    
    public StringProperty idProperty() { return id; }
    public String getId() { return id.get(); }
    public void setId(String newId) { id.set(newId); }
    
    public StringProperty sessionProperty() { return session; }
    public String getSession() { return session.get(); }
    public void setSession(String newSession) { session.set(newSession); }
    
    public StringProperty departmentProperty() { return department; }
    public String getDepartment() { return department.get(); }
    public void setDepartment(String newDepartment) { department.set(newDepartment); }
    
    public StringProperty bloodProperty() { return blood; }
    public String getBlood() { return blood.get(); }
    public void setBlood(String newBlood) { blood.set(newBlood); }
    
    public StringProperty experienceProperty() { return experience; }
    public String getExperience() { return experience.get(); }
    public void setExperience(String newExperience) { experience.set(newExperience); }
    

    
    
}