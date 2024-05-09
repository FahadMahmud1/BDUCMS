/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bducms;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Fahad Mahmud
 */
public class Notice {
    
    private final StringProperty nid;    
    private final StringProperty notice;
 
    
    public Notice()
    {
        nid = new SimpleStringProperty(this, "nid");
        notice = new SimpleStringProperty(this, "notice");

    }
 
    
    public StringProperty nidProperty() { return nid; }
    public String getNid() { return nid.get(); }
    public void setNid(String newNid) { nid.set(newNid); }

 
    public StringProperty noticeProperty() { return notice; }
    public String getNotice() { return notice.get(); }
    public void setNotice(String newNotice) { notice.set(newNotice); }
    
    
}
