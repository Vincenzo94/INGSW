/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Date;
import java.util.Observable;

/**
 *
 * @author Andrea
 */
public class Document extends Observable{
    final Integer id;
    String state;
    final Date generatedDate;
    Date confirmedDate;
    public Document(Integer id, String state, Date generatedDate, Date confirmedDate){
        this.id = id;
        this.state = state;
        this.generatedDate = generatedDate;
        this.confirmedDate = confirmedDate;
    }
      
    public Integer getId(){
        return id;
    }
    public String getState(){
        return state;
    }
    public  Date getGeneratedDate(){
        return generatedDate;
    }
    public Date getConfirmedDate(){
        return confirmedDate;
    }
    
    
    public void setState(String state) {
        this.state = state;
    }
    public void setConfirmedDate(Date confirmedDate){
            this.confirmedDate = confirmedDate;
    }
}

