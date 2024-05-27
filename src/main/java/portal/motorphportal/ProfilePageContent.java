package portal.motorphportal;

import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfilePageContent extends JPanel {
    
    private JPanel profilePicturePanel, profileName;
    private JLabel lblProfileName;
    
    Resources rsc = new Resources();
    DBoperation DBops = new DBoperation();
    
    //private int userID = -1;
    //private String userFirstName = "";
    //private String userLastName = "";
    //private String userBirthday = "";
    
    ProfilePageContent(){
        LoadUserData();
        initialize();
    }
    
    
    public void LoadUserData(){
        //List<User> user = DBops.LoadUsersData();
        //if(user != null){}
    }
    
    
    public void initialize(){
        
        // >>> Test for geting info from CSV file. Delete after <<< //
        User user = DBops.LoadUsersData("j.lopez", "lopez12345qwert");
        String userLastName = user.getLastName();

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
        lblProfileName.setText(userLastName);
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
