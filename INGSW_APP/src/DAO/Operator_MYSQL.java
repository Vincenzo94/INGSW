/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Database_Controller;
import Controller.Popup_Controller;
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
    Database_Controller dbManager;
    public Operator_MYSQL(Database_Controller dbManager) throws SQLException{
        this.dbManager = dbManager;
    }
    private final String QUERY_CHECK_OPERATOR = "SELECT * FROM " + Database_Controller.schema + "." + TABLE + " WHERE ID = ? AND `password` = ?";

    @Override
    public Operator check(Operator o) {
    Operator loggedOperator = null;
    try {
            PreparedStatement statement = dbManager.getStatement(QUERY_CHECK_OPERATOR);
            statement.setInt(1,o.getId());
            statement.setString(2, o.getPassword());
            ResultSet rs = dbManager.doQuery(statement);
            while(rs.next()){
                loggedOperator = new Operator(rs.getInt("ID"), rs.getString("password"), rs.getBoolean("isAdmin"), rs.getBoolean("isDetector"));
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            Popup_Controller popupController = Popup_Controller.getPopup_C();
            popupController.showPopup(msg);
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
