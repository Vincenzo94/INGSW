/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Andrea
 */
public class Bill extends Document{
    
    private String period;
    private Date PaymentDate;
    private Date StartPeriod;
    private Date EndPeriod;
    private Integer DetectionValue;
    private Date DetectionOn;
    private Date Deadline;
    private final Integer contractID;
    private final Float total;
    public Bill(int contractID, Date detection, Date generatedOn, Float Total) {
        this.contractID = contractID;
        this.DetectionOn = detection;
        this.GeneratedDate = generatedOn;
        this.total = Total;
    }
    
    public Integer getId(){
        return id;
    }
    public String getPeriod(){
        return period;
    }
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
        return EndPeriod;
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

    public void setStartPeriod(Date StartPeriod) {
        this.StartPeriod = StartPeriod;
    }

    public void setEndPeriod(Date EndPeriod) {
        this.EndPeriod = EndPeriod;
    }

    public void setDetectionValue(Integer DetectionValue) {
        this.DetectionValue = DetectionValue;
    }

    public void setDetectionOn(Date DetectionOn) {
        this.DetectionOn = DetectionOn;
    }

    public void setState(String State) {
        this.state = State;
    }

    public Object getDeadline() {
        return Deadline;
    }

    public Object getContractId() {
        return contractID;
    }

    public Object getDetectionDate() {
        return DetectionOn;
    }

    public Object getTotal() {
        return total;
    }

}
