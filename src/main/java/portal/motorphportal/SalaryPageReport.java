package portal.motorphportal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SalaryPageReport extends JPanel {
    
    private String userID, fromDate, toDate;
    
    private JLabel lblSalary, lblWorkedDays, lblVacationLeave, lblAbsences, lblTotalHours, lblUnderTime, lblHrsToBePaid;
    
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
        this.setBackground(rsc.PrimaryColor());
        this.setBounds(0, rsc.ProfilePictureHeight()-50, rsc.BodyContentPageWidth(), rsc.BodyContentPageHeight()-(rsc.ProfilePictureHeight()-50));
        this.setLayout(null);
        
        /*
        HRService hrSVC = new HRService();
        //double salary = hrSVC.ComputeSalary(userID, fromDate, toDate);
        double salary = hrSVC.ComputeSalary(userID, fromDate, toDate);
        String convertedSalary = String.valueOf(salary);
        */
        
        lblWorkedDays = new JLabel();
        lblWorkedDays.setText("Worked days: ");
        lblWorkedDays.setFont(rsc.MainFont());
        lblWorkedDays.setForeground(rsc.PrimaryTextColor());
        lblWorkedDays.setBounds(0, 0, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblWorkedDays.setHorizontalAlignment(JLabel.RIGHT);
        lblWorkedDays.setVerticalAlignment(JLabel.CENTER);
        
        lblVacationLeave = new JLabel();
        lblVacationLeave.setText("Vacation leave: ");
        lblVacationLeave.setFont(rsc.MainFont());
        lblVacationLeave.setForeground(rsc.PrimaryTextColor());
        lblVacationLeave.setBounds(0, rsc.bcTextHeight(), rsc.bcTextWidth(), rsc.bcTextHeight());
        lblVacationLeave.setHorizontalAlignment(JLabel.RIGHT);
        lblVacationLeave.setVerticalAlignment(JLabel.CENTER);
        
        lblAbsences = new JLabel();
        lblAbsences.setText("Absences: ");
        lblAbsences.setFont(rsc.MainFont());
        lblAbsences.setForeground(rsc.PrimaryTextColor());
        lblAbsences.setBounds(0, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblAbsences.setHorizontalAlignment(JLabel.RIGHT);
        lblAbsences.setVerticalAlignment(JLabel.CENTER);
        
        lblTotalHours = new JLabel();
        lblTotalHours.setText("Total hours: ");
        lblTotalHours.setFont(rsc.MainFont());
        lblTotalHours.setForeground(rsc.PrimaryTextColor());
        lblTotalHours.setBounds(rsc.bcTextWidth(), 0, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblTotalHours.setHorizontalAlignment(JLabel.RIGHT);
        lblTotalHours.setVerticalAlignment(JLabel.CENTER);
        
        lblUnderTime = new JLabel();
        lblUnderTime.setText("Undertime: ");
        lblUnderTime.setFont(rsc.MainFont());
        lblUnderTime.setForeground(rsc.PrimaryTextColor());
        lblUnderTime.setBounds(rsc.bcTextWidth(), rsc.bcTextHeight(), rsc.bcTextWidth(), rsc.bcTextHeight());
        lblUnderTime.setHorizontalAlignment(JLabel.RIGHT);
        lblUnderTime.setVerticalAlignment(JLabel.CENTER);
        
        
        
        
        lblSalary = new JLabel();
        lblSalary.setText("");
        lblSalary.setOpaque(true);
        lblSalary.setBackground(Color.ORANGE);
        lblSalary.setFont(rsc.MainFont());
        lblSalary.setForeground(rsc.PrimaryTextColor());
        lblSalary.setBounds(0, rsc.BodyPanelHeight() / 16, rsc.bcTextWidth()*2, rsc.bcTextHeight());
        lblSalary.setHorizontalAlignment(JLabel.RIGHT);
        lblSalary.setVerticalAlignment(JLabel.CENTER);
        
        //this.add(lblSalary);
        this.add(lblWorkedDays);
        this.add(lblVacationLeave);
        this.add(lblAbsences);
        this.add(lblTotalHours);
        this.add(lblUnderTime);
        
    }
    
    public void setDates(String fromDate, String toDate){
        double salary = HRSVC.ComputeSalary(userID, fromDate, toDate);
        String convertedSalary = String.valueOf(salary);
        lblSalary.setText(convertedSalary);
        revalidate();
        repaint();
    }
    
}
