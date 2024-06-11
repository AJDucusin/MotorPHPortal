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
    
    
    public int HeaderPanelWidth(){
        int infoPanelWidth = (int) (fullScreenWidth - ((fullScreenWidth / ratio)/4));
        return infoPanelWidth;
    }
    
    public int HeaderPanelHeight(){
        int infoPanelHeight = (int) ((fullScreenHeight/100)*5)*3;
        return infoPanelHeight;
    }
    
    public int BodyPanelWidth(){
        int bodyPanelWidth = (int) (fullScreenWidth - ((fullScreenWidth / ratio)/4));
        return bodyPanelWidth;
    }
    
    public int BodyPanelHeight(){
        int bodyPanelHeight = (int) (fullScreenHeight - ((((fullScreenHeight/100)*5)*3)+((fullScreenHeight/100)*10)));
        return bodyPanelHeight;
    }
    
    public int FooterPanelWidth(){
        int footerPanelWidth = (int) (fullScreenWidth - ((fullScreenWidth / ratio)/4));
        return footerPanelWidth;
    }
    
    public int FooterPanelHeight(){
        int footerPanelHeight = (int) (fullScreenHeight/100)*10;
        return footerPanelHeight;
    }
    
    
    
    
    public int BodyContentVWidthPadding(){
        int profileVWidthPadding = (int) ((fullScreenHeight/100)*5);
        return profileVWidthPadding;
    }
    
    public int BodyContentVHeightPadding(){
        int profileVHeightPadding = (int) (fullScreenHeight - ((((fullScreenHeight/100)*5)*3)+((fullScreenHeight/100)*10)));
        return profileVHeightPadding;
    }
    
    public int BodyContentHWidthPadding(){
        int profileHorizontalPadding = (int) (fullScreenWidth - ((fullScreenWidth / ratio)/4));
        return profileHorizontalPadding;
    }
    
    public int BodyContentHHeightPadding(){
        int profileHHeightPadding = (int) ((fullScreenHeight/100)*5);
        return profileHHeightPadding;
    }
    
    public int BodyContentPageWidth() {
        int profilePageWidth = (int) (fullScreenWidth - ((fullScreenWidth / ratio)/4)) - ((fullScreenHeight/100)*5);
        return profilePageWidth;
    }
    
    public int BodyContentPageHeight() {
        int profilePageHeight = (int) (fullScreenHeight - ((((fullScreenHeight/100)*5)*3)+((fullScreenHeight/100)*10))) - ((fullScreenHeight/100)*5);
        return profilePageHeight;
    }
    
    
    public int bcTextWidth(){
        int bodyContentTextWidth = (int) ((fullScreenWidth - ((fullScreenWidth / ratio)/4)) - ((fullScreenHeight/100)*5))/8;
        return bodyContentTextWidth;
    }
    
    public int bcTextHeight(){
        int bodyContentTextHeight = (int) (fullScreenHeight - ((((fullScreenHeight/100)*5)*3)+((fullScreenHeight/100)*10)))/16;
        return bodyContentTextHeight;
    }
    
    
    public int ProfilePictureWidth() {
        int profilePictureWidth = (int) ((fullScreenWidth - ((fullScreenWidth / ratio)/4)) - ((fullScreenHeight/100)*5))/4;
        return profilePictureWidth;
    }
    
    public int ProfilePictureHeight() {
        int profilePictureHeight = (int) (((fullScreenHeight - ((((fullScreenHeight/100)*5)*3)+((fullScreenHeight/100)*10))) - ((fullScreenHeight/100)*5))/8)*4;
        return profilePictureHeight;
    }
    
    
    
    
    public Color PrimaryColor(){
        return new Color(0x12202b);
    }
    
    public Color SecondaryColor(){
        return new Color(0x192734);
    }
    
    public Color AccentColor(){
        return new Color(0xffc857);
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
    
    
    public Font HeaderFont2(){
        return new Font("Sans Serif",Font.BOLD,24);
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
    
    public Font NavBarFont(){
        return new Font("Sans Serif",Font.PLAIN,12);
    }
    
}
