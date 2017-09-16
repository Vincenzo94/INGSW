/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DatabaseManager;
import Model.Bill;
import Model.Contract;
import Model.Document;
import View.Bills;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

/**
 *
 * @author Andrea
 */
public class Bill_MYSQL implements DAO_Document {

    private Connection connection = null;
    private final String TABELLA = "BillsQueue_View";
    private final String QUERY_GET_ALL_BILLS= "SELECT * FROM " + DatabaseManager.schema + "." + TABELLA;
    public Bill_MYSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Document search(Document d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Document d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Document d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Document d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public List<Document> getAllDocuments(Contract c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> getAllDocuments() {
    List<Bill> bills = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_ALL_BILLS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                bills.add(new Bill(rs.getInt("Contract ID"), rs.getDate("Reference detection"), rs.getDate("Generated on"), rs.getFloat("Total")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operator_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;         
    }
    
}
