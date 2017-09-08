/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Andrea
 */
public interface Document {
    public Integer getGeneratedDate();
    public Integer getInsertedDate();
    public Integer getIussedDate();
    public Integer getPaymentDate();
    public boolean toPdf();
    public boolean toMail();
    public boolean toPoste();
    public String getState();
    
}
