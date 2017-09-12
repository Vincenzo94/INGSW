/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Contract;

/**
 *
 * @author Andrea
 */
public interface Strategy_Contract {
    public Contract search(Contract c);
    public boolean update(Contract c);
    public boolean remove(Contract c);
    public boolean create(Contract c);
}
