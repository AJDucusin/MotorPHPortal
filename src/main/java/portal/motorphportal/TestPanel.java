package portal.motorphportal;

import java.awt.Color;
import javax.swing.JPanel;

// to Delete this Test Panel

public class TestPanel extends JPanel{
    
    TestPanel() {
        initialize();
    }
    
    public void initialize(){
        JPanel panel = new JPanel();
        
        panel.setBackground(Color.red);
        panel.setSize(200, 200);
    }
    
}
