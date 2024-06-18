package portal.motorphportal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SalaryPageReport extends JPanel {
    
    private String userID, fromDate, toDate;
    
    private JLabel lblSalary, lblWorkedDays, lblVacationLeave, lblAbsences, lblTotalHours, lblUnderTime, lblHrsToBePaid, lblOutputWorkedDays, lblOutputTotalHours, lblOutputVacationLeave, lblOutputUnderTime, lblOutputAbsences, lblOutputHrsToBePaid, lblOutputSalary;
    
    Resources rsc = new Resources();
    HRService HRSVC = new HRService();
    
    public SalaryPageReport(String userIDinput, String fromDateInput, String toDateInput) {
        this.userID = userIDinput;
        this.fromDate = fromDateInput;
        this.toDate = toDateInput;
        
        initialize(userID, fromDate, toDate);
    }
    
    public void initialize(String userID, String fromDate, String toDate ){
        
        //this.setBackground(Color.red);
        this.setBackground(rsc.PrimaryColor());
        this.setBounds(0, rsc.ProfilePictureHeight()-50, rsc.BodyContentPageWidth(), rsc.BodyContentPageHeight()-(rsc.ProfilePictureHeight()-50));
        this.setLayout(null);
        
        /*
        HRService hrSVC = new HRService();
        //double salary = hrSVC.ComputeSalary(userID, fromDate, toDate);
        double salary = hrSVC.ComputeSalary(userID, fromDate, toDate);
        String convertedSalary = String.valueOf(salary);
        */
        
        // ********** Worked Days ********** //
        lblWorkedDays = new JLabel();
        lblWorkedDays.setText("Worked days: ");
        lblWorkedDays.setFont(rsc.MainFont());
        lblWorkedDays.setForeground(rsc.PrimaryTextColor());
        lblWorkedDays.setBounds(0, rsc.bcTextHeight(), rsc.bcTextWidth(), rsc.bcTextHeight());
        lblWorkedDays.setHorizontalAlignment(JLabel.RIGHT);
        lblWorkedDays.setVerticalAlignment(JLabel.CENTER);
        
        lblOutputWorkedDays = new JLabel();
        lblOutputWorkedDays.setText("");
        lblOutputWorkedDays.setFont(rsc.MainFont());
        lblOutputWorkedDays.setForeground(rsc.PrimaryTextColor());
        lblOutputWorkedDays.setBounds(rsc.bcTextWidth(), rsc.bcTextHeight(), rsc.bcTextWidth(), rsc.bcTextHeight());
        lblOutputWorkedDays.setHorizontalAlignment(JLabel.CENTER);
        lblOutputWorkedDays.setVerticalAlignment(JLabel.CENTER);
        
        
        // ********** Total Hours ********** //
        lblTotalHours = new JLabel();
        lblTotalHours.setText("Total hours: ");
        lblTotalHours.setFont(rsc.MainFont());
        lblTotalHours.setForeground(rsc.PrimaryTextColor());
        lblTotalHours.setBounds(rsc.bcTextWidth()*2, rsc.bcTextHeight(), rsc.bcTextWidth(), rsc.bcTextHeight());
        lblTotalHours.setHorizontalAlignment(JLabel.RIGHT);
        lblTotalHours.setVerticalAlignment(JLabel.CENTER);
        
        lblOutputTotalHours = new JLabel();
        lblOutputTotalHours.setText("");
        lblOutputTotalHours.setFont(rsc.MainFont());
        lblOutputTotalHours.setForeground(rsc.PrimaryTextColor());
        lblOutputTotalHours.setBounds(rsc.bcTextWidth()*3, rsc.bcTextHeight(), rsc.bcTextWidth(), rsc.bcTextHeight());
        lblOutputTotalHours.setHorizontalAlignment(JLabel.CENTER);
        lblOutputTotalHours.setVerticalAlignment(JLabel.CENTER);
        
        
        // ********** Vacation Leaves ********** //
        lblVacationLeave = new JLabel();
        lblVacationLeave.setText("Paid vacation: ");
        lblVacationLeave.setFont(rsc.MainFont());
        lblVacationLeave.setForeground(rsc.PrimaryTextColor());
        lblVacationLeave.setBounds(0, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblVacationLeave.setHorizontalAlignment(JLabel.RIGHT);
        lblVacationLeave.setVerticalAlignment(JLabel.CENTER);
        
        lblOutputVacationLeave = new JLabel();
        lblOutputVacationLeave.setText("");
        lblOutputVacationLeave.setFont(rsc.MainFont());
        lblOutputVacationLeave.setForeground(rsc.PrimaryTextColor());
        lblOutputVacationLeave.setBounds(rsc.bcTextWidth(), rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblOutputVacationLeave.setHorizontalAlignment(JLabel.CENTER);
        lblOutputVacationLeave.setVerticalAlignment(JLabel.CENTER);
        
        
        // ********** Undertime ********** //
        lblUnderTime = new JLabel();
        lblUnderTime.setText("Undertime: ");
        lblUnderTime.setFont(rsc.MainFont());
        lblUnderTime.setForeground(rsc.PrimaryTextColor());
        lblUnderTime.setBounds(rsc.bcTextWidth()*2, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblUnderTime.setHorizontalAlignment(JLabel.RIGHT);
        lblUnderTime.setVerticalAlignment(JLabel.CENTER);
        
        lblOutputUnderTime = new JLabel();
        lblOutputUnderTime.setText("");
        lblOutputUnderTime.setFont(rsc.MainFont());
        lblOutputUnderTime.setForeground(rsc.PrimaryTextColor());
        lblOutputUnderTime.setBounds(rsc.bcTextWidth()*3, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblOutputUnderTime.setHorizontalAlignment(JLabel.CENTER);
        lblOutputUnderTime.setVerticalAlignment(JLabel.CENTER);
        
        
        // ********** Absences ********** //
        lblAbsences = new JLabel();
        lblAbsences.setText("Absences: ");
        lblAbsences.setFont(rsc.MainFont());
        lblAbsences.setForeground(rsc.PrimaryTextColor());
        lblAbsences.setBounds(0, rsc.bcTextHeight()*3, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblAbsences.setHorizontalAlignment(JLabel.RIGHT);
        lblAbsences.setVerticalAlignment(JLabel.CENTER);
        
        lblOutputAbsences = new JLabel();
        lblOutputAbsences.setText("");
        lblOutputAbsences.setFont(rsc.MainFont());
        lblOutputAbsences.setForeground(rsc.PrimaryTextColor());
        lblOutputAbsences.setBounds(rsc.bcTextWidth(), rsc.bcTextHeight()*3, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblOutputAbsences.setHorizontalAlignment(JLabel.CENTER);
        lblOutputAbsences.setVerticalAlignment(JLabel.CENTER);
        
        
        // ********** Hours to be paid ********** //
        lblHrsToBePaid = new JLabel();
        lblHrsToBePaid.setText("Hours to be paid: ");
        lblHrsToBePaid.setFont(rsc.MainFont());
        lblHrsToBePaid.setForeground(rsc.PrimaryTextColor());
        lblHrsToBePaid.setBounds(0, rsc.bcTextHeight()*5, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblHrsToBePaid.setHorizontalAlignment(JLabel.RIGHT);
        lblHrsToBePaid.setVerticalAlignment(JLabel.CENTER);
        
        lblOutputHrsToBePaid = new JLabel();
        lblOutputHrsToBePaid.setText("");
        lblOutputHrsToBePaid.setFont(rsc.MainFont());
        lblOutputHrsToBePaid.setForeground(rsc.PrimaryTextColor());
        lblOutputHrsToBePaid.setBounds(rsc.bcTextWidth(), rsc.bcTextHeight()*5, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblOutputHrsToBePaid.setHorizontalAlignment(JLabel.CENTER);
        lblOutputHrsToBePaid.setVerticalAlignment(JLabel.CENTER);
        
        
        // ********** Salary ********** //
        lblSalary = new JLabel();
        lblSalary.setText("Salary: ");
        lblSalary.setFont(rsc.MainFont());
        lblSalary.setForeground(rsc.PrimaryTextColor());
        lblSalary.setBounds(rsc.bcTextWidth()*3, rsc.bcTextHeight()*5, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblSalary.setHorizontalAlignment(JLabel.RIGHT);
        lblSalary.setVerticalAlignment(JLabel.CENTER);
        
        lblOutputSalary = new JLabel();
        lblOutputSalary.setText("");
        lblOutputSalary.setFont(rsc.MainFont());
        lblOutputSalary.setForeground(rsc.PrimaryTextColor());
        lblOutputSalary.setBounds(rsc.bcTextWidth()*4, rsc.bcTextHeight()*5, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblOutputSalary.setHorizontalAlignment(JLabel.RIGHT);
        lblOutputSalary.setVerticalAlignment(JLabel.CENTER);
        
        
        
        
        
        this.add(lblWorkedDays);
        this.add(lblOutputWorkedDays);
        
        this.add(lblTotalHours);
        this.add(lblOutputTotalHours);
        
        this.add(lblVacationLeave);
        this.add(lblOutputVacationLeave);
        
        this.add(lblUnderTime);
        this.add(lblOutputUnderTime);
        
        this.add(lblAbsences);
        this.add(lblOutputAbsences);
        
        this.add(lblHrsToBePaid);
        this.add(lblOutputHrsToBePaid);
        
        this.add(lblSalary);
        this.add(lblOutputSalary);
    }
    
    public void setDates(String fromDate, String toDate){
        double salary = HRSVC.ComputeSalary(userID, fromDate, toDate);
        String convertedSalary = String.valueOf(salary);
        lblOutputSalary.setText(convertedSalary +" Php");
        
        int totalWorkedDays = HRSVC.ComputeWorkedDays(userID, fromDate, toDate);
        String convertedWorkedDays = String.valueOf(totalWorkedDays);
        if(totalWorkedDays == 0) {
            lblOutputWorkedDays.setText(convertedWorkedDays);
        } else if(totalWorkedDays == 1) {
            lblOutputWorkedDays.setText(convertedWorkedDays +" day");
        } else {
            lblOutputWorkedDays.setText(convertedWorkedDays +" days");
        }
        
        int totalVL = HRSVC.ComputeVL(userID, fromDate, toDate);
        String convertedVacationLeave = String.valueOf(totalVL);
        if(totalVL == 0) {
            lblOutputVacationLeave.setText(convertedVacationLeave);
        } else if(totalVL == 1) {
            lblOutputVacationLeave.setText(convertedVacationLeave +" day");
        } else {
            lblOutputVacationLeave.setText(convertedVacationLeave +" days");
        }
        
        double lateHrs = HRSVC.ComputeLateHours(userID, fromDate, toDate);
        String convertedLateHrs = String.valueOf(lateHrs);
        if(lateHrs == 0.0) {
            lblOutputUnderTime.setText(convertedLateHrs);
        } else if(lateHrs == 1.0) {
            lblOutputUnderTime.setText(convertedLateHrs +" hr");
        } else {
            lblOutputUnderTime.setText(convertedLateHrs +" hrs");
        }
        
        double totalHours = totalWorkedDays * 8.0;
        String convertedTotalHrs = String.valueOf(totalHours);
        if(totalHours == 0) {
            lblOutputTotalHours.setText(convertedTotalHrs);
        } else if(totalHours == 1.0) {
            lblOutputTotalHours.setText(convertedTotalHrs +" hr");
        } else {
            lblOutputTotalHours.setText(convertedTotalHrs +" hrs");
        }
        
        int absences = HRSVC.ComputeAbsences(userID, fromDate, toDate);
        String convertedAbsences = String.valueOf(absences);
        if(absences == 0) {
            lblOutputAbsences.setText(convertedAbsences);
        } else if(absences == 1) {
            lblOutputAbsences.setText(convertedAbsences +" day");
        } else {
            lblOutputAbsences.setText(convertedAbsences +" days");
        }
        
        
        
        revalidate();
        repaint();
    }
    
}
