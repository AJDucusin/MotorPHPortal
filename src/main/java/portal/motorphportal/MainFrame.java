package portal.motorphportal;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {
    
    private String username;
    private String password;
    
    private JPanel loginPanel, sideBar, headerPanel, bodyPanel, footerPanel;
    private JButton loginButton, headerButton, timeInOutButton, profileButton, btnSchedule, salaryButton, exitButton, updateDeleteButton;
    private JLabel lblHeader, lblFooter, lblIntroduction, lblIntroPicture;
    private ImageIcon bannerPicture, scaledBannerPicture;
    
    private JPanel profilePageContent, salaryPageContent, updateDeleteProfile;

    Resources rsc = new Resources();
    UserService UserSVC = new UserService();
    
    
    public MainFrame(String username, String password) {
        this.username = username;
        this.password = password;
        
        initialize(username, password);
    }

    public void initialize(String username, String password)
    {
        // ********** Pages and Contents ********** //
        User user = UserSVC.LoadUsersData(username, password);
        String userID = String.valueOf(user.getId());
        //imageCount = userID;
        String userLastName = user.getLastName();
        String userFirstName = user.getFirstName();
        String userSss = user.getSss();
        String userPhilhealth = user.getPhilhealth();
        String userTIN = user.getTin();
        String userPagibig = user.getPagibig();
        String userDesignation = user.getDesignation();
        String userAddress = user.getAddress();
        
        
        profilePageContent = new ProfilePageContent(username, password);
        salaryPageContent = new SalaryPageContent(userID);
        updateDeleteProfile = new UpdateDeleteProfile();
        // ********** Pages and Contents ********** //
        
        // ********** Mouse Function ********** //
        MouseAdapter handPointer = new MouseAdapter() {
        @Override
            public void mouseEntered(MouseEvent e) {
                headerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                timeInOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                profileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnSchedule.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                salaryButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        @Override
            public void mouseExited(MouseEvent e) {
                headerButton.setCursor(Cursor.getDefaultCursor());
                timeInOutButton.setCursor(Cursor.getDefaultCursor());
                profileButton.setCursor(Cursor.getDefaultCursor());
                btnSchedule.setCursor(Cursor.getDefaultCursor());
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
        lblHeader.setForeground(rsc.AccentColor());
        lblHeader.setHorizontalAlignment(JLabel.CENTER); //Original
        lblHeader.setVerticalAlignment(JLabel.CENTER); //Original
        
        
        
        bannerPicture = new ImageIcon("C:\\Users\\ducus\\Desktop\\MotorPHPortal\\img\\banner.png");
        Image originalImage = bannerPicture.getImage();
        Image scaledImage = originalImage.getScaledInstance(rsc.ProfilePictureWidth(), rsc.ProfilePictureHeight(), Image.SCALE_DEFAULT);
        scaledBannerPicture = new ImageIcon(scaledImage);
        
        lblIntroPicture = new JLabel();
        lblIntroPicture.setIcon(bannerPicture);
        lblIntroPicture.setBounds(rsc.SideBarWidth()+5, rsc.HeaderPanelHeight(), rsc.BodyPanelWidth()-10, rsc.BodyPanelHeight()/4);
        lblIntroPicture.setHorizontalAlignment(JLabel.CENTER);
        lblIntroPicture.setVerticalAlignment(JLabel.BOTTOM);
        
        lblIntroduction = new JLabel();
        lblIntroduction.setText("<html><p align='center'>Overview<br/><br/>MotorPH started as an online company but now plans to expand operations by opening multiple physical branches in the Philippines. We will start by opening a physical headquarters to centralize their services and ensure that all other sites can communicate with each other.</p></html>");
        lblIntroduction.setFont(rsc.HeaderFont());
        lblIntroduction.setForeground(rsc.PrimaryTextColor());
        lblIntroduction.setBounds(rsc.SideBarWidth()+5, (rsc.BodyPanelHeight()/4)+100, rsc.BodyPanelWidth()-10, rsc.BodyPanelHeight()/2);
        lblIntroduction.setHorizontalAlignment(JLabel.CENTER); //Original
        lblIntroduction.setVerticalAlignment(JLabel.CENTER); //Original
        
        
        lblFooter = new JLabel();
        lblFooter.setText("Terms of Service | Privacy Policy | © 2023-2024 MMDC MO-IT103. All Rights Reserved.");
        lblFooter.setFont(rsc.SecondaryFont());
        lblFooter.setForeground(rsc.SecondaryTextColor());
        lblFooter.setHorizontalAlignment(JLabel.CENTER);
        lblFooter.setVerticalAlignment(JLabel.CENTER);
        
        
        headerButton = new JButton("HOME");
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
        timeInOutButton.setFont(rsc.SecondaryFont());
        timeInOutButton.setBorder(null);
        timeInOutButton.setFocusable(false);
        timeInOutButton.setBounds(0, rsc.SideBarHeight()-(rsc.NavButtonHeight()*10), rsc.NavButtonWidth(), rsc.NavButtonHeight());
        timeInOutButton.addMouseListener(handPointer);
        
        profileButton = new JButton("My Profile");
        profileButton.addActionListener(this);
        profileButton.setBackground(rsc.SecondaryColor());
        profileButton.setForeground(rsc.PrimaryTextColor());
        profileButton.setFont(rsc.SecondaryFont());
        profileButton.setBorder(null);
        profileButton.setFocusable(false);
        profileButton.setBounds(0, rsc.SideBarHeight()-(rsc.NavButtonHeight()*9), rsc.NavButtonWidth(), rsc.NavButtonHeight());
        profileButton.addMouseListener(handPointer);
        
        btnSchedule = new JButton("Schedule");
        btnSchedule.addActionListener(this);
        btnSchedule.setBackground(rsc.SecondaryColor());
        btnSchedule.setForeground(rsc.PrimaryTextColor());
        btnSchedule.setFont(rsc.SecondaryFont());
        btnSchedule.setBorder(null);
        btnSchedule.setFocusable(false);
        btnSchedule.setBounds(0, rsc.SideBarHeight()-(rsc.NavButtonHeight()*8), rsc.NavButtonWidth(), rsc.NavButtonHeight());
        btnSchedule.addMouseListener(handPointer);
        
        salaryButton = new JButton("View Salary");
        salaryButton.addActionListener(this);
        salaryButton.setBackground(rsc.SecondaryColor());
        salaryButton.setForeground(rsc.PrimaryTextColor());
        salaryButton.setFont(rsc.SecondaryFont());
        salaryButton.setBorder(null);
        salaryButton.setFocusable(false);
        salaryButton.setBounds(0, rsc.SideBarHeight()-(rsc.NavButtonHeight()*7), rsc.NavButtonWidth(), rsc.NavButtonHeight());
        salaryButton.addMouseListener(handPointer);
        
        updateDeleteButton = new JButton("<html><p align='center'>Update or Delete Profile</p></html>");
        updateDeleteButton.addActionListener(this);
        updateDeleteButton.setBackground(rsc.SecondaryColor());
        updateDeleteButton.setForeground(rsc.PrimaryTextColor());
        updateDeleteButton.setFont(rsc.SecondaryFont());
        updateDeleteButton.setBorder(null);
        updateDeleteButton.setFocusable(false);
        updateDeleteButton.setBounds(0, rsc.SideBarHeight()-(rsc.NavButtonHeight()*6), rsc.NavButtonWidth(), rsc.NavButtonHeight());
        updateDeleteButton.addMouseListener(handPointer);
        
        exitButton = new JButton("Exit Portal");
        exitButton.addActionListener(this);
        exitButton.setBackground(rsc.SecondaryColor());
        exitButton.setForeground(rsc.PrimaryTextColor());
        exitButton.setFont(rsc.SecondaryFont());
        exitButton.setBorder(null);
        exitButton.setFocusable(false);
        exitButton.setBounds(0, rsc.SideBarHeight()-rsc.NavButtonHeight(), rsc.NavButtonWidth(), rsc.NavButtonHeight());
        exitButton.addMouseListener(handPointer);
        
        
        
        headerPanel.add(lblHeader);
        
        bodyPanel.add(profilePageContent);
        bodyPanel.add(salaryPageContent);
        bodyPanel.add(updateDeleteProfile);
        
        footerPanel.add(lblFooter);
        
        sideBar.add(headerButton);
        sideBar.add(timeInOutButton);
        sideBar.add(profileButton);
        sideBar.add(btnSchedule);
        sideBar.add(salaryButton);
        sideBar.add(updateDeleteButton);
        sideBar.add(exitButton);
        this.add(headerPanel);
        this.add(lblIntroduction);
        this.add(lblIntroPicture);
        this.add(bodyPanel);
        this.add(footerPanel);
        this.add(sideBar);
        this.setVisible(true);
        
        HideAllPagesAndContent();
        //DefaultForeGround();
        lblIntroduction.setVisible(true);
        lblIntroPicture.setVisible(true);
    }
    
    
    public void HideAllPagesAndContent(){
        profilePageContent.setVisible(false);
        salaryPageContent.setVisible(false);
        lblIntroduction.setVisible(false);
        lblIntroPicture.setVisible(false);
        updateDeleteProfile.setVisible(false);
    }
    
    /*
    public void DefaultForeGround() {
        headerButton.setForeground(rsc.PrimaryTextColor());
        timeInOutButton.setForeground(rsc.PrimaryTextColor());
        profileButton.setForeground(rsc.PrimaryTextColor());
        timeButton.setForeground(rsc.PrimaryTextColor());
        salaryButton.setForeground(rsc.PrimaryTextColor());
        updateDeleteButton.setForeground(rsc.PrimaryTextColor());
    }
    */
    
    public void ButtonDefaultColor() {
        headerButton.setBackground(rsc.SecondaryColor());
        timeInOutButton.setBackground(rsc.SecondaryColor());
        profileButton.setBackground(rsc.SecondaryColor());
        btnSchedule.setBackground(rsc.SecondaryColor());
        salaryButton.setBackground(rsc.SecondaryColor());
        updateDeleteButton.setBackground(rsc.SecondaryColor());
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
            //DefaultForeGround();
            headerButton.setBackground(rsc.PrimaryColor());
            lblHeader.setText("Welcome to MotorPH Dashboard Portal");
            lblIntroduction.setVisible(true);
            lblIntroPicture.setVisible(true);
        }
        else if(e.getSource()==timeInOutButton)
        {
            HideAllPagesAndContent();
            ButtonDefaultColor();
            //DefaultForeGround();
            timeInOutButton.setBackground(rsc.PrimaryColor());
            lblHeader.setText("Time-In Time-Out Page");
            //timeInOutButton.setForeground(rsc.AccentColor());
        }
        else if(e.getSource()==profileButton)
        {
            HideAllPagesAndContent();
            ButtonDefaultColor();
            //DefaultForeGround();
            profileButton.setBackground(rsc.PrimaryColor());
            lblHeader.setText("Profile Page");
            //profileButton.setForeground(rsc.AccentColor());
            profilePageContent.setVisible(true);
        }
        else if(e.getSource()==btnSchedule)
        {
            HideAllPagesAndContent();
            ButtonDefaultColor();
            //DefaultForeGround();
            btnSchedule.setBackground(rsc.PrimaryColor());
            lblHeader.setText("View Schedules and Request");
            //timeButton.setForeground(rsc.AccentColor());
        }
        else if(e.getSource()==salaryButton)
        {
            HideAllPagesAndContent();
            ButtonDefaultColor();
            //DefaultForeGround();
            salaryButton.setBackground(rsc.PrimaryColor());
            lblHeader.setText("View Salary Page");
            //salaryButton.setForeground(rsc.AccentColor());
            salaryPageContent.setVisible(true);
        }
        else if(e.getSource()==updateDeleteButton){
            HideAllPagesAndContent();
            ButtonDefaultColor();
            //DefaultForeGround();
            updateDeleteButton.setBackground(rsc.PrimaryColor());
            lblHeader.setText("Update or Delete User's Profile");
            //updateDeleteButton.setForeground(rsc.AccentColor());
            updateDeleteProfile.setVisible(true);
        }
    }
}