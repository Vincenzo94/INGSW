/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import Model.Operator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 *
 * @author ansan
 */
public class Log_Controller implements Controller{

    private static Integer operator;
    static void setOperator(Operator o) {
        operator = o.getId();
    }
    
    private Log_Controller() {
    }
    
    public static void writeLog(String s, Class c){
        Logger log = Logger.getLogger(c.getName());
        PropertyConfigurator.configure("././src/ingsw_app/log4j.properties");
        log.info(s);
    }
}
