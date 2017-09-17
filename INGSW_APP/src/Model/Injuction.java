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
    
    private Date paymentDate;

    public Injuction(Integer id, String state, Date generatedDate, Date confirmedDate) {
        super(id, state, generatedDate, confirmedDate);
    }

    
    public Date getPaymentDate() {
        return paymentDate;
    }

    
}
