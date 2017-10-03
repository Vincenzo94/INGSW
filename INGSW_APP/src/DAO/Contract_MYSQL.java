/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Database_Controller;
import Model.Contract;
import Model.Operator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Andrea
 */
public class Contract_MYSQL implements DAO_Contract{
    private final Database_Controller dbManager;
    private final String TABELLA = "Contract";
    private final String TABELLA_AUX = "Contract_Address";
    private final String TABELLA_ADDRESS = "Address";
    private final String QUERY_GET_ALL_CONTRACT = " SELECT * FROM " + Database_Controller.schema + "." + TABELLA_AUX;
    private final String QUERY_SEARCH_CONTRACT = " SELECT * FROM " + Database_Controller.schema + "." + TABELLA_AUX
                                               + " WHERE name LIKE ? AND surname LIKE ? AND ID LIKE ? AND taxCode LIKE ?";
    
    private final String QUERY_UPDATE_CONTRACT = " UPDATE "+Database_Controller.schema+"."+TABELLA
                                               + " SET name = ?, surname = ?, taxCode = ?, phone = ?,"
                                               + " mobile = ?, eMail = ?, UPDATED_BY = ?"
                                               + " WHERE id = ?";
    private final String QUERY_UPDATE_BILLING_ADDRESS = "UPDATE "+Database_Controller.schema+"."+TABELLA_ADDRESS
                                                      + " SET city = ?, district = ?, zipCode = ?, street = ?, number = ?"
                                                      + " WHERE ID = (SELECT BILLING_ADDRESS FROM " + Database_Controller.schema +"."+TABELLA
                                                      + " WHERE ID = ?)";
    private final String QUERY_UPDATE_ADDRESS = "UPDATE "+Database_Controller.schema+"."+TABELLA_ADDRESS
                                                      + " SET city = ?, district = ?, zipCode = ?, street = ?, number = ?"
                                                      + " WHERE ID = (SELECT ADDRESS FROM " + Database_Controller.schema +"."+TABELLA
                                                      + " WHERE ID = ?)";
    private final String QUERY_UPDATE_OPERATOR = " UPDATE "+Database_Controller.schema+"."+TABELLA
                                               + " SET UPDATED_BY = ? WHERE ID = ?";
    private final String QUERY_INSERT_ADDRESS = " INSERT INTO "+Database_Controller.schema+"."+TABELLA_ADDRESS
                                                      + " (city,district,zipCode,street,number) VALUES (?, ?, ?, ?, ?)";
    private final String QUERY_SET_BILLING_ADDRESS = " UPDATE "+Database_Controller.schema+"."+TABELLA
                                                   + " SET BILLING_ADDRESS = ? WHERE ID = ?";   
    
    private final String QUERY_GET_ADDRESS = " SELECT ID FROM "+Database_Controller.schema+"."+TABELLA_ADDRESS
                                           + " WHERE city = ? AND district = ? AND street = ? AND zipCode = ? AND number = ? ORDER BY ID DESC LIMIT 1";
    private final String QUERY_INSERT_CONTRACT = " INSERT INTO "+Database_Controller.schema+"."+TABELLA
                                               + " (name, surname, taxCode, phone, eMail, mobile, ADDRESS, INSERTED_BY)"
                                               + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private final String QUERY_INSERT_CONTRACT_BILLING_ADDRESS = " INSERT INTO "+Database_Controller.schema+"."+TABELLA
                                               + " (name, surname, taxCode, phone, eMail, mobile, ADDRESS, INSERTED_BY, BILLING_ADDRESS)"
                                               + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String QUERY_REMOVE_CONTRACT = " DELETE FROM "+Database_Controller.schema+"."+TABELLA
                                               + " WHERE ID = ?";
    private final String QUERY_GET_SINGLE_CONTRACT = " SELECT * FROM " + Database_Controller.schema + "." + TABELLA_AUX
                                                   + " WHERE ID = ?";
    public Contract_MYSQL(Database_Controller dbManager){
        this.dbManager = dbManager;
    }
    @Override
    public Contract search(Contract c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update_UpdatedBy(Contract c, Operator o){
        PreparedStatement statement = dbManager.getStatement(QUERY_UPDATE_OPERATOR);
        try {
            statement.setInt(1,o.getId());
            statement.setInt(2, c.getId());
            if(!dbManager.doUpdate(statement))
                throw new SQLException("Unable to update UPDATE_BY in Contract " +c.getId());
        } catch (SQLException ex) {

        }
    }
    @Override
    public void update_Registry(Contract c, Operator o){
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_UPDATE_CONTRACT);
            statement.setString(1, c.getName());
            statement.setString(2, c.getSurname());
            statement.setString(3, c.getTaxCode());
            statement.setString(4, c.getPhone());
            statement.setString(5, c.getMobile());
            statement.setString(6, c.getEmailAddress());
            statement.setInt(7, o.getId());
            statement.setInt(8, c.getId());
            if(!dbManager.doUpdate(statement))
                throw new SQLException("Unable to update Contract " +c.getId());
        } catch (SQLException ex) {
        }
    }
    @Override
    public void update_BillingAddress(Contract c, Operator o){
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_UPDATE_BILLING_ADDRESS);
            statement.setString(1, c.getBillingCity());
            statement.setString(2, c.getBillingDistrict());
            statement.setString(3, c.getBillingZip());
            statement.setString(4, c.getBillingStreet());
            if(c.getBillingNumber() == null)
                statement.setInt(5, 0);
            else
                statement.setInt(5, c.getBillingNumber());
            statement.setInt(6, c.getId());
            if(!dbManager.doUpdate(statement))
                throw new SQLException("Unable to update BillingAddress in Contract " +c.getId());
            update_UpdatedBy(c,o);
        } catch (SQLException ex) {
        }
    }
    @Override
    public void update_Address(Contract c, Operator o){
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_UPDATE_ADDRESS);
            statement.setString(1, c.getCity());
            statement.setString(2, c.getDistrict());
            statement.setString(3, c.getZip());
            statement.setString(4, c.getStreet());
            statement.setInt(5, c.getNumber());
            statement.setInt(6, c.getId());
            if(!dbManager.doUpdate(statement))
                throw new SQLException("Unable to update Addrress in Contract " +c.getId());
            update_UpdatedBy(c,o);
        } catch (SQLException ex) {
        }
    }
    @Override
    public void remove(Contract c) {
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_REMOVE_CONTRACT);
            statement.setInt(1, c.getId());
            if(!dbManager.doUpdate(statement))
                throw new SQLException("Unable to remove Contract "+c.getId());
        } catch (SQLException ex) {
        }
    }

    @Override
    public void create(Contract c, Operator o) {
        addAddress(c);
        Integer addressID = getAddress(c.getCity(),c.getDistrict(),c.getStreet(),c.getZip(),c.getNumber());
        PreparedStatement statement = null;
        try {
            if(c.getBillingAddress() != null){
                statement = dbManager.getStatement(QUERY_INSERT_CONTRACT_BILLING_ADDRESS);
                addBillingAddress(c);
                Integer billingAddressID = getAddress(c.getBillingCity(),c.getBillingDistrict(),c.getBillingStreet(),c.getBillingZip(),c.getBillingNumber());
                statement.setInt(9, billingAddressID);
            }
            else
                statement = dbManager.getStatement(QUERY_INSERT_CONTRACT); 
            statement.setString(1, c.getName());
            statement.setString(2, c.getSurname());
            statement.setString(3, c.getTaxCode());
            statement.setString(4, c.getPhone());
            statement.setString(5, c.getEmailAddress());
            statement.setString(6, c.getMobile());
            statement.setInt(7, addressID);
            statement.setInt(8, o.getId());
            if(!dbManager.doUpdate(statement))
                throw new SQLException("Unable to insert Contract");
        } catch (SQLException ex) {
        }
    }

    @Override
    public List<Contract> getAllContracts() {
        List<Contract> contracts = new ArrayList<>();
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_GET_ALL_CONTRACT);
            ResultSet rs = dbManager.doQuery(statement);
            while(rs.next()){
                contracts.add(new Contract(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getInt(20)));
            }
        } catch (SQLException ex) {
        }
        return contracts;         
    }
    @Override
    public Contract getContract(Integer id) {
        Contract contract = null;
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_GET_SINGLE_CONTRACT);
            statement.setInt(1,id);
            ResultSet rs = dbManager.doQuery(statement);
            while(rs.next()){
                contract = new Contract(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getInt(20));
            }
        } catch (SQLException ex) {
        }
        return contract;         
    }
    @Override
    public List<Contract> getAllContracts(Contract c) {
        List<Contract> contracts = new ArrayList<>();
        String name = c.getName();
        String surname = c.getSurname();
        String tax= c.getTaxCode();
        Integer id = c.getId();
        if(name == null)
            name = "";
        if(surname == null)
            surname = "";
        if(tax == null)
            tax = "";            
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_SEARCH_CONTRACT);
            statement.setString(1,name+"%");
            statement.setString(2,surname+"%");
            if(id == null)
                statement.setString(3,"%");
            else
                statement.setInt(3,id);
            statement.setString(4,tax+"%");
            ResultSet rs = dbManager.doQuery(statement);
            while(rs.next()){
                contracts.add(new Contract(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getInt(20)));
            }
        } catch (SQLException ex) {
        }
        return contracts;         
    }

    @Override
    public void addBillingAddress(Contract c) {
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_INSERT_ADDRESS);
            statement.setString(1, c.getBillingCity());
            statement.setString(2, c.getBillingDistrict());
            statement.setString(3, c.getBillingZip());
            statement.setString(4, c.getBillingStreet());
            statement.setInt(5, c.getBillingNumber());
            if(!dbManager.doUpdate(statement))
                throw new SQLException("Unable to add BillingAddress " +c.getBillingAddress());
        } catch (SQLException ex) {
        }
    }
    private void addAddress(Contract c) {
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_INSERT_ADDRESS);
            statement.setString(1, c.getCity());
            statement.setString(2, c.getDistrict());
            statement.setString(3, c.getZip());
            statement.setString(4, c.getStreet());
            statement.setInt(5, c.getNumber());
            if(!dbManager.doUpdate(statement))
                throw new SQLException("Unable to add Address " +c.getAddress());
        } catch (SQLException ex) {
        }
    }
    @Override
    public void setBillingAddress(Contract c) {
        try {
            Integer id = null;
            if(c.getBillingAddress() != null)
                id= getAddress(c.getBillingCity(),c.getBillingDistrict(),c.getBillingStreet(),c.getBillingZip(),c.getBillingNumber());
            PreparedStatement statement = dbManager.getStatement(QUERY_SET_BILLING_ADDRESS);
            if(id==null)
                statement.setObject(1, null);
            else
                statement.setInt(1, id);
            statement.setInt(2, c.getId());
            if(!dbManager.doUpdate(statement))
                throw new SQLException("Unable to set BillingAddress "+c.getBillingAddress()+" to Contract " +c.getId());
        } catch (SQLException ex) {
        }
    }
    private Integer getAddress(String city, String district, String street, String zip, Integer number){
        Integer id = null;
        try {
            PreparedStatement statement = dbManager.getStatement(QUERY_GET_ADDRESS);
            statement.setString(1,city);
            statement.setString(2,district);
            statement.setString(3,street);
            statement.setString(4,zip);
            statement.setInt(5,number);
            ResultSet rs = dbManager.doQuery(statement);
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
        }
        return id;             
    }
   
}
