/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Contract;
import Model.Operator;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface DAO_Contract {
    //Metodo che accetta un contratto con dati incompleti
    // e restuisce lo stesso contratto con tutti i dati oppure null se non esiste.
    public Contract search(Contract c)throws SQLException;
    public void update_Registry(Contract c, Operator o)throws SQLException;
    public void update_UpdatedBy(Contract c, Operator o)throws SQLException;
    public void update_BillingAddress(Contract c, Operator o)throws SQLException;
    public void update_Address(Contract c, Operator o)throws SQLException;
    public void remove(Contract c)throws SQLException;
    public void create(Contract c, Operator o)throws SQLException;
    public List<Contract> getAllContracts()throws SQLException;
    public List<Contract> getAllContracts(Contract c)throws SQLException;
    public void addBillingAddress(Contract contract)throws SQLException;
    public void setBillingAddress(Contract contract)throws SQLException;
    public Contract getContract(Integer id)throws SQLException;

}
