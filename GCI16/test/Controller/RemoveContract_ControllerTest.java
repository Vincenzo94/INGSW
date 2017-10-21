/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contract;
import Model.Operator;
import View.RegistryPanel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class RemoveContract_ControllerTest {
    private static ContractTestGetter_DBMS contractGetter;
    private static RemoveContract_Controller instance;
    private Contract contract;
    
    public RemoveContract_ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            contractGetter = new ContractTestGetter_DBMS();
        } catch (SQLException ex) {
            fail("contractGetter instantiation failed");
        }
        instance = new RemoveContract_Controller(new Registry_Controller(new Operator(2, "ingsw"), new RegistryPanel()));
    }
        
    @Before
    public void setUp() {
        contract = null;
    }
    
    /*
    contract is null
    */
    @Test(expected = NullPointerException.class)
    public void testRemoveContract1() {
        Boolean result = instance.removeContract(contract);
    }
    
    /*
    contract is valid
    */
    @Test
    public void testRemoveContract2() {
        try {
            contract = contractGetter.getValidContract();
        } catch (SQLException ex) {
            fail("contract instantiation failed");
        }
        Boolean expResult = true;
        Boolean result = instance.removeContract(contract);
        assertEquals(expResult, result);
    }
    
    /*
    contract is pendant
    */
    @Test
    public void testRemoveContract3() {
        try {
            contract = contractGetter.getPendantContract();
        } catch (SQLException ex) {
            fail("contract instantiation failed");
        }
        Boolean expResult = false;
        Boolean result = instance.removeContract(contract);
        assertEquals(expResult, result);
    }
    
    /*
    contact is closed yet
    */
    @Test
    public void testRemoveContract4() {
        try {
            contract = contractGetter.getClosedContract();
        } catch (SQLException ex) {
            fail("contract instantiation failed");
        }
        Boolean expResult = false;
        Boolean result = instance.removeContract(contract);
        assertEquals(expResult, result);
    }
    
    /*
    "no" selected from view
    */
    @Test
    public void testRemoveContract5() {
        try {
            contract = contractGetter.getClosedContract();
        } catch (SQLException ex) {
            fail("contract instantiation failed");
        }
        Boolean expResult = false;
        Boolean result = instance.removeContract(contract);
        assertEquals(expResult, result);
    }
}
