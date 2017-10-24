/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Injuction_MYSQL;
import Model.Bill;
import Model.Contract;
import Model.Injuction;
import View.InjuctionsHistory;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ansan
 */
public class InjuctionsHistory_Controller implements Controller {
    private final Contract contract;
    private final Registry_Controller reg;
    private Database_Controller dbManager;
    private InjuctionsHistory view;
    private List<Injuction> injuctions;
    private final DefaultTableCellRenderer defaultRender;
    private Controller current;
    
    InjuctionsHistory_Controller(Registry_Controller reg, Contract contract) {
        view=new InjuctionsHistory();
        view.setSize();
        view.setVisible(true);
        this.contract=contract;
        this.reg=reg;
        defaultRender = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object
                    value, boolean isSelected, boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(JLabel.CENTER);
                    return this;
                }
            };
        try {
            dbManager=Database_Controller.getDbManager();
            initTable();

            view.addActionListener(new Listener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCliked((Component)e.getSource());            
            }
            });

            view.addMouseListener(new Listener(){
                @Override
                public void mouseClicked(MouseEvent e){
                    tableClicked();
                }
            });
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }    
    }

    private void buttonCliked(Component component) {
        int i = view.checkButton(component);
        switch(i){
            case 1: buildPDFClicked();break;
            case 2: view.dispose(); reg.back(); break;
        }
    }

    private void tableClicked() {
        Integer injuctionCont = view.getInjuctionCount();
        if(injuctionCont>0){
            Integer injuction=view.getSelectedInjuction();
            if(injuction>=0 && injuction<injuctions.size()){
                Injuction temp = injuctions.get(injuction);
                Bill ref = temp.getBill();
                view.setBillsPeriod(ref.getPeriod());
                Date dueDate = ref.getDeadline();
                view.setBillsDue(dueDate.toString());
                Float detectionValue = ref.getDetectionValue();
                view.setDetectionValue(detectionValue.toString());
                Date paymentDate = ref.getPaymentDate();
                if(paymentDate != null)
                    view.setPaymentDate(paymentDate.toString());
                view.enableBuildPDFButton(true);
            }
            else
                JOptionPane.showConfirmDialog(view, "Invalid Selection from the table","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buildPDFClicked() {
        int i=view.getSelectedInjuction();
        Injuction b;
        if(i>=0 && i<injuctions.size()){
            b= injuctions.get(i);
            view.dispose();
            current = new ConfirmInjuction_Controller(b,this);
        }
        else
            JOptionPane.showConfirmDialog(view, "Invalid Selection from the table","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
    }

    private void initTable() {
        DefaultTableModel model = view.getInjuctionsTableModel();
        String[] columns = {"Contract ID", "Reference bill", "Expired from", "Arrears"};
        model.setColumnIdentifiers(columns);
        Injuction_MYSQL dao = new Injuction_MYSQL(dbManager);
        try {
                injuctions=dao.getAllDocuments(contract);

            for(Injuction temp : injuctions){
                Object[] row = {temp.getContractID(), temp.getBillID(), temp.getExpiredFrom(), Float.valueOf(temp.getArrears().replace(',', '.'))};
                model.addRow(row);
                setDefaultRender(view.getInjuctionsTable());
            }
            } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage(),"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setDefaultRender(JTable table) {
        TableColumnModel tableModel = table.getColumnModel();
        TableColumn tableColumn;
        Integer columns = table.getColumnCount();
        if(table.getColumnName(columns-1).equals("Selected"))
            columns--;
        for(Integer i = 0; i < columns; i++){
            tableColumn = tableModel.getColumn(i);
            tableColumn.setCellRenderer(defaultRender);
        }
    }

    void back() {
        view.setVisible(true);
    }
    
}
