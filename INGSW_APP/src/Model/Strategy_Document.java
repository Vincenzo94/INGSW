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
public interface Strategy_Document {
    public Document search();
    public boolean update();
    public boolean remove();
    public boolean create();
    public boolean buildPdf(Document d);
    public boolean sendMail(Document d, Contract c);
    public boolean sendPost(Document d, Contract c);
    
}
