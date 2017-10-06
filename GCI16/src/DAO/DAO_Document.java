/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Contract;
import Model.Document;
import Model.Operator;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface DAO_Document {
    public Document search(Document d)throws SQLException;
    public boolean update(Document d)throws SQLException;
    public void remove(Document d)throws SQLException;
    public <T extends Document> List<T> getAllDocuments(Operator o)throws SQLException;
    public <T> List<T> getAllDocuments(Contract c)throws SQLException;
    public void setState(Document d)throws SQLException;
    public <T extends Document> void setManagedOperator(T document, Operator o)throws SQLException;
}
