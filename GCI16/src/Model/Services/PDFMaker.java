package Model.Services;

import Model.Bill;
import Model.Contract;
import Model.Injuction;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
/**
 *
 * @author Andrea
 */
public class PDFMaker{
    private static boolean status;
    private static String templateDirectory;
    private static String tmpDirectory;
    private static PDFMaker instance;
    private final static Boolean[] RET = {true};
    private final static String TMP_DIR = System.getProperty("java.io.tmpdir");

    private PDFMaker() throws IOException{
        /*
        pre-conditions: 
        - the "images" directory must exists and it must contains the "template.jpg" file.
        
        post-conditions:
        - status is setted on "true".
        */
        RET[0] = true;
        tmpDirectory =  TMP_DIR+"/GCI16";
        templateDirectory = tmpDirectory+"/template.jpg";

        new File(tmpDirectory).mkdir();
        File file = new File(tmpDirectory, "template.jpg");
        if (!file.exists()) {
            InputStream is = (getClass().getResourceAsStream("/Image/template.jpg"));
            Files.copy(is, file.getAbsoluteFile().toPath());
        }
        if(!new File(templateDirectory).exists()){
            status = false;
            throw new RuntimeException("\"template.jpg\" path is not valid");
        }
        
        //creates the "tmp" directory if it doesn't exists
       
        status = true;
    }
    
    public static boolean createPDF(Map<Bill,Contract> bills){
        for(Bill b: bills.keySet())
            new Thread(){
                @Override
                public void run(){
                    if(!createPDF(bills.get(b),b,null)){
                        synchronized(RET){
                            RET[0] = false;
                        }
                    }
                }
            }.start();
        return RET[0];
    }
    /*
    pre-conditions:
    - PDFMaker state must be valid (directoriesValidity = true)
    - Cliente must not be null

    post-conditions:
    - returns true if it creates a PDF
    */
    synchronized public static boolean createPDF(Contract contract, Bill billObject, Injuction injunction) {
        if(instance == null)
            try {
                instance = new PDFMaker();
        } catch (IOException ex) {
            Logger.getLogger(PDFMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        String filepath;
        if(injunction!=null)
            filepath = tmpDirectory + "/injuction_" + contract.getId() + ".pdf";
        else
            filepath = tmpDirectory + "/bill_" + contract.getId() + ".pdf";

        boolean isCreated = false;

        if(!status)
            throw new RuntimeException("PDFMaker state is not valid");
        if(contract == null)
            throw new RuntimeException("Contract is null");
        if(new File(filepath).exists()){
            return true;
        }
        
        try{
            PDDocument bill;
            bill = new PDDocument();
            PDPage page = new PDPage();
            bill.addPage(page);
            PDImageXObject template = PDImageXObject.createFromFile(templateDirectory, bill);
            PDPageContentStream printStream;
            printStream = new PDPageContentStream(bill, page);
            
            //drawingPDF
            drawPDF(printStream, template, contract, billObject, injunction);
            
            //saving and closing
            printStream.close();
            bill.save(filepath);
            bill.close();
            isCreated = true;
        }
        catch (IOException e){
            System.out.println("Error in the bill's creating. The operation will be interrupted.("+e.getMessage()+")");
        }
        return isCreated;
    }
    
    /*
    pre-conditions:
    - status must be on true

    post-conditions:
    - the PDFFile is drawn and ready to be saved
    */    
    private static void drawPDF(PDPageContentStream printStream, PDImageXObject template, Contract contract, Bill bill, Injuction injunction) throws IOException{
        float totalAmount = bill.getTotal();
        if(injunction != null)
            totalAmount += Float.parseFloat(injunction.getArrears());
        //inserting template
        printStream.drawImage(template,0F, 0F, 615F, 795F);
        //startText
        printStream.beginText();
        //setting parameters
        printStream.newLineAtOffset(75, 690);
        printStream.setFont(PDType1Font.COURIER, 9);
        printStream.setLeading(10F);
        //writing
        printStream.newLine();
        printStream.newLine();
        printStream.showText(contract.getName() + " " + contract.getSurname());
        printStream.newLine();
        printStream.showText(contract.getStreet());
        printStream.newLine();
        printStream.showText(contract.getDistrict());
        printStream.newLine();
        printStream.showText(contract.getCity());
        printStream.newLine();
        printStream.showText(contract.getZip());
        printStream.newLine();
        //end text
        printStream.endText();
        
        printStream.beginText();
        printStream.newLineAtOffset(425, 690);
        printStream.setFont(PDType1Font.COURIER, 12);
        printStream.setLeading(10F);
        printStream.showText("" + contract.getId());
        printStream.newLine();
        printStream.newLine();
        printStream.newLine();
        printStream.showText("" + bill.getDeadline());
        printStream.endText();
        
        printStream.beginText();
        printStream.newLineAtOffset(75, 495);
        printStream.setFont(PDType1Font.HELVETICA, 20);
        printStream.setLeading(10F);
        printStream.showText(" " + bill.getPeriod());
        printStream.endText();
        
        printStream.beginText();
        printStream.newLineAtOffset(73, 410);
        printStream.setFont(PDType1Font.COURIER, 9);
        printStream.setLeading(11F);
        printStream.showText(contract.getStreet() + ", " + contract.getDistrict());
        printStream.newLine();
        printStream.showText(contract.getCity() + ", " + contract.getZip());
        if(contract.getEmailAddress() != null){
            printStream.newLine();
            printStream.showText(contract.getEmailAddress());
        }
        printStream.newLine();
        if(contract.getPhone() != null){
            printStream.showText(contract.getPhone());
            if(contract.getMobile() != null)
                printStream.showText(" - " + contract.getMobile());
        }
        if(contract.getTaxCode() != null){
            printStream.newLine();
            printStream.showText(contract.getTaxCode());
        }
        printStream.newLine();
        printStream.newLine();
        if(contract.getBillingAddress() != null){
            printStream.showText("Billing address:");
            printStream.newLine();
            printStream.showText(contract.getBillingStreet() + ", " + contract.getBillingDistrict());
            printStream.newLine();
            printStream.showText(contract.getBillingCity() + ", " + contract.getBillingZip());
            printStream.newLine();
        }
        printStream.endText();
        
        if(injunction != null){
            printStream.beginText();
            printStream.newLineAtOffset(245, 410);
            printStream.setFont(PDType1Font.COURIER_BOLD, 9);
            printStream.setLeading(11F);
            printStream.showText("Injunction reffered");
            printStream.newLine();
            printStream.showText("to bill: " + injunction.getBillID());
            printStream.newLine();
            printStream.showText("Arrears: " + injunction.getArrears());
            printStream.endText();
        }
        
        printStream.beginText();
        printStream.newLineAtOffset(425, 410);
        printStream.setFont(PDType1Font.COURIER, 35);
        printStream.setLeading(10F);
        printStream.showText("" + String.format("%.2f",totalAmount));
        printStream.endText();
        
        printStream.beginText();
        printStream.newLineAtOffset(440, 370);
        printStream.setFont(PDType1Font.COURIER_BOLD, 9);
        printStream.setLeading(10F);
        printStream.showText("" + bill.getDeadline());
        printStream.endText();
        
        printStream.beginText();
        printStream.newLineAtOffset(180, 130);
        printStream.setFont(PDType1Font.COURIER, 9);
        printStream.setLeading(11F);
        printStream.showText("" + contract.getId());
        printStream.endText();
        
        printStream.beginText();
        printStream.newLineAtOffset(380, 130);
        printStream.setFont(PDType1Font.COURIER, 9);
        printStream.setLeading(11F);
        printStream.showText("" + String.format("%.2f",totalAmount));
        printStream.endText();
        
        printStream.beginText();
        printStream.newLineAtOffset(139, 107);
        printStream.setFont(PDType1Font.COURIER, 9);
        printStream.setLeading(11F);
        Random r = new Random();
        for(int i = 0; i < 20; i++)
            printStream.showText("" + r.nextInt(10));
        printStream.endText();
    }
}
