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
public class ProgAdmin {
    
    private final StringProperty serial;
    private final StringProperty trxid;
    private final StringProperty uni_id;
    private final StringProperty status;
   
    
    public ProgAdmin()
    {
        serial= new SimpleStringProperty(this, "serial");
        trxid = new SimpleStringProperty(this, "trxid");
        uni_id = new SimpleStringProperty(this, "uni_id");
        status = new SimpleStringProperty(this, "status");
        
    }
 
    public StringProperty serialProperty() { return serial; }
    public String getSerial() { return serial.get(); }
    public void setSerial(String newSerial) { serial.set(newSerial); }
 
    public StringProperty trxidProperty() { return trxid; }
    public String getTrxid() { return trxid.get(); }
    public void setTrxid(String newTrxid) { trxid.set(newTrxid); }
 
    public StringProperty uni_idProperty() { return uni_id; }
    public String getUni_id() { return uni_id.get(); }
    public void setUni_id(String newUni_id) { uni_id.set(newUni_id); }
    
    public StringProperty statusProperty() { return status; }
    public String getStatus() { return status.get(); }
    public void setStatus(String newStatus) { status.set(newStatus); }

    
    

    
    
    
    
}
