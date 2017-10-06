/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;

/**
 *
 * @author Andrea
 */
public class ErrorModel extends Observable{
    private final Bill bill;
    private final String description;
    private static Integer operatorID;

    public ErrorModel(Bill bill, String desc) {
        this.bill = bill;
        this.description=desc;
    }

    public Bill getBill() {
        return bill;
    }

    public String getDescription() {
        return description;
    }
    
    public static void setOperatorID(Integer id){
        operatorID = id;
    }

    public Integer getOperatorID() {
        return operatorID;
    }
}
