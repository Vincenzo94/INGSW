package Controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Login_ControllerPrivateTest {
    private static Login_Controller instance;
    private static Method[] methods;
    private static Method testMethod;
    private Boolean result;
    private String user;
    private String psw;
    private Boolean expResult;
    
    public Login_ControllerPrivateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
            instance = new Login_Controller(Main_Controller.getMain());
        } catch (SQLException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        methods = instance.getClass().getDeclaredMethods();
        for(Method m: methods){
            if("check".equals(m.getName()))
                testMethod = m;
        }
        testMethod.setAccessible(true);
    }
    
    @AfterClass
    public static void endClass() {
        testMethod.setAccessible(false);
    }
    
    @Before
    public void setUp() {
        user = null;
        psw = null;
        result = null;
        expResult = null;
    }
    
    @Test
    public void checkTest1(){
        user = "2";
        psw = "ingsw";
        expResult = true;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    /**
     * case T,F1
     */
    @Test
    public void checkTest2(){
        user = "2";
        psw = "ingw";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    /**
     * case T,F2
     */
    @Test
    public void checkTest3(){
        user = "2";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    /**
     * case F2,T
     */
    @Test
    public void checkTest4(){
        user = "101";
        psw = "ingsw";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    /**
     * case F2,F1
     */
    @Test
    public void checkTest5(){
        user = "101";
        psw = "ingw";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    /**
     * case F2,F2
     */
    @Test
    public void checkTest6(){
        user = "101";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    /**
     * case F4,T
     */
    @Test
    public void checkTest7(){
        user = "2abc";
        psw = "ingsw";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    
    /**
     * case F4,F1
     */
    @Test
    public void checkTest8(){
        user = "2abc";
        psw = "ingw";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    
    /**
     * case F4,F2
     */
    @Test
    public void checkTest9(){
        user = "2abc";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    
    /**
     * case F3,T
     */
    @Test
    public void checkTest10(){
        psw = "ingsw";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    
    /**
     * case F3,F1
     */
    @Test
    public void checkTest11(){
        psw = "ingw";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    
    /**
     * case F3,F2
     */
    @Test
    public void checkTest12(){
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    /**
     * case F1,T
     */
    @Test
    public void checkTest13(){
        user = "-1";
        psw = "ingsw";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    /**
     * case F1,F1
     */
    @Test
    public void checkTest14(){
        user = "-1";
        psw = "ingw";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
    
    /**
     * case F1,F2
     */
    @Test
    public void checkTest15(){
        user = "-1";
        expResult = false;
        try {
            result = (Boolean)testMethod.invoke(instance, user, psw);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Login_ControllerPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(result, expResult);
    }
}
