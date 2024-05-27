package portal.motorphportal;

import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfilePageContent extends JPanel {
    
    private JPanel profilePicturePanel, profileName;
    private JLabel lblProfileName, lblSss, lblPhilhealthNum, sssOutput, lblTaxNum, lblPagibigNum, philhealthOutput, taxOutput, pagibigOutput;
    
    Resources rsc = new Resources();
    DBoperation DBops = new DBoperation();
    
    ProfilePageContent(String usernameInput, String passwordInput){
        initialize(usernameInput, passwordInput);
    }
    
    public void initialize(String usernameInput, String passwordInput){
        
        User user = DBops.LoadUsersData(usernameInput, passwordInput);
        String userLastName = user.getLastName();
        String userFirstName = user.getFirstName();
        String userSss = user.getSss();
        String userPhilhealth = user.getPhilhealth();
        String userTIN = user.getTin();
        String userPagibig = user.getPagibig();
        
        this.setBackground(rsc.PrimaryColor());
        this.setSize(rsc.ProfilePageWidth(), rsc.ProfilePageHeight());
        this.setLayout(null);
        
        profilePicturePanel = new JPanel();
        profilePicturePanel.setBackground(rsc.AccentColor());
        profilePicturePanel.setBounds(rsc.ProfilePictureWidth()*3, 0, rsc.ProfilePictureWidth(), rsc.ProfilePictureHeight());
        
        
        lblProfileName = new JLabel();
        lblProfileName.setText(userLastName +" " +userFirstName);
        lblProfileName.setFont(rsc.HeaderFont());
        lblProfileName.setForeground(rsc.PrimaryTextColor());
        lblProfileName.setBounds(0, 0, rsc.ProfilePictureWidth()*3, rsc.BodyPanelHeight()/8);
        lblProfileName.setHorizontalAlignment(JLabel.CENTER);
        lblProfileName.setVerticalAlignment(JLabel.CENTER);
        
        
        
        lblSss = new JLabel();
        lblSss.setText("SSS Number:");
        lblSss.setFont(rsc.MainFont());
        lblSss.setForeground(rsc.PrimaryTextColor());
        //lblSss.setOpaque(true);
        //lblSss.setBackground(Color.red);
        lblSss.setBounds(0, rsc.BodyPanelHeight()/8, (rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/8);
        lblSss.setHorizontalAlignment(JLabel.CENTER);
        lblSss.setVerticalAlignment(JLabel.CENTER);
        
        sssOutput = new JLabel();
        sssOutput.setText(userSss);
        sssOutput.setFont(rsc.MainFont());
        sssOutput.setForeground(rsc.PrimaryTextColor());
        //sssOutput.setOpaque(true);
        //sssOutput.setBackground(Color.red);
        sssOutput.setBounds((rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/8, (rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/8);
        sssOutput.setHorizontalAlignment(JLabel.CENTER);
        sssOutput.setVerticalAlignment(JLabel.CENTER);
        
        
        lblPhilhealthNum = new JLabel();
        lblPhilhealthNum.setText("Philhealth Number:");
        lblPhilhealthNum.setFont(rsc.MainFont());
        lblPhilhealthNum.setForeground(rsc.PrimaryTextColor());
        //lblPhilhealthNum.setOpaque(true);
        //lblPhilhealthNum.setBackground(Color.ORANGE);
        lblPhilhealthNum.setBounds(0, (rsc.BodyPanelHeight()/8)*2, (rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/8);
        lblPhilhealthNum.setHorizontalAlignment(JLabel.CENTER);
        lblPhilhealthNum.setVerticalAlignment(JLabel.CENTER);
        
        philhealthOutput = new JLabel();
        philhealthOutput.setText(userPhilhealth);
        philhealthOutput.setFont(rsc.MainFont());
        philhealthOutput.setForeground(rsc.PrimaryTextColor());
        //philhealthOutput.setOpaque(true);
        //philhealthOutput.setBackground(Color.red);
        philhealthOutput.setBounds((rsc.ProfilePictureWidth()*3)/2, (rsc.BodyPanelHeight()/8)*2, (rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/8);
        philhealthOutput.setHorizontalAlignment(JLabel.CENTER);
        philhealthOutput.setVerticalAlignment(JLabel.CENTER);
        
        
        lblTaxNum = new JLabel();
        lblTaxNum.setText("Tax Identification Number:");
        lblTaxNum.setFont(rsc.MainFont());
        lblTaxNum.setForeground(rsc.PrimaryTextColor());
        //lblTaxNum.setOpaque(true);
        //lblTaxNum.setBackground(Color.YELLOW);
        lblTaxNum.setBounds(0, (rsc.BodyPanelHeight()/8)*3, (rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/8);
        lblTaxNum.setHorizontalAlignment(JLabel.CENTER);
        lblTaxNum.setVerticalAlignment(JLabel.CENTER);
        
        taxOutput = new JLabel();
        taxOutput.setText(userTIN);
        taxOutput.setFont(rsc.MainFont());
        taxOutput.setForeground(rsc.PrimaryTextColor());
        //taxOutput.setOpaque(true);
        //taxOutput.setBackground(Color.red);
        taxOutput.setBounds((rsc.ProfilePictureWidth()*3)/2, (rsc.BodyPanelHeight()/8)*3, (rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/8);
        taxOutput.setHorizontalAlignment(JLabel.CENTER);
        taxOutput.setVerticalAlignment(JLabel.CENTER);
        
        
        lblPagibigNum = new JLabel();
        lblPagibigNum.setText("Pag-ibig Number:");
        lblPagibigNum.setFont(rsc.MainFont());
        lblPagibigNum.setForeground(rsc.PrimaryTextColor());
        //lblPagibigNum.setOpaque(true);
        //lblPagibigNum.setBackground(Color.CYAN);
        lblPagibigNum.setBounds(0, (rsc.BodyPanelHeight()/8)*4, (rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/8);
        lblPagibigNum.setHorizontalAlignment(JLabel.CENTER);
        lblPagibigNum.setVerticalAlignment(JLabel.CENTER);
        
        pagibigOutput = new JLabel();
        pagibigOutput.setText(userPagibig);
        pagibigOutput.setFont(rsc.MainFont());
        pagibigOutput.setForeground(rsc.PrimaryTextColor());
        //pagibigOutput.setOpaque(true);
        //pagibigOutput.setBackground(Color.red);
        pagibigOutput.setBounds((rsc.ProfilePictureWidth()*3)/2, (rsc.BodyPanelHeight()/8)*4, (rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/8);
        pagibigOutput.setHorizontalAlignment(JLabel.CENTER);
        pagibigOutput.setVerticalAlignment(JLabel.CENTER);
        
        
        this.add(profilePicturePanel);
        this.add(lblProfileName);
        this.add(lblSss);
        this.add(lblPhilhealthNum);
        this.add(lblTaxNum);
        this.add(lblPagibigNum);
        
        this.add(sssOutput);
        this.add(philhealthOutput);
        this.add(taxOutput);
        this.add(pagibigOutput);
    }
}