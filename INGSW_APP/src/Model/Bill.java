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
public class Bill implements Document{
    private Strategy_Document manager;
    private Integer generatedOn;
    private Integer confirmedOn;
    private Integer paidOn;
    private Integer startPeriod;
    private Integer endPeriod;
    private Integer detectionValue;
    private Integer detectionOn;
    private String state;


    public Integer getGeneratedOn() {
        return generatedOn;
    }

    public Integer getConfirmedOn() {
        return confirmedOn;
    }

    public Integer getPaidOn() {
        return paidOn;
    }

    public Integer getStartPeriod() {
        return startPeriod;
    }

    public Integer getEndPeriod() {
        return endPeriod;
    }

    public Integer getDetectionValue() {
        return detectionValue;
    }

    public Integer getDetectionOn() {
        return detectionOn;
    }
   
    @Override
    public String getState() {
        return state;
    }

    @Override
    public Integer getGeneratedDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setManager(Strategy_Document db) {
        this.manager=db;
    }
   
}
