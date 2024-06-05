package portal.motorphportal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SalaryPageReport extends JPanel {
    
    private String userID, fromDate, toDate;
    
    private JLabel lblSalary;
    
    Resources rsc = new Resources();
    HRService HRSVC = new HRService();
    
    public SalaryPageReport(String userIDinput, String fromDateInput, String toDateInput) {
        this.userID = userIDinput;
        this.fromDate = fromDateInput;
        this.toDate = toDateInput;
        
        initialize(userID, fromDate, toDate);
    }
    
    public void initialize(String userID, String fromDate, String toDate ){
        
        this.setBackground(Color.red);
        this.setBounds(0, rsc.ProfilePictureHeight()-50, rsc.BodyContentPageWidth(), rsc.BodyContentPageHeight()-(rsc.ProfilePictureHeight()-50));
        this.setLayout(null);
        
        HRService hrSVC = new HRService();
        double salary = hrSVC.ComputeSalary(userID, fromDate, toDate);
        String convertedSalary = String.valueOf(salary);
        
        
        lblSalary = new JLabel();
        lblSalary.setText(convertedSalary);
        lblSalary.setOpaque(true);
        lblSalary.setBackground(Color.ORANGE);
        lblSalary.setFont(rsc.MainFont());
        lblSalary.setForeground(rsc.PrimaryTextColor());
        lblSalary.setBounds(0, rsc.BodyPanelHeight() / 16, rsc.bcTextWidth()*2, rsc.bcTextHeight());
        lblSalary.setHorizontalAlignment(JLabel.RIGHT);
        lblSalary.setVerticalAlignment(JLabel.CENTER);
        
        this.add(lblSalary);
        
    }
    
}
