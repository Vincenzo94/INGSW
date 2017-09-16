/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Contract;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface DAO_Contract {
    //Metodo che accetta un contratto con dati incompleti
    // e restuisce lo stesso contratto con tutti i dati oppure null se non esiste.
    public Contract search(Contract c);
    public void update(Contract c);
    public void remove(Contract c);
    public void create(Contract c);
    public List<Contract> getAllContracts();
    public List<Contract> getAllContracts(String s);
}
