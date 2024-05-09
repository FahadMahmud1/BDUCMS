package adminFeature;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Fahad Mahmud
 */
public class PayBdUpc1 {
    private int serial;
    private String trxid;
    private int uniId;
    private String status;
    

    

    

    public PayBdUpc1(int serial, String trxid, int uniId, String status) {
        this.serial = serial;
        this.trxid = trxid;
        this.uniId = uniId;
        this.status = status;
        
    }
    

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
   
    

    public String getTrxid() {
        return trxid;
    }

    public void setTrxid(String trxid) {
        this.trxid = trxid;
    }
   

    public int getUniId() {
        return uniId;
    }

    public void setUniId(int uniId) {
        this.uniId = uniId;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
