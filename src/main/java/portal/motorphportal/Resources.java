package portal.motorphportal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;


public class Resources
{
    
    private Dimension fullScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int fullScreenWidth = fullScreenSize.width;
    private int fullScreenHeight = fullScreenSize.height;
    private double ratio = 1.618;
    
    
    public int FullscreenWidth(){
        return fullScreenWidth;
    }
    
    public int FullscreenHeight(){
        return fullScreenHeight;
    }
    
    public int MidScreenWidth(){
        int midX = (fullScreenWidth)/2;
        return midX;
    }
    
    public int MidScreenHeight(){
        int midY = (fullScreenHeight)/2;
        return midY;
    }
    
    
    public int SideBarWidth() {
        int sideBarWidth = (int)(fullScreenWidth / ratio)/4;
        return sideBarWidth;
    }
    
    public int SideBarHeight() {
        int sideBarHeight = fullScreenHeight;
        return sideBarHeight;
    }
    
    
    public int NavButtonWidth(){
        int navButtonWidth = (int)(fullScreenWidth / ratio)/4;
        return navButtonWidth;
    }
    
    public int NavButtonHeight(){
        int navButtonHeight = (int)(fullScreenHeight/100)*10;
        return navButtonHeight;
    }
    
    
    public int InfoPanelWidth(){
        int infoPanelWidth = (int) (fullScreenWidth - ((fullScreenWidth / ratio)/4));
        return infoPanelWidth;
    }
    
    public int InfoPanelHeight(){
        int infoPanelHeight = (fullScreenHeight/100)*5;
        return infoPanelHeight;
    }
    
    
    public Color PrimaryColor(){
        return new Color(0x12202b);
    }
    
    public Color SecondaryColor(){
        return new Color(0x192734);
    }
    
    public Color AccentColor(){
        return new Color(0x22303c);
    }
    
    public Color PrimaryTextColor(){
        return new Color(0xffffff);
    }
    
    public Color SecondaryTextColor(){
        return new Color(0x8899a6);
    }
    
    public Color InputTextColor(){
        return new Color(0x28231d);
    }
    
    public Font HeaderFont(){
        return new Font("Sans Serif",Font.BOLD,20);
    }
    
    public Font MainFont(){
        return new Font("Sans Serif",Font.PLAIN,16);
    }
    
    public Font SecondaryFont(){
        return new Font("Sans Serif",Font.PLAIN,14);
    }
    
    
    
}
