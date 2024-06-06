package portal.motorphportal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class UpdateDeleteProfile extends JPanel implements ActionListener {
    
    //private JPanel prompt; // <<< (promt class) saka ko nalang pag-iisipan kung pano paganahin. . .
    private JLabel lblSearchById, lblLastName, lblFirstName, lblBirthday, lblAddress, lblPhone, lblSss, lblTIN, lblPagibig, lblPhilhealth;
    private JTextField tfSearchID, tfLastName, tfFirstName, tfBirthday, tfAddress, tfPhone, tfSss, tfTIN, tfPagibig, tfPhilhealth;
    private JButton btnSearchUser, btnClearField, btnEditUser, btnDeleteUser;
    
    Resources rsc = new Resources();
    UserService UserSVC = new UserService();
    
    UpdateDeleteProfile(){
        initialize();
    }
    
    public void initialize() {
        
        //this.setBackground(Color.red);
        this.setBackground(rsc.PrimaryColor());
        this.setSize(rsc.BodyContentPageWidth(), rsc.BodyContentPageHeight());
        this.setLayout(null);
        
        
        /* ******** Search By ID Start ******** */
        lblSearchById = new JLabel();
        lblSearchById.setText("Search By ID: ");
        lblSearchById.setFont(rsc.MainFont());
        lblSearchById.setForeground(rsc.PrimaryTextColor());
        lblSearchById.setBounds(0, 0, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblSearchById.setHorizontalAlignment(JLabel.CENTER);
        lblSearchById.setVerticalAlignment(JLabel.CENTER);
        
        tfSearchID = new JTextField();
        tfSearchID.setFont(rsc.MainFont());
        tfSearchID.setForeground(rsc.InputTextColor());
        tfSearchID.setBorder(null);
        tfSearchID.setBounds(rsc.bcTextWidth(), 5, rsc.bcTextWidth()/3, rsc.bcTextHeight()-10);
        tfSearchID.setHorizontalAlignment(JLabel.CENTER);
        
        btnSearchUser = new JButton("Generate");
        btnSearchUser.addActionListener(this);
        btnSearchUser.setBackground(rsc.SecondaryColor());
        btnSearchUser.setForeground(rsc.PrimaryTextColor());
        btnSearchUser.setFocusable(false);
        btnSearchUser.setFont(rsc.SecondaryFont());
        btnSearchUser.setBounds(rsc.bcTextWidth()*2, 0, rsc.bcTextWidth(), rsc.bcTextHeight());
        
        btnClearField = new JButton("Clear");
        btnClearField.addActionListener(this);
        btnClearField.setBackground(rsc.SecondaryColor());
        btnClearField.setForeground(rsc.PrimaryTextColor());
        btnClearField.setFocusable(false);
        btnClearField.setFont(rsc.SecondaryFont());
        btnClearField.setBounds((rsc.bcTextWidth()*3)+10, 0, rsc.bcTextWidth(), rsc.bcTextHeight());
        /* ******** Search By ID Ends ******** */
        
        
        
        /* ******** Lastname Starts ******** */
        lblLastName = new JLabel();
        lblLastName.setText("Lastname: ");
        lblLastName.setFont(rsc.MainFont());
        lblLastName.setForeground(rsc.PrimaryTextColor());
        lblLastName.setBounds(0, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblLastName.setHorizontalAlignment(JLabel.CENTER);
        lblLastName.setVerticalAlignment(JLabel.CENTER);
        
        tfLastName = new JTextField();
        tfLastName.setText("");
        tfLastName.setFont(rsc.MainFont());
        tfLastName.setForeground(rsc.InputTextColor());
        tfLastName.setBorder(null);
        tfLastName.setBounds(rsc.bcTextWidth(), (rsc.bcTextHeight()*2)+5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        tfLastName.setHorizontalAlignment(JLabel.CENTER);
        /* ******** Lastname Ends ******** */
        
        /* ******** Firstname Starts ******** */
        lblFirstName = new JLabel();
        lblFirstName.setText("Firstname: ");
        lblFirstName.setFont(rsc.MainFont());
        lblFirstName.setForeground(rsc.PrimaryTextColor());
        lblFirstName.setBounds(rsc.bcTextWidth()*2, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblFirstName.setHorizontalAlignment(JLabel.CENTER);
        lblFirstName.setVerticalAlignment(JLabel.CENTER);
        
        tfFirstName = new JTextField();
        tfFirstName.setText("");
        tfFirstName.setFont(rsc.MainFont());
        tfFirstName.setForeground(rsc.InputTextColor());
        tfFirstName.setBorder(null);
        tfFirstName.setBounds(rsc.bcTextWidth()*3, (rsc.bcTextHeight()*2)+5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        tfFirstName.setHorizontalAlignment(JLabel.CENTER);
        /* ******** Firstname Ends ******** */
        
        /* ******** Birthday Starts ******** */
        lblBirthday = new JLabel();
        lblBirthday.setText("Birthday: ");
        lblBirthday.setFont(rsc.MainFont());
        lblBirthday.setForeground(rsc.PrimaryTextColor());
        lblBirthday.setBounds(rsc.bcTextWidth()*4, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblBirthday.setHorizontalAlignment(JLabel.CENTER);
        lblBirthday.setVerticalAlignment(JLabel.CENTER);
        
        tfBirthday = new JTextField();
        tfBirthday.setText("");
        tfBirthday.setFont(rsc.MainFont());
        tfBirthday.setForeground(rsc.InputTextColor());
        tfBirthday.setBorder(null);
        tfBirthday.setBounds(rsc.bcTextWidth()*5, (rsc.bcTextHeight()*2)+5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        tfBirthday.setHorizontalAlignment(JLabel.CENTER);
        /* ******** Birthday Ends ******** */
        
        /* ******** Address Starts ******** */
        lblAddress = new JLabel();
        lblAddress.setText("Address: ");
        lblAddress.setFont(rsc.MainFont());
        lblAddress.setForeground(rsc.PrimaryTextColor());
        lblAddress.setBounds(0, rsc.bcTextHeight()*3, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblAddress.setHorizontalAlignment(JLabel.CENTER);
        lblAddress.setVerticalAlignment(JLabel.CENTER);
        
        tfAddress = new JTextField();
        tfAddress.setText("");
        tfAddress.setFont(rsc.MainFont());
        tfAddress.setForeground(rsc.InputTextColor());
        tfAddress.setBorder(null);
        tfAddress.setBounds(rsc.bcTextWidth(), (rsc.bcTextHeight()*3)+5, rsc.bcTextWidth()*3, rsc.bcTextHeight()-10);
        tfAddress.setHorizontalAlignment(JLabel.CENTER);
        /* ******** Address Ends ******** */
        
        /* ******** Phone Starts ******** */
        lblPhone = new JLabel();
        lblPhone.setText("Phone Number: ");
        lblPhone.setFont(rsc.MainFont());
        lblPhone.setForeground(rsc.PrimaryTextColor());
        lblPhone.setBounds(rsc.bcTextWidth()*4, rsc.bcTextHeight()*3, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblPhone.setHorizontalAlignment(JLabel.CENTER);
        lblPhone.setVerticalAlignment(JLabel.CENTER);
        
        tfPhone = new JTextField();
        tfPhone.setText("");
        tfPhone.setFont(rsc.MainFont());
        tfPhone.setForeground(rsc.InputTextColor());
        tfPhone.setBorder(null);
        tfPhone.setBounds(rsc.bcTextWidth()*5, (rsc.bcTextHeight()*3)+5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        tfPhone.setHorizontalAlignment(JLabel.CENTER);
        /* ******** Phone Ends ******** */
        
        /* ******** SSS Starts ******** */
        lblSss = new JLabel();
        lblSss.setText("SSS: ");
        lblSss.setFont(rsc.MainFont());
        lblSss.setForeground(rsc.PrimaryTextColor());
        lblSss.setBounds(0, rsc.bcTextHeight()*5, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblSss.setHorizontalAlignment(JLabel.CENTER);
        lblSss.setVerticalAlignment(JLabel.CENTER);
        
        tfSss = new JTextField();
        tfSss.setText("");
        tfSss.setFont(rsc.MainFont());
        tfSss.setForeground(rsc.InputTextColor());
        tfSss.setBorder(null);
        tfSss.setBounds(rsc.bcTextWidth(), (rsc.bcTextHeight()*5)+5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        tfSss.setHorizontalAlignment(JLabel.CENTER);
        /* ******** SSS Ends ******** */
        
        /* ******** Tin Starts ******** */
        lblTIN = new JLabel();
        lblTIN.setText("TIN: ");
        lblTIN.setFont(rsc.MainFont());
        lblTIN.setForeground(rsc.PrimaryTextColor());
        lblTIN.setBounds(rsc.bcTextWidth()*3, rsc.bcTextHeight()*5, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblTIN.setHorizontalAlignment(JLabel.CENTER);
        lblTIN.setVerticalAlignment(JLabel.CENTER);
        
        tfTIN = new JTextField();
        tfTIN.setText("");
        tfTIN.setFont(rsc.MainFont());
        tfTIN.setForeground(rsc.InputTextColor());
        tfTIN.setBorder(null);
        tfTIN.setBounds(rsc.bcTextWidth()*4, (rsc.bcTextHeight()*5)+5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        tfTIN.setHorizontalAlignment(JLabel.CENTER);
        /* ******** Tin Ends ******** */
        
        /* ******** Pagibig Starts ******** */
        lblPagibig = new JLabel();
        lblPagibig.setText("Pag-ibig: ");
        lblPagibig.setFont(rsc.MainFont());
        lblPagibig.setForeground(rsc.PrimaryTextColor());
        lblPagibig.setBounds(0, rsc.bcTextHeight()*6, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblPagibig.setHorizontalAlignment(JLabel.CENTER);
        lblPagibig.setVerticalAlignment(JLabel.CENTER);
        
        tfPagibig = new JTextField();
        tfPagibig.setText("");
        tfPagibig.setFont(rsc.MainFont());
        tfPagibig.setForeground(rsc.InputTextColor());
        tfPagibig.setBorder(null);
        tfPagibig.setBounds(rsc.bcTextWidth(), (rsc.bcTextHeight()*6)+5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        tfPagibig.setHorizontalAlignment(JLabel.CENTER);
        /* ******** Pagibig Ends ******** */
        
        /* ******** Philhealth Starts ******** */
        lblPhilhealth = new JLabel();
        lblPhilhealth.setText("Philhealth: ");
        lblPhilhealth.setFont(rsc.MainFont());
        lblPhilhealth.setForeground(rsc.PrimaryTextColor());
        lblPhilhealth.setBounds(rsc.bcTextWidth()*3, rsc.bcTextHeight()*6, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblPhilhealth.setHorizontalAlignment(JLabel.CENTER);
        lblPhilhealth.setVerticalAlignment(JLabel.CENTER);
        
        tfPhilhealth = new JTextField();
        tfPhilhealth.setText("");
        tfPhilhealth.setFont(rsc.MainFont());
        tfPhilhealth.setForeground(rsc.InputTextColor());
        tfPhilhealth.setBorder(null);
        tfPhilhealth.setBounds(rsc.bcTextWidth()*4, (rsc.bcTextHeight()*6)+5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        tfPhilhealth.setHorizontalAlignment(JLabel.CENTER);
        /* ******** Philhealth Ends ******** */
        
        
        /* ******** Edit Delete Button Start ******** */
        btnDeleteUser = new JButton("Delete");
        btnDeleteUser.addActionListener(this);
        btnDeleteUser.setBackground(rsc.SecondaryColor());
        btnDeleteUser.setForeground(rsc.PrimaryTextColor());
        btnDeleteUser.setFocusable(false);
        btnDeleteUser.setFont(rsc.SecondaryFont());
        btnDeleteUser.setBounds(0, rsc.BodyContentPageHeight()-rsc.bcTextHeight(), rsc.bcTextWidth(), rsc.bcTextHeight());
        
        btnEditUser = new JButton("Edit");
        btnEditUser.addActionListener(this);
        btnEditUser.setBackground(rsc.SecondaryColor());
        btnEditUser.setForeground(rsc.PrimaryTextColor());
        btnEditUser.setFocusable(false);
        btnEditUser.setFont(rsc.SecondaryFont());
        btnEditUser.setBounds(rsc.bcTextWidth(), rsc.BodyContentPageHeight()-rsc.bcTextHeight(), rsc.bcTextWidth(), rsc.bcTextHeight());
        /* ******** Edit Delete Button Ends ******** */
        
        
        /* ******** Prompt Initialize ******** */
        //prompt = new Prompt(); // <<< (promt class) saka ko nalang pag-iisipan kung pano paganahin. . .
        /* ******** Prompt Initialize ******** */
        
        
        this.add(lblSearchById);
        this.add(tfSearchID);
        this.add(btnSearchUser);
        this.add(btnClearField);
        this.add(btnDeleteUser);
        this.add(btnEditUser);
        this.add(lblLastName);
        this.add(tfLastName);
        this.add(lblFirstName);
        this.add(tfFirstName);
        this.add(lblBirthday);
        this.add(tfBirthday);
        this.add(lblAddress);
        this.add(tfAddress);
        this.add(lblPhone);
        this.add(tfPhone);
        this.add(lblSss);
        this.add(tfSss);
        this.add(lblTIN);
        this.add(tfTIN);
        this.add(lblPagibig);
        this.add(tfPagibig);
        this.add(lblPhilhealth);
        this.add(tfPhilhealth);
        
        //this.add(prompt); // <<< (promt class) saka ko nalang pag-iisipan kung pano paganahin. . .
        
        HidePagesAndContent();
    }

    public void HidePagesAndContent(){
        tfLastName.setVisible(false);
        tfFirstName.setVisible(false);
        tfBirthday.setVisible(false);
        tfAddress.setVisible(false);
        tfPhone.setVisible(false);
        tfSss.setVisible(false);
        tfTIN.setVisible(false);
        tfPagibig.setVisible(false);
        tfPhilhealth.setVisible(false);
        //prompt.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btnSearchUser){
            tfLastName.setVisible(true);
            tfFirstName.setVisible(true);
            tfBirthday.setVisible(true);
            tfAddress.setVisible(true);
            tfPhone.setVisible(true);
            tfSss.setVisible(true);
            tfTIN.setVisible(true);
            tfPagibig.setVisible(true);
            tfPhilhealth.setVisible(true);
            User users = UserSVC.LoadUsersDataByID(tfSearchID.getText());
            
            if(users != null){
                int empID = users.getId();
                tfLastName.setText(users.getLastName());
                tfFirstName.setText(users.getFirstName());
                tfBirthday.setText(users.getBirthday());
                tfAddress.setText(users.getAddress());
                tfPhone.setText(users.getPhone());
                tfSss.setText(users.getSss());
                tfTIN.setText(users.getTin());
                tfPagibig.setText(users.getPagibig());
                tfPhilhealth.setText(users.getPhilhealth());
            } else {
                //prompt.setVisible(true); // <<< (promt class) saka ko nalang pag-iisipan kung pano paganahin. . .
                //HidePagesAndContent();
                tfLastName.setText("Not found");
                tfFirstName.setText("Not found");
                tfBirthday.setText("Not found");
                tfAddress.setText("Not found");
                tfPhone.setText("Not found");
                tfSss.setText("Not found");
                tfTIN.setText("Not found");
                tfPagibig.setText("Not found");
                tfPhilhealth.setText("Not found");
            }
            
            
            /*
            if(users == null){
                tfLastName.setText("no record");
                tfFirstName.setText("no record");
            } else {
            */
                
            //}
        } else if(e.getSource()==btnClearField){
            tfLastName.setText(null);
            tfFirstName.setText(null);
            tfFirstName.setText(null);
            tfBirthday.setText(null);
            tfAddress.setText(null);
            tfPhone.setText(null);
            tfSss.setText(null);
            tfTIN.setText(null);
            tfPagibig.setText(null);
            tfPhilhealth.setText(null);
            HidePagesAndContent();
        }
        
        
        if(e.getSource()==btnEditUser){
            User getUserData = UserSVC.LoadUsersDataByID(tfSearchID.getText());
            String ogUsername = getUserData.getUsername();
            String ogPassword = getUserData.getPassword();
            String ogStatus = getUserData.getStatus();
            String ogDesignation = getUserData.getDesignation();
            String ogSupervisor = getUserData.getSupervisor();
            String ogBasicSalary = getUserData.getBasicSalary();
            String ogRiceSubsidy = getUserData.getRiceSubsidy();
            String ogPhoneAllowance = getUserData.getPhoneAllowance();
            String ogClothingAllowance = getUserData.getClothingAllowance();
            String ogGrossSemiMonthlyRate = getUserData.getGrossSemiMonthlyRate();
            String ogHourlyRate = getUserData.getHourlyRate();
            
            if(getUserData != null){
                String[] toUpdate = {
                    tfSearchID.getText(),
                    tfFirstName.getText(),
                    tfLastName.getText(),
                    ogUsername,
                    ogPassword,
                    tfBirthday.getText(),
                    tfAddress.getText(),
                    tfPhone.getText(),
                    tfSss.getText(),
                    tfTIN.getText(),
                    tfPagibig.getText(),
                    ogStatus,
                    ogDesignation,
                    ogSupervisor,
                    ogBasicSalary,
                    ogRiceSubsidy,
                    ogPhoneAllowance,
                    ogClothingAllowance,
                    ogGrossSemiMonthlyRate,
                    ogHourlyRate,
                    tfPhilhealth.getText()
                };
                UserSVC.UpdateUserData(tfSearchID.getText(), toUpdate);
            }
        }

        if(e.getSource()==btnDeleteUser){
            UserSVC.DeleteUserData(tfSearchID.getText());
            tfLastName.setText(null);
            tfFirstName.setText(null);
            tfFirstName.setText(null);
            tfBirthday.setText(null);
            tfAddress.setText(null);
            tfPhone.setText(null);
            tfSss.setText(null);
            tfTIN.setText(null);
            tfPagibig.setText(null);
            tfPhilhealth.setText(null);
            HidePagesAndContent();
        }
    
    }
    
}
