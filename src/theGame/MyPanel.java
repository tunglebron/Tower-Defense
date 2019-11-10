package theGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private Image myImage;
	
    public MyPanel(String file) {
    	initBoard(file);
    }
    
    private void initBoard(String file) {
    	loadImage(file);
    	int w = myImage.getWidth(this);
    	int h = myImage.getHeight(this);
    	setPreferredSize(new Dimension(w, h));
    }
    
    private void loadImage(String file) {
        ImageIcon ii = new ImageIcon(file);
        myImage = ii.getImage();        
    }
    
    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(myImage, 0, 0, null);
    }
}
