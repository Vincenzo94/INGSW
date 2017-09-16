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
public interface DAO_Operator {
    public Operator check(Operator o);
    public void update(Operator o);
    public void delete(Operator o);
    public void create (Operator o);
}
