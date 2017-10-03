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
public class Bill extends Document{
    
    private final Date paymentDate;
    private final Date startPeriod;
    private final Date endPeriod;
    private final Float detectionValue;
    private final Date detectionDate;
    private final Date deadline;
    private final Integer contractID;
    private final Integer detectorID;
    private final Float total;
    private final Float tax;
    
    
    public Bill(Integer id, String state, Date generatedDate, Date confirmedDate,Date startPeriod, Date endPeriod, Float detectionValue, Date detectionDate, Integer contractID, Integer detectorID, Date paymentDate, Date deadline, Float total, Float tax, Integer operatorID){
        super(id,state,generatedDate,confirmedDate, operatorID);
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.detectionValue = detectionValue;
        this.detectionDate = detectionDate;
        this.contractID = contractID;
        this.detectorID = detectorID;
        this.paymentDate = paymentDate;
        this.deadline = deadline;
        this.total = total;
        this.tax = tax;
    }
    
    public Date getPaymentDate() {
        return paymentDate;
    }
    public String getPeriod(){
        return getStartPeriod().toString().concat(" - "+getEndPeriod().toString());
    }
    public Date getStartPeriod() {
        return endPeriod;
    }
    public Date getEndPeriod() {
        return startPeriod;
    }
    public Float getDetectionValue(){
        return detectionValue;
    }
    public Date getDetectionDate() {
        return detectionDate;
    }
    public Date getDeadline(){
        return deadline;
    }
    public Integer getContractID() {
        return contractID;
    }
    public Float getTotal() {
        return total;
    }
    public Float getTax(){
        return tax;
    }
    public Integer getDetector() {
        return detectorID;
    }

}
