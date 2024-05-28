package portal.motorphportal;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {
    
    private String username;
    private String password;
    
    private JPanel loginPanel, sideBar, headerPanel, bodyPanel, footerPanel;
    private JButton loginButton, headerButton, timeInOutButton, profileButton, timeButton, salaryButton, exitButton;
    private JLabel lblHeader, lblFooter;
    
    private JPanel profilePageContent, salaryPageContent;

    Resources rsc = new Resources();
    
    
    public MainFrame(String username, String password) {
        this.username = username;
        this.password = password;
        
        initialize();
    }

    public void initialize()
    {
        // ********** Pages and Contents ********** //
        profilePageContent = new ProfilePageContent(username, password);
        salaryPageContent = new SalaryPageContent(username, password);
        // ********** Pages and Contents ********** //
        
        // ********** Mouse Function ********** //
        MouseAdapter handPointer = new MouseAdapter() {
        @Override
            public void mouseEntered(MouseEvent e) {
                headerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                timeInOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                timeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                salaryButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        @Override
            public void mouseExited(MouseEvent e) {
                headerButton.setCursor(Cursor.getDefaultCursor());
                timeInOutButton.setCursor(Cursor.getDefaultCursor());
                profileButton.setCursor(Cursor.getDefaultCursor());
                timeButton.setCursor(Cursor.getDefaultCursor());
                salaryButton.setCursor(Cursor.getDefaultCursor());
                exitButton.setCursor(Cursor.getDefaultCursor());
            }
        };
        // ********** Mouse Function ********** //
        
        
        
        this.setTitle("Motor PH Portal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(rsc.FullscreenWidth(), rsc.FullscreenHeight());
        this.getContentPane().setBackground(rsc.PrimaryColor());
        this.setUndecorated(true);
        
        
        
        sideBar = new JPanel();
        sideBar.setBackground(rsc.SecondaryColor());
        sideBar.setBounds(0, 0, rsc.SideBarWidth(), rsc.SideBarHeight());
        sideBar.setLayout(null);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(rsc.PrimaryColor());
        headerPanel.setBounds(rsc.SideBarWidth(), 0, rsc.HeaderPanelWidth(), rsc.HeaderPanelHeight());
        headerPanel.setLayout(new BorderLayout()); //Original
        
        bodyPanel = new JPanel();
        bodyPanel.setBackground(rsc.PrimaryColor());
        bodyPanel.setBounds(rsc.SideBarWidth(), rsc.HeaderPanelHeight(), rsc.BodyPanelWidth(), rsc.BodyPanelHeight());
        bodyPanel.setLayout(null);
        
        footerPanel = new JPanel();
        footerPanel.setBackground(rsc.PrimaryColor());
        footerPanel.setBounds(rsc.SideBarWidth(), (rsc.HeaderPanelHeight()+rsc.BodyPanelHeight()), rsc.FooterPanelWidth(), rsc.FooterPanelHeight());
        footerPanel.setLayout(new BorderLayout());
        
        
        lblHeader = new JLabel();
        lblHeader.setText("Welcome to MotorPH Dashboard Portal");
        lblHeader.setFont(rsc.HeaderFont2());
        lblHeader.setForeground(rsc.PrimaryTextColor());
        lblHeader.setHorizontalAlignment(JLabel.CENTER); //Original
        lblHeader.setVerticalAlignment(JLabel.CENTER); //Original
        
        lblFooter = new JLabel();
        lblFooter.setText("Terms of Service | Privacy Policy | © 2023-2024 MMDC MO-IT103. All Rights Reserved.");
        lblFooter.setFont(rsc.SecondaryFont());
        lblFooter.setForeground(rsc.SecondaryTextColor());
        lblFooter.setHorizontalAlignment(JLabel.CENTER);
        lblFooter.setVerticalAlignment(JLabel.CENTER);
        
        
        headerButton = new JButton("Motor PH");
        headerButton.addActionListener(this);
        headerButton.setBackground(rsc.PrimaryColor());
        headerButton.setForeground(rsc.PrimaryTextColor());
        headerButton.setFont(rsc.HeaderFont());
        headerButton.setBorder(null);
        headerButton.setFocusable(false);
        headerButton.setBounds(0, 0, rsc.NavButtonWidth(), rsc.NavButtonHeight());
        headerButton.addMouseListener(handPointer);
        
        timeInOutButton = new JButton("Time-in Time-out");
        timeInOutButton.addActionListener(this);
        timeInOutButton.setBackground(rsc.SecondaryColor());
        timeInOutButton.setForeground(rsc.PrimaryTextColor());
        timeInOutButton.setFont(rsc.MainFont());
        timeInOutButton.setBorder(null);
        timeInOutButton.setFocusable(false);
        timeInOutButton.setBounds(0, rsc.SideBarHeight()-(rsc.NavButtonHeight()*10), rsc.NavButtonWidth(), rsc.NavButtonHeight());
        timeInOutButton.addMouseListener(handPointer);
        
        profileButton = new JButton("My Profile");
        profileButton.addActionListener(this);
        profileButton.setBackground(rsc.SecondaryColor());
        profileButton.setForeground(rsc.PrimaryTextColor());
        profileButton.setFont(rsc.MainFont());
        profileButton.setBorder(null);
        profileButton.setFocusable(false);
        profileButton.setBounds(0, rsc.SideBarHeight()-(rsc.NavButtonHeight()*9), rsc.NavButtonWidth(), rsc.NavButtonHeight());
        profileButton.addMouseListener(handPointer);
        
        timeButton = new JButton("View Time Logs");
        timeButton.addActionListener(this);
        timeButton.setBackground(rsc.SecondaryColor());
        timeButton.setForeground(rsc.PrimaryTextColor());
        timeButton.setFont(rsc.MainFont());
        timeButton.setBorder(null);
        timeButton.setFocusable(false);
        timeButton.setBounds(0, rsc.SideBarHeight()-(rsc.NavButtonHeight()*8), rsc.NavButtonWidth(), rsc.NavButtonHeight());
        timeButton.addMouseListener(handPointer);
        
        salaryButton = new JButton("View Salary");
        salaryButton.addActionListener(this);
        salaryButton.setBackground(rsc.SecondaryColor());
        salaryButton.setForeground(rsc.PrimaryTextColor());
        salaryButton.setFont(rsc.MainFont());
        salaryButton.setBorder(null);
        salaryButton.setFocusable(false);
        salaryButton.setBounds(0, rsc.SideBarHeight()-(rsc.NavButtonHeight()*7), rsc.NavButtonWidth(), rsc.NavButtonHeight());
        salaryButton.addMouseListener(handPointer);
        
        exitButton = new JButton("Exit Portal");
        exitButton.addActionListener(this);
        exitButton.setBackground(rsc.SecondaryColor());
        exitButton.setForeground(rsc.PrimaryTextColor());
        exitButton.setFont(rsc.MainFont());
        exitButton.setBorder(null);
        exitButton.setFocusable(false);
        exitButton.setBounds(0, rsc.SideBarHeight()-rsc.NavButtonHeight(), rsc.NavButtonWidth(), rsc.NavButtonHeight());
        exitButton.addMouseListener(handPointer);
        
        
        
        headerPanel.add(lblHeader);
        
        bodyPanel.add(profilePageContent);
        bodyPanel.add(salaryPageContent);
        
        footerPanel.add(lblFooter);
        
        sideBar.add(headerButton);
        sideBar.add(timeInOutButton);
        sideBar.add(profileButton);
        sideBar.add(timeButton);
        sideBar.add(salaryButton);
        sideBar.add(exitButton);
        this.add(headerPanel);
        this.add(bodyPanel);
        this.add(footerPanel);
        this.add(sideBar);
        this.setVisible(true);
        
        HideAllPagesAndContent();
    }
    
    
    public void HideAllPagesAndContent(){
        profilePageContent.setVisible(false);
        salaryPageContent.setVisible(false);
    }
    
    public void ButtonDefaultColor() {
        headerButton.setBackground(rsc.SecondaryColor());
        timeInOutButton.setBackground(rsc.SecondaryColor());
        profileButton.setBackground(rsc.SecondaryColor());
        timeButton.setBackground(rsc.SecondaryColor());
        salaryButton.setBackground(rsc.SecondaryColor());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==exitButton)
        {
            this.dispose();
        }
        else if(e.getSource()==headerButton)
        {
            HideAllPagesAndContent();
            ButtonDefaultColor();
            headerButton.setBackground(rsc.PrimaryColor());
            lblHeader.setText("Welcome to MotorPH Dashboard Portal");
        }
        else if(e.getSource()==timeInOutButton)
        {
            HideAllPagesAndContent();
            ButtonDefaultColor();
            timeInOutButton.setBackground(rsc.PrimaryColor());
            lblHeader.setText("Time-In Time-Out Page");
        }
        else if(e.getSource()==profileButton)
        {
            HideAllPagesAndContent();
            ButtonDefaultColor();
            profileButton.setBackground(rsc.PrimaryColor());
            profilePageContent.setVisible(true);
            lblHeader.setText("Profile Page");
        }
        else if(e.getSource()==timeButton)
        {
            HideAllPagesAndContent();
            ButtonDefaultColor();
            timeButton.setBackground(rsc.PrimaryColor());
            lblHeader.setText("View Time Logs Page");
        }
        else if(e.getSource()==salaryButton)
        {
            HideAllPagesAndContent();
            ButtonDefaultColor();
            salaryButton.setBackground(rsc.PrimaryColor());
            salaryPageContent.setVisible(true);
            lblHeader.setText("View Salary Page");
        }
    }
}