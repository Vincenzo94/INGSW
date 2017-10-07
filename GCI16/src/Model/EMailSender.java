package Model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
Per testare questa classe ho creato una classe stub "Cliente" che contiene i dati
che poi recupereremo dalle classi del nostro progetto

-modifiche da fare: distinzione tra invio ingiunzione e bolletta
tra ingiunzione e bolletta cambierà il soggetto e la ricerca del file.
le ingiunzioni saranno del tipo: injuncion_clientID.pdf
le bollette saranno del tipo bill_clientID.pdf
*/

public class EMailSender {

    private final static String SENDER = "ingsw.gr12@gmail.com";
    private final static String PSW = "hxegtqrhgueywops";
    private final static String HOST = "smtp.gmail.com";
    private final static String TMP_DIR = System.getProperty("java.io.tmpdir");
    private final static String PATH = TMP_DIR+"/GCI16";
    private final static Properties PROPS = new Properties(){
        {
            this.put("mail.smtp.auth", "true");
            this.put("mail.smtp.starttls.enable", "true");
            this.put("mail.smtp.host", HOST);
            this.put("mail.smtp.port", "25");
            this.put("mail.smtp.starttls.enable", "true"); 

        }
    };
    private final static Session session=Session.getInstance(PROPS,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SENDER, PSW);
                }
            }
        );
    private static Integer cont=0;
    private final static Object sync=new Object();

    
    private EMailSender(){
    }
    
    public static Map<Integer,String> sendEmail(Map<Bill,Contract> bills, Class<?> obj) {
        if(!(obj.equals(Bill.class) || (obj.equals(Injuction.class))))
            throw new RuntimeException("Object.class not valid");
        
        final Map<Integer,String> results = new HashMap<>();
        for(Bill b: bills.keySet()){
            Contract c = bills.get(b);
            new Thread(){
                @Override
                public void run(){
                    String result = sendEmail(c, obj);
                    synchronized(results){
                        results.put(c.getId(),result);
                    }
                    synchronized(sync){
                        cont++;
                        sync.notifyAll();
                    }
                }
            }.start();
        }
        while(cont<bills.size()){
            synchronized(sync){
                try {
                    sync.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(EMailSender.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return results;
    }

    public static String sendEmail(Contract contract, Class<?> obj){
        /*
        pre-conditions:
        - receiver's email must be valid
        - obj must be "Bill.class" or "Injuction.class"
        
        post-conditions:
        - it sends the email to receiver
        */
        String result = "Error sending eMail to "+contract.getEmailAddress()+" ("+contract.getId()+")";
        String documentName = contract.getId() + ".pdf";
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(contract.getEmailAddress()));
            if(obj.equals(Bill.class))
                message.setSubject("Bill");
            else
                message.setSubject("Injunction");

            message.setContent(createMultipartMessage(documentName, obj));

            Transport.send(message);

            result = null;
        }
        catch(MessagingException e){
            System.out.println(e.getMessage());
            System.out.println("Receiver's email is not valid");
        }
        return result;
    }
    static private Multipart createMultipartMessage(String documentName, Class<?> obj){
        /*
        pre-conditions:
        - Document must exists
        - obj must be "Bill.class" or "Injuction.class"
        
        post-conditions:
        - this methods creates a message ready to be sent
        */
        String absolutePath = PATH + "/" + documentName;
        if(!new File(absolutePath).exists())
            throw new RuntimeException("Document doesn't exists.");
        
        String mailDescription = "Dear costumer,\n in this mail you can found your ";
        if(obj.equals(Bill.class))
            mailDescription += "bill ";
        else
            mailDescription += "injunction ";
        mailDescription += " as attachment.\n\nThis is an automatically generated email, please do not reply.";
        Multipart multipart = null;
        try{
            multipart = new MimeMultipart();
            File file = new File(absolutePath);
            BodyPart text = new MimeBodyPart();
            ((MimeBodyPart) text).setText(mailDescription);
            BodyPart attached = new MimeBodyPart();
            ((MimeBodyPart) attached).attachFile(file);
            attached.setFileName(documentName);
            //unisco allegato e testo al messaggio
            multipart.addBodyPart(attached);
            multipart.addBodyPart(text);
        }
        catch(MessagingException | IOException m){
        }
        return multipart;
    }
}