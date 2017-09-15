package Model;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
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
    private final String sender;
    private final String psw;
    private final String host;
    private final String basicPath;
    private Properties props;
    private Session session;
    
    public EMailSender(){
        sender = "ingsw.gr12@gmail.com";
        psw = "hxegtqrhgueywops";
        host = "smtp.gmail.com";
        basicPath = System.getProperty("user.dir") + "\\tmp";
        
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");
        session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(sender, psw);
                }
            }
        );
    }
    public boolean sendEmail(Client client){
        /*
        pre-conditions:
        - receiver's email must be valid
        
        post-conditions:
        - it sends the email to receiver
        */
        boolean result = false;
        String documentName = client.getId() + ".pdf";
        
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(client.getEmailAddress()));
            message.setSubject("Bill");
            
            message.setContent(createMultipartMessage(documentName));
            
            System.out.println("Prima dell invio");
            Transport.send(message);
            System.out.println("Messaggio inviato");
            result = true;
        }
        catch(MessagingException e){
            System.out.println("Receiver's email is not valid");
        }
        return result;
    }
    private Multipart createMultipartMessage(String documentName){
        /*
        pre-conditions:
        - Document must exists
        
        post-conditions:
        - this methods creates a message ready to be sent
        */
        String absolutePath = basicPath + "\\" + documentName;
        if(!new File(absolutePath).exists())
            throw new RuntimeException("Document doesn't exists.");
        
        Multipart multipart = null;
        try{
            multipart = new MimeMultipart();
            File file = new File(absolutePath);
            BodyPart text = new MimeBodyPart();
            ((MimeBodyPart) text).setText("TESTO");
            BodyPart attached = new MimeBodyPart();
            ((MimeBodyPart) attached).attachFile(file);
            attached.setFileName(documentName);
            //unisco allegato e testo al messaggio
            multipart.addBodyPart(attached);
            multipart.addBodyPart(text);
        }
        catch(MessagingException m){
            m.printStackTrace();
        }
        catch(IOException i){
            i.printStackTrace();
        }
        return multipart;
    }/*
    public static void main(String[] args){
        EMailSender e = new EMailSender();
        if(e.sendEmail(new Client()))
            System.out.println("well done");
    }
*/
}

