package portal.motorphportal;

import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SchedulePageContent extends JPanel {
    
    private String userIdInput;
    private int monthInput, yearInput;
    
    private JTable tblSchedule;
    private JScrollPane scrollPane;
    
    Resources rsc = new Resources();
    HRService HRSVC = new HRService();
    
    public SchedulePageContent(String userId, int month, int year) {
        this.userIdInput = userId;
        this.monthInput = month;
        this.yearInput = year;
        
        initialize(userId, month, year);
    }
    
    public void initialize(String userId, int month, int year) {
        
        this.setBackground(Color.red);
        this.setBounds(0, rsc.bcTextHeight()*3, rsc.BodyContentPageWidth(), rsc.BodyContentPageHeight()-(rsc.bcTextHeight()*3));
        this.setLayout(null);
        
        List<String[]> data = HRSVC.GetUserScheduleForMonth(userIdInput, month, year);
        if(data.isEmpty()){
            return;
        }
        String[] columnNames = data.get(0);
        
        DefaultTableModel tableModel = new DefaultTableModel(data.toArray(new String[0][0]), columnNames);
        
        
        tblSchedule = new JTable(tableModel);
        scrollPane = new JScrollPane(tblSchedule);
        scrollPane.setBounds(0, 0, rsc.BodyContentPageWidth(), rsc.BodyContentPageHeight()-(rsc.bcTextHeight()*3));
        
        String salo = "";
        this.add(scrollPane);
        
        
    }
    
}
