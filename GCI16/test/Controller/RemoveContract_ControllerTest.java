package Controller;
import Model.Contract;
import Model.Operator;
import View.RegistryPanel;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Andrea
 * In this class is tested the RemoveContract_Controller's method "removeContract".
 * It takes an instance of contract as parameter.
 * Four equivalence classes were found:
 * - contracts setted on null (case A)
 * - contracts that can be closed (case B)
 * - contracts that can't be closed because there are pendants bills (case C)
 * - contracts already closed (case D)
 * 
 * others:
 * - choice "no" selected during the operation (case E)
*/ 
public class RemoveContract_ControllerTest {
    private static ContractTestGetter_DBMS contractGetter;
    private static RemoveContract_Controller instance;
    private Contract contract;
    
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
    
    /**
     * testing case A: contracts setted on null.
     */
    @Test(expected = NullPointerException.class)
    public void testRemoveContract1() {
        Boolean result = instance.removeContract(contract);
    }
    
    /**
     * testing case B: contracts that can be closed.
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
    
    /**
     * testing case C: contracts that can't be closed because there are pendants bills (case C).
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
    
    /**
     * testing case D: contracts already closed (case D).
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
    
    /**
     * testing case E: choice "no" selected during the operation.
     */
    @Test
    public void testRemoveContract5() {
        instance = new RemoveContract_Controller(new Registry_Controller(new Operator(2, "ingsw"), new RegistryPanel()));
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
