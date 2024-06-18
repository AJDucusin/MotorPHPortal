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
    
    private String userIdInput;
    
    private JPanel clockPanel;
    private SalaryPageReport salaryPageReport;
    private JLabel lblSearch, lblFrom, lblTo, lblOutputFrom, lblOutputTo;
    private JTextField TFfrom;
    private JCalendar salaryCalendar;
    private JButton getDateButton, BTNsetFromDate, btnGetFromDate, btnGetToDate, btnGeneratePayslip;
    
    Resources rsc = new Resources();
    UserService UserSVC = new UserService();
    
    public SalaryPageContent(String userId) {
        this.userIdInput = userId;
        
        initialize(userId);
    }
    
    public void initialize(String userId) {
        
        
        this.setBackground(rsc.PrimaryColor());
        this.setSize(rsc.BodyContentPageWidth(), rsc.BodyContentPageHeight());
        this.setLayout(null);
        
        
        salaryCalendar = new JCalendar();
        salaryCalendar.setBounds((rsc.BodyContentPageWidth()-rsc.ProfilePictureWidth()), 0, rsc.ProfilePictureWidth(), rsc.ProfilePictureHeight()-50);
        
        getDateButton = new JButton("Set Date");
        getDateButton.addActionListener(this);
        getDateButton.setBackground(rsc.SecondaryColor());
        getDateButton.setForeground(rsc.PrimaryTextColor());
        //loginButton.setBorder(null);
        getDateButton.setFont(rsc.SecondaryFont());
        getDateButton.setFocusable(false);
        getDateButton.setBounds((rsc.BodyContentPageWidth()-rsc.ProfilePictureWidth()), rsc.ProfilePictureHeight()-50, rsc.ProfilePictureWidth(), 100);
        
        
        lblSearch = new JLabel();
        lblSearch.setText("Search Salary by Date");
        lblSearch.setFont(rsc.MainFont());
        lblSearch.setForeground(rsc.PrimaryTextColor());
        lblSearch.setBounds(0, 0, rsc.bcTextWidth()*7, rsc.bcTextHeight());
        lblSearch.setHorizontalAlignment(JLabel.CENTER);
        lblSearch.setVerticalAlignment(JLabel.CENTER);
        
        
        // ********** From (Group) ********** //
        lblFrom = new JLabel();
        lblFrom.setText("From: ");
        lblFrom.setOpaque(true);
        lblFrom.setBackground(rsc.PrimaryColor());
        lblFrom.setFont(rsc.MainFont());
        lblFrom.setForeground(rsc.PrimaryTextColor());
        lblFrom.setBounds(0, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblFrom.setHorizontalAlignment(JLabel.CENTER);
        lblFrom.setVerticalAlignment(JLabel.CENTER);
        
        lblOutputFrom = new JLabel();
        lblOutputFrom.setText("");
        lblOutputFrom.setFont(rsc.MainFont());
        lblOutputFrom.setForeground(rsc.PrimaryTextColor());
        lblOutputFrom.setBounds(rsc.bcTextWidth(), rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblOutputFrom.setHorizontalAlignment(JLabel.LEFT);
        lblOutputFrom.setVerticalAlignment(JLabel.CENTER);
        String selectedFromDate = lblOutputFrom.getText();
        
        btnGetFromDate = new JButton("Set");
        btnGetFromDate.addActionListener(this);
        btnGetFromDate.setBackground(rsc.SecondaryColor());
        btnGetFromDate.setForeground(rsc.PrimaryTextColor());
        btnGetFromDate.setFont(rsc.SecondaryFont());
        btnGetFromDate.setFocusable(false);
        btnGetFromDate.setBounds(rsc.bcTextWidth()*2, rsc.bcTextHeight()*2, rsc.bcTextWidth()/2, rsc.bcTextHeight());
        
        
        // ********** To (Group) ********** //
        lblTo = new JLabel();
        lblTo.setText("To: ");
        lblTo.setFont(rsc.MainFont());
        lblTo.setForeground(rsc.PrimaryTextColor());
        lblTo.setBounds(rsc.bcTextWidth()*3, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblTo.setHorizontalAlignment(JLabel.CENTER);
        lblTo.setVerticalAlignment(JLabel.CENTER);
        
        lblOutputTo = new JLabel();
        lblOutputTo.setText("");
        lblOutputTo.setFont(rsc.MainFont());
        lblOutputTo.setForeground(rsc.PrimaryTextColor());
        lblOutputTo.setBounds(rsc.bcTextWidth()*4, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblOutputTo.setHorizontalAlignment(JLabel.LEFT);
        lblOutputTo.setVerticalAlignment(JLabel.CENTER);
        
        btnGetToDate = new JButton("Set");
        btnGetToDate.addActionListener(this);
        btnGetToDate.setBackground(rsc.SecondaryColor());
        btnGetToDate.setForeground(rsc.PrimaryTextColor());
        btnGetToDate.setFont(rsc.SecondaryFont());
        btnGetToDate.setFocusable(false);
        btnGetToDate.setBounds(rsc.bcTextWidth()*5, rsc.bcTextHeight()*2, rsc.bcTextWidth()/2, rsc.bcTextHeight());
        
        
        
        btnGeneratePayslip = new JButton("Generate Report");
        btnGeneratePayslip.addActionListener(this);
        btnGeneratePayslip.setBackground(rsc.SecondaryColor());
        btnGeneratePayslip.setForeground(rsc.PrimaryTextColor());
        
        btnGeneratePayslip.setFont(rsc.SecondaryFont());
        btnGeneratePayslip.setFocusable(false);
        btnGeneratePayslip.setBounds(rsc.bcTextWidth()/2, rsc.bcTextHeight()*4, (rsc.bcTextWidth()*6)/4, rsc.bcTextHeight());
        
        
        // ********** Pages and Contents ********** //
        salaryPageReport = new SalaryPageReport(userId, lblOutputFrom.getText(), lblOutputTo.getText());
        // ********** Pages and Contents ********** //
        
        
        this.add(salaryCalendar);
        this.add(lblSearch);
        this.add(lblFrom);
        this.add(lblOutputFrom);
        this.add(btnGetFromDate);
        //this.add(TFfrom);
        this.add(lblTo);
        this.add(lblOutputTo);
        this.add(btnGetToDate);
        this.add(btnGeneratePayslip);
        //this.add(getDateButton);
        
        this.add(salaryPageReport);
        
        HideAllPagesAndContent();
    }
    
    public void HideAllPagesAndContent(){
        salaryPageReport.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnGetFromDate){
            
            HideAllPagesAndContent();
            Date selectedDate = salaryCalendar.getDate();
            //SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd HH:mm");
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
            String formattedDate = dateFormatter.format(selectedDate);
            lblOutputFrom.setText(formattedDate);

        } else if(e.getSource()==btnGetToDate){
            
            HideAllPagesAndContent();
            Date selectedDate = salaryCalendar.getDate();
            //SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd HH:mm");
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
            String formattedDate = dateFormatter.format(selectedDate);
            lblOutputTo.setText(formattedDate);
            
        } else if(e.getSource()==btnGeneratePayslip){
            salaryPageReport.setDates(lblOutputFrom.getText(), lblOutputTo.getText());
            this.add(salaryPageReport);
            salaryPageReport.setVisible(true);
        }
        
    }
    
}