/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Bill;
import Model.Contract;
import Model.Document;
import Model.Injuction;
import Model.Operator;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface DAO_Document {
    public Document search(Document d);
    public boolean update(Document d);
    public <T extends Document> List<T> getAllDocuments(Operator o);
    public <T> List<T> getAllDocuments(Contract c);

    public <T extends Document> void setManagedOperator(T document, Operator o);
}
