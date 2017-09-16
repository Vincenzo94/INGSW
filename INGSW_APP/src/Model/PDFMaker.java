package Model;

import java.io.File;
import java.io.IOException;
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
        templateDirectory = System.getProperty("user.dir") + "\\images\\template.jpg";
        tmpDirectory = System.getProperty("user.dir") + "\\tmp";
        //creates the "tmp" directory if it doesn't exists
        new File(tmpDirectory).mkdir();
        if(!new File(templateDirectory).exists()){
            status = false;
            throw new RuntimeException("\"template.jpg\" path is not valid");
        }
        status = true;
    }
    public boolean createPDF(Contract contract){
        /*
        pre-conditions:
        - PDFMaker state must be valid (directoriesValidity = true)
        - Cliente must not be null
        
        post-conditions:
        - returns true if it creates a PDF
        */
        String filepath = tmpDirectory + "\\" + contract.getId() + ".pdf";
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
            drawPDF(printStream, template, contract);
            
            //saving and closing
            printStream.close();
            bill.save(filepath);
            bill.close();
            isCreated = true;
        }
        catch (IOException e){
            System.out.println("Missing items for the bill's creating. The operation will be interrupted.");
        }
        return isCreated;
    }
    private void drawPDF(PDPageContentStream printStream, PDImageXObject template, Contract contract) throws IOException{
        /*
        pre-conditions:
        - status must be on true

        post-conditions:
        - the PDFFile is drawn and ready to be saved
        */
        
        //inserting template
        printStream.drawImage(template, -40F, -400F);
        //startText
        printStream.beginText();
        //setting parameters
        printStream.newLineAtOffset(25, 700);
        printStream.setFont(PDType1Font.TIMES_ROMAN, 11);
        printStream.setLeading(10F);
        //writing
        printStream.showText(contract.getName());
        printStream.newLine();
        //end text
        printStream.endText();
    }
}
