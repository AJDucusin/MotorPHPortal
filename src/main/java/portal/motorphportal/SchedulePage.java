package portal.motorphportal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SchedulePage extends JPanel implements ActionListener {
    
    private String userIdInput;
    
    private JLabel lblScheduleForMonth;
    private JComboBox<String> monthComboBox;
    private JButton btnView;
    private SchedulePageContent schedulePageContent;
    
    Resources rsc = new Resources();
    
    public SchedulePage(String userId) {
        this.userIdInput = userId;
        
        initialize(userId);
    }
    
    public void initialize(String userId) {
        
        //this.setBackground(Color.red);
        this.setBackground(rsc.PrimaryColor());
        this.setSize(rsc.BodyContentPageWidth(), rsc.BodyContentPageHeight());
        this.setLayout(null);
        
        lblScheduleForMonth = new JLabel();
        lblScheduleForMonth.setText("Schedule for month of:   ");
        lblScheduleForMonth.setFont(rsc.MainFont());
        lblScheduleForMonth.setForeground(rsc.PrimaryTextColor());
        lblScheduleForMonth.setBounds(0, 0, (rsc.bcTextWidth()*6)/4, rsc.bcTextHeight());
        lblScheduleForMonth.setHorizontalAlignment(JLabel.CENTER);
        lblScheduleForMonth.setVerticalAlignment(JLabel.CENTER);
        
        
        monthComboBox = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        monthComboBox.setBounds((rsc.bcTextWidth()*6)/4, 5, rsc.bcTextWidth(), rsc.bcTextHeight()-10);
        
        
        btnView = new JButton("View");
        btnView.addActionListener(this);
        btnView.setBackground(rsc.SecondaryColor());
        btnView.setForeground(rsc.PrimaryTextColor());
        btnView.setFont(rsc.SecondaryFont());
        btnView.setFocusable(false);
        btnView.setBounds(rsc.bcTextWidth()/2, (rsc.bcTextHeight()*2)-5, rsc.bcTextWidth()/2, rsc.bcTextHeight()-10);
        
        
        
        //schedulePageContent = new SchedulePageContent(userId, monthHolder, yearHolder);
        
        
        this.add(lblScheduleForMonth);
        this.add(monthComboBox);
        this.add(btnView);
        //this.add(schedulePageContent);
        
        HideAllPagesAndContent();
    }
    
    public void HideAllPagesAndContent() {
        if(schedulePageContent != null) {
            schedulePageContent.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnView) {
            
            int month = monthComboBox.getSelectedIndex()+1;
            int year = 2024;
            
            if(schedulePageContent != null) {
                this.remove(schedulePageContent);
            }
            
            schedulePageContent = new SchedulePageContent(userIdInput, month, year);
            schedulePageContent.setVisible(true);
            this.add(schedulePageContent);
            
            schedulePageContent.revalidate();
            schedulePageContent.repaint();
        }
        
    }
    
}
