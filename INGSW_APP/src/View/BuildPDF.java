package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout; 
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class BuildPDF extends JFrame{
    private final String filePath;
    private SwingController controller;
    private SwingViewBuilder factory;
    private JPanel viewerComponentPanel;
    private JButton sendPDFButton;
    private JButton cancelButton;
    
    public BuildPDF(String filePath){
        this.filePath = filePath;
        initComponents();
    }
    private void initComponents(){
        sendPDFButton = new JButton();
        cancelButton = new JButton();
        controller = new SwingController();
        //factory
        factory = new SwingViewBuilder(controller);
        
        //button
        sendPDFButton.setText("Send PDF");
        cancelButton.setText("Cancel");
        
        //viewer
        viewerComponentPanel = factory.buildViewerPanel();
        ComponentKeyBinding.install(controller, viewerComponentPanel);
        viewerComponentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("PDF preview"));
        controller.getDocumentViewController().setAnnotationCallback(
            new org.icepdf.ri.common.MyAnnotationCallback(
                controller.getDocumentViewController()));
        viewerComponentPanel.setSize(600, 400);        
        
        //frame
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(viewerComponentPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sendPDFButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewerComponentPanel,200,400,800)                   
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendPDFButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        
        controller.openDocument(filePath);
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                String pathProva = "C:/Users/Andrea/Desktop/API Apache PDFBox/provaDocumenti/prova2.pdf";
                new BuildPDF(pathProva).setVisible(true);
            }
        });
    }
}
