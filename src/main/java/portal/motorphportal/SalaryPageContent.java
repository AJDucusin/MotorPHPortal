package portal.motorphportal;

import com.toedter.calendar.JCalendar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SalaryPageContent extends JPanel {
    
    private String imagePath = "C:\\Users\\Abdul-JohariDucusin\\OneDrive - Paynamics Technologies Inc\\Desktop\\MotorPHPortal\\img\\";
    
    private JPanel clockPanel;
    private JLabel lblSearch, lblFrom, lblTo;
    private JCalendar salaryCalendar;
    
    Resources rsc = new Resources();
    DBoperation DBops = new DBoperation();
    
    SalaryPageContent(String usernameInput, String passwordInput) {
        initialize();
    }
    
    public void initialize() {
        
        this.setBackground(rsc.PrimaryColor());
        this.setSize(rsc.ProfilePageWidth(), rsc.ProfilePageHeight());
        this.setLayout(null);
        
        //clockPanel = new JPanel();
        //clockPanel.setBackground(rsc.AccentColor());
        //clockPanel.setSize(400, 300);
        //clockPanel.setBounds(0, 0, 250, 156);
        //clockPanel.setLayout(null);
        
        salaryCalendar = new JCalendar();
        salaryCalendar.setBounds((rsc.ProfilePageWidth()-rsc.ProfilePictureWidth()), 0, rsc.ProfilePictureWidth(), rsc.ProfilePictureHeight()-50);
        
        lblSearch = new JLabel();
        lblSearch.setText("Search Salary by Date");
        //lblSearch.setOpaque(true);
        //lblSearch.setBackground(Color.BLUE);
        lblSearch.setFont(rsc.MainFont());
        lblSearch.setForeground(rsc.PrimaryTextColor());
        lblSearch.setBounds(0, 0, rsc.ProfilePictureWidth()*3, rsc.BodyPanelHeight()/16);
        lblSearch.setHorizontalAlignment(JLabel.CENTER);
        lblSearch.setVerticalAlignment(JLabel.CENTER);
        
        lblFrom = new JLabel();
        lblFrom.setText("From: ");
        lblFrom.setOpaque(true);
        lblFrom.setBackground(Color.BLUE);
        lblFrom.setFont(rsc.MainFont());
        lblFrom.setForeground(rsc.PrimaryColor());
        lblFrom.setBounds(0, rsc.BodyPanelHeight()/16, (rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/16);
        lblFrom.setHorizontalAlignment(JLabel.LEFT);
        lblFrom.setVerticalAlignment(JLabel.CENTER);
        
        lblTo = new JLabel();
        lblTo.setText("To: ");
        lblTo.setOpaque(true);
        lblTo.setBackground(Color.GREEN);
        lblTo.setFont(rsc.MainFont());
        lblTo.setForeground(rsc.PrimaryColor());
        lblTo.setBounds((rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/16, (rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/16);
        lblTo.setHorizontalAlignment(JLabel.LEFT);
        lblTo.setVerticalAlignment(JLabel.CENTER);
        
        
        this.add(salaryCalendar);
        this.add(lblSearch);
        this.add(lblFrom);
        this.add(lblTo);
    }
    
}