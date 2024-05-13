package portal.motorphportal;

import java.awt.Color;
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
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener
{
    
    private JPanel loginPanel;
    public JButton loginButton;
    
    
    public MainFrame()
    {
        initialize();
    }

    public void initialize()
    {
        this.setTitle("Motor PH Portal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null); //Ito ang dahilan kung bakit puwede ng mag manual set ng coordinates, width, height, ng mga components.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Ito ang responsible sa pag-kuha ng screen size ng computer.
        this.setSize(screenSize); // Sinet ko as size ang nakuhang screen size.
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Ito ang responsible sa pag-full screen ng window.
        //this.setUndecorated(true); // Ito ang responsible sa pag-remove ng window decorations. Ka sama nyang tinatangal ang window title bar.
        this.setVisible(true);

        
        
        loginPanel = new JPanel();
        
        int loginPanelWidth = 405;
        int loginPanelHeight = 250;
        int midX = (screenSize.width - loginPanelWidth) / 2;
        int midY = (screenSize.height - loginPanelHeight) / 2;
        
        loginPanel.setBackground(new Color(0xFFFFFF));
        loginPanel.setBounds(midX, midY, loginPanelWidth, loginPanelHeight);
        this.add(loginPanel);
        
        
        
        loginButton = new JButton("Login");
        
        //int loginButtonHeight = 36;
        loginButton.addActionListener(this);
        //loginButton.addActionListener(e -> System.out.println("Login button clicked!"));
        Dimension loginButtonSize = loginButton.getPreferredSize();
        loginButton.setBounds(midX+(loginPanelWidth-loginButtonSize.width)/2, midY+(loginPanelHeight-loginButtonSize.height)-10, loginButtonSize.width, loginButtonSize.height);
        loginButton.setFocusable(false);
        loginButton.setFont(new Font("Sans Serif",Font.PLAIN,12));
        loginButton.setBackground(new Color(0xffc857));
        loginButton.setBorder(null);
        this.add(loginButton);
        /*
        loginButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                loginButton.setBackground(new Color(0xdb3a34));
            }
            @Override
            public void mouseReleased(MouseEvent e)
            {
                loginButton.setBackground(new Color(0xffc857));
            }
        });
        */
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==loginButton)
        {
            //System.out.println("Login button clicked!");
            loginPanel.setVisible(false);
            loginButton.setVisible(false);
        }
    }

}
