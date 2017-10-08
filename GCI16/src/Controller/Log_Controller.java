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
import java.util.logging.Level;
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
    private static final InputStream config = Log_Controller.class.getResourceAsStream("/GCI16/log4j.properties");
    private static final String TMP_DIR = System.getProperty("java.io.tmpdir");
    private static final String server = "loggci16.altervista.org";
    private static final int port = 21;
    private static final String user = "loggci16";
    private static final String pass = "ingsw12a3v";
    private static final FTPClient ftpClient = new FTPClient();
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final Date date = new Date();
    static void setOperator(Operator o) {
        Log_Controller.o = o;
        string="User: "+o.getId();
    }

    private static void copyLog(File[] files) {
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.changeWorkingDirectory(""+o.getId());
            if (ftpClient.getReplyCode() == 550) {
                ftpClient.makeDirectory(""+o.getId());
                ftpClient.changeWorkingDirectory(""+o.getId());
            }
            File file = new File("./LOG/log");
            String remoteFile = file.getName()+"."+dateFormat.format(date);
            InputStream inputStream = new FileInputStream(file);
            boolean done = ftpClient.storeFile(remoteFile, inputStream);
            inputStream.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
        
    private Log_Controller() {
        
    }
    
    public static void writeLog(String s, Class c){
        Logger log = Logger.getLogger(c.getName());
        new File(TMP_DIR+"/GCI16").mkdir();
        File file = new File(TMP_DIR+"/GCI16", "log4j.properties");
        if (!file.exists()) {
           
            try {
                Files.copy(config, file.getAbsoluteFile().toPath());
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Log_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        PropertyConfigurator.configure(TMP_DIR+"/GCI16/log4j.properties");
        log.info(string+s);
        
        new Thread(){
            public void run(){
                copyLog(new File("./LOG").listFiles());
            }
        }.start();
        
    }
}
