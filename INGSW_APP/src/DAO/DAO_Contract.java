/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Contract;
import Model.Operator;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface DAO_Contract {
    //Metodo che accetta un contratto con dati incompleti
    // e restuisce lo stesso contratto con tutti i dati oppure null se non esiste.
    public Contract search(Contract c);
    public void update_Registry(Contract c, Operator o);
    public void update_UpdatedBy(Contract c, Operator o);
    public void update_BillingAddress(Contract c, Operator o);
    public void update_Address(Contract c, Operator o);
    public void remove(Contract c);
    public void create(Contract c, Operator o);
    public List<Contract> getAllContracts();
    //Metodo che restuisce una lista di contratti 
    //corrispondenti alla ricerca con i dati del contratto passato.
    public List<Contract> getAllContracts(Contract c);
    public void addBillingAddress(Contract contract);
    public void setBillingAddress(Contract contract);

}
