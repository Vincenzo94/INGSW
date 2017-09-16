/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Andrea
 */
public class Bill extends Document{
    
    private Integer GeneratedDate;
    private Integer ConfirmedDate;
    private Integer PaymentDate;
    private Integer StartPeriod;
    private Integer EndPeriod;
    private Integer DetectionValue;
    private Integer DetectionOn;
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
        return EndPeriod;
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

    public void setStartPeriod(Integer StartPeriod) {
        this.StartPeriod = StartPeriod;
    }

    public void setEndPeriod(Integer EndPeriod) {
        this.EndPeriod = EndPeriod;
    }

    public void setDetectionValue(Integer DetectionValue) {
        this.DetectionValue = DetectionValue;
    }

    public void setDetectionOn(Integer DetectionOn) {
        this.DetectionOn = DetectionOn;
    }

    public void setState(String State) {
        this.State = State;
    }

}
