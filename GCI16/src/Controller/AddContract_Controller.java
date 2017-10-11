/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.Contract_MYSQL;
import DAO.DAO_Contract;
import Model.Contract;
import View.AddHolder;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Andrea
 */
public class AddContract_Controller implements Controller{
    private AddHolder view;
    private final Registry_Controller controller;
    private Contract contract;
    private final String success = "New contract added";
    private final String error = "No contract added";
    

    public AddContract_Controller(Registry_Controller controller){
        this.controller=controller;
        view= new AddHolder();
        view.setVisible(true);
        view.addActionListener(new Listener(this){
            @Override
            public void actionPerformed(ActionEvent e) {
                AddContract_Controller m = (AddContract_Controller)controller;
                m.buttonClicked((Component)e.getSource());
            }
        });
    }

    private void buttonClicked(Component j){
        int i=view.checkButton(j);
        if(i==1){
            view.dispose();
            controller.back();
        }
        else{
            createClicked();
        }
    }
    
    private void createClicked(){
        Database_Controller dbManager = null;
        
        try {
            dbManager = Database_Controller.getDbManager();        
            DAO_Contract daoContract = new Contract_MYSQL(dbManager);
            String billingCity = view.getCity1(),
                   billingDistrict = view.getDistrict1(),
                   billingZip = view.getZip1(),
                   billingStreet = view.getStreet1(),
                   name=view.getPersonName(),
                   surname=view.getSurname(),
                   taxc=view.getTaxC(),
                   phone=view.getPhone(),
                   email=view.getEmail(),
                   mobile=view.getMobile(),
                   city=view.getCity2(),
                   district=view.getDistrict2(),
                   zip=view.getZip2(),
                   street=view.getStreet2(),
                   number=view.getNumber1(),
                   number2=view.getNumber2();
            if(!name.matches("[[a-z]|[A-Z]]*") || !surname.matches("[[a-z]|[A-Z]]*") || !taxc.matches("[[a-z]|[0-9]]*") || !city.matches("[[a-z]|[A-Z]]*") || !district.matches("[[a-z]|[A-Z]]*") || !street.matches("[[a-z]|[A-Z]]*") || !phone.matches("[0-9]*") || !mobile.matches("[0-9]*") || !zip.matches("[0-9]*") || !number.matches("[0-9]*") || !number2.matches("[0-9]*") || !email.matches("[[0-9]|[a-z]|[A-Z]|[_|\\-|.]]*"))
                throw new SQLException("Invalid characters");
            if(billingCity.equals("") && billingDistrict.equals("") && billingZip.equals("") && billingStreet.equals(""))
                contract = new Contract(name,surname,taxc,phone,email,mobile,city,district,zip,street,Integer.valueOf(number2));
            else
                contract = new Contract(name,surname,taxc,phone,email,mobile,city,district,zip,street,Integer.valueOf(number2), billingCity, billingDistrict, billingZip, billingStreet, Integer.valueOf(number));
            daoContract.create(contract,controller.getOperator());
            Log_Controller.writeLog(" creates a new contract with the Tax Code "+contract.getTaxCode(),AddContract_Controller.class);
            JOptionPane.showConfirmDialog(view, success,"Info",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
            controller.back();
        }catch (SQLException ex) {
            JOptionPane.showConfirmDialog(view, ex.getMessage()+"\n"+error,"Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
