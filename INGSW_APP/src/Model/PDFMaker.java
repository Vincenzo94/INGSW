package Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

/*
NOTE:
- la classe "Cliente" l'ho usata come stub per settare la classe PDFMaker, al suo posto andranno
passate le classi da cui verranno recuperati i dati da scrivere sulla bolletta.
La scrittura avverrà tramite il metodo "drawImage".

- va modificato il sequence. Non viene ritornato un oggetto di tipo "PDF" ma un booleano
che dice se è stato creato o meno.
In più la classe PDFMaker è stata salvata come <<interface>>. Renderla interfaccia
è inutile visto che avrà sempre lo stesso comportamento in ogni caso. (o nel caso dell'entity boundary control resta così??)

- modifica da fare: distinzione tra generazione ingiunzione e bolletta
bolletta: il nome file sarà bill_clientID.pdf
ingiunzione: il nome sarà injunction_clientID.pdf
*/
public class PDFMaker {
    private final boolean status;
    private final String templateDirectory;
    private final String tmpDirectory;
    
    public PDFMaker(){
        /*
        pre-conditions: 
        - the "images" directory must exists and it must contains the "template.jpg" file.
        
        post-conditions:
        - status is setted on "true".
        */
        templateDirectory ="././images/template.jpg";
        System.out.println(templateDirectory);
        tmpDirectory = "././tmp";
        //creates the "tmp" directory if it doesn't exists
        new File(tmpDirectory).mkdir();
        if(!new File(templateDirectory).exists()){
            status = false;
            throw new RuntimeException("\"template.jpg\" path is not valid");
        }
        status = true;
    }
    public boolean createPDF(Contract contract, Bill billObject, Injuction injunction){
        /*
        pre-conditions:
        - PDFMaker state must be valid (directoriesValidity = true)
        - Cliente must not be null
        
        post-conditions:
        - returns true if it creates a PDF
        */
        String filepath = tmpDirectory + "/" + contract.getId() + ".pdf";
        try {
            Files.deleteIfExists(Paths.get(filepath));
        } catch (IOException ex) {
            Logger.getLogger(PDFMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean isCreated = false;

        if(!status)
            throw new RuntimeException("PDFMaker state is not valid");
        if(contract == null)
            throw new RuntimeException("Contract is null");
        if(new File(filepath).exists()){
            throw new RuntimeException("Another file with the same name already exists.");
        }
        
        try{
            PDDocument bill = new PDDocument();
            PDPage page = new PDPage();
            bill.addPage(page);
            PDImageXObject template = PDImageXObject.createFromFile(templateDirectory, bill);
            PDPageContentStream printStream = new PDPageContentStream(bill, page);
            
            //drawingPDF
            drawPDF(printStream, template, contract, billObject, injunction);
            
            //saving and closing
            printStream.close();
            bill.save(filepath);
            bill.close();
            isCreated = true;
        }
        catch (IOException e){
            System.out.println("Error in the bill's creating. The operation will be interrupted.");
        }
        return isCreated;
    }
    private void drawPDF(PDPageContentStream printStream, PDImageXObject template, Contract contract, Bill bill, Injuction injunction) throws IOException{
        /*
        pre-conditions:
        - status must be on true

        post-conditions:
        - the PDFFile is drawn and ready to be saved
        */
        
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
        printStream.newLine();
        printStream.showText(contract.getEmailAddress());
        printStream.newLine();
        printStream.showText(contract.getPhone() + " - " + contract.getMobile());
        printStream.newLine();
        printStream.showText(contract.getTaxCode());
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
        printStream.showText("€ " + totalAmount);
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
        printStream.showText("€ " + totalAmount);
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
