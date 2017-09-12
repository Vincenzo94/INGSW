/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interface.Observable;
import Interface.Observer;

/**
 *
 * @author Andrea
 */
public class Report_Error implements Observable{
    private final Bill bill;
    private final Injuction inj;
    private final Contract con;
    private final String description;

    public Report_Error(Bill bill, String desc) {
        this.bill = bill;
        this.description=desc;
        this.inj=null;
        this.con=null;
    }

    public Report_Error(Injuction inj, String desc) {
        this.inj = inj;
        this.description=desc;
        this.con=null;
        this.bill=null;
    }

    public Report_Error(Contract con, String desc) {
        this.con = con;
        this.description=desc;
        this.bill=null;
        this.inj=null;
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
