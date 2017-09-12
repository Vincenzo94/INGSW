/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interface.Document;
import Interface.Observer;

/**
 *
 * @author Andrea
 */
public class Injuction implements Document{
    
    private Integer GeneratedDate;
    private Integer ConfirmedDate;
    private Integer PaymentDate;
    private String State;

    @Override
    public String getState() {
        return State;
    }

    @Override
    public Integer getGeneratedDate() {
        return GeneratedDate;
    }

    @Override
    public Integer getInsertedDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getIussedDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getPaymentDate() {
        return PaymentDate;
    }

    public void setGeneratedDate(Integer GeneratedDate) {
        this.GeneratedDate = GeneratedDate;
    }

    public void setConfirmedDate(Integer ConfirmedDate) {
        this.ConfirmedDate = ConfirmedDate;
    }

    public void setPaymentDate(Integer PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

    public void setState(String State) {
        this.State = State;
    }

    @Override
    public void attach(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void detach(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
