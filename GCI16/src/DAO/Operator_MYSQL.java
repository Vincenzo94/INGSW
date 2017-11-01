/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Database_Controller;
import Model.Operator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ansan
 */
public class Operator_MYSQL implements DAO_Operator{
    private final String TABLE = "Operator";
    Database_Controller dbController;
    public Operator_MYSQL(Database_Controller dbController) throws SQLException{
        this.dbController = dbController;
    }
    private final String QUERY_CHECK_OPERATOR = "SELECT * FROM " + Database_Controller.SCHEMA + "." + TABLE + " WHERE ID = ? AND `password` = ?";

    @Override
    public Operator check(Operator o)  throws SQLException{
        Operator loggedOperator = null;
        PreparedStatement statement = dbController.getStatement(QUERY_CHECK_OPERATOR);
        statement.setInt(1,o.getId());
        statement.setString(2, o.getPassword());
        ResultSet rs = dbController.doQuery(statement);
        while(rs.next()){
            loggedOperator = new Operator(rs.getInt("ID"), rs.getString("password"), rs.getBoolean("isAdmin"), rs.getBoolean("isDetector"));
        }
        return loggedOperator;         
   }

    @Override
    public void update(Operator o)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Operator o)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Operator o)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
