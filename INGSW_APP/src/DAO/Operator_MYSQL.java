/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DatabaseManager;
import Model.Operator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ansan
 */
public class Operator_MYSQL implements DAO_Operator{
    private final String TABLE = "Operator";
    Connection connection;
    public Operator_MYSQL(Connection connection) throws SQLException{
        this.connection = connection;
    }
    private final String QUERY_CHECK_OPERATOR = "SELECT * FROM " + DatabaseManager.schema + "." + TABLE + " WHERE ID = ? AND `password` = ?";

    @Override
    public Operator check(Operator o) {
    Operator loggedOperator = null;
    try {
            PreparedStatement statement = connection.prepareStatement(QUERY_CHECK_OPERATOR, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1,o.getId());
            statement.setString(2, o.getPassword());
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                loggedOperator = new Operator(rs.getInt("ID"), rs.getString("password"), rs.getBoolean("isAdmin"), rs.getBoolean("isDetector"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operator_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loggedOperator;         
   }

    @Override
    public void update(Operator o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Operator o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Operator o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
