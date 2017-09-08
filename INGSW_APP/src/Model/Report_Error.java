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
public class Report_Error {
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
    
    
    
}
