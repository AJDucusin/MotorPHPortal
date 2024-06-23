package portal.motorphportal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimeInTimeOutPage extends JPanel {
    
    private JLabel lblScheduleForToday, lblDateToday, lblClock, lblClockIn, lblBreakStart, lblBreakEnd, lblClockOut, lblOutPutCI, lblOutPutBS, lblOutPutBE, lblOutPutCO;
    
    Resources rsc = new Resources();
    HRService HRSVC = new HRService();
    
    public TimeInTimeOutPage() {
        initialize();
    }
    
    public void initialize() {
        
        //this.setBackground(Color.red);
        this.setBackground(rsc.PrimaryColor());
        this.setSize(rsc.BodyContentPageWidth(), rsc.BodyContentPageHeight());
        this.setLayout(null);
        
        
        lblScheduleForToday = new JLabel();
        lblScheduleForToday.setText("Your schedule for today:  ");
        lblScheduleForToday.setFont(rsc.MainFont());
        lblScheduleForToday.setForeground(rsc.PrimaryTextColor());
        lblScheduleForToday.setBounds(0, 0, rsc.bcTextWidth()*2, rsc.bcTextHeight());
        lblScheduleForToday.setHorizontalAlignment(JLabel.CENTER);
        lblScheduleForToday.setVerticalAlignment(JLabel.CENTER);
        
        lblDateToday = new JLabel();
        //lblDateToday.setText("");
        lblDateToday.setFont(rsc.MainFont());
        lblDateToday.setForeground(rsc.PrimaryTextColor());
        lblDateToday.setBounds(rsc.bcTextWidth()*2, 0, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblDateToday.setHorizontalAlignment(JLabel.CENTER);
        lblDateToday.setVerticalAlignment(JLabel.CENTER);
        
        // ********** Clock In Start ********** //
        lblClockIn = new JLabel();
        lblClockIn.setText("Clock In: ");
        lblClockIn.setFont(rsc.MainFont());
        lblClockIn.setForeground(rsc.PrimaryTextColor());
        lblClockIn.setBounds(rsc.bcTextWidth(), rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblClockIn.setHorizontalAlignment(JLabel.CENTER);
        lblClockIn.setVerticalAlignment(JLabel.CENTER);
        
        lblOutPutCI = new JLabel();
        lblOutPutCI.setText("No Record.");
        lblOutPutCI.setFont(rsc.MainFont());
        lblOutPutCI.setForeground(rsc.SecondaryTextColor());
        lblOutPutCI.setBounds(rsc.bcTextWidth(), (rsc.bcTextHeight()*3)-5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        lblOutPutCI.setHorizontalAlignment(JLabel.CENTER);
        lblOutPutCI.setVerticalAlignment(JLabel.CENTER);
        lblOutPutCI.setOpaque(true);
        lblOutPutCI.setBackground(Color.WHITE);
        // ********** Clock In Start ********** //
        
        // ********** Break Start Start ********** //
        lblBreakStart = new JLabel();
        lblBreakStart.setText("Break Start: ");
        lblBreakStart.setFont(rsc.MainFont());
        lblBreakStart.setForeground(rsc.PrimaryTextColor());
        lblBreakStart.setBounds(rsc.bcTextWidth()*3, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblBreakStart.setHorizontalAlignment(JLabel.CENTER);
        lblBreakStart.setVerticalAlignment(JLabel.CENTER);
        
        lblOutPutBS = new JLabel();
        lblOutPutBS.setText("No Record.");
        lblOutPutBS.setFont(rsc.MainFont());
        lblOutPutBS.setForeground(rsc.SecondaryTextColor());
        lblOutPutBS.setBounds(rsc.bcTextWidth()*3, (rsc.bcTextHeight()*3)-5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        lblOutPutBS.setHorizontalAlignment(JLabel.CENTER);
        lblOutPutBS.setVerticalAlignment(JLabel.CENTER);
        lblOutPutBS.setOpaque(true);
        lblOutPutBS.setBackground(Color.WHITE);
        // ********** Break Start End ********** //
        
        // ********** Break End Start ********** //
        lblBreakEnd = new JLabel();
        lblBreakEnd.setText("Break End: ");
        lblBreakEnd.setFont(rsc.MainFont());
        lblBreakEnd.setForeground(rsc.PrimaryTextColor());
        lblBreakEnd.setBounds(rsc.bcTextWidth()*5, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblBreakEnd.setHorizontalAlignment(JLabel.CENTER);
        lblBreakEnd.setVerticalAlignment(JLabel.CENTER);
        
        lblOutPutBE = new JLabel();
        lblOutPutBE.setText("No Record.");
        lblOutPutBE.setFont(rsc.MainFont());
        lblOutPutBE.setForeground(rsc.SecondaryTextColor());
        lblOutPutBE.setBounds(rsc.bcTextWidth()*5, (rsc.bcTextHeight()*3)-5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        lblOutPutBE.setHorizontalAlignment(JLabel.CENTER);
        lblOutPutBE.setVerticalAlignment(JLabel.CENTER);
        lblOutPutBE.setOpaque(true);
        lblOutPutBE.setBackground(Color.WHITE);
        // ********** Break End End ********** //
        
        // ********** Clock Out Start ********** //
        lblClockOut = new JLabel();
        lblClockOut.setText("Clock Out: ");
        lblClockOut.setFont(rsc.MainFont());
        lblClockOut.setForeground(rsc.PrimaryTextColor());
        lblClockOut.setBounds(rsc.bcTextWidth()*7, rsc.bcTextHeight()*2, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblClockOut.setHorizontalAlignment(JLabel.CENTER);
        lblClockOut.setVerticalAlignment(JLabel.CENTER);
        
        lblOutPutCO = new JLabel();
        lblOutPutCO.setText("No Record.");
        lblOutPutCO.setFont(rsc.MainFont());
        lblOutPutCO.setForeground(rsc.SecondaryTextColor());
        lblOutPutCO.setBounds(rsc.bcTextWidth()*7, (rsc.bcTextHeight()*3)-5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        lblOutPutCO.setHorizontalAlignment(JLabel.CENTER);
        lblOutPutCO.setVerticalAlignment(JLabel.CENTER);
        lblOutPutCO.setOpaque(true);
        lblOutPutCO.setBackground(Color.WHITE);
        // ********** Clock Out End ********** //
        
        
        
        lblClock = new JLabel();
        lblClock.setFont(new Font("Cascadia Code", Font.BOLD, 24));
        lblClock.setForeground(rsc.SecondaryTextColor());
        lblClock.setBounds(rsc.bcTextWidth()*3, 0, rsc.bcTextWidth(), rsc.bcTextHeight());
        lblClock.setHorizontalAlignment(JLabel.CENTER);
        lblClock.setVerticalAlignment(JLabel.CENTER);
        lblClock.setOpaque(true);
        lblClock.setBackground(Color.WHITE);
        
        // ********** Timer Start ********** //
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClock();
            }
        });
        timer.start();
        updateClock();
        // ********** Timer End ********** //
        
        
        // ********** Date Today Start ********** //
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());
        lblDateToday.setText(currentDate);
        // ********** Date Today End ********** //
        
        
        
        this.add(lblScheduleForToday);
        this.add(lblDateToday);
        this.add(lblClock);
        this.add(lblClockIn);
        this.add(lblBreakStart);
        this.add(lblBreakEnd);
        this.add(lblClockOut);
        this.add(lblOutPutCI);
        this.add(lblOutPutBS);
        this.add(lblOutPutBE);
        this.add(lblOutPutCO);
    }
    
    private void updateClock() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String currentTime = timeFormat.format(new Date());
        lblClock.setText(currentTime);
    }
    
}
