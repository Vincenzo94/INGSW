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
    public String getState();
    public Integer getGeneratedDate();
    public Integer getInsertedDate();
    public Integer getIussedDate();
    public Integer getPaymentDate();
    public void setManager(Strategy_Document db);
}
