package View;

import Model.Document;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout; 
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class BuildPDF extends JFrame{
    private String filePath;
    private SwingController controller;
    private SwingViewBuilder factory;
    private JPanel viewerComponentPanel;
    private JButton sendPDFButton;
    private JButton cancelButton;
    private final List<ActionListener> actionListener;
    private final String TMP_DIR = System.getProperty("java.io.tmpdir");
    private final String PATH = TMP_DIR+"/INGSW_GR12";
    
    public BuildPDF(){
        
        initComponents();
        actionListener = new LinkedList<>();
        Toolkit tk = Toolkit.getDefaultToolkit();  
        Dimension screenSize = tk.getScreenSize();
        int xSize = ((int) screenSize.getWidth());  
        int ySize = ((int) screenSize.getHeight());  
        this.setSize(xSize,ySize);
    }
    public void setPDF(Document doc){
        this.filePath = PATH+"/"+doc.getContractID()+".pdf";
        controller.openDocument(filePath);
    }
    private void sendPDFButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        for(ActionListener a: actionListener)
            a.actionPerformed(evt);
    }
    public void addActionListener(ActionListener a){
        actionListener.add(a);
    }    
    private void initComponents(){
        this.setUndecorated(true);
        this.setExtendedState(6);
        Toolkit tk = Toolkit.getDefaultToolkit();  
        Dimension screenSize = tk.getScreenSize();
        int xSize = ((int) screenSize.getWidth());  
        int ySize = ((int) screenSize.getHeight());  
        this.setSize(xSize,ySize);
        this.setAlwaysOnTop(true);
        sendPDFButton = new JButton();
        cancelButton = new JButton();
        controller = new SwingController();
        //factory
        factory = new SwingViewBuilder(controller);
        
        //button
        sendPDFButton.setText("Send PDF");
        sendPDFButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendPDFButtonActionPerformed(evt);
            }
        });
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        
        //viewer
        viewerComponentPanel = factory.buildViewerPanel();
        ComponentKeyBinding.install(controller, viewerComponentPanel);
        viewerComponentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("PDF preview"));
        controller.getDocumentViewController().setAnnotationCallback(
            new org.icepdf.ri.common.MyAnnotationCallback(
                controller.getDocumentViewController()));
        //viewerComponentPanel.setSize(600, 400);        
        
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
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        pack();
    }

    public Integer checkButton(Component j) {
        if(j == sendPDFButton)
            return 3;
        else
            return 1;
    }
}
