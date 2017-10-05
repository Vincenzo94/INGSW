/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Database_Controller;
import Controller.Popup_Controller;
import Model.Bill;
import Model.ErrorModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ansan
 */
public class Error_MYSQL implements DAO_Error{

    private final Database_Controller dbController;
    private final String TABELLA = "Error";
    private final String QUERY_INSERT_ERROR = "INSERT INTO "+ Database_Controller.schema + "." + TABELLA
                                            + " (description, REPORTED_BY_OPERATOR, REFERRED_BILL) VALUES (?, ?, ?)";
    public Error_MYSQL(Database_Controller dbController){
        this.dbController = dbController;
    }
    
    @Override
    public void create(ErrorModel error)throws SQLException{
        Bill b = error.getBill();
        PreparedStatement statement = dbController.getStatement(QUERY_INSERT_ERROR);
        statement.setString(1, error.getDescription());
        statement.setInt(2, error.getOperatorID());
        statement.setInt(3, b.getId());
        System.out.println(statement);
        if(!dbController.doUpdate(statement))
            throw new SQLException("Unable to insert Error");
    }
}


