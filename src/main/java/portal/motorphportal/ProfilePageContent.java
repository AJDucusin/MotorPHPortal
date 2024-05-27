package portal.motorphportal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfilePageContent extends JPanel {
    
    private JPanel profilePicturePanel, profileName;
    private JLabel lblProfileName;
    
    Resources rsc = new Resources();
    DBoperation DBops = new DBoperation();
    
    ProfilePageContent(){
        initialize();
    }
    
    public void initialize(){
        
        // >>> Test for geting info from CSV file. Delete after <<< //
        int TestOutputByDBops = DBops.GetIDbyUsernamePassword("j.lopez", "lopez12345qwert");
        String ConvertedTestOutputByDBops = String.valueOf(TestOutputByDBops);
        // >>> Test for geting info from CSV file. Delete after <<< //
        
        this.setBackground(rsc.PrimaryColor());
        this.setSize(rsc.ProfilePageWidth(), rsc.ProfilePageHeight());
        this.setLayout(null);
        
        profilePicturePanel = new JPanel();
        profilePicturePanel.setBackground(rsc.AccentColor());
        profilePicturePanel.setBounds(rsc.ProfilePictureWidth()*3, 0, rsc.ProfilePictureWidth(), rsc.ProfilePictureHeight());
        
        //profileName = new JPanel();
        //profileName.setBackground(Color.MAGENTA);
        //profileName.setBounds(0, 0, rsc.ProfilePictureWidth()*3, rsc.BodyPanelHeight()/8);
        
        
        lblProfileName = new JLabel();
        // >>> Test for geting info from CSV file. Delete after <<< //
        if(TestOutputByDBops == -1){
            lblProfileName.setText("Ducusin, Abdul-Johari");
        } else {
            lblProfileName.setText(ConvertedTestOutputByDBops);
        }
        // >>> Test for geting info from CSV file. Delete after <<< //
        lblProfileName.setFont(rsc.HeaderFont());
        lblProfileName.setForeground(rsc.PrimaryTextColor());
        lblProfileName.setBounds(0, 0, rsc.ProfilePictureWidth()*3, rsc.BodyPanelHeight()/8);
        lblProfileName.setHorizontalAlignment(JLabel.CENTER);
        lblProfileName.setVerticalAlignment(JLabel.CENTER);
        
        
        this.add(profilePicturePanel);
        //this.add(profileName);
        this.add(lblProfileName);
        
        
    }
    
}
