/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import Model.Operator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 *
 * @author ansan
 */
public class Log_Controller implements Controller{

    private static String string;
    private static final InputStream config = Log_Controller.class.getResourceAsStream("/GCI16/log4j.properties");
        private static final String TMP_DIR = System.getProperty("java.io.tmpdir");

    static void setOperator(Operator o) {
        string="User: "+o.getId();
    }
    
    private Log_Controller() {
        
    }
    
    public static void writeLog(String s, Class c){
        Logger log = Logger.getLogger(c.getName());
        new File(TMP_DIR+"/INGSW_GR12").mkdir();
        File file = new File(TMP_DIR+"/INGSW_GR12", "log4j.properties");
        if (!file.exists()) {
           
            try {
                Files.copy(config, file.getAbsoluteFile().toPath());
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Log_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        PropertyConfigurator.configure(TMP_DIR+"/INGSW_GR12/log4j.properties");
        log.info(string+s);
    }
}
