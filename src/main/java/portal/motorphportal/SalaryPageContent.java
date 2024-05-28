package portal.motorphportal;

import java.awt.Color;
import javax.swing.JPanel;


public class SalaryPageContent extends JPanel {
    
    private String imagePath = "C:\\Users\\Abdul-JohariDucusin\\OneDrive - Paynamics Technologies Inc\\Desktop\\MotorPHPortal\\img\\";
    
    Resources rsc = new Resources();
    DBoperation DBops = new DBoperation();
    
    SalaryPageContent(String usernameInput, String passwordInput) {
        initialize();
    }
    
    public void initialize() {
        
        this.setBackground(Color.RED);
        this.setSize(rsc.ProfilePageWidth(), rsc.ProfilePageHeight());
        this.setLayout(null);
        
    }
    
}