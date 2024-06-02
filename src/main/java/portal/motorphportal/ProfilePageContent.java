package portal.motorphportal;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfilePageContent extends JPanel {
    
    private String imagePath = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\img\\";
    private String imageCount = "0";
    
    private JPanel profilePicturePanel, profileName;
    private JLabel lblProfileName, lblSss, lblPhilhealthNum, sssOutput, lblTaxNum, lblPagibigNum, philhealthOutput, taxOutput, pagibigOutput, profilePictureContainer, lblAddress, addressOutput, designationOutput;
    private ImageIcon profilePicture, scaledProfilePicture;
    
    Resources rsc = new Resources();
    DBoperation DBops = new DBoperation();
    
    ProfilePageContent(String usernameInput, String passwordInput){
        initialize(usernameInput, passwordInput);
    }
    
    public void initialize(String usernameInput, String passwordInput){
        
        User user = DBops.LoadUsersData(usernameInput, passwordInput);
        String userID = String.valueOf(user.getId());
        imageCount = userID;
        String userLastName = user.getLastName();
        String userFirstName = user.getFirstName();
        String userSss = user.getSss();
        String userPhilhealth = user.getPhilhealth();
        String userTIN = user.getTin();
        String userPagibig = user.getPagibig();
        String userDesignation = user.getDesignation();
        String userAddress = user.getAddress();
        
        this.setBackground(rsc.PrimaryColor());
        this.setSize(rsc.ProfilePageWidth(), rsc.ProfilePageHeight());
        this.setLayout(null);
        
        
        // >>> Profile Picture <<< //
        profilePicturePanel = new JPanel();
        profilePicturePanel.setBackground(rsc.AccentColor());
        profilePicturePanel.setBounds(rsc.ProfilePictureWidth()*3, 0, rsc.ProfilePictureWidth(), rsc.ProfilePictureHeight());
        profilePicturePanel.setLayout(null);
        
        //Ito ang mag vavalidate kung existing ang image file
        File imageFile = new File((imagePath +imageCount +".png"));
        if(!imageFile.exists()){
            imageCount = "0";
        }
        profilePicture = new ImageIcon(imagePath +imageCount +".png");
        //Ito ang responsible sa pag autoscale ng image para mag kasya sa profilePicturePanel
        Image originalImage = profilePicture.getImage();
        Image scaledImage = originalImage.getScaledInstance(rsc.ProfilePictureWidth(), rsc.ProfilePictureHeight(), Image.SCALE_DEFAULT);
        scaledProfilePicture = new ImageIcon(scaledImage);
        
        profilePictureContainer = new JLabel();
        profilePictureContainer.setIcon(scaledProfilePicture);
        profilePictureContainer.setBounds(0, 0, rsc.ProfilePictureWidth(), rsc.ProfilePictureHeight());
        profilePictureContainer.setHorizontalAlignment(JLabel.CENTER);
        profilePictureContainer.setVerticalAlignment(JLabel.CENTER);
        profilePictureContainer.setIconTextGap(0);
        // >>> Profile Picture <<< //
        
        
        lblProfileName = new JLabel();
        lblProfileName.setText(userLastName +", " +userFirstName);
        lblProfileName.setFont(rsc.HeaderFont());
        lblProfileName.setForeground(rsc.PrimaryTextColor());
        lblProfileName.setBounds(0, 0, rsc.ProfilePictureWidth()*3, rsc.BodyPanelHeight()/8);
        lblProfileName.setHorizontalAlignment(JLabel.CENTER);
        lblProfileName.setVerticalAlignment(JLabel.CENTER);
        
        
        // ********************* SSS ********************* //
        lblSss = new JLabel();
        lblSss.setText("SSS Number:");
        lblSss.setFont(rsc.MainFont());
        //lblSss.setOpaque(true);
        //lblSss.setBackground(Color.RED);
        lblSss.setForeground(rsc.PrimaryTextColor());
        lblSss.setBounds(0, rsc.BodyPanelHeight()/8, rsc.ProfilePictureWidth()-10, rsc.BodyPanelHeight()/16);
        lblSss.setHorizontalAlignment(JLabel.RIGHT);
        lblSss.setVerticalAlignment(JLabel.CENTER);
        
        sssOutput = new JLabel();
        sssOutput.setText(userSss);
        sssOutput.setFont(rsc.MainFont());
        //sssOutput.setOpaque(true);
        //sssOutput.setBackground(Color.DARK_GRAY);
        sssOutput.setForeground(rsc.PrimaryTextColor());
        sssOutput.setBounds(rsc.ProfilePictureWidth()+10, rsc.BodyPanelHeight()/8, (rsc.ProfilePictureWidth()*2)-10, rsc.BodyPanelHeight()/16);
        sssOutput.setHorizontalAlignment(JLabel.LEFT);
        sssOutput.setVerticalAlignment(JLabel.CENTER);
        // ********************* SSS ********************* //
        
        
        // ********************* PhilHealth ********************* //
        lblPhilhealthNum = new JLabel();
        lblPhilhealthNum.setText("Philhealth Number:");
        lblPhilhealthNum.setFont(rsc.MainFont());
        //lblPhilhealthNum.setOpaque(true);
        //lblPhilhealthNum.setBackground(Color.ORANGE);
        lblPhilhealthNum.setForeground(rsc.PrimaryTextColor());
        lblPhilhealthNum.setBounds(0, (rsc.BodyPanelHeight()*3)/16, rsc.ProfilePictureWidth()-10, rsc.BodyPanelHeight()/16);
        lblPhilhealthNum.setHorizontalAlignment(JLabel.RIGHT);
        lblPhilhealthNum.setVerticalAlignment(JLabel.CENTER);
        
        philhealthOutput = new JLabel();
        philhealthOutput.setText(userPhilhealth);
        philhealthOutput.setFont(rsc.MainFont());
        //philhealthOutput.setOpaque(true);
        //philhealthOutput.setBackground(Color.GREEN);
        philhealthOutput.setForeground(rsc.PrimaryTextColor());
        philhealthOutput.setBounds(rsc.ProfilePictureWidth()+10, (rsc.BodyPanelHeight()*3)/16, (rsc.ProfilePictureWidth()*2)-10, rsc.BodyPanelHeight()/16);
        philhealthOutput.setHorizontalAlignment(JLabel.LEFT);
        philhealthOutput.setVerticalAlignment(JLabel.CENTER);
        // ********************* PhilHealth ********************* //
        
        
        // ********************* Tax ********************* //
        lblTaxNum = new JLabel();
        lblTaxNum.setText("Tax Identification Number:");
        lblTaxNum.setFont(rsc.MainFont());
        //lblTaxNum.setOpaque(true);
        //lblTaxNum.setBackground(Color.YELLOW);
        lblTaxNum.setForeground(rsc.PrimaryTextColor());
        lblTaxNum.setBounds(0, rsc.BodyPanelHeight()/4, rsc.ProfilePictureWidth()-10, rsc.BodyPanelHeight()/16);
        lblTaxNum.setHorizontalAlignment(JLabel.RIGHT);
        lblTaxNum.setVerticalAlignment(JLabel.CENTER);
        
        taxOutput = new JLabel();
        taxOutput.setText(userTIN);
        taxOutput.setFont(rsc.MainFont());
        //taxOutput.setOpaque(true);
        //taxOutput.setBackground(Color.PINK);
        taxOutput.setForeground(rsc.PrimaryTextColor());
        taxOutput.setBounds(rsc.ProfilePictureWidth()+10, rsc.BodyPanelHeight()/4, (rsc.ProfilePictureWidth()*2)-10, rsc.BodyPanelHeight()/16);
        taxOutput.setHorizontalAlignment(JLabel.LEFT);
        taxOutput.setVerticalAlignment(JLabel.CENTER);
        // ********************* Tax ********************* //
        
        
        // ********************* Pagibig ********************* //
        lblPagibigNum = new JLabel();
        lblPagibigNum.setText("Pag-ibig Number:");
        lblPagibigNum.setFont(rsc.MainFont());
        //lblPagibigNum.setOpaque(true);
        //lblPagibigNum.setBackground(Color.GREEN);
        lblPagibigNum.setForeground(rsc.PrimaryTextColor());
        lblPagibigNum.setBounds(0, (rsc.BodyPanelHeight()*5)/16, rsc.ProfilePictureWidth()-10, rsc.BodyPanelHeight()/16);
        lblPagibigNum.setHorizontalAlignment(JLabel.RIGHT);
        lblPagibigNum.setVerticalAlignment(JLabel.CENTER);
        
        pagibigOutput = new JLabel();
        pagibigOutput.setText(userPagibig);
        pagibigOutput.setFont(rsc.MainFont());
        pagibigOutput.setForeground(rsc.PrimaryTextColor());
        pagibigOutput.setBounds(rsc.ProfilePictureWidth()+10, (rsc.BodyPanelHeight()*5)/16, (rsc.ProfilePictureWidth()*2)-10, rsc.BodyPanelHeight()/16);
        pagibigOutput.setHorizontalAlignment(JLabel.LEFT);
        pagibigOutput.setVerticalAlignment(JLabel.CENTER);
        // ********************* Pagibig ********************* //
        
        
        // ********************* Address ********************* //
        lblAddress = new JLabel();
        lblAddress.setText("Address:");
        lblAddress.setFont(rsc.MainFont());
        //lblAddress.setOpaque(true);
        //lblAddress.setBackground(Color.RED);
        lblAddress.setForeground(rsc.PrimaryTextColor());
        lblAddress.setBounds(0, (rsc.BodyPanelHeight()*3)/8, rsc.ProfilePictureWidth()-10, rsc.BodyPanelHeight()/16);
        lblAddress.setHorizontalAlignment(JLabel.RIGHT);
        lblAddress.setVerticalAlignment(JLabel.CENTER);
        
        addressOutput = new JLabel();
        addressOutput.setText(userAddress);
        addressOutput.setFont(rsc.MainFont());
        addressOutput.setForeground(rsc.PrimaryTextColor());
        addressOutput.setBounds(rsc.ProfilePictureWidth()+10, (rsc.BodyPanelHeight()*3)/8, (rsc.ProfilePictureWidth()*2)-10, rsc.BodyPanelHeight()/16);
        addressOutput.setHorizontalAlignment(JLabel.LEFT);
        addressOutput.setVerticalAlignment(JLabel.CENTER);
        // ********************* Address ********************* //
        
        
        designationOutput = new JLabel();
        designationOutput.setText(userDesignation);
        designationOutput.setFont(rsc.MainFont());
        designationOutput.setForeground(rsc.PrimaryTextColor());
        designationOutput.setOpaque(true);
        designationOutput.setBackground(rsc.SecondaryColor());
        designationOutput.setBounds(rsc.ProfilePictureWidth()*3, rsc.ProfilePictureHeight(), rsc.ProfilePictureWidth(), rsc.BodyPanelHeight()/16);
        designationOutput.setHorizontalAlignment(JLabel.CENTER);
        designationOutput.setVerticalAlignment(JLabel.CENTER);
        
        
        
        this.add(profilePicturePanel);
        profilePicturePanel.add(profilePictureContainer);
        this.add(lblProfileName);
        this.add(lblSss);
        this.add(lblPhilhealthNum);
        this.add(lblTaxNum);
        this.add(lblPagibigNum);
        this.add(lblAddress);
        this.add(designationOutput);
        
        this.add(sssOutput);
        this.add(philhealthOutput);
        this.add(taxOutput);
        this.add(pagibigOutput);
        this.add(addressOutput);
    }
}