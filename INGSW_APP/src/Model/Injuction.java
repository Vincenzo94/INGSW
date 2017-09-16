/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;


/**
 *
 * @author Andrea
 */
public class Injuction extends Document{
    
    private Date PaymentDate;

    @Override
    public String getState() {
        return state;
    }

    @Override
    public Date getGeneratedDate() {
        return GeneratedDate;
    }

    @Override
    public Date getInsertedDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getIussedDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getPaymentDate() {
        return PaymentDate;
    }

    public void setGeneratedDate(Date GeneratedDate) {
        this.GeneratedDate = GeneratedDate;
    }

    public void setConfirmedDate(Date ConfirmedDate) {
        this.ConfirmedDate = ConfirmedDate;
    }

    public void setPaymentDate(Date PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

    public void setState(String State) {
        this.state = State;
    }

    @Override
    public Integer getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
