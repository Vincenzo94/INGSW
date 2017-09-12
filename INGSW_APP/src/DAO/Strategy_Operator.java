/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Operator;

/**
 *
 * @author ansan
 */
public interface Strategy_Operator {
    public boolean isAdmin(Operator o);
    public boolean isValid(Operator o);
}
