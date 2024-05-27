package portal.motorphportal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

// to Delete this Test Panel

public class TestPanel extends JPanel{
    
    private JLabel lblTest;
    
    Resources rsc = new Resources();
    
    TestPanel() {
        initialize();
    }
    
    public void initialize(){
        //JPanel panel = new JPanel();
        
        this.setBackground(Color.red);
        this.setSize(250, 50);
        
        
        lblTest = new JLabel();
        lblTest.setText("This is a test");
        lblTest.setFont(rsc.MainFont());
        //lblTest.setBounds(100, 100, 0, 0);
        
        this.add(lblTest);
    }
    
}
