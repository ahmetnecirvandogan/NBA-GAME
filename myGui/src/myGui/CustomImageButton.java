package myGui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CustomImageButton extends JButton {

    private Image image;
    private static String imageName;

    public CustomImageButton(ImageIcon icon, String imageName) {
        super(icon);
        this.image = icon.getImage();
        this.imageName = imageName; // Set the image name
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    
    public static String getImageName() {
    	return imageName;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255, 240, 224));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}