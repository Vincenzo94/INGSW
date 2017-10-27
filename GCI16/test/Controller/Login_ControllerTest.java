
package Controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * 
 * @author Andrea
 * 
 * This class tests the "check" method of "Login_Controller" class.
 * This methods takes 2 parameters in input: USER(String) and PSW(String).
 * 
 * Equivalence classes:
 * USER:
 *  - Numerical value between 0 and 100 (T)
 *  - Numerical value lower then 0  (F1)
 *  - Numerical value higher then 100   (F2)
 *  - NULL  (F3)
 *  - Alphanumerical value  (F4)
 * 
 * PSW:
 *  - Stored values (T)
 *  - Not stored values (F1) 
 *  - NULL  (F2)
 * 
 * Method applied: SECT
 * Number of tests: 15 (5x3)
 */
public class Login_ControllerTest {
    private static Login_Controller instance;
    private Boolean result;
    private String user;
    private String psw;
    private Boolean expResult;
    
    public Login_ControllerTest() {        
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            instance = new Login_Controller(Main_Controller.getMain());
        } catch (SQLException ex) {
            Logger.getLogger(Login_ControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Login_Controller instantiation failed");
        }
    } 
    
    @Before
    public void setUp() {
        user = null;
        psw = null;
        result = null;
        expResult = null;
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   T   
    *   Psw:    T
    */
    @Test
    public void checkTest1(){
        user = "2";
        psw = "ingsw";
        expResult = true;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   T
    *   Psw:    F1
    */
    @Test
    public void checkTest2(){
        user = "2";
        psw = "ingw";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   T   
    *   Psw:    F2
    */
    @Test
    public void checkTest3(){
        user = "2";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F2
    *   Psw:    T
    */
    @Test
    public void checkTest4(){
        user = "101";
        psw = "ingsw";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F2   
    *   Psw:    F1
    */
    @Test
    public void checkTest5(){
        user = "101";
        psw = "ingw";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F2
    *   Psw:    F2
    */
    @Test
    public void checkTest6(){
        user = "101";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F3
    *   Psw:    T
    */
    @Test
    public void checkTest7(){
        user = "2abc";
        psw = "ingsw";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F3   
    *   Psw:    F1
    */
    @Test
    public void checkTest8(){
        user = "2abc";
        psw = "ingw";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F3
    *   Psw:    F2
    */
    @Test
    public void checkTest9(){
        user = "2abc";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F4
    *   Psw:    T
    */
    @Test
    public void checkTest10(){
        psw = "ingsw";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F4
    *   Psw:    F1
    */
    @Test
    public void checkTest11(){
        psw = "ingw";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F4
    *   Psw:    F2
    */
    @Test
    public void checkTest12(){
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F1   
    *   Psw:    T
    */
    @Test
    public void checkTest13(){
        user = "-1";
        psw = "ingsw";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F1   
    *   Psw:    F1
    */
    @Test
    public void checkTest14(){
        user = "-1";
        psw = "ingw";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
    
    /*
    *   EQUIVALENCE CLASSES TESTED:
    *   User:   F1   
    *   Psw:    F2
    */
    @Test
    public void checkTest15(){
        user = "-1";
        expResult = false;
        result = instance.check(user, psw);
        assertEquals(result, expResult);
    }
}