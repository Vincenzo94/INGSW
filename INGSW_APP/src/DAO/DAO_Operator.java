/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Operator;
import java.sql.SQLException;

/**
 *
 * @author ansan
 */
public interface DAO_Operator {
    public Operator check(Operator o)throws SQLException;
    public void update(Operator o)throws SQLException;
    public void delete(Operator o)throws SQLException;
    public void create (Operator o)throws SQLException;
}
