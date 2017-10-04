/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.DAYS;


/**
 *
 * @author Andrea
 */
public class Injuction extends Document{
    private final Bill referredBill;
    
    public Injuction(Integer id, Date generatedDate, Date confirmedDate, String state, Bill bill, Integer operatorID) {
        super(id, state, generatedDate, confirmedDate, operatorID);
        this.referredBill = bill;
        if(referredBill == null)
            System.out.println("null");
    }
    public Bill getBill(){
        return referredBill;
    }
    @Override
    public Integer getContractID(){
        return referredBill.getContractID();
    }

    public Integer getBillID() {
        return referredBill.getId();
    }

    public long getExpiredFrom() {
        Long diffInMillies =  (new java.util.Date()).getTime() - referredBill.getDeadline().getTime();
        return DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

    public String getArrears() {//SERVIREBBE FLOAT O DOUBLE MA DA UN ERRORE STRANO
        return new DecimalFormat("#0,00").format(getExpiredFrom() * 0.5 + 100 + referredBill.getTotal());
    }
   
}
