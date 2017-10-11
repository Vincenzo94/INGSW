/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import Model.Operator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
/**
 *
 * @author ansan
 */
public class Log_Controller implements Controller{

    private static String string;
    private static Operator o;
    private static final InputStream CONFIG = Log_Controller.class.getResourceAsStream("/GCI16/log4j.properties");
    private static final String TMP_DIR = System.getProperty("java.io.tmpdir");
    private static final String SERVER = "loggci16.altervista.org";
    private static final int PORT = 21;
    private static final String USER = "loggci16";
    private static final String PASS = "ingsw12a3v";
    private static final FTPClient FTP_CLIENT = new FTPClient();
    private static final DateFormat DATE_FORMATE = new SimpleDateFormat("yyyy-MM-dd");
    private static final Date DATE = new Date();
    private static final Object SYNC = new Object();
    
    static void setOperator(Operator o) {
        Log_Controller.o = o;
        string="User: "+o.getId();
    }

    private static void copyLog(File[] files) {
        try {
            FTP_CLIENT.connect(SERVER, PORT);
            FTP_CLIENT.login(USER, PASS);
            FTP_CLIENT.enterLocalPassiveMode();
            FTP_CLIENT.setFileType(FTP.BINARY_FILE_TYPE);
            FTP_CLIENT.changeWorkingDirectory("LOG");
            FTP_CLIENT.changeWorkingDirectory(""+o.getId());
            if (FTP_CLIENT.getReplyCode() == 550) {
                FTP_CLIENT.makeDirectory(""+o.getId());
                FTP_CLIENT.changeWorkingDirectory(""+o.getId());
            }
            synchronized(SYNC){
                File file = new File(TMP_DIR+"/GCI16/LOG/log");
                String remoteFile = file.getName()+"."+DATE_FORMATE.format(DATE);
                try (InputStream inputStream = new FileInputStream(file)) {
                    FTP_CLIENT.storeFile(remoteFile, inputStream);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (FTP_CLIENT.isConnected()) {
                    FTP_CLIENT.logout();
                    FTP_CLIENT.disconnect();
                }
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
        
    private Log_Controller() {
        
    }
    
    static void writeLog(String s, Class c){
        Logger log = Logger.getLogger(c.getName());
        new File(TMP_DIR+"/GCI16").mkdir();
        File file = new File(TMP_DIR+"/GCI16", "log4j.properties");
        if (!file.exists()) {
            try {
                Files.copy(CONFIG, file.getAbsoluteFile().toPath());
            } catch (IOException ex) {
                
            }
            
        }
        PropertyConfigurator.configure(TMP_DIR+"/GCI16/log4j.properties");
        synchronized(SYNC){
            log.info(string+s);
        }
        
        new Thread(){
            @Override
            public void run(){
                copyLog(new File("./LOG").listFiles());
            }
        }.start();
        
    }
}
