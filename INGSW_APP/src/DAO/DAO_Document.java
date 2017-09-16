/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Contract;
import Model.Document;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface DAO_Document {
    public Document search(Document d);
    public boolean update(Document d);
    public boolean remove(Document d);
    public boolean create(Document d);
    public List<Document> getAllDocuments();
    public List<Document> getAllDocuments(Contract c);
}
