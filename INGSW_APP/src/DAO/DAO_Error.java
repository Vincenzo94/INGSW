/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ErrorModel;
import java.sql.SQLException;

/**
 *
 * @author ansan
 */
public interface DAO_Error {
    public void create(ErrorModel error)throws SQLException;

}
