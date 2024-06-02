package portal.motorphportal;

import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SalaryPageContent extends JPanel implements ActionListener {
    
    private String imagePath = "C:\\Users\\ducus\\Desktop\\MotorPHPortal\\img\\";
    
    private JPanel clockPanel;
    private JLabel lblSearch, lblFrom, lblTo, lblOutputFrom, lblOutputTo;
    private JTextField TFfrom;
    private JCalendar salaryCalendar;
    private JButton getDateButton, BTNsetFromDate, btnGetFromDate, btnGetToDate;
    
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
        
        getDateButton = new JButton("Set Date");
        getDateButton.addActionListener(this);
        getDateButton.setBackground(rsc.SecondaryColor());
        getDateButton.setForeground(rsc.PrimaryTextColor());
        //loginButton.setBorder(null);
        getDateButton.setFont(rsc.SecondaryFont());
        getDateButton.setFocusable(false);
        getDateButton.setBounds((rsc.ProfilePageWidth()-rsc.ProfilePictureWidth()), rsc.ProfilePictureHeight()-50, rsc.ProfilePictureWidth(), 100);
        
        
        
        
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
        //lblFrom.setOpaque(true);
        //lblFrom.setBackground(Color.ORANGE);
        lblFrom.setFont(rsc.MainFont());
        lblFrom.setForeground(rsc.PrimaryTextColor());
        lblFrom.setBounds(0, rsc.BodyPanelHeight()/16, rsc.ProfilePictureWidth()/4, rsc.BodyPanelHeight()/16);
        lblFrom.setHorizontalAlignment(JLabel.RIGHT);
        lblFrom.setVerticalAlignment(JLabel.CENTER);
        
        lblOutputFrom = new JLabel();
        lblOutputFrom.setText("<date>");
        //lblOutputFrom.setOpaque(true);
        //lblOutputFrom.setBackground(Color.BLUE);
        lblOutputFrom.setFont(rsc.MainFont());
        lblOutputFrom.setForeground(rsc.PrimaryTextColor());
        lblOutputFrom.setBounds(rsc.ProfilePictureWidth()/4, rsc.BodyPanelHeight()/16, rsc.ProfilePictureWidth()-(rsc.ProfilePictureWidth()/4), rsc.BodyPanelHeight()/16);
        lblOutputFrom.setHorizontalAlignment(JLabel.CENTER);
        lblOutputFrom.setVerticalAlignment(JLabel.CENTER);
        
        btnGetFromDate = new JButton("Set");
        btnGetFromDate.addActionListener(this);
        btnGetFromDate.setBackground(rsc.SecondaryColor());
        btnGetFromDate.setForeground(rsc.PrimaryTextColor());
        //btnGetFromDate.setBorder(null);
        btnGetFromDate.setFont(rsc.SecondaryFont());
        btnGetFromDate.setFocusable(false);
        btnGetFromDate.setBounds(rsc.ProfilePictureWidth(), rsc.BodyPanelHeight()/16, rsc.ProfilePictureWidth()/4, rsc.BodyPanelHeight()/16);
        
        //TFfrom = new JTextField();
        //TFfrom.setFont(rsc.MainFont());
        //TFfrom.setForeground(rsc.InputTextColor());
        //TFfrom.setBorder(null);
        //TFfrom.setSize((rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/16);
        //TFfrom.setBounds((rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/16, (rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/16);
        
        
        
        lblTo = new JLabel();
        lblTo.setText("To: ");
        //lblTo.setOpaque(true);
        //lblTo.setBackground(Color.GREEN);
        lblTo.setFont(rsc.MainFont());
        lblTo.setForeground(rsc.PrimaryTextColor());
        lblTo.setBounds((rsc.ProfilePictureWidth()*3)/2, rsc.BodyPanelHeight()/16, rsc.ProfilePictureWidth()/4, rsc.BodyPanelHeight()/16);
        lblTo.setHorizontalAlignment(JLabel.RIGHT);
        lblTo.setVerticalAlignment(JLabel.CENTER);
        
        lblOutputTo = new JLabel();
        lblOutputTo.setText("<date>");
        //lblOutputTo.setOpaque(true);
        //lblOutputTo.setBackground(Color.BLUE);
        lblOutputTo.setFont(rsc.MainFont());
        lblOutputTo.setForeground(rsc.PrimaryTextColor());
        lblOutputTo.setBounds(((rsc.ProfilePictureWidth()*3)/2)+(rsc.ProfilePictureWidth()/4), rsc.BodyPanelHeight()/16, rsc.ProfilePictureWidth()-(rsc.ProfilePictureWidth()/4), rsc.BodyPanelHeight()/16);
        lblOutputTo.setHorizontalAlignment(JLabel.CENTER);
        lblOutputTo.setVerticalAlignment(JLabel.CENTER);
        
        btnGetToDate = new JButton("Set");
        btnGetToDate.addActionListener(this);
        btnGetToDate.setBackground(rsc.SecondaryColor());
        btnGetToDate.setForeground(rsc.PrimaryTextColor());
        //btnGetToDate.setBorder(null);
        btnGetToDate.setFont(rsc.SecondaryFont());
        btnGetToDate.setFocusable(false);
        btnGetToDate.setBounds(((rsc.ProfilePictureWidth()*3)/2+(rsc.ProfilePictureWidth()/4))+rsc.ProfilePictureWidth(), rsc.BodyPanelHeight()/16, rsc.ProfilePictureWidth()/4, rsc.BodyPanelHeight()/16);
        
        
        this.add(salaryCalendar);
        this.add(lblSearch);
        this.add(lblFrom);
        this.add(lblOutputFrom);
        this.add(btnGetFromDate);
        //this.add(TFfrom);
        this.add(lblTo);
        this.add(lblOutputTo);
        this.add(btnGetToDate);
        //this.add(getDateButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnGetFromDate){
            
            Date selectedDate = salaryCalendar.getDate();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd HH:mm");
            String formattedDate = dateFormatter.format(selectedDate);
            lblOutputFrom.setText(formattedDate);

        } else if(e.getSource()==btnGetToDate){
            
            Date selectedDate = salaryCalendar.getDate();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd HH:mm");
            String formattedDate = dateFormatter.format(selectedDate);
            lblOutputTo.setText(formattedDate);
            
        }
        
    }
    
}