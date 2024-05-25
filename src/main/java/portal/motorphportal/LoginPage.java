package portal.motorphportal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import portal.motorphportal.DBoperation;


public class LoginPage extends JFrame implements ActionListener
{
    
    private JButton loginButton;
    private JLabel lblLoginMessage, lblUsername, lblPassword;
    private JTextField usernameTF;
    private JPasswordField passwordTF;
    private JPanel loginFocusPanel, loginButtonContainer, usernameTFContainer, passwordTFContainer;
    private Color primaryColor, secondaryColor, accentColor, primaryTextColor, secondaryTextColor, inputTextColor;
    private Font headerFont, mainFont, secondaryFont;
    DBoperation DBops = new DBoperation();
    
    LoginPage()
    {
        initialize();
    }
    
    public void initialize()
    {
        // ********** Dimensions, Colors, Fonts ********** //
        Dimension fullScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int fullScreenWidth = fullScreenSize.width;
        int fullScreenHeight = fullScreenSize.height;
        
        int textFieldWidth = 250;
        int textFieldHeight = 21;
        
        int loginFocusWidth = 405;
        int loginFocusHeight = 250;
        
        double ratio = 1.618;
        int midX = (fullScreenWidth-loginFocusWidth)/2;
        int midY = (fullScreenHeight-loginFocusHeight)/2;
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
        
        
        
        
        this.setTitle("Login Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(fullScreenWidth, fullScreenHeight);
        this.getContentPane().setBackground(primaryColor);
        this.setUndecorated(true);
        
        
        
        loginFocusPanel = new JPanel();
        loginFocusPanel.setBounds(midX, midY, loginFocusWidth, loginFocusHeight);
        loginFocusPanel.setBackground(secondaryColor);
        loginFocusPanel.setLayout(null);
        
        loginButtonContainer = new JPanel();
        loginButtonContainer.setBounds(0, loginFocusHeight-60, loginFocusWidth, 60);
        loginButtonContainer.setBackground(secondaryColor);
        
        usernameTFContainer = new JPanel();
        usernameTFContainer.setBounds(loginFocusWidth-270, 75, 270, 50);
        usernameTFContainer.setLayout(null);
        usernameTFContainer.setBackground(secondaryColor);
        
        passwordTFContainer = new JPanel();
        passwordTFContainer.setBounds(loginFocusWidth-270, 125, 270, 50);
        passwordTFContainer.setLayout(null);
        passwordTFContainer.setBackground(secondaryColor);
        
        
        lblLoginMessage = new JLabel();
        lblLoginMessage.setText("Please provide your username and password to login.");
        lblLoginMessage.setFont(mainFont);
        lblLoginMessage.setForeground(secondaryTextColor);
        lblLoginMessage.setHorizontalAlignment(JLabel.CENTER);
        lblLoginMessage.setBounds(0, 0, loginFocusWidth, 75);
        
        lblUsername = new JLabel();
        lblUsername.setText("Username: ");
        lblUsername.setFont(mainFont);
        lblUsername.setForeground(secondaryTextColor);
        lblUsername.setHorizontalAlignment(JLabel.CENTER);
        lblUsername.setBounds(0, 75, 175, 50);
        
        lblPassword = new JLabel();
        lblPassword.setText("Password: ");
        lblPassword.setFont(mainFont);
        lblPassword.setForeground(secondaryTextColor);
        lblPassword.setHorizontalAlignment(JLabel.CENTER);
        lblPassword.setBounds(0, 125, 175, 50);
        
        
        usernameTF = new JTextField();
        usernameTF.setFont(mainFont);
        usernameTF.setForeground(inputTextColor);
        usernameTF.setBorder(null);
        //usernameTF.setPreferredSize(textFieldWidth,textFieldHeight);
        usernameTF.setSize(textFieldWidth, textFieldHeight);
        usernameTF.setBounds((270-250)/2, (50-21)/2, 210, 21);
        
        passwordTF = new JPasswordField();
        passwordTF.setFont(mainFont);
        passwordTF.setForeground(inputTextColor);
        passwordTF.setBorder(null);
        //usernameTF.setPreferredSize(textFieldWidth,textFieldHeight);
        passwordTF.setSize(textFieldWidth, textFieldHeight);
        passwordTF.setBounds((270-250)/2, (50-21)/2, 210, 21);
        
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBackground(secondaryColor);
        loginButton.setForeground(primaryTextColor);
        //loginButton.setBorder(null);
        loginButton.setFont(secondaryFont);
        loginButton.setFocusable(false);
        
        
        
        
        
        
        
        usernameTFContainer.add(usernameTF);
        passwordTFContainer.add(passwordTF);
        loginButtonContainer.add(loginButton);
        loginFocusPanel.add(loginButtonContainer);
        loginFocusPanel.add(usernameTFContainer);
        loginFocusPanel.add(passwordTFContainer);
        loginFocusPanel.add(lblLoginMessage);
        loginFocusPanel.add(lblUsername);
        loginFocusPanel.add(lblPassword);
        this.add(loginFocusPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==loginButton)
        {
            String loginUsername = usernameTF.getText();
            //String loginPassword = passwordTF.getText();
            char[] passwordPerParts = passwordTF.getPassword();
            String loginPassword = new String(passwordPerParts);
            
            boolean loginResult = DBops.LoginUser(loginUsername, loginPassword);
            
            if(loginResult == true) {
                MainFrame mainFrame = new MainFrame(loginUsername, loginPassword);
                this.dispose();
            } else {
                lblLoginMessage.setText("Login failed. Incorrect username or password.");
                usernameTF.setText(null);
                passwordTF.setText(null);
            }
            
            
            /* // >>> Get ID by Username and Password <<< //
            String loginUsername = usernameTF.getText();
            char[] passwordPerParts = passwordTF.getPassword();
            //String loginPassword = passwordPerParts.toString();
            String loginPassword = new String(passwordPerParts);
            
            String saloSalo = "";
            
            int IDresult = DBops.GetIDbyUsernamePassword(loginUsername, loginPassword);
            String convertedID = String.valueOf(IDresult);
            
            lblLoginMessage.setText(convertedID);
            */
            
            //this.dispose();
            //MainFrame mainFrame = new MainFrame();
        }
    }
    
}
