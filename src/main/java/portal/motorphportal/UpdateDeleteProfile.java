package portal.motorphportal;

import java.awt.Color;
import javax.swing.JPanel;



public class UpdateDeleteProfile extends JPanel {
    
    Resources rsc = new Resources();
    UserService UserSVC = new UserService();
    
    UpdateDeleteProfile(){
        initialize();
    }
    
    public void initialize() {
        
        this.setBackground(Color.red);
        //this.setBackground(rsc.PrimaryColor());
        this.setSize(rsc.BodyContentPageWidth(), rsc.BodyContentPageHeight());
        this.setLayout(null);
        
    }
    
}
