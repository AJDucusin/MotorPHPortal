package portal.motorphportal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener
{
    
    private JPanel loginPanel, sideBar, headerPanel;
    private JButton loginButton, headerButton, timeInOutButton, profileButton, timeButton, salaryButton, exitButton;
    private JLabel lblHeader;
    private Color primaryColor, secondaryColor, accentColor, primaryTextColor, secondaryTextColor, inputTextColor;
    private Font headerFont, mainFont, secondaryFont;
    
    
    public MainFrame()
    {
        initialize();
    }

    public void initialize()
    {
        // ********** Mouse Function ********** //
        MouseAdapter handPointer = new MouseAdapter()
        {
        @Override
            public void mouseEntered(MouseEvent e)
            {
                headerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                timeInOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                timeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                salaryButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        @Override
            public void mouseExited(MouseEvent e)
            {
                headerButton.setCursor(Cursor.getDefaultCursor());
                timeInOutButton.setCursor(Cursor.getDefaultCursor());
                profileButton.setCursor(Cursor.getDefaultCursor());
                timeButton.setCursor(Cursor.getDefaultCursor());
                salaryButton.setCursor(Cursor.getDefaultCursor());
                exitButton.setCursor(Cursor.getDefaultCursor());
            }
        };
        // ********** Mouse Function ********** //
        
        // ********** Dimensions, Colors, Fonts ********** //
        Dimension fullScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int fullScreenWidth = fullScreenSize.width;
        int fullScreenHeight = fullScreenSize.height;
        
        double ratio = 1.618;
        int midX = (fullScreenWidth)/2;
        int midY = (fullScreenHeight)/2;
        int sideBarWidth = (int)(fullScreenWidth / ratio)/4;
        int sideBarHeight = fullScreenHeight;
        int navButtonWidth = sideBarWidth;
        int navButtonHeight = (sideBarHeight/100)*10;
        int infoPanelWidth = fullScreenWidth-sideBarWidth;
        int inforPanelHeight = (fullScreenHeight/100)*5;
        
        primaryColor = new Color(0x12202b);
        secondaryColor = new Color(0x192734);
        accentColor = new Color(0x22303c);
        primaryTextColor = new Color(0xffffff);
        secondaryTextColor = new Color(0x8899a6);
        inputTextColor = new Color(0x28231d);
        
        headerFont = new Font("Sans Serif",Font.BOLD,20);
        mainFont = new Font("Sans Serif",Font.PLAIN,16);
        secondaryFont = new Font("Sans Serif",Font.PLAIN,14);
        // ********** Dimensions, Colors, Fonts ********** //
        
        
        
        
        this.setTitle("Motor PH Portal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(fullScreenWidth, fullScreenHeight);
        this.getContentPane().setBackground(primaryColor);
        this.setUndecorated(true);
        
        
        
        
        sideBar = new JPanel();
        sideBar.setBackground(secondaryColor);
        sideBar.setBounds(0, 0, sideBarWidth, sideBarHeight);
        sideBar.setLayout(null);
        
        headerPanel = new JPanel();
        headerPanel.setBackground(primaryColor);
        headerPanel.setBounds(sideBarWidth, 0, infoPanelWidth, inforPanelHeight*3);
        headerPanel.setLayout(new BorderLayout());
        
        
        lblHeader = new JLabel();
        lblHeader.setText("Welcome to MotorPH Dashboard Portal");
        lblHeader.setFont(headerFont);
        lblHeader.setForeground(primaryTextColor);
        lblHeader.setHorizontalAlignment(JLabel.CENTER);
        lblHeader.setVerticalAlignment(JLabel.CENTER);
        //lblHeader.setBounds(infoPanelWidth/2, (inforPanelHeight*3)/2, 0, 0);
        
        
        headerButton = new JButton("Motor PH");
        headerButton.addActionListener(this);
        headerButton.setBackground(primaryColor);
        headerButton.setForeground(primaryTextColor);
        headerButton.setFont(headerFont);
        headerButton.setBorder(null);
        headerButton.setFocusable(false);
        headerButton.setBounds(0, 0, navButtonWidth, navButtonHeight);
        headerButton.addMouseListener(handPointer);
        
        timeInOutButton = new JButton("Time-in Time-out");
        timeInOutButton.addActionListener(this);
        timeInOutButton.setBackground(secondaryColor);
        timeInOutButton.setForeground(primaryTextColor);
        timeInOutButton.setFont(mainFont);
        timeInOutButton.setBorder(null);
        timeInOutButton.setFocusable(false);
        timeInOutButton.setBounds(0, sideBarHeight-(navButtonHeight*10), navButtonWidth, navButtonHeight);
        timeInOutButton.addMouseListener(handPointer);
        
        profileButton = new JButton("My Profile");
        profileButton.addActionListener(this);
        profileButton.setBackground(secondaryColor);
        profileButton.setForeground(primaryTextColor);
        profileButton.setFont(mainFont);
        profileButton.setBorder(null);
        profileButton.setFocusable(false);
        profileButton.setBounds(0, sideBarHeight-(navButtonHeight*9), navButtonWidth, navButtonHeight);
        profileButton.addMouseListener(handPointer);
        
        timeButton = new JButton("View Time Logs");
        timeButton.addActionListener(this);
        timeButton.setBackground(secondaryColor);
        timeButton.setForeground(primaryTextColor);
        timeButton.setFont(mainFont);
        timeButton.setBorder(null);
        timeButton.setFocusable(false);
        timeButton.setBounds(0, sideBarHeight-(navButtonHeight*8), navButtonWidth, navButtonHeight);
        timeButton.addMouseListener(handPointer);
        
        salaryButton = new JButton("View Salary");
        salaryButton.addActionListener(this);
        salaryButton.setBackground(secondaryColor);
        salaryButton.setForeground(primaryTextColor);
        salaryButton.setFont(mainFont);
        salaryButton.setBorder(null);
        salaryButton.setFocusable(false);
        salaryButton.setBounds(0, sideBarHeight-(navButtonHeight*7), navButtonWidth, navButtonHeight);
        salaryButton.addMouseListener(handPointer);
        
        exitButton = new JButton("Exit Portal");
        exitButton.addActionListener(this);
        exitButton.setBackground(secondaryColor);
        exitButton.setForeground(primaryTextColor);
        exitButton.setFont(mainFont);
        exitButton.setBorder(null);
        exitButton.setFocusable(false);
        exitButton.setBounds(0, sideBarHeight-navButtonHeight, navButtonWidth, navButtonHeight);
        exitButton.addMouseListener(handPointer);
        
        
        
        
        headerPanel.add(lblHeader);
        sideBar.add(headerButton);
        sideBar.add(timeInOutButton);
        sideBar.add(profileButton);
        sideBar.add(timeButton);
        sideBar.add(salaryButton);
        sideBar.add(exitButton);
        this.add(headerPanel);
        this.add(sideBar);
        this.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==exitButton)
        {
            //System.out.println("Login button clicked!");
            //loginPanel.setVisible(false);
            //loginButton.setVisible(false);
            
            this.dispose();
        }
        else if(e.getSource()==headerButton)
        {
            headerButton.setBackground(primaryColor);
            timeInOutButton.setBackground(secondaryColor);
            profileButton.setBackground(secondaryColor);
            timeButton.setBackground(secondaryColor);
            salaryButton.setBackground(secondaryColor);
            
            lblHeader.setText("Welcome to MotorPH Dashboard Portal");
            
        }
        else if(e.getSource()==timeInOutButton)
        {
            headerButton.setBackground(secondaryColor);
            timeInOutButton.setBackground(primaryColor);
            profileButton.setBackground(secondaryColor);
            timeButton.setBackground(secondaryColor);
            salaryButton.setBackground(secondaryColor);
            
            lblHeader.setText("Time-In Time-Out Page");
            
        }
        else if(e.getSource()==profileButton)
        {
            headerButton.setBackground(secondaryColor);
            timeInOutButton.setBackground(secondaryColor);
            profileButton.setBackground(primaryColor);
            timeButton.setBackground(secondaryColor);
            salaryButton.setBackground(secondaryColor);
            
            lblHeader.setText("Profile Page");
            
        }
        else if(e.getSource()==timeButton)
        {
            headerButton.setBackground(secondaryColor);
            timeInOutButton.setBackground(secondaryColor);
            profileButton.setBackground(secondaryColor);
            timeButton.setBackground(primaryColor);
            salaryButton.setBackground(secondaryColor);
            
            lblHeader.setText("View Time Logs Page");
            
        }
        else if(e.getSource()==salaryButton)
        {
            headerButton.setBackground(secondaryColor);
            timeInOutButton.setBackground(secondaryColor);
            profileButton.setBackground(secondaryColor);
            timeButton.setBackground(secondaryColor);
            salaryButton.setBackground(primaryColor);
            
            lblHeader.setText("View Salary Page");
            
        }
    }

}
