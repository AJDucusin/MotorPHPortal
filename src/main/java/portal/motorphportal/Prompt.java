package portal.motorphportal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Prompt extends JPanel implements ActionListener {
    
    private JLabel lblMessage;
    private JButton btnOK;
    private UpdateDeleteProfile parentPanel;
    
    Resources rsc = new Resources();
    
    public Prompt() {
        this.parentPanel = parentPanel;
        initialize();
    }
    
    public void initialize() {
        
        this.setBackground(rsc.SecondaryColor());
        this.setBounds((rsc.BodyContentPageWidth()/2)-200, (rsc.BodyContentPageHeight()/2)-125, 400, 250);
        this.setLayout(null);
        
        lblMessage = new JLabel();
        lblMessage.setText("User not found!");
        lblMessage.setFont(rsc.MainFont());
        lblMessage.setForeground(rsc.SecondaryTextColor());
        lblMessage.setBounds(0, 10, 400, rsc.bcTextHeight());
        lblMessage.setHorizontalAlignment(JLabel.CENTER);
        
        btnOK = new JButton("Ok");
        btnOK.addActionListener(this);
        btnOK.setBackground(rsc.SecondaryColor());
        btnOK.setForeground(rsc.PrimaryTextColor());
        btnOK.setFocusable(false);
        btnOK.setBounds(200-(rsc.bcTextWidth()/2), 200-rsc.bcTextHeight(), rsc.bcTextWidth(), rsc.bcTextHeight());
        
        
        this.add(lblMessage);
        this.add(btnOK);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btnOK){
            parentPanel.HidePagesAndContent();
            this.setVisible(false);
        }
        
    }
    
}
