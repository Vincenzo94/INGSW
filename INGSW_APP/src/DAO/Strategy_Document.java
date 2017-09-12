/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.Document;
import Model.Contract;

/**
 *
 * @author Andrea
 */
public interface Strategy_Document {
    public Document search(Document d);
    public boolean update(Document d);
    public boolean remove(Document d);
    public boolean create(Document d);
    public boolean buildPdf(Document d);
    public boolean sendMail(Document d, Contract c);
    public boolean sendPost(Document d, Contract c);
    
}
