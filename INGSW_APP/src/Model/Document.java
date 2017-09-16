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
public abstract class Document extends Observable{
    Integer id;
    String state;
    Date GeneratedDate;
    Date ConfirmedDate;
    public abstract Integer getId();
    public abstract String getState();
    public abstract Date getGeneratedDate();
    public abstract Date getInsertedDate();
    public abstract Date getIussedDate();
    public abstract Date getPaymentDate();
}
